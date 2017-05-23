package ACMEInvoice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String value;
    private long customerId;

    public Address(long id, String value, long customerId) {
        this.id = id;
        this.value = value;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return String.format(
                "Address[id=%d, value='%s', customerId='%s']",
                id, value, customerId);
    }

    public long getId(){
        return this.id;
    }

    public String getValue(){
        return this.value;
    }

    public long getCustomerId(){
        return this.customerId;
    }

    public void setId(long newId){
        this.id=newId;
    }

    public void setValue(String value){
        this.value= value;
    }

    public void setCustomerId(long customerId){
        this.customerId= customerId;
    }

}