package ACMEInvoice.repository;

import ACMEInvoice.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository(value = "AddressRepository")
public interface AddressRepository extends JpaRepository<Address, Long> {

    //@Query("SELECT * FROM ADDRESSES WHERE ADDRESS_STRING LIKE %?1% ")
    List<Address> findByAddress(String address);

    //@Query("SELECT * FROM ADDRESSES WHERE CUSTOMER_ID = ?1 ")
    List<Address> findByCustomerId(long customerId);
}