package View;

import Controller.AccountController;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AccountView {

    private AccountController accountController = new AccountController();

    public void showMenu(){

        System.out.println("Добро пожаловать в меню редактирования аккаунта клиента: ");
        System.out.println("\n");

    }
    public void addClient() throws ParseException {

        System.out.println("Введите ID аккаунта: ");
        Scanner scanner = new Scanner(System.in);
        int newAccountId = scanner.nextInt();

        System.out.println("Введите ID клиента: ");
        Scanner scanner1 = new Scanner(System.in);
        int clientId = scanner1.nextInt();

        System.out.println("Введите ID книги: ");
        Scanner scanner2 = new Scanner(System.in);
        int bookId = scanner1.nextInt();

        Date date = new Date();

        System.out.println("Введите дату возврата книги: ");
        Scanner scanner3 = new Scanner(System.in);
        String dataaaa = scanner2.next();
        Date returnDate = new SimpleDateFormat( "yyyy.MM.dd" ).parse( dataaaa );

        System.out.println("Введите статус аккаунта: ");
        Scanner scanner4 = new Scanner(System.in);
        String status = scanner2.next();

        accountController.addAccount(newAccountId,clientId,bookId,date,returnDate,status);

    }

    public void deleteAccount(){

        System.out.println("Введите Id аккаунта который желаете удалить: ");
        Scanner scanner = new Scanner(System.in);
        int accountId = scanner.nextInt();

        accountController.deleteAccount(accountId);
    }

    public void updateAccount() throws ParseException {

        System.out.println("Введите ID аккаунта: ");
        Scanner scanner = new Scanner(System.in);
        int updateAccountId = scanner.nextInt();

        System.out.println("Введите ID клиента: ");
        Scanner scanner1 = new Scanner(System.in);
        int updateClientId = scanner1.nextInt();

        System.out.println("Введите ID книги: ");
        Scanner scanner2 = new Scanner(System.in);
        int updateBookId = scanner1.nextInt();

        Date date = new Date();

        System.out.println("Введите дату возврата книги: ");
        Scanner scanner3 = new Scanner(System.in);
        String dataaaa = scanner2.next();
        Date updateReturnDate = new SimpleDateFormat( "dd.MM.yyyy" ).parse( dataaaa );

        System.out.println("Введите статус аккаунта (Занята / Свободна): ");
        Scanner scanner4 = new Scanner(System.in);
        String updateStatus = scanner2.next();

        accountController.updateAccount(updateAccountId,updateClientId,updateBookId,date,updateReturnDate,updateStatus);
    }

}
