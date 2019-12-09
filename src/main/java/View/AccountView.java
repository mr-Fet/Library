package View;

import Controller.AccountController;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AccountView {

    private AccountController accountController = new AccountController();
    private GeneralView generalView = new GeneralView();
    private int number3;

    private String scannerString(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
    private int scannerInteger(){
        Scanner scanner = new Scanner(System.in);
        number3 = scanner.nextInt();
        return number3;
    }

    public int showMenu(){
        System.out.println("Добро пожаловать в меню редактирования аккаунта");
        System.out.println("1. Добавить аккаунт ");
        System.out.println("2. Удалить аккаунт ");
        System.out.println("3. Изменить аккаунт ");
        System.out.println("4. Найти аккаунт ");
        System.out.println("5. Назад");
        number3=0;
        return scannerInteger();
    }
    public void switchAccountMenu() throws ParseException {
        //showMenu();
        switch (showMenu()){
            case (1): addAccount();
                break;
            case (2): deleteAccount();
                break;
            case (3): updateAccount();
                break;
            case(4): searchTheAccoutnt();
                break;
            case (5): generalView.dataEditingSwithc();
break;
        }
    }
    public void addAccount() throws ParseException {

        System.out.println("Добро пожаловать в меню создания аккаунта");
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
        DateFormat dateFormat = new SimpleDateFormat( "yyyy.MM.dd" );
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        System.out.println("Введите дату возврата книги: ");
        Scanner scanner3 = new Scanner(System.in);
        String returnDate = scanner2.next();
        DateFormat dateFormat2 = new SimpleDateFormat( "yyyy.MM.dd" );
        Date myDate2 = dateFormat2.parse(returnDate);
        java.sql.Date sqlDate2 = new java.sql.Date(myDate2.getTime());

        System.out.println("Введите статус аккаунта (Свободна/Занята): ");
        Scanner scanner4 = new Scanner(System.in);
        String status = scanner2.next();

        accountController.addAccount(newAccountId,clientId,bookId,sqlDate,sqlDate2,status);

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
        int updateBookId = scanner2.nextInt();

        Date date = new Date();

        System.out.println("Введите дату возврата книги: ");
        Scanner scanner3 = new Scanner(System.in);
        String updateReturnDate = scanner3.next();
        DateFormat dateFormat3 = new SimpleDateFormat( "yyyy.MM.dd" );
        Date myDate3 = dateFormat3.parse(updateReturnDate);
        java.sql.Date sqlDate3 = new java.sql.Date(myDate3.getTime());

        System.out.println("Введите статус аккаунта (Занята / Свободна): ");
        Scanner scanner4 = new Scanner(System.in);
        String updateStatus = scanner4.next();

        accountController.updateAccount(updateAccountId,updateClientId,updateBookId,date,sqlDate3,updateStatus);
    }

    public void searchTheAccoutnt() {
        System.out.println("Введите ID аккаунта: ");
        Scanner scanner = new Scanner(System.in);
        int accountId = scanner.nextInt();
        System.out.println(accountController.searchAccount(accountId));
    }

}
