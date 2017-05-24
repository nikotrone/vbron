package ACMEInvoice.rest;

import ACMEInvoice.domain.Address;
import ACMEInvoice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/address")
public class AddressController extends AbstractController<Address, Long> {

    private AddressService service;

    @Autowired
    public AddressController(AddressService service) {
        super(service);
        this.service=service;
    }

    @RequestMapping(value="findByAddress/{name}", method = RequestMethod.GET)
    public List<Address> findByAddress(@PathVariable String name) {
        return service.findByAddress(name);
    }

    @RequestMapping(value="findByCustomerId/{customerId}", method = RequestMethod.GET)
    public List<Address> findByCustomerId(@PathVariable long customerId) {
        return service.findByCustomerId(customerId);
    }
}
