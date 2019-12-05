package Controller;

import Model.AcountingRecords;
import Model.Authors;
import Model.Books;
import Model.Client;
import Services.Classes.SearchServiceIMPL;
import Services.SearchService;

public class SearchController {

    private SearchService searchService = new SearchServiceIMPL();

    public Client searchClient(Integer clientId){

       return searchService.searchClient(clientId);

    }
    public Books searchBook (Integer bookId){
        return searchService.searchBook(bookId);
    }

    public Authors searchAuthor(Integer authorId){
        return searchService.searchAuthor(authorId);
    }
    public AcountingRecords searchAccount (Integer AccountId){
        return searchService.searchAccount(AccountId);
    }
}
