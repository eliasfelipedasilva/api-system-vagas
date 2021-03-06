package io.github.eliasfelipedasilva;

import io.github.eliasfelipedasilva.domain.entity.Usuario;
import io.github.eliasfelipedasilva.domain.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VagasApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(VagasApplication.class, args);
    }

}
