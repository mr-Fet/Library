package Services;

public interface AuthorService {
    void createNewAuthor(Integer newAuthorId, String newAuthorFirstname, String newAuthorLastname) ;
    void deleteAuthor(Integer authorId);
    void modifyAuthor(Integer authorId, String updateAuthorFirstname, String updateAuthorLastname);
}
