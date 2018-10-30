package fr.formation.sdj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"fr.formation.sdj.entities"})
@ComponentScan(basePackages = {"fr.formation.sdj.controller", "fr.formation.sdj.repositories"})
public class SpringDataJpaApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

}
