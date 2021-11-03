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


    public void printValuesOfCurrenciesInRepository() {
        List<CurrencyObject> listOfCurrenciesAndValues;
        listOfCurrenciesAndValues = currencyObjectRepository.findAll();
        for (CurrencyObject currencyObject : listOfCurrenciesAndValues) {
            System.out.println(currencyObject.getTicker());
        }
    }



}
