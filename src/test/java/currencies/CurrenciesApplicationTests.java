package currencies;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Optional;

@SpringBootTest
class CurrenciesApplicationTests {

	@Autowired
	CurrencyObjectRepository currencyObjectRepository;

	@Test
	void contextLoads() {
	}


	@Test
	void currencyRepositoryTests() {
		long count = currencyObjectRepository.count();
		assertThat(count).isGreaterThan(1);

		Optional<CurrencyObject> oc = currencyObjectRepository.findById(20L);
		CurrencyObject c = oc.get();
		assertThat(c).isNotNull();
	}


}
