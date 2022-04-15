package com.simple.simplemybatis_gradle;

import java.util.List;

import com.simple.simplemybatis_gradle.model.Bank;
import com.simple.simplemybatis_gradle.service.BankService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BankController {
    
    private static final Logger log = LoggerFactory.getLogger(BankController.class);
    
    @Autowired
    private BankService bankService;
    
    @GetMapping(value="/bank")
    public Bank getBankId(Long id){
        log.info("id : "+id);
        log.info("bank data : "+bankService.getBankById(id));
        System.out.println("----------------- "+bankService.getBankById(id).toString());
        return bankService.getBankById(id);
    }

    @GetMapping(value="/banks")
    public List<Bank> getBanks(){
        log.info("bank : ");
        log.info("banks data : "+bankService.getAllBank());
        //return bankService.getAllBank();
        return bankService.getAllBank();
    }
}
