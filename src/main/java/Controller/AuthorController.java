package Controller;

import Services.AuthorService;
import Services.Classes.AuthorServiceIMPL;

public class AuthorController {
    AuthorService authorService = new AuthorServiceIMPL();
    public void addAuthor(Integer newAuthorId, String newAuthorFirstname, String newAuthorLastname){

        authorService.createNewAuthor(newAuthorId,newAuthorFirstname,newAuthorLastname);

    }
    public void deleteAuthor (Integer authorId){
        authorService.deleteAuthor(authorId);
    }

    public void updateAuthor(Integer authorId, String updateAuthorFirstname, String updateAuthorLastname){
        authorService.modifyAuthor(authorId, updateAuthorFirstname, updateAuthorLastname);
    }
}
