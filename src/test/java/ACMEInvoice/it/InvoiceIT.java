package ACMEInvoice.it;

import ACMEInvoice.domain.Invoice;
import ACMEInvoice.repository.InvoiceRepository;
import ACMEInvoice.rest.InvoiceController;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InvoiceIT extends AbstractIT<Category, Long> {

    private InvoiceController controller;
    private InvoiceRepository repository;
    private final static String INVOICE_URL_PREFIX ="invoice";

    @Autowired
    public void setInvoiceController(InvoiceController controller) {
        this.controller=controller;
        super.setController(controller);
    }

    @Autowired
    public void setInvoiceRepository(InvoiceRepository repository) {
        this.repository=repository;
        super.setRepository(repository);
    }

    public InvoiceIT() {
        super(INVOICE_URL_PREFIX, Invoice.class);
    }

    @Test
    public void findByAddressTest() throws Exception {
        Invoice entity=getTestEntity();
        entity.setCustomerId("5");
        repository.save(entity);

        String json= templateGetRequest("/" + CATEGORY_URL_PREFIX + "/findByCustomerId/5");
        List<Invoice> returned=(List<Invoice>)jsonToObject(json);
        Assert.assertTrue("", (returned.get(0).getCustomerId()==5);
    }
}