package com.abroad.ims.Controller;

import com.abroad.ims.Entity.Institute;
import com.abroad.ims.Services.InstituteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.validation.Valid;

@Tag(name = "Institute API")
@RestController
@RequestMapping("/institute")
@Validated
public class InstituteController {

    private static final Logger LOGGER= LoggerFactory.getLogger(InstituteController.class);
    @Autowired
    private InstituteService instituteService;

    @Operation(summary = "Register a new institute")
    @PostMapping("/register")
    public ResponseEntity<Object> resistorInstitute(@Valid @RequestBody Institute institute){
        LOGGER.info("Registering Intitute", HtmlUtils.htmlEscape(institute.getName()));
                try {
                    return new ResponseEntity<>(instituteService.registerInstituteInDB(institute), HttpStatus.CREATED);
                }catch(Exception e){
                    return new ResponseEntity<>(institute,HttpStatus.BAD_REQUEST);
                }
    }
    @Operation(summary = "Update an existing institute")
    @PutMapping("/{id}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable Long id,
                                                     @RequestBody Institute upInstitute){
        LOGGER.info("Updating ID", HtmlUtils.htmlEscape(String.valueOf(id)));
        return  new ResponseEntity<>(instituteService.updateInstituteInDB(id,upInstitute),HttpStatus.OK);



    }
    @Operation(summary = "Get information about an institute by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Institute> getInstitute(@PathVariable Long id){
        LOGGER.info("Fetching Institute with ID ", HtmlUtils.htmlEscape(String.valueOf(id)));
        instituteService.getInstituteFromDB(id);


        return new ResponseEntity<>(instituteService.getInstituteFromDB(id),HttpStatus.FOUND);

    }


}
