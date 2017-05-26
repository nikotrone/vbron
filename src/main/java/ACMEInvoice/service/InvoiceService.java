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

    public List<Invoice> findByCustomerIdAndMonth(long id, int month) {
        return repository.findByCustomerIdAndMonth(id, month);
    }
    public List<Invoice> findByCustomerIdAndMonthAndType(long id, int month, String type) {
        return repository.findByCustomerIdAndMonthAndType(id, month, type);
    }

    public void saveNew(long id, long customerId, long addressId, float amount, int month, int year, String type){
        repository.save(new Invoice(id,customerId, addressId, amount, month, year, type));
    }
}