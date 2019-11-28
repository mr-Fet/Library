package Repository;

import Model.*;

import java.util.Map;

public class SearchRepositoryIMPL implements SearchRepository {


    public Client searchTheClient(int clientId, Map<Integer, Client> localMap) {
        Client key = localMap.get(clientId);
        return key;
    }

    public Books searchTheBooks(int booksId, Map<Integer, Books> localBooksMap) {
        Books key = localBooksMap.get(booksId);
        return key;
    }

    public Authors searchTheAuthors(int authorId,Map<Integer, Authors> localAuthorsMap) {
        Authors key = localAuthorsMap.get(authorId);
        return key;
    }

    public AcountingRecords searchTheAccoutnt(int accountId, Map<Integer, AcountingRecords> localAcountMap) {

        AcountingRecords key = localAcountMap.get(accountId);
        return key;
        }
    }


