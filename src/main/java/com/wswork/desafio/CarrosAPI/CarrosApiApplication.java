package com.wswork.desafio.CarrosAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.wswork.desafio.CarrosAPI","controller", "service", "response", "config"})
@EntityScan("model")
@EnableJpaRepositories("repository")
@SpringBootApplication

public class CarrosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrosApiApplication.class, args);
	}

}

//Configuracao da classe principal da aplicacao Spring Boot
//definicao dos repositorios com a anotacao jparepositories e das entidades com o entityscan, lendo os respectivos pacotes
//componentscan para ler os outros pacotes da aplicacao
