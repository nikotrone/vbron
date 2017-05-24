package ACMEInvoice.rest;
/*
// old controller
import java.util.List;

import ACMEInvoice.service.CustomerService;
import ACMEInvoice.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {

//-------------------Retrieve All Users--------------------------------------------------------
    @Autowired
CustomerService userService;  //Service which will do all data retrieval/manipulation work

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllUsers() {
        List<Customer> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Customer>>(users, HttpStatus.OK);
    }

}
*/

import ACMEInvoice.domain.Customer;
import ACMEInvoice.service.AbstractService;
import ACMEInvoice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/customers")
public class CustomerController extends AbstractController<Customer, Long> {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        super(service);
        this.service=service;
    }

    @RequestMapping(value="findByName/{name}", method = RequestMethod.GET)
    public List<Customer> findByLastName(@PathVariable String name) {
        return service.findByName(name);
    }
}
