package Repository;

import Model.AcountingRecords;
import Model.Authors;
import Model.Books;
import Model.Client;

import java.util.Map;

public interface SearchRepository {
    Client searchTheClient(int clientId,  Map<Integer, Client> localClientsMap);
    Books searchTheBooks(int booksId,Map<Integer, Books> localBooksMap);
    Authors searchTheAuthors(int authorId,Map<Integer, Authors> localAuthorsMap);
    AcountingRecords searchTheAccoutnt(int accountId,Map<Integer, AcountingRecords> localAcountMap);

}
