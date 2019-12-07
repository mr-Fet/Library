package Controller;

import Model.AcountingRecords;
import Services.AccountService;
import Services.AuthorService;
import Services.Classes.AccountServiceIMPL;
import Services.Classes.AuthorServiceIMPL;

import java.util.Date;

public class AccountController {

    private AccountService accountService = new AccountServiceIMPL();

    public void addAccount(Integer newAccountId, Integer clientId, Integer bookId, String receiptDate, String returnDate, String status){

        accountService.createNewAccount(newAccountId,clientId,bookId,receiptDate,returnDate,status);

    }
    public void deleteAccount (Integer accountId){
        accountService.deleteAccount(accountId);
    }

    public void updateAccount(Integer accountId, Integer updateClientId, Integer updateBookId, String updateReceiptDate, String updateReturnDate, String UpdateStatus){
        accountService.modifyAccount(accountId,updateClientId,updateBookId,updateReceiptDate,updateReturnDate,UpdateStatus);
    }
    public AcountingRecords searchAccount (Integer AccountId){
        return accountService.searchAccount(AccountId);
    }
}
