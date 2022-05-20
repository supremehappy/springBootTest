package com.simple.simplemybatis_gradle.repository;

import java.util.List;

import com.simple.simplemybatis_gradle.model.Bank;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankMapper {
    
    Bank selectBankById(long id);
    List<Bank> selectAllBank();
    void insertBank(Bank bank);
}
