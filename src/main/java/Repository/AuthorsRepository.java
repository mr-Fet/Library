package Repository;

public interface AuthorsRepository {
    void createAuthor(Integer newId, String newFirstname, String newLastname);
    void deleteAuthor(Integer clientId);
    void modifyAuthor(Integer clientId, String updateFirstname, String updateLastname);
}
