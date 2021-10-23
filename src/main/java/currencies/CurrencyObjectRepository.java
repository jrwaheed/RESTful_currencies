package currencies;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;
//Daniel originally used JpaRepository instead on CrudeRepository*/

public interface CurrencyObjectRepository extends JpaRepository<CurrencyObject, Long> {

//    @Query("SELECT u FROM User u WHERE u.status = 1")
//    Object myMethod();

}
