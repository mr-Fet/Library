package com.Library.Services;

import com.Library.Model.AccountingRecords;

import java.util.List;

public interface AccountService {
    void createNewAccount(AccountingRecords newAccount) ;
    void deleteAccount(Integer accountId);
    void modifyAccount(AccountingRecords modifyAccount);
    AccountingRecords searchAccount(Integer accountId);
    List<AccountingRecords> returnAccounts();
}
