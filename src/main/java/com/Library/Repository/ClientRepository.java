package com.Library.Repository;

import com.Library.Model.Clients;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Clients, Integer> {
    List<Clients> findAllByLastName(String lastName);
}