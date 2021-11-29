package co.edu.usa.ciclo4;

import co.edu.usa.ciclo4.modelo.User;
import co.edu.usa.ciclo4.repositorio.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.usa.ciclo4"})
public class Ciclo4Application {

    @Autowired
    private UserRepository repoUser;

    public static void main(String[] args) {
        SpringApplication.run(Ciclo4Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            List<User> listaUsuarios = repoUser.getAll();
            System.out.println("Users: " + listaUsuarios.size());

        };
    }
}
