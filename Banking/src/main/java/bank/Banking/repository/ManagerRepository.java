package bank.Banking.repository;

import bank.Banking.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
}
