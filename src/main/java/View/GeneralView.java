package View;

import Model.Authors;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GeneralView {

    static int number;
    static BooksView booksView = new BooksView();
    static ClientView clientView = new ClientView();
    static AccountView accountView = new AccountView();
    static AuthorView authorView = new AuthorView();
    static int i;

    private int vvod()   {
            Scanner scanner = new Scanner(System.in);

            return  scanner.nextInt();
    }

    public void mainMenuSwithc () throws ParseException {

        switch (mainMenu()){
            case (1): dataEditingSwithc();
                break;
            case (2): booksView.returnAllBooks();
                break;
            case (3): seachBooksSwithc();
                break;
            case (4): giveBookSwitch();
            break;

        }
    }
    public void dataEditingSwithc() throws ParseException {
        switch (dataEditing()) {
            case (1):
                clientView.switchClientMenu();
                break;
            case (2):
                booksView.switchBooksMenu();
                break;
            case (3):
                accountView.switchAccountMenu();
                break;
            case (4):authorView.switchAuthorMenu();
            break;
            case (5):
                mainMenuSwithc();
                break;
        }
    }
    public void seachBooksSwithc() throws ParseException {

        switch (searchTheBook()) {
            case (1):
                booksView.searchTheBooksById();
                break;
            case (2):
                booksView.searchTheBooksByAuthor();
                break;
            case (3):
                booksView.searchTheBooksByName();
                break;
            case (4):
                mainMenuSwithc();
                break;
        }
    }

    public void giveBookSwitch() throws ParseException {
        System.out.println("Клиент, которому неоходимо выдать книгу уже есть в базе?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        System.out.println("3. Назад");
        //System.out.println("4. Перейти к поиску клиента");
        try {
        number = vvod();
        switch (number){
            case (1): accountView.addAccount();
                break;
            case (2):
                System.out.println("Тогда сначала создайте клиента");
                clientView.addClient();
                System.out.println("Теперь можете создать аккаунт");
                accountView.addAccount();
                break;
            case (3): mainMenuSwithc();
            break;
          //  case (4): clientView.searchTheClient();
            //break;
        }
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
            giveBookSwitch();
        }
    }
    public void addBookSwitch() throws ParseException {
        System.out.println("Автор книги, которую вы желаете добавить, есть в нашей базе?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        System.out.println("3. Назад");
        try {
            number = vvod();
            switch (number){
                case (1): booksView.addBook();
                    break;
                case (2):
                    System.out.println("Тогда сначала создайте автора");
                    authorView.addAuthor();
                    System.out.println("Теперь можете добавить книгу");
                    booksView.addBook();
                    break;
                case (3): booksView.switchBooksMenu();
            }
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
            addBookSwitch();
        }
    }

    public int mainMenu() throws ParseException {
        System.out.println("_________ДОБРО ПОЖАЛОВАТЬ В ГЛАВНОЕ МЕНЮ_________");
        System.out.println("1. Редактирование данных ");
        System.out.println("2. Показать все доступные книги ");
        System.out.println("3. Найти книгу ");
        System.out.println("4. Выдать книгу ");
        System.out.println("Введите желаемый номер пункта меню");
        try {
            number = vvod();
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
            mainMenuSwithc();
        }

        return number;
    }
    public int dataEditing() throws ParseException {
        System.out.println("_____Меню редактирования данных_____");
        System.out.println("1. Редактировать пользователей ");
        System.out.println("2. Редактировать книги ");
        System.out.println("3. Редактировать учетные записи ");
        System.out.println("4. Редактировать авторов ");
        System.out.println("5. Назад");
        try {
            number = vvod();
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
            dataEditingSwithc();
        }

        return number;
    }
    public int searchTheBook() throws ParseException {
        System.out.println("_____Меню поиска книги_____");
        System.out.println("1. Поиск по ID ");
        System.out.println("2. Поиск по автору ");
        System.out.println("3. Поиск по названию ");
        System.out.println("4. Назад");
        try {
            number = vvod();
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
            seachBooksSwithc();
        }

        return number;
    }
}
