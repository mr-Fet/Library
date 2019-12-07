package Services.Classes;

import Model.AcountingRecords;
import Repository.AccountRepository;
import Repository.AccountRepositoryIMPL;
import Services.AccountService;

import java.util.Date;

public class AccountServiceIMPL implements AccountService {
    AccountRepository accountRepository = new AccountRepositoryIMPL();

    @Override
    public void createNewAccount(Integer newAccountId, Integer clientId, Integer bookId, String receiptDate, String returnDate, String status) {
        accountRepository.createNewAccount(newAccountId,clientId,bookId,receiptDate,returnDate,status);
    }

    @Override
    public void deleteAccount(Integer accountId) {
accountRepository.deleteAccount(accountId);
    }

    @Override
    public void modifyAccount(Integer accountId, Integer updateClientId, Integer updateBookId, String updateReceiptDate, String updateReturnDate, String UpdateStatus) {
accountRepository.modifyAccount(accountId,updateClientId,updateBookId,updateReceiptDate,updateReturnDate,UpdateStatus);
    }
    @Override
    public AcountingRecords searchAccount(Integer accountId) {
        return accountRepository.searchTheAccount(accountId);
    }
}
