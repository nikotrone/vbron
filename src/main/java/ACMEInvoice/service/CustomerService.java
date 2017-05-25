package ACMEInvoice.service;

import ACMEInvoice.domain.Customer;
import ACMEInvoice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends AbstractService<Customer, Long> {

    private CustomerRepository repository;


    @Autowired
    public CustomerService(CustomerRepository repository) {
        super(repository);
        this.repository=repository;
    }

    public List<Customer> findByLastName(String name) {
        return repository.findByLastName(name);
    }

    public List<Customer> findById(long id) {
        return repository.findById(id);
    }
}