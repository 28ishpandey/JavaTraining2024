package bank.Banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId;
    private String cName;
    private String cPhone;
    private String cAddress;
    private Integer mId;

    public Customer(Integer cId, String cName, String cPhone, String cAddress, Integer mId) {
        this.cId = cId;
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.mId = mId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cId, customer.cId) && Objects.equals(cName, customer.cName) && Objects.equals(cPhone, customer.cPhone) && Objects.equals(cAddress, customer.cAddress) && Objects.equals(mId, customer.mId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, cName, cPhone, cAddress, mId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cPhone='" + cPhone + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", mId=" + mId +
                '}';
    }

    public Customer() {
    }
}
