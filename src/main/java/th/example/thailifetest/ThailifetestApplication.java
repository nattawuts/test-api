package th.example.thailifetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@ComponentScan(basePackages = {"th.example.thailifetest"})
public class ThailifetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThailifetestApplication.class, args);
	}

}
