package br.com.gabrielmormar.microservices.hrworker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielmormar.microservices.hrworker.entities.Worker;
import br.com.gabrielmormar.microservices.hrworker.repositories.WorkerRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/workers")
@Slf4j
public class WorkerController {

	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		log.info("PORT = " + env.getProperty("local.server.port"));
		
		Optional<Worker> workers = workerRepository.findById(id);
		return ResponseEntity.ok(workers.get());
	}
}
