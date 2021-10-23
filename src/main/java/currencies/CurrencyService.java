package currencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyService {

    @Autowired
    CurrencyObjectRepository currencyObjectRepository;


    public void getInfo() {
        long count = currencyObjectRepository.count();
        System.out.println("Count" + count);
    }

   public void showValues(){
        List<CurrencyObject> currency = currencyObjectRepository.findAllValues();
        System.out.println(currency);
    }
}
