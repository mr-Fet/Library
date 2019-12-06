package Repository;

import Model.AcountingRecords;

import java.util.Date;

public interface AccountRepository {
    void createNewAccount(Integer newAccountId, Integer clientId, Integer bookId, Date receiptDate, Date returnDate, String status) ;
    void deleteAccount(Integer accountId);
    void modifyAccount(Integer accountId, Integer updateClientId, Integer updateBookId, Date updateReceiptDate, Date updateReturnDate, String UpdateStatus);
    AcountingRecords searchTheAccount(int accountId);
}
