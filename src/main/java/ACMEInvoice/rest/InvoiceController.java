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

    @RequestMapping(value="findByAddress/{customerId}&{addressId}", method = RequestMethod.GET)
    public List<Invoice> findByCustomerIdAndAddressId(@PathVariable long customerId, @PathVariable long addressId) {
        return service.findByCustomerIdAndAddressId(customerId, addressId);
    }

    @RequestMapping(value="findByCustomerId/{customerId}", method = RequestMethod.GET)
    public List<Invoice> findByCustomerId(@PathVariable long customerId) {
        return service.findByCustomerId(customerId);
    }

    @RequestMapping(value="findByMonth/{customerId}&{month}", method = RequestMethod.GET)
    public List<Invoice> findByCustomerIdAndMonth(@PathVariable long customerId, @PathVariable short month) {
        return service.findByCustomerIdAndMonth(customerId, month);
    }

    @RequestMapping(value="findByMonthAndType/{customerId}&{month}&{type}", method = RequestMethod.GET)
    public List<Invoice> findByCustomerIdAndMonthAndType(@PathVariable long customerId, @PathVariable short month, @PathVariable String type) {
        return service.findByCustomerIdAndMonthAndType(customerId, month, type);
    }

    
}
