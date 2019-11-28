package Model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class SpisokOfEntity {

         public Map<Integer, Client> clientsMap = new HashMap<Integer, Client>();
         public Map<Integer, AcountingRecords> acountingRecordsMap = new HashMap<Integer, AcountingRecords>();
         public Map<Integer, Books> booksMap = new HashMap<Integer, Books>();
         public Map<Integer, Integer> booksAuthorsMap = new HashMap<Integer, Integer>();
         public Map<Integer, Authors> authorsMap = new HashMap<Integer, Authors>();



}
