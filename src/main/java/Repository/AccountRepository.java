package Repository;

import Model.AcountingRecords;

import java.util.Date;

public interface AccountRepository {
    void createNewAccount(Integer newAccountId, Integer clientId, Integer bookId, String receiptDate, String returnDate, String status) ;
    void deleteAccount(Integer accountId);
    void modifyAccount(Integer accountId, Integer updateClientId, Integer updateBookId, String updateReceiptDate, String updateReturnDate, String UpdateStatus);
    AcountingRecords searchTheAccount(int accountId);
}
