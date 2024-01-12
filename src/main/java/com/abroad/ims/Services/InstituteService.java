package com.abroad.ims.Services;

import com.abroad.ims.Entity.Institute;
import com.abroad.ims.Handler.ResourceNotFoundException;
import com.abroad.ims.Repositories.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class InstituteService {
    @Autowired
    private InstituteRepository instituteRepository;

    public Institute registerInstituteInDB(Institute institute){
        return instituteRepository.save(institute);
    }
    public Institute updateInstituteInDB(Long id,Institute upInstitute){
       return  instituteRepository.findById(id).map(institute -> {
           institute.setName(upInstitute.getName());
           institute.setLocation(upInstitute.getLocation());
           institute.setContact(upInstitute.getContact());
           Institute institute1 = instituteRepository.save(institute);
           return institute1;
       }).orElseThrow(() -> new ResourceNotFoundException("Institute not found with ID: " + id));
    }

    public Institute getInstituteFromDB(Long id){
        return instituteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institute not found with ID: " + id));
    }
}
