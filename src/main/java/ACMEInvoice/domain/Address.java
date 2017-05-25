package ACMEInvoice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;


@Entity (name="ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private long id;

    @Column (name = "address")
    private String address;

    @Column (name = "customerId")
    private long customerId;

    public Address(){}

    public Address(long id, String address, long customerId) {
        this.id = id;
        this.address = address;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return String.format(
                "Address[id=%d, value='%s', customerId='%s']",
                id, address, customerId);
    }

    public long getId(){
        return this.id;
    }

    public String getAddress(){
        return this.address;
    }

    public long getCustomerId(){
        return this.customerId;
    }

    public void setId(long newId){
        this.id= newId;
    }

    public void setAddress(String address){
        this.address= address;
    }

    public void setCustomerId(long customerId){
        this.customerId= customerId;
    }

}