package com.Library.Controller;

import com.Library.Model.AccountingRecords;
import com.Library.Services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/Accounts")
@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    AccountingRecords updateAccount;

    @RequestMapping(value = "/mainAccountMenu", method = RequestMethod.GET)
    public String mainAccountMenu(Model model){
        List<AccountingRecords> list = accountService.returnAccounts();
        model.addAttribute("allAccount", list);
        model.addAttribute("newAccount", new AccountingRecords());
        model.addAttribute("deleteAccount", new AccountingRecords());

        return "account/mainAccountMenu";
    }

    @RequestMapping(value="/addAccount", method= RequestMethod.POST)
    public ResponseEntity addAccount(@ModelAttribute AccountingRecords account) throws ParseException {

           accountService.createNewAccount(account);

        return ResponseEntity.ok("Аккаунт успешно создан:  account ID " + account.getAccountId() + "<br>"
                + " client Id " + account.getClientId() + "<br>"
                + " book Id " + account.getBookId() + "<br>"
                + " receipt Date " + account.getReceiptDate() + "<br>"
                + " return Date " + account.getReturnDate() + "<br>"
                + " status " + account.getStatus());
    }

    @GetMapping(value="/deleteAccount/{accountId}")
    public ResponseEntity deleteAccount (@PathVariable("accountId") Integer accountId){
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Аккаунт с ID " + accountId + "успешно удален");
    }

    @GetMapping(value="/updateAccount1/{accountId}")
    public String updateAccount1(@PathVariable Integer accountId, Model model){
        updateAccount = new AccountingRecords();
        updateAccount.setAccountId(accountId);
        model.addAttribute("updateAccount", updateAccount);
        return "account/updateAccount";
    }

    @RequestMapping(value="/updateAccount2", method=RequestMethod.POST)
    public ResponseEntity updateAccount2(@ModelAttribute AccountingRecords account){

        updateAccount.setClientId(account.getClientId());
        updateAccount.setBookId(account.getBookId());
        updateAccount.setReceiptDate(account.getReceiptDate());
        updateAccount.setReturnDate(account.getReturnDate());
        updateAccount.setStatus(account.getStatus());

        accountService.modifyAccount(updateAccount);

        return ResponseEntity.ok("Аккаунт успешно обновлен:  account ID " + updateAccount.getAccountId() + "<br>"
                + " client Id " + updateAccount.getClientId() + "<br>"
                + " book Id " + updateAccount.getBookId() + "<br>"
                + " receipt Date " + updateAccount.getReceiptDate() +" <br>"
                + " return Date " + updateAccount.getReturnDate() + "<br>"
                + " status " + updateAccount.getStatus());
    }

    @RequestMapping(value="/searchAccount", method=RequestMethod.GET)
    public String searchAccount (@RequestParam("accountId")Integer accountId, Model model){

       AccountingRecords searchAkk =  accountService.searchAccount(accountId);
        model.addAttribute("searchAkk", searchAkk);
        return "account/searchAccount";
    }
}
