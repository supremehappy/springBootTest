package com.simple.simplemybatis_maven.service;

import java.util.List;

import com.simple.simplemybatis_maven.model.Bank;
import com.simple.simplemybatis_maven.repository.BankMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {
    
    @Autowired
    private BankMapper bankMapper;

    public Bank getBankById(Long id){
        return bankMapper.selectBankById(id);
    }

    public List<Bank> getAllBank(){
        return bankMapper.selectAllBank();
    }

    @Transactional
    public void addBank(Bank bank){
        bankMapper.insertBank(bank);
    }
}