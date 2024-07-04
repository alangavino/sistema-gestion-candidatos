package com.sistema.gestion.candidatos.infraestructure.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.gestion.candidatos.application.usecases.CandidateService;
import com.sistema.gestion.candidatos.domain.model.dto.CandidateResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateRequestDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateUpdateRequestDTO;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@ApiOperation("Register a new candidate")
	@PostMapping("/registerCandidate")
	public ResponseEntity<CandidateResponseDTO> createCandidate(@Valid @RequestBody CandidateRequestDTO request){
		return  new ResponseEntity<>(candidateService.createCandidate(request), HttpStatus.CREATED);
		
	}
	
	@ApiOperation("Find an candidate by id")
	@GetMapping("/candidate/{id}")
	public ResponseEntity<CandidateResponseDTO> getCandidateById(@PathVariable(value = "id") Long id) {

		return new ResponseEntity<>(candidateService.getCandidateById(id), HttpStatus.OK);
	}
	
    @ApiOperation("Get the list of candidates")
	@GetMapping("/candidates")
	public ResponseEntity<List<CandidateResponseDTO>> getAllCandidates() {

		return new ResponseEntity<>(candidateService.getAllCandidates(), HttpStatus.OK);
	}
	
    @ApiOperation("Update an existing candidate")
	@PutMapping("/candidate/{id}")
	public ResponseEntity<CandidateResponseDTO> updateCandidate(@PathVariable(name = "id") Long id,
			                                      @Valid @RequestBody CandidateUpdateRequestDTO request){
		return  new ResponseEntity<>(candidateService.updateCandidate(request,id), HttpStatus.CREATED);
		
	}
    @ApiOperation("Delete an candidate by id")
	@DeleteMapping("/candidate/{id}")
	public ResponseEntity<Void> deleteCandidate(@PathVariable(name = "id") Long id){
		candidateService.deleteCandidate(id);
		return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
