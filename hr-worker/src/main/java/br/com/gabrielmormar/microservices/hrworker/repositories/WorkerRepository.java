package br.com.gabrielmormar.microservices.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrielmormar.microservices.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
