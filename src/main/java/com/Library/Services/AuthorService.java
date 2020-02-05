package com.Library.Services;

import com.Library.Model.Authors;

import java.util.List;

public interface AuthorService {
    void createNewAuthor(Authors author) ;
    void deleteAuthor(Integer authorId);
    void modifyAuthor(Authors author);
    List<Authors> searchAuthor(String lastName);
    List<Authors> returnAuthors();
}
