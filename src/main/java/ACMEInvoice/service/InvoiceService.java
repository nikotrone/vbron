package ACMEInvoice.service;

import ACMEInvoice.domain.Invoice;
import ACMEInvoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Servicepublic
class InvoiceService extends AbstractService<Invoice, Long> {

    private InvoiceRepository repository;


    @Autowired
    public InvoiceService(InvoiceRepository repository) {
        super(repository);
        this.repository=repository;
    }

    public List<Invoice> findByCustomerId(long id) {
        return repository.findByCustomerID(id);
    }
    public List<Invoice> findByAddressId(long id) {
        return repository.findByAddressID(id);
    }
    public List<Invoice> findByAddressId(long id) {
        return repository.findByAddressID(id);
    }
    public List<Invoice> findByMonth(short month) {
        return repository.findByMonth(month);
    }
    public List<Invoice> findByMonthAndType(short month, String type) {
        return repository.findByMonthAndType(month,type);
    }

}