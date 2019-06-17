package br.edu.unifcv.faculdade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FaculdadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaculdadeApplication.class, args);
	}

}
