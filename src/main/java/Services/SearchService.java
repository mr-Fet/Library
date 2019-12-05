package Services;

import Model.AcountingRecords;
import Model.Authors;
import Model.Books;
import Model.Client;

public interface SearchService {
    Client searchClient(Integer clientId);
    Books searchBook(Integer bookId);
    Authors searchAuthor(Integer authorId);
    AcountingRecords searchAccount(Integer accountId);
}
