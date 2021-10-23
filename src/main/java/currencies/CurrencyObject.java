package currencies;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class CurrencyObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ticker;
    private float value;
    private String relation;

    @ElementCollection
    @CollectionTable(name = "currency_item_mapping",
            joinColumns = {@JoinColumn(name = "currency_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "target_currency")
    @Column(name = "value")
    private Map<String,Double> currencyMap = new HashMap<>();

    public CurrencyObject() {

    }


    public CurrencyObject(String ticker, float value, String relation) {

        this.ticker = ticker;
        this.value = value;
        this.relation = relation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Map<String, Double> getCurrencyMap() {
        return currencyMap;
    }

    public void setCurrencyMap(Map<String, Double> currencyMap) {
        this.currencyMap = currencyMap;
    }
}
