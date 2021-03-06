package ACMEInvoice.service;

import ACMEInvoice.domain.Address;
import ACMEInvoice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AddressService extends AbstractService<Address, Long> {

    private AddressRepository repository;


    @Autowired
    public AddressService(AddressRepository repository) {
        super(repository);
        this.repository=repository;
    }

    public List<Address> findByAddress(String name) {
        return repository.findByAddress(name);
    }

    public List<Address> findByCustomerId(long id) {
        return repository.findByCustomerId(id);
    }
}