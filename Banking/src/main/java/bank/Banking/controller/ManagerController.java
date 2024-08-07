package bank.Banking.controller;


import bank.Banking.entity.Manager;
import bank.Banking.service.ManagerService;
import bank.Banking.util.BankConstants;
import bank.Banking.util.BankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/create")
    public ResponseEntity<String> createManager(@RequestBody Manager manager){
        try{
            return managerService.createManager(manager);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return BankUtil.getResponseEntity(BankConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public Optional<Manager> getManagerById(@PathVariable Integer id ){
        return managerService.getManagerById(id);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Manager>> getAllManager(){
        try{
            return managerService.getAllManager();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> createManager(@PathVariable Integer id){
        try{
            return managerService.deleteManager(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return BankUtil.getResponseEntity(BankConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateManagerDetails(@RequestBody Manager manager){
        try {
            return managerService.updateManagerDetails(manager);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return BankUtil.getResponseEntity(BankConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}