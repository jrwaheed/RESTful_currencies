package currencies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin
public class CurrenciesResources {

    private final CurrencyObjectRepository currencyObjectRepository;

    private final Logger log = LoggerFactory.getLogger(CurrenciesResources.class);

    public CurrenciesResources (CurrencyObjectRepository currencyObjectRepository) {
        this.currencyObjectRepository = currencyObjectRepository;
    }

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/info")
    public void info() {
        currencyService.getInfo();
    }

    /**
     * Retrieves the target map created in javascript.
     * @param currencyMap
     * @return
     */
    @PostMapping("/index1")
    public ResponseEntity<Map<String,Double>> retrieveCurrency (@RequestBody Map<String,Double> currencyMap) {
        log.info("REST request to save currency: {}", currencyMap.toString());

        CurrencyObject currencyObject = new CurrencyObject();
        currencyObject.setCurrencyMap(currencyMap);
        CurrencyObject savedMapCurrency = currencyObjectRepository.save(currencyObject);
        log.info("REST request to save currency: {}", savedMapCurrency.toString());
        return new ResponseEntity<>(currencyMap, HttpStatus.CREATED);
    }


    /**
     * {@code POST /currency} : Creates a new currency in SQL
     *
     * @param currencyObject the currencyObject to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new currency.
     */
    @PostMapping("/index")
    public ResponseEntity<CurrencyObject> saveCurrency (@RequestBody CurrencyObject currencyObject) {
        log.info("REST request to save currency: {}", currencyObject);
        CurrencyObject savedCurrency = currencyObjectRepository.save(currencyObject);
        return new ResponseEntity<>(savedCurrency, HttpStatus.CREATED);
    }


}



