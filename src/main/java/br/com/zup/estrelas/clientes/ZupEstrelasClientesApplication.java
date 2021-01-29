package br.com.zup.estrelas.clientes;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZupEstrelasClientesApplication {
    
    static Logger logger = Logger.getLogger(ZupEstrelasClientesApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ZupEstrelasClientesApplication.class, args);
				  
		  logger.info("Aplicação iniciada");		     
	}
}