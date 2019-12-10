package View;

import Controller.AuthorController;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AuthorView {
    private AuthorController authorController = new AuthorController();
    private GeneralView generalView = new GeneralView();
    private int number4;

    private String scannerString(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
    private int scannerInteger(){
        Scanner scanner = new Scanner(System.in);
        number4 = scanner.nextInt();
        return number4;
    }

    public int showMenu() throws ParseException {
        System.out.println("Добро пожаловать в меню редактирования авторов");
        System.out.println("1. Добавить автора ");
        System.out.println("2. Удалить автора ");
        System.out.println("3. Изменить автора ");
        System.out.println("4. Найти автора ");
        System.out.println("5. Назад");
        try {
            number4 = scannerInteger();
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
            switchAuthorMenu();
        }

        return number4;
    }
    public void switchAuthorMenu() throws ParseException {
        switch (showMenu()){
            case (1): addAuthor();
                break;
            case (2): deleteAuthor();
                break;
            case (3): updateAuthor();
                break;
            case (4): searchTheAuthors();
            break;
            case (5): generalView.dataEditingSwithc();
                break;
        }
    }

    public void addAuthor() throws ParseException {
try {
        System.out.println("Введите ID автора: ");
        int newAuthorId = scannerInteger();

        System.out.println("Введите имя автора: ");
        String newAuthorFirstName = scannerString();

        System.out.println("Введите фамилию автора: ");
        String newAuthorLastName = scannerString();

        authorController.addAuthor(newAuthorId, newAuthorFirstName, newAuthorLastName);
    }
        catch (
    InputMismatchException e){
        System.out.println("Возможно вы ввели неккоректные данные " + e);
        System.out.println("Попробуйте снова.");
    }
finally {
    switchAuthorMenu();
}

    }
    public void deleteAuthor() throws ParseException {
        try {
        System.out.println("Введите Id автора которого желаете удалить: ");
        int authorId = scannerInteger();
        authorController.deleteAuthor(authorId);
    }
        catch (
    InputMismatchException e){
        System.out.println("Возможно вы ввели неккоректные данные " + e);
        System.out.println("Попробуйте снова.");
    }
        finally {
            switchAuthorMenu();
        }
    }
    public void updateAuthor() throws ParseException {
        try {
        System.out.println("Введите Id автора, которого желаете изменить: ");
        int authorId = scannerInteger();

        System.out.println("Введите новое имя автора: ");
        String updateAuthorFirstName = scannerString();

        System.out.println("Введите новую фамилию автора: ");
        String updateAuthorLastName = scannerString();

        authorController.updateAuthor(authorId, updateAuthorFirstName, updateAuthorLastName);
    }
        catch (
    InputMismatchException e){
        System.out.println("Возможно вы ввели неккоректные данные " + e);
        System.out.println("Попробуйте снова.");
    }
        finally {
            switchAuthorMenu();
        }
    }
    public void searchTheAuthors() {
        try {
        System.out.println("Введите ID автора: ");
        int authorId = scannerInteger();
            System.out.println(authorController.searchAuthor(authorId));
    }
        catch (
    InputMismatchException e){
        System.out.println("Возможно вы ввели неккоректные данные " + e);
        System.out.println("Попробуйте снова.");
    }
    }
}
