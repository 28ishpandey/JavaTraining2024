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
    private Operation operation;
    private LocalDateTime dateTime;
    private String cId;
    private Long amount;

    public Transaction(Integer tId, Operation operation, LocalDateTime dateTime, String cId, Long amount) {
        this.tId = tId;
        this.operation = operation;
        this.dateTime = dateTime;
        this.cId = cId;
        this.amount = amount;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
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
        return Objects.equals(tId, that.tId) && operation == that.operation && Objects.equals(dateTime, that.dateTime) && Objects.equals(cId, that.cId) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tId, operation, dateTime, cId, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tId=" + tId +
                ", operation=" + operation +
                ", dateTime=" + dateTime +
                ", cId='" + cId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
