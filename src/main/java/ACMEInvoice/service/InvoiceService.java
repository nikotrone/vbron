package ACMEInvoice.service;

import ACMEInvoice.domain.Invoice;
import ACMEInvoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class InvoiceService extends AbstractService<Invoice, Long> {

    private InvoiceRepository repository;


    @Autowired
    public InvoiceService(InvoiceRepository repository) {
        super(repository);
        this.repository=repository;
    }

    public List<Invoice> findByCustomerId(long id) {
        return repository.findByCustomerId(id);
    }
    public List<Invoice> findByCustomerIdAndAddressId(long customerId, long addressId) {
        return repository.findByCustomerIdAndAddressId(customerId, addressId);
    }

    public List<Invoice> findByCustomerIdAndMonth(long id, short month) {
        return repository.findByCustomerIdAndMonth(id, month);
    }
    public List<Invoice> findByCustomerIdAndMonthAndType(long id, short month, String type) {
        return repository.findByCustomerIdAndMonthAndType(id, month,type);
    }

}