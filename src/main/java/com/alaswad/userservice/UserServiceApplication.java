package com.alaswad.userservice;

import com.alaswad.userservice.domain.AppUser;
import com.alaswad.userservice.domain.Role;
import com.alaswad.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;

@SpringBootApplication
@EnableAutoConfiguration
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return  args -> { // this will run after the app have benn initialized
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null,"Salah Alaswad","s.alaswad","132132",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Daniel Maximilian","d.max","132132",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Kevin M.","k.mueller","132132",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"David E.","e.david_9","132132",new ArrayList<>()));

			userService.addRoleToUser("s.alaswad","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("s.alaswad","ROLE_USER");
			userService.addRoleToUser("d.max","ROLE_USER");
			userService.addRoleToUser("k.mueller","ROLE_USER");
			userService.addRoleToUser("e.david_9","ROLE_MANAGER");
			userService.addRoleToUser("e.david_9","ROLE_USER");
		};
	}

}
