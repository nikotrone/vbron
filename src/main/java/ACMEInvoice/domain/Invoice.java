package ACMEInvoice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;


@Entity (name="CUSTOMER")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private long id;

    @Column (name = "customerId")
    private long customerId;

    @Column (name = "addressId")
    private long addressId;

    @Column (name = "amount")
    private float amount;

    @Column (name = "month")
    private short month;

    @Column (name = "year")
    private short year;

    @Column (name = "type")
    private String type;

    public Invoice(){}

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

    public long getCustomerId(){
        return this.customerId;
    }

    public long getAddressId(){
        return this.addressId;
    }

    public float getAmount(){
        return this.amount;
    }

    public String getType(){
        return this.type;
    }

    public short getMonth(){
        return this.month;
    }

    public short getYear(){
        return this.year;
    }

    public void setId(long newId){
        this.id=newId;
    }

    public void setAddressId(long newAddressId){
        this.addressId= newAddressId;
    }

    public void setCustomerId(long newCustomerId){
        this.customerId= newCustomerId;
    }

    public void setAmount(float newAmount){
        this.amount= newAmount;
    }

    public void setType(String newType){
        this.type= newType;
    }

    public void setMonth(short newMonth){
        this.month= newMonth;
    }

    public void setAddressId(short newYear){
        this.year= newYear;
    }

}