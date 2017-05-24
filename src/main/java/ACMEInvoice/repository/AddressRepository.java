package ACMEInvoice.repository;

import ACMEInvoice.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;*/

/*@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, long> {

}*/

@Repository(value = "AddressRepository")
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("FROM ADDRESSES WHERE VALUE LIKE %?1% ")
    List<Address> findByAddress(String value);

    @Query("FROM ADDRESSES WHERE CUSTOMER_ID = %?1% ")
    List<Address> findByCustomerID(long customerId);
}