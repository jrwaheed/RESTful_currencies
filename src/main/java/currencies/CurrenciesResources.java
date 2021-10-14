package currencies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrenciesResources {

    private final CurrencyObjectRepository currencyObjectRepository;

    private final Logger log = LoggerFactory.getLogger(CurrenciesResources.class);

    public CurrenciesResources (CurrencyObjectRepository currencyObjectRepository) {
        this.currencyObjectRepository = currencyObjectRepository;
    }


    /**
     * {@code POST /currency} : Creates a new currency.
     *
     * @param currencyObject the currencyObject to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new currency.
     */

    @PostMapping("/index")
    public ResponseEntity<CurrencyObject> createCurrency(@RequestBody CurrencyObject currencyObject) {
        log.info("REST request to save currency: {}", currencyObject);
        CurrencyObject savedCurrency = currencyObjectRepository.save(currencyObject);
        return new ResponseEntity<>(savedCurrency, HttpStatus.CREATED);
    }

}



