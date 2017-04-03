package com.manuelrey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.manuelrey.dao.ClientRepository;
import com.manuelrey.entities.Client;

@SpringBootApplication
public class AppClientsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(AppClientsApplication.class, args);
		ClientRepository clientRepository=ctx.getBean(ClientRepository.class);
		clientRepository.save(new Client("juan", "manuel", "email", 100));
		clientRepository.save(new Client("juan2", "manuel2", "email2", 200));
		clientRepository.save(new Client("juan3", "manuel3", "email3", 300));
		clientRepository.save(new Client("juan4", "manuel4", "email4", 400));
		
		clientRepository.findAll().forEach(p->System.out.println(p.getFirst_name()));
	}
}
