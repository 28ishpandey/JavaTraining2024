package bank.Banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mId;
    private String mName;
    private String mPhone;

    public Manager(Integer mId, String mName, String mPhone) {
        this.mId = mId;
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(mId, manager.mId) && Objects.equals(mName, manager.mName) && Objects.equals(mPhone, manager.mPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mPhone);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mPhone='" + mPhone + '\'' +
                '}';
    }
}
