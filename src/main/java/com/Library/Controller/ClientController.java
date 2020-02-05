package com.Library.Controller;

import com.Library.Model.Clients;
import com.Library.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Client")
@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    Clients upClient;

    @RequestMapping(value = "/mainClientMenu", method = RequestMethod.GET)
    public String mainClientMenu(Model model){
        String searchLastName = null;
        List<Clients> list = clientService.returnAllClients();
        model.addAttribute("allClient", list);
        model.addAttribute("newClient", new Clients());
        model.addAttribute("deleteClient", new Clients());
        model.addAttribute("searchLastName", searchLastName);

        return "client/mainClientMenu";
    }

    @RequestMapping(value="/addClient", method= RequestMethod.POST)
    public ResponseEntity registration(@ModelAttribute Clients client){
        clientService.createNewClient(client);

        return  ResponseEntity.ok("Клиент: id " + client.getClientId() + "<br>"
                + " Name " + client.getFirstName() + "<br>"
                + " Last name " + client.getLastName() + " успешно создан");
    }

    @GetMapping(value="/deleteClient/{clientId}")
    public ResponseEntity deleteClient (@PathVariable Integer clientId){
        try {
            clientService.deleteClient(clientId);
        }
        catch (Exception e){
            return ResponseEntity.ok("Нельзя удалить клиента. Он связан с записью в таблице аккаунтов.");
        }
        return  ResponseEntity.ok("Клиент " + clientId + " успешно удален");
    }

    @GetMapping(value="/updateClient1/{clientId}")
    public String updateClient1(@PathVariable Integer clientId, Model model){
        upClient = new Clients();
        upClient.setClientId(clientId);
        model.addAttribute("updateClient", upClient);
        return "client/update";
    }

    @RequestMapping(value="/updateClient2", method= RequestMethod.POST)
    public ResponseEntity updateClient2(@ModelAttribute Clients client){
         upClient.setFirstName(client.getFirstName());
         upClient.setLastName(client.getLastName());
         clientService.modifyClient(upClient);
        return ResponseEntity.ok("Ваш обновленный клиент: " + "<br>"
                + " clientId " + upClient.getClientId() + "<br>"
                + " name " + upClient.getFirstName() + "<br>"
                + " last name " + upClient.getLastName());
    }

    @RequestMapping(value="/searchClient", method=RequestMethod.GET)
    public String searchClient(@RequestParam("lastName") String lastName, Model model){
       List<Clients> searchList = clientService.searchClient(lastName);
       model.addAttribute("searchClients", searchList);
        return "client/searchTheClient";
    }
}
