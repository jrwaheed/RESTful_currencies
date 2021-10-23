package currencies;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//Daniel originally used JpaRepository instead on CrudeRepository*/

@Repository
public interface CurrencyObjectRepository extends JpaRepository <CurrencyObject, Long> {

    @Query(value="SELECT * FROM currency_item_mapping;", nativeQuery = true)
    List<CurrencyObject> findAllValues ();
}
