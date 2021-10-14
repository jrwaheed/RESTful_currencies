package currencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args){

		List<CurrencyObject> targetCurrencies = new ArrayList<>();
		CurrencyObject USD = new CurrencyObject("USD", 1.015f, "base");
		CurrencyObject JPY = new CurrencyObject("JPY", 123.54f, "target");
		CurrencyObject GBP = new CurrencyObject("GBP", .86f, "target");

		targetCurrencies.add(USD);
		targetCurrencies.add(JPY);
		targetCurrencies.add(GBP);




		for (CurrencyObject element: targetCurrencies) {

			String currencyTickerString = element.getTicker();
			String currencyValueString = Float.toString(element.getValue());
			String currencyRelationString = element.getRelation();
			String sql = "";
			boolean mdebug = true;

			sql = "DROP TABLE IF EXISTS " + currencyTickerString + ";";
			if (mdebug) System.out.println(sql);
			jdbcTemplate.execute(sql);

			sql = "CREATE TABLE "+ currencyTickerString +" (" +
					"ID int AUTO_INCREMENT PRIMARY KEY," +
					"Ticker VARCHAR(3)," +
					"Value VARCHAR(20)," +
					"Relation VARCHAR(8));";
			if (mdebug) System.out.println(sql);
			jdbcTemplate.execute(sql);

			sql = "INSERT INTO " + currencyTickerString + " (Ticker, Value, Relation)" +
					" VALUES ('" + currencyTickerString + "', '" + currencyValueString + "', '" +
					currencyRelationString + "');";
			if (mdebug) System.out.println(sql + "\n");
			jdbcTemplate.execute(sql);
		}
	}
}
