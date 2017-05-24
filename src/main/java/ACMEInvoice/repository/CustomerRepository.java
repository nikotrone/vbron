package ACMEInvoice.repository;

import ACMEInvoice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;*/

/*@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, long> {

}*/

@Repository(value = "CustomerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("FROM CUSTOMERS WHERE LAST_NAME LIKE %?1% ")
    List<Customer> findByLastName(String name);
}