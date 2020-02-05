package com.Library.Services.Classes;

import com.Library.Model.AccountingRecords;
import com.Library.Repository.AccountRepository;
import com.Library.Services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceIMPL implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public void createNewAccount(AccountingRecords newAccount) {
        accountRepository.save(newAccount);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public void modifyAccount(AccountingRecords modifyAccount) {
        accountRepository.save(modifyAccount);
    }

    @Override
    public AccountingRecords searchAccount(Integer accountId) {

        return accountRepository.findById(accountId).get();
    }

    @Override
    public List<AccountingRecords> returnAccounts() {
        return (List<AccountingRecords>) accountRepository.findAll();
    }
}
