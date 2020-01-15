package View;

import Controller.AccountController;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
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

    public int showMenu() throws ParseException {
        System.out.println("Добро пожаловать в меню редактирования аккаунта");
        System.out.println("1. Добавить аккаунт ");
        System.out.println("2. Удалить аккаунт ");
        System.out.println("3. Изменить аккаунт ");
        System.out.println("4. Найти аккаунт ");
        System.out.println("5. Назад");
        try {
            number3 = scannerInteger();
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
            switchAccountMenu();
        }

        return number3;
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

        try {
            System.out.println("Добро пожаловать в меню создания аккаунта");
            System.out.println("Введите ID аккаунта: ");
            int newAccountId = scannerInteger();

            System.out.println("Введите ID клиента: ");
            int clientId = scannerInteger();

            System.out.println("Введите ID книги: ");
            int bookId = scannerInteger();

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            System.out.println("Введите дату возврата книги: ");
            Scanner scanner2 = new Scanner(System.in);
            String returnDate = scanner2.next();
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy.MM.dd");
            Date myDate2 = dateFormat2.parse(returnDate);
            java.sql.Date sqlDate2 = new java.sql.Date(myDate2.getTime());

            System.out.println("Введите статус аккаунта (Свободна/Занята): ");
            String status = scannerString();
            if(status.equals("Свободна".toLowerCase())||status.equals("Занята".toLowerCase())){
                accountController.addAccount(newAccountId, clientId, bookId, sqlDate, sqlDate2, status);
            }
            else {
                System.out.println("Неправильная запись в поле status");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            switchAccountMenu();
        }

    }

    public void deleteAccount() throws ParseException {
try {
        System.out.println("Введите Id аккаунта который желаете удалить: ");
        int accountId = scannerInteger();

        accountController.deleteAccount(accountId);
    }
        catch (InputMismatchException e){
        System.out.println("Возможно вы ввели неккоректные данные " + e);
        System.out.println("Попробуйте снова.");
    }
        finally {
        switchAccountMenu();
    }
    }

    public void updateAccount() throws ParseException {
try {
        System.out.println("Введите ID аккаунта: ");
        int updateAccountId = scannerInteger();

        System.out.println("Введите ID клиента: ");
        int updateClientId = scannerInteger();

        System.out.println("Введите ID книги: ");
        int updateBookId = scannerInteger();

        Date date = new Date();

        System.out.println("Введите дату возврата книги: ");
        Scanner scanner3 = new Scanner(System.in);
        String updateReturnDate = scanner3.next();
        DateFormat dateFormat3 = new SimpleDateFormat( "yyyy.MM.dd" );
        Date myDate3 = dateFormat3.parse(updateReturnDate);
        java.sql.Date sqlDate3 = new java.sql.Date(myDate3.getTime());

        System.out.println("Введите статус аккаунта (Занята / Свободна): ");
        String updateStatus = scannerString();

        if(updateStatus.equals("Свободна".toLowerCase())||updateStatus.equals("Занята".toLowerCase())){
            accountController.updateAccount(updateAccountId,updateClientId,updateBookId,date,sqlDate3,updateStatus);
        }
        else {
            System.out.println("Неправильная запись в поле status");
        }
    }
        catch (InputMismatchException e){
        System.out.println("Возможно вы ввели неккоректные данные " + e);
        System.out.println("Попробуйте снова.");
    }
        finally {
        switchAccountMenu();
    }
    }

    public void searchTheAccoutnt() throws ParseException {
        try {
        System.out.println("Введите ID аккаунта: ");
        int accountId = scannerInteger();
        System.out.println(accountController.searchAccount(accountId));
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            switchAccountMenu();
        }
    }

}
