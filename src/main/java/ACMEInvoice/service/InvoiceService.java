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

    public List<Invoice> findByCustomerID(long id) {
        return repository.findByCustomerID(id);
    }
    public List<Invoice> findByAddressID(long customerId, long addressId) {
        return repository.findByAddressID(customerId, addressId);
    }
    /*public List<Invoice> findByAddressID(long id) {
        return repository.findByAddressID(id);
    }*/
    public List<Invoice> findByMonth(long id, short month) {
        return repository.findByMonth(id, month);
    }
    public List<Invoice> findByMonthAndType(long id, short month, String type) {
        return repository.findByMonthAndType(id, month,type);
    }

}