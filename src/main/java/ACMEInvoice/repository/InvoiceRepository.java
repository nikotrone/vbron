package ACMEInvoice.repository;

import ACMEInvoice.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;*/

/*@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, long> {

}*/

@Repository(value = "InvoiceRepository")
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query("FROM INVOICE WHERE CUSTOMER_ID = ?1 ")
    List<Invoice> findByCustomerID(long customerId);

    @Query("FROM INVOICE WHERE CUSTOMER_ID = ?1 AND ADDRESS_ID = ?2 ")
    List<Invoice> findByAddressID(long customerId,long addressId);

    @Query("FROM INVOICE WHERE CUSTOMER_ID = ?1 AND MONTH = ?2 ")
    List<Invoice> findByMonth(long customerId, short month);

    @Query("FROM INVOICE WHERE CUSTOMER_ID = ?1 AND MONTH = ?2 AND PURCHASE_TYPE= ?3 ")
    List<Invoice> findByMonthAndType(long customerId, short month, String type);

    // save method should be inherited by JpaRepository
}