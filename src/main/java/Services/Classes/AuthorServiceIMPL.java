package Services.Classes;

import Model.Authors;
import Repository.AuthorsRepository;
import Repository.AuthorsRepositoryIMPL;
import Services.AuthorService;

public class AuthorServiceIMPL implements AuthorService {

    private AuthorsRepository authorsRepository = new AuthorsRepositoryIMPL();

    @Override
    public void createNewAuthor(Integer newAuthorId, String newAuthorFirstname, String newAuthorLastname) {
        authorsRepository.createAuthor(newAuthorId,newAuthorFirstname,newAuthorLastname);
    }

    @Override
    public void deleteAuthor(Integer authorId) {
        authorsRepository.deleteAuthor(authorId);
    }

    @Override
    public void modifyAuthor(Integer authorId, String updateAuthorFirstname, String updateAuthorLastname) {
        authorsRepository.modifyAuthor(authorId,updateAuthorFirstname,updateAuthorLastname);
    }
    @Override
    public Authors searchAuthor(Integer authorId) {
        return authorsRepository.searchTheAuthors(authorId);
    }
}
