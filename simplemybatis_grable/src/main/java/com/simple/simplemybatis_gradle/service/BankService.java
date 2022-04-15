package com.simple.simplemybatis_gradle.service;

import java.util.List;

import com.simple.simplemybatis_gradle.model.Bank;
import com.simple.simplemybatis_gradle.repository.BankMapper;

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