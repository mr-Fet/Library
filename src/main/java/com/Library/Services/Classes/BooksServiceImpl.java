package com.Library.Services.Classes;

import com.Library.Model.Authors;
import com.Library.Model.Books;
import com.Library.Repository.AuthorsRepository;
import com.Library.Repository.BooksRepository;
import com.Library.Services.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BooksServiceImpl  implements BooksService {

    private final BooksRepository booksRepository;
    private final AuthorsRepository authorsRepository;


    @Override
    public void createBook(Books book) {
      booksRepository.save(book);
    }
    @Override
    public void deleteBook(Integer bookId) {
        booksRepository.deleteById(bookId);
    }
    @Override
    public void modifyBook(Books book) {
        booksRepository.save(book);
    }
    @Override
    public List<Books> returnAllBooks() {
        return (List<Books>) booksRepository.findAll();
    }

    @Override
    public List<Books> searchBookByAuthor(String authorLastName) {
        List<Authors> list = authorsRepository.findAllByLastName(authorLastName);
        List<Books> booksList = new ArrayList<>();
        for(Authors x : list){

            for(Books z : booksRepository.findAll()){
                if (z.getAuthorId().equals(x.getAuthorId())){
                    booksList.add(z);
                }
            }
        }

        return booksList;
    }

    @Override
    public List<Books> searchBookByName(String bookName) {

        return booksRepository.findAllByBookName(bookName);
}

    @Override
    public List<Books> searchBookById(Integer bookId) {
        return booksRepository.findAllByBookId(bookId);
    }


}
