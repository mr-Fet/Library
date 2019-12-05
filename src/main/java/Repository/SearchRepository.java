package Repository;

import Model.AcountingRecords;
import Model.Authors;
import Model.Books;
import Model.Client;

import java.util.Map;

public interface SearchRepository {
    Client searchTheClient(int clientId);
    Books searchTheBooks(int booksId);
    Authors searchTheAuthors(int authorId);
    AcountingRecords searchTheAccount(int accountId);

}
