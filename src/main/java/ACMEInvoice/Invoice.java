package ACMEInvoice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id, customerId, addressId;
    private float amount;
    private short month,year;
    private String type;

    public Invoice(long id, long customerId, long addressId, float amount, short month, short year, String type) {
        this.id = id;
        this.addressId = addressId;
        this.customerId = customerId;
        this.amount = amount;
        this.month = month;
        this.year = year;
        this.type = type;

    }

    @Override
    public String toString() {
        return String.format(
                "Address[id=%d, addressId='%s', customerId='%s']",
                id, addressId, customerId);
    }

    public long getId(){
        return this.id;
    }

    /*public String getValue(){
        return this.value;
    }*/

    public long getCustomerId(){
        return this.customerId;
    }

    public void setId(long newId){
        this.id=newId;
    }

    /*public void setValue(String value){
        this.value= value;
    }*/

    public void setCustomerId(long customerId){
        this.customerId= customerId;
    }

}