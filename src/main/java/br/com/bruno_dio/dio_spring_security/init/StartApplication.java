package br.com.bruno_dio.dio_spring_security.init;

import br.com.bruno_dio.dio_spring_security.model.User;
import br.com.bruno_dio.dio_spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUsername("admin");
        if (user == null) {
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("master123");
            user.getRoles().add("MANAGERS");
            userRepository.save(user);
        }

        user = userRepository.findByUsername("user");
        if (user == null) {
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            userRepository.save(user);
        }
    }

}
