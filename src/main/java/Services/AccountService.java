package Services;

import Model.AcountingRecords;

import java.util.Date;

public interface AccountService {
    void createNewAccount(Integer newAccountId, Integer clientId, Integer bookId, String receiptDate, String returnDate, String status) ;
    void deleteAccount(Integer accountId);
    void modifyAccount(Integer accountId, Integer updateClientId, Integer updateBookId, String updateReceiptDate, String updateReturnDate, String UpdateStatus);
    AcountingRecords searchAccount(Integer accountId);
}
