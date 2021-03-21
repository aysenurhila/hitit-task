package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}

@Component
class Init implements CommandLineRunner {

	@Autowired
	ContactRepository contactRepository;
	@Override
	public void run(String... args) throws Exception {
		Contact kisi1 = new Contact("Hilal", "Çocalak", "kız", "5348259617");
		contactRepository.save(kisi1);
	}
}