package Repository;

public interface AuthorsRepository {
    void createAuthor(Integer newAuthorId, String newAuthorFirstname, String newAuthorLastname);
    void deleteAuthor(Integer authorId);
    void modifyAuthor(Integer authorId, String updateAuthorFirstname, String updateAuthorLastname);
}
