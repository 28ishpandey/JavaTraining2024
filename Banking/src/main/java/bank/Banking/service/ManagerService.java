package bank.Banking.service;

import bank.Banking.entity.Customer;
import bank.Banking.entity.Manager;
import bank.Banking.repository.CustomerRepository;
import bank.Banking.repository.ManagerRepository;
import bank.Banking.util.BankConstants;
import bank.Banking.util.BankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public ResponseEntity<String> createManager(Manager manager) {
        managerRepository.save(manager);
        return BankUtil.getResponseEntity(BankConstants.CREATED_SUCCESSFULLY, HttpStatus.OK);
    }

    public Optional<Manager> getManagerById(Integer id){
        return managerRepository.findById(id);
    }

    public ResponseEntity<List<Manager>> getAllManager(){
        return new ResponseEntity<>(managerRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String> deleteManager(Integer id){
        managerRepository.deleteById(id);
        return BankUtil.getResponseEntity("Manager Deleted Successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> updateManagerDetails(Manager manager) {
        Optional<Manager> optionalManager = managerRepository.findById(manager.getmId());
        if(optionalManager.isPresent()){
            Manager mang = optionalManager.get();

            mang.setmName(manager.getmName());
            mang.setmPhone(manager.getmPhone());

            managerRepository.save(mang);
            return BankUtil.getResponseEntity("Manager Updated Successfully",HttpStatus.OK);
        }
        return BankUtil.getResponseEntity("Manager Not Found", HttpStatus.BAD_REQUEST);

    }
}

