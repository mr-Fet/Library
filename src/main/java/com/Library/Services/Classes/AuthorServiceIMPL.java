package com.Library.Services.Classes;

import com.Library.Model.Authors;
import com.Library.Repository.AuthorsRepository;
import com.Library.Services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceIMPL implements AuthorService {

    private final AuthorsRepository authorsRepository;

    @Override
    public void createNewAuthor(Authors author) {
        authorsRepository.save(author);
    }

    @Override
    public void deleteAuthor(Integer authorId) {
        authorsRepository.deleteById(authorId);
    }

    @Override
    public void modifyAuthor(Authors author) {

        authorsRepository.save(author);
    }

    @Override
    public List<Authors>  searchAuthor(String lastName) {

        return authorsRepository.findAllByLastName(lastName);
    }

    @Override
    public List<Authors> returnAuthors() {
        return (List<Authors>) authorsRepository.findAll();
    }
}
