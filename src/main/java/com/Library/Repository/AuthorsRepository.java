package com.Library.Repository;

import com.Library.Model.Authors;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorsRepository extends CrudRepository<Authors, Integer> {
List<Authors> findAllByLastName(String lastName);
}
