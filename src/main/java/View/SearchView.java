package View;

import Controller.SearchController;
import Model.AcountingRecords;
import Model.Authors;
import Model.Books;
import Model.Client;

import java.util.Scanner;

public class SearchView {

private SearchController searchController = new SearchController();

public void showMenu(){

        System.out.println("Добро пожаловать в меню редактирования книги: ");
        System.out.println("\n");

    }

    public void searchTheClient() {
        System.out.println("Введите ID клиента: ");
        Scanner scanner = new Scanner(System.in);
        int clientId = scanner.nextInt();
        System.out.println(searchController.searchClient(clientId));
    }


    public void searchTheBooks() {
        System.out.println("Введите ID книги: ");
        Scanner scanner = new Scanner(System.in);
        int booksId = scanner.nextInt();
        System.out.println(searchController.searchBook(booksId));
    }

    public void searchTheAuthors() {
        System.out.println("Введите ID автора: ");
        Scanner scanner = new Scanner(System.in);
        int authorId = scanner.nextInt();
        System.out.println(searchController.searchAuthor(authorId));
    }

    public void searchTheAccoutnt() {
        System.out.println("Введите ID аккаунта: ");
        Scanner scanner = new Scanner(System.in);
        int accountId = scanner.nextInt();
        System.out.println(searchController.searchAccount(accountId));
    }
}
