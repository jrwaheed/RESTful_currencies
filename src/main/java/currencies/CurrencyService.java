package currencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyService {

    @Autowired
    CurrencyObjectRepository currencyObjectRepository;


    public void getInfo() {
        long count = currencyObjectRepository.count();
        System.out.println("Count" + count);
    }
}
