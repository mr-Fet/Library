package View;

import Controller.BooksController;
import Model.Books;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BooksView {

    private BooksController booksController = new BooksController();
    private GeneralView generalView = new GeneralView();
    private int number1;

    private String scannerString(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
    private int scannerInteger(){
        Scanner scanner = new Scanner(System.in);
        number1 = scanner.nextInt();
        return number1;
    }

    public int showMenu() throws ParseException {
        System.out.println("Добро пожаловать в меню редактирования книг");
        System.out.println("1. Добавить книгу ");
        System.out.println("2. Удалить книгу ");
        System.out.println("3. Изменить книгу ");
        System.out.println("4. Назад");
        try {
            number1 = scannerInteger();
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
            switchBooksMenu();
        }

        return number1;
    }
    public void switchBooksMenu() throws ParseException {
        switch (showMenu()){
            case (1): generalView.addBookSwitch();
break;
            case (2): deleteBook();
break;
            case (3): updateBook();
break;
            case (4): generalView.dataEditingSwithc();
break;
        }
    }
    public void addBook() throws ParseException {
        try {
        System.out.println("Добро пожаловать в меню создания книги");
        System.out.println("Введите ID книги: ");
        int newBookId = scannerInteger();

        System.out.println("Введите название книги: ");
        String newBookName = scannerString();

        System.out.println("Введите ID автора книги: ");
        int newAuthorId = scannerInteger();

        System.out.println("Введите категорию книги: ");
        String newCategory = scannerString();

        booksController.addBook(newBookId,newBookName,newAuthorId,newCategory);
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            switchBooksMenu();
        }

    }
    public void deleteBook() throws ParseException {
        try {
        System.out.println("Введите Id книги которую желаете удалить: ");
        int bookId = scannerInteger();

        booksController.deleteBook(bookId);
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            switchBooksMenu();
        }
    }
    public void updateBook() throws ParseException {
        try {
        System.out.println("Введите Id книги которую желаете изменить: ");
        int bookId = scannerInteger();

        System.out.println("Введите новое название книги: ");
        String updateBookName = scannerString();

        System.out.println("Введите новое ID автора книги: ");
        int updateAuthorId = scannerInteger();

        System.out.println("Введите новую категорию книги: ");
        String updateCathegory = scannerString();

        booksController.updateBook(bookId, updateBookName, updateAuthorId, updateCathegory);
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            switchBooksMenu();
        }
    }
    public void returnAllBooks(){
        List<Books> bookList = booksController.returnAllBooks();
        bookList.stream().map((x)->x+"\n").forEach(System.out::println);
    }
    public void searchTheBooksById() throws ParseException {
        try {
        System.out.println("Введите ID книги: ");
        int booksId = scannerInteger();
        System.out.println(booksController.searchBookById(booksId));
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            generalView.seachBooksSwithc();
        }
    }
    public void searchTheBooksByAuthor() throws ParseException {
        try {
        System.out.println("Введите автора книги: ");
        String authorLastName = scannerString();
        System.out.println(booksController.searchBookByAuthor(authorLastName));
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            generalView.seachBooksSwithc();
        }
    }
    public void searchTheBooksByName() throws ParseException {
        try {
        System.out.println("Введите название книги: ");
        String bookName = scannerString();
        System.out.println(booksController.searchBookByName(bookName));
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            generalView.seachBooksSwithc();
        }
    }

}
