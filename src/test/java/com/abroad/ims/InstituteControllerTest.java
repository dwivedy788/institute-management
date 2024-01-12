package com.abroad.ims;

import com.abroad.ims.Controller.InstituteController;
import com.abroad.ims.Entity.Institute;
import com.abroad.ims.Services.InstituteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;

class InstituteControllerTest {

    @Mock
    private InstituteService instituteService;

    @InjectMocks
    private InstituteController instituteController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(instituteController).build();
    }

    @Test
    void testRegisterInstitute_Success() throws Exception {
        Institute institute = new Institute();
        when(instituteService.registerInstituteInDB(any())).thenReturn(institute);

        mockMvc.perform(MockMvcRequestBuilders.post("/institute/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").doesNotExist());

        verify(instituteService, times(1)).registerInstituteInDB(any());
    }

    @Test
    void testRegisterInstitute_Failure() throws Exception {
        when(instituteService.registerInstituteInDB(any())).thenThrow(new IllegalArgumentException("Registration failed"));

        mockMvc.perform(MockMvcRequestBuilders.post("/institute/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        verify(instituteService, times(1)).registerInstituteInDB(any());
    }

    @Test
    void testUpdateInstitute() throws Exception {
        Long instituteId = 1L;
        Institute updatedInstitute = new Institute();
        when(instituteService.updateInstituteInDB(eq(instituteId), any())).thenReturn(updatedInstitute);

        mockMvc.perform(MockMvcRequestBuilders.put("/institute/{id}", instituteId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").doesNotExist());

        verify(instituteService, times(1)).updateInstituteInDB(eq(instituteId), any());
    }

    @Test
    void testGetInstitute() throws Exception {
        Long instituteId = 1L;
        Institute institute = new Institute();
        when(instituteService.getInstituteFromDB(eq(instituteId))).thenReturn(institute);

        mockMvc.perform(MockMvcRequestBuilders.get("/institute/{id}", instituteId))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").doesNotExist());

        verify(instituteService, times(1)).getInstituteFromDB(eq(instituteId));
    }
}
