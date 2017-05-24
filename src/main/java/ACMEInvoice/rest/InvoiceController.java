package ACMEInvoice.rest;

import ACMEInvoice.domain.Invoice;
import ACMEInvoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController@RequestMapping("/invoice")
public class InvoiceController extends AbstractController<Invoice, Long> {

    private InvoiceService service;

    @Autowired
    public InvoiceController(InvoiceService service) {
        super(service);
        this.service=service;
    }

    @RequestMapping(value="findByAddress/{name}", method = RequestMethod.GET)
    public List<Invoice> findByAddressID(@PathVariable long customerId, @PathVariable long addressId) {
        return service.findByAddressID(customerId, addressId);
    }

    @RequestMapping(value="findByCustomerId/{customerId}", method = RequestMethod.GET)
    public List<Invoice> findByCustomerID(@PathVariable long customerId) {
        return service.findByCustomerID(customerId);
    }

    @RequestMapping(value="findByMonth/{month}", method = RequestMethod.GET)
    public List<Invoice> findByMonth(@PathVariable long customerId, @PathVariable short month) {
        return service.findByMonth(customerId, month);
    }

    @RequestMapping(value="findByMonthAndType/{type}", method = RequestMethod.GET)
    public List<Invoice> findByMonthAndType(@PathVariable long customerId, @PathVariable short month, @PathVariable String type) {
        return service.findByMonthAndType(customerId, month, type);
    }
}
