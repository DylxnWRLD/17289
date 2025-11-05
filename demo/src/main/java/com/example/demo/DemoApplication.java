package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hola");
	}

	@RequestMapping ("/")
	public String home(){
		System.out.println("Bienvenido a Spring Boot");
		return "Bienvenido a Spring Boot";
	}

	@RequestMapping ("/hola")
	public String hola(){
		System.out.println("hola a Spring Boot");
		return "hola a Spring Boot";
	}

	@RequestMapping ("/adios")
	public String adios(){
		System.out.println("adiós a Spring Boot");
		return "adiós a Spring Boot";
	}

	@RequestMapping ("/html")
	public String html(){
		String html = "<h1>Ejemplo de HTML</h1><p>Esto es un párrafo en HTML servido desde Spring Boot</p></>";
		return html;
	}


}
