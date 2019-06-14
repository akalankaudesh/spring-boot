package lk.ijse.dep.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer extends SuperEntity {

    @Id
    private String cusid;
    private String cusname;
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String address) {
        this.cusid = id;
        this.cusname = name;
        this.address = address;
    }

    public String getId() {
        return cusid;
    }

    public void setId(String id) {
        this.cusid = id;
    }

    public String getName() {
        return cusname;
    }

    public void setName(String name) {
        this.cusname = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + cusid + '\'' +
                ", name='" + cusname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
