package com.k0ft3.atman;

import java.util.ArrayList;

import com.k0ft3.atman.model.Process;
import com.k0ft3.atman.model.User;
import com.k0ft3.atman.model.processmodel.Task;
import com.k0ft3.atman.model.processmodel.UserRole;
import com.k0ft3.atman.repository.ProcessRepository;
import com.k0ft3.atman.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ATManApplication implements CommandLineRunner {

	@Autowired
	private ProcessRepository processRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ATManApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		processRepository.deleteAll();
		userRepository.save(new User("userName", "name", "surname", "email", new ArrayList<>()));
		processRepository.save(new Process("processCreationOrImportDate", "processName", "processAdminId",
				"generatablePublicProcessKey", new ArrayList<UserRole>(), new ArrayList<String>(),
				new ArrayList<Task>()));
	}

}
