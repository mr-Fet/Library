package com.Library.Repository;

import com.Library.Model.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository <Books, Integer> {
    List<Books> findAllByBookName(String bookName);
    List<Books> findAllByBookId(Integer bookId);
    Books findBooksByAuthorId(Integer authorId);
    List<Books> findAllByAuthorId(Integer authorId);
}