package View;

import Main.Main;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;



public class GeneralView {

    static int number;
   //static Main main =new Main();
    static BooksView booksView = new BooksView();
    static ClientView clientView = new ClientView();
    static AccountView accountView = new AccountView();

    private int vvod(){
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
       // scanner.close();
        return number;
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

    public void giveBookSwitch() throws ParseException {
        System.out.println("Клиент, которому неоходимо выдать книгу уже есть в базе?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        int result = vvod();
        switch (result){
            case (1): accountView.addAccount();
                break;
            case (2):
                System.out.println("Тогда сначала создайте клиента");
                clientView.addClient();
                accountView.addAccount();
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
            case (4):
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
    public int mainMenu(){
        System.out.println("_________ДОБРО ПОЖАЛОВАТЬ В ГЛАВНОЕ МЕНЮ_________");
        System.out.println("1. Редактирование данных ");
        System.out.println("2. Показать все доступные книги ");
        System.out.println("3. Найти книгу ");
        System.out.println("4. Выдать книгу ");
        System.out.println("Введите желаемый номер пункта меню");
        number=0;
        return vvod();
    }


    public int dataEditing(){
        System.out.println("_____Меню редактирования данных_____");
        System.out.println("1. Редактировать пользователей ");
        System.out.println("2. Редактировать книги ");
        System.out.println("3. Редактировать учетные записи ");
        System.out.println("4. Назад");
        number=0;
            return vvod();
    }
    public int searchTheBook(){
        System.out.println("_____Меню поиска книги_____");
        System.out.println("1. Поиск по ID ");
        System.out.println("2. Поиск по автору ");
        System.out.println("3. Поиск по названию ");
        System.out.println("4. Назад");
        number=0;
        return vvod();
    }
}
