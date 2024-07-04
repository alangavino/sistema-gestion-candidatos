package com.sistema.gestion.candidatos.infraestructure.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sistema.gestion.candidatos.domain.model.Candidate;
import com.sistema.gestion.candidatos.infraestructure.adapter.entity.CandidateEntity;
import com.sistema.gestion.candidatos.infraestructure.adapter.mapper.InfraMapperObject;
import com.sistema.gestion.candidatos.infraestructure.adapter.repository.CandidateRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CandidateJpaAdapterTest.TestConfiguration.class)

public class CandidateJpaAdapterTest {
	
    @MockBean
    private CandidateRepository candidateRepository;
	@Autowired
	private CandidateJpaAdapter candidateJpaAdapter;
    @MockBean
    private InfraMapperObject infraMapperObject;


    @Test
    void when_ceate_Then_ok() {    	
    	
    	Candidate candidate= new Candidate();
        Mockito.when(infraMapperObject.mapearCandidateEntityTOCandidate(Mockito.anyObject())).thenReturn(candidate);
        Assertions.assertDoesNotThrow(()-> candidateJpaAdapter.create(candidate));

        
    } 
    @Test
    void when_findById_Then_ok() {    	
    	
    	Candidate candidate= new Candidate();
    	CandidateEntity candidateEntity= new CandidateEntity();
        Mockito.when(candidateRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(candidateEntity));
        Mockito.when(infraMapperObject.mapearCandidateEntityTOCandidate(Mockito.anyObject())).thenReturn(candidate);

        Assertions.assertDoesNotThrow(()-> candidateJpaAdapter.findById(1L));

        
    } 
    
    
    @Test
    void when_findById_Then_error() {    	    	
    	Candidate candidate= new Candidate();

        Mockito.when(candidateRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Mockito.when(infraMapperObject.mapearCandidateEntityTOCandidate(Mockito.anyObject())).thenReturn(candidate);

        Assertions.assertDoesNotThrow(()-> candidateJpaAdapter.findById(1L));

        
    }
    
    @Test
    void when_findByEmail_Then_ok() {    	
    	String email="alan@gmail.com";
    	Candidate candidate= new Candidate();
    	CandidateEntity candidateEntity= new CandidateEntity();
    	
        Mockito.when(candidateRepository.findCandidateByEmail(Mockito.anyString())).thenReturn(Optional.of(candidateEntity));
        Mockito.when(infraMapperObject.mapearCandidateEntityTOCandidate(Mockito.anyObject())).thenReturn(candidate);

        Assertions.assertDoesNotThrow(()-> candidateJpaAdapter.findByEmail(email));

        
    } 
    
    @Test
    void when_findByEmail_Then_error() {    	
    	String email="alan@gmail.com";
    	Candidate candidate= new Candidate();
    
    	  Mockito.when(candidateRepository.findCandidateByEmail(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(infraMapperObject.mapearCandidateEntityTOCandidate(Mockito.anyObject())).thenReturn(candidate);

        Assertions.assertDoesNotThrow(()-> candidateJpaAdapter.findByEmail(email));
        
    } 
    
    @Test
    void when_getAll_Then_ok() {    	
    
    	Candidate candidate= new Candidate();
    	CandidateEntity candidateEntity= new CandidateEntity();
    	List<CandidateEntity> candidatesEntity=new ArrayList<>();
    	candidatesEntity.add(candidateEntity);
        Mockito.when(candidateRepository.findAll()).thenReturn(candidatesEntity);
        Mockito.when(infraMapperObject.mapearCandidateEntityTOCandidate(Mockito.anyObject())).thenReturn(candidate);

        Assertions.assertDoesNotThrow(()-> candidateJpaAdapter.getAll());

        
    } 
    @Test
    void when_update_Then_ok() {    	
    	CandidateEntity candidateEntity= new CandidateEntity();
    	Candidate candidate= new Candidate();
        Mockito.when(infraMapperObject.mapearCandidateTOCandidateEntity(Mockito.anyObject())).thenReturn(candidateEntity);
        Mockito.when(candidateRepository.save(Mockito.anyObject())).thenReturn(candidateEntity);
        Mockito.when(infraMapperObject.mapearCandidateEntityTOCandidate(Mockito.anyObject())).thenReturn(candidate);

        
        Assertions.assertDoesNotThrow(()-> candidateJpaAdapter.update(candidate));

        
    } 
    
    @Test
    void when_deleteCandidate_Then_ok() {    	

        Assertions.assertDoesNotThrow(()-> candidateJpaAdapter.deleteCandidate(1L));
        
    } 
    
	public static class TestConfiguration{
		
		@Bean
		CandidateJpaAdapter candidateJpaAdapter(CandidateRepository candidateRepository,InfraMapperObject infraMapperObject) {
			
			return new  CandidateJpaAdapter(candidateRepository,infraMapperObject);
		}
		
		
	}
}
