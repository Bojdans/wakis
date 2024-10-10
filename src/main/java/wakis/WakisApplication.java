package wakis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wakis.repository.ClothRepository;

@SpringBootApplication
public class WakisApplication {
	public static void main(String[] args) {
		SpringApplication.run(WakisApplication.class, args);
	}
}
