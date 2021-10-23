package currencies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;




@SpringBootApplication
public class Application  implements CommandLineRunner {

	@Autowired
	CurrencyService currencyService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
/*
	@Bean
	CommandLineRunner commandLineRunner(CurrencyObjectRepository currencyObjectRepository){
		return args -> {
			currencyObjectRepository.findAllValues();
		};
	}
*/
	
	@Override
	public void run(String... args) throws Exception {
		currencyService.getInfo();
		currencyService.showValues();
	}
}
