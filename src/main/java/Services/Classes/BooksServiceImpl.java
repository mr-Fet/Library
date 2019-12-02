package Services.Classes;

import Repository.BooksRepository;
import Repository.BooksRepositoryIMPL;
import Repository.ClientRepository;
import Repository.ClientRepositoryIMPL;
import Services.BooksService;

public class BooksServiceImpl  implements BooksService {

    private BooksRepository booksRepository = new BooksRepositoryIMPL();

    @Override
    public void createBook(Integer newBookId, String newBookName, Integer newAuthorId, String newCategory) {
        booksRepository.createBook(newBookId,newBookName,newAuthorId,newCategory);
    }

    @Override
    public void deleteBook(Integer bookId) {
        booksRepository.deleteBook(bookId);
    }

    @Override
    public void modifyBook(Integer bookId, String updateBookName, Integer updateAuthorId, String updateCategory) {
        booksRepository.modifyBook(bookId,updateBookName,updateAuthorId,updateCategory);
    }
}
