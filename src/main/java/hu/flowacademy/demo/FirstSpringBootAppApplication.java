package hu.flowacademy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableJpaRepositories
public class FirstSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootAppApplication.class, args);
	}

}
