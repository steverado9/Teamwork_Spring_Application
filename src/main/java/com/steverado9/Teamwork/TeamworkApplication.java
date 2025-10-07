package com.steverado9.Teamwork;

import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class TeamworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TeamworkApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(
				"Stephen", "Isaac", "isaac.stephen@example.com", "stephen123",
				"Male", "admin", "Engineering", "7 Adekoya Street, Lagos, Nigeria"
		);
		userRepository.save(user1);
	}
}
