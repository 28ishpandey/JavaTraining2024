package bank.Banking.repository;

import bank.Banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findbyCId(Integer cId);
}
