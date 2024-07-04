package com.sistema.gestion.candidatos.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sistema.gestion.candidatos.application.mapper.AppMapperObject;
import com.sistema.gestion.candidatos.domain.model.Candidate;
import com.sistema.gestion.candidatos.domain.model.dto.CandidateResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateRequestDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateUpdateRequestDTO;
import com.sistema.gestion.candidatos.domain.port.CandidatePersistencePort;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CandidateManagementServiceTest.TestConfiguration.class)
public class CandidateManagementServiceTest {
	@Autowired
	private CandidateManagementService candidateManagementService;
	
    @MockBean
    private CandidatePersistencePort candidatePersistencePort;

    @MockBean
    private AppMapperObject appMapperObject;
    
    @Test
    void when_ceateCandidate_Then_ok() {
    	
    	CandidateRequestDTO resquest= new CandidateRequestDTO();
    	Candidate candidate= new Candidate();
        Mockito.when(candidatePersistencePort.findByEmail(Mockito.anyString())).thenReturn( Optional.of(candidate));
        Mockito.when(appMapperObject.mapearCandidateRqTOCandidate(Mockito.anyObject())).thenReturn(new Candidate());
        Mockito.when(appMapperObject.mapearCandidateTOCandidateRs(Mockito.anyObject())).thenReturn(new CandidateResponseDTO());
        Assertions.assertDoesNotThrow(()-> candidateManagementService.createCandidate(resquest));

        
    } 
    
    
    @Test
    void when_getCandidateById_Then_ok() {
    	
    	Candidate candidate= new Candidate();
        Mockito.when(candidatePersistencePort.findById(Mockito.anyLong())).thenReturn(Optional.of(candidate));

        Mockito.when(appMapperObject.mapearCandidateTOCandidateRs(Mockito.anyObject())).thenReturn(new CandidateResponseDTO());
        Assertions.assertDoesNotThrow(()-> candidateManagementService.getCandidateById(1L));

        
    } 

    @Test
    void when_getAllCandidates_Then_ok() {
    	
    	
    	List<Candidate> candidates= new ArrayList<>();
    	
        Mockito.when(candidatePersistencePort.getAll()).thenReturn(candidates);

        Mockito.when(appMapperObject.mapearCandidateTOCandidateRs(Mockito.anyObject())).thenReturn(new CandidateResponseDTO());
        Assertions.assertDoesNotThrow(()-> candidateManagementService.getAllCandidates());

        
    } 
    
    
    @Test
    void when_updateCandidate_Then_ok() {
    	
    	CandidateUpdateRequestDTO resquest= new CandidateUpdateRequestDTO();
    	Candidate candidate= new Candidate();
        Mockito.when(candidatePersistencePort.findById(Mockito.anyLong())).thenReturn(Optional.of(candidate));
        Assertions.assertDoesNotThrow(()-> candidateManagementService.updateCandidate(resquest,1L));

        
    } 
    
    @Test
    void when_deleteCandidate_Then_ok() {
    	
    	
    	Candidate candidate= new Candidate();
        Mockito.when(candidatePersistencePort.findById(Mockito.anyLong())).thenReturn(Optional.of(candidate));


        Assertions.assertDoesNotThrow(()-> candidateManagementService.deleteCandidate(1L));

        
    } 
    
	public static class TestConfiguration{
		
		@Bean
		CandidateManagementService candidateManagementService(CandidatePersistencePort candidatePersistencePort,AppMapperObject appMapperObject) {
			
			return new  CandidateManagementService(candidatePersistencePort,appMapperObject);
		}
		
		
	}
}
