package com.Library.Repository;

import com.Library.Model.AccountingRecords;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountingRecords, Integer> {

}
