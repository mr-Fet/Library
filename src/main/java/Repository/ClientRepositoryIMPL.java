package Repository;

import Model.Client;
import Model.SpisokOfEntity;

import java.awt.print.Book;
import java.util.Iterator;
import java.util.Map;

public class ClientRepositoryIMPL implements ClientRepository {
    SpisokOfEntity spisokOfEntity = new SpisokOfEntity();

    public Client createClient(Integer newId, String newFirstname, String newLastname){

        spisokOfEntity.clientsMap.put(newId,new Client(newId,newFirstname,newLastname));

        return new Model.Client(newId,newFirstname,newLastname);
    }

    public void deleteClient(int clientId) {
        SpisokOfEntity spisok = new SpisokOfEntity();
        Map<Integer,Client> newMap = spisok.getClientsMap();
        Iterator<Map.Entry<Integer,Client>> iterator = spisok.getClientsMap().entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Client> entry = iterator.next();
            if(entry.getKey().equals(clientId)){
                newMap.remove(clientId);
            }
            spisok.setClientsMap(newMap);
        }
    }

    public void modifyClient(int clientId) {

    }
}
