package Services.Classes;

import Model.AcountingRecords;
import Model.Authors;
import Model.Books;
import Model.Client;
import Repository.SearchRepository;
import Repository.SearchRepositoryIMPL;
import Services.SearchService;

public class SearchServiceIMPL implements SearchService {
    SearchRepository searchRepository = new SearchRepositoryIMPL();

    @Override
    public Client searchClient(Integer clientId) {

        return searchRepository.searchTheClient(clientId);
    }

    @Override
    public Books searchBook(Integer bookId) {
        return searchRepository.searchTheBooks(bookId);
    }

    @Override
    public Authors searchAuthor(Integer authorId) {
        return searchRepository.searchTheAuthors(authorId);
    }

    @Override
    public AcountingRecords searchAccount(Integer accountId) {
        return searchRepository.searchTheAccount(accountId);
    }
}
