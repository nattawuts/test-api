package th.example.thailifetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"th.example.thailifetest"})
public class ThailifetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThailifetestApplication.class, args);
	}

}
