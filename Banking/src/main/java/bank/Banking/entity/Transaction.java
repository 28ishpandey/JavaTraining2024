package bank.Banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tId;
    private String operation;
    private LocalDateTime dateTime;
    private Integer aId;
    private Long amount;

    public Transaction(Integer tId, String operation, LocalDateTime dateTime, Integer aId, Long amount) {
        this.tId = tId;
        this.operation = operation;
        this.dateTime = dateTime;
        this.aId = aId;
        this.amount = amount;
    }

    public Transaction() {
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(tId, that.tId) && operation == that.operation && Objects.equals(dateTime, that.dateTime) && Objects.equals(aId, that.aId) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tId, operation, dateTime, aId, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tId=" + tId +
                ", operation=" + operation +
                ", dateTime=" + dateTime +
                ", cId='" + aId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
