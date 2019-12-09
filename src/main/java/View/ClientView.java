package View;

import Controller.ClientController;
import Model.Client;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientView {

    private ClientController clientController = new ClientController();
    private GeneralView generalView = new GeneralView();
    private int number2;

    private String scannerString(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
    private int scannerInteger(){
        Scanner scanner = new Scanner(System.in);
        number2 = scanner.nextInt();
        return number2;
    }

    private int showMenu(){
        System.out.println("Добро пожаловать в меню редактирования клиента");
        System.out.println("1. Добавить клиента ");
        System.out.println("2. Удалить клиента ");
        System.out.println("3. Изменить клиента ");
        System.out.println("4. Вывести всех клиентов ");
        System.out.println("5. Найти клиента ");
        System.out.println("6. Назад");
        number2=0;
           return scannerInteger();
    }
    public void switchClientMenu() throws ParseException {
        //showMenu();
        switch (showMenu()){
            case (1): addClient();
                break;
            case (2): deleteClient();
                break;
            case (3): updateClient();
                break;
            case(4): returnAllClients();
                break;
            case (5): searchTheClient();
                break;
            case (6): generalView.dataEditingSwithc();
            break;
        }
    }

    public void addClient() throws ParseException {
        try {
            System.out.println("Добро пожаловать в меню создания клиента");
            System.out.println("Введите ID клиента: ");
            int newId = scannerInteger();

            System.out.println("Введите имя клиента: ");
            String newFirstName = scannerString();

            System.out.println("Введите фамилию клиента: ");
            String newLastName = scannerString();

            clientController.registration(newId,newFirstName,newLastName);
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            switchClientMenu();
        }
    }

    public void deleteClient() throws ParseException {
        try {
        System.out.println("Введите Id клиента которого желаете удалить: ");
        int clientId = scannerInteger();

        clientController.deleteClient(clientId);
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            switchClientMenu();
        }
    }

    public void updateClient() throws ParseException {
        try {
        System.out.println("Введите Id клиента которого желаете изменить: ");
        int clientId = scannerInteger();

        System.out.println("Введите новое имя клиента: ");
        String updateFirstName = scannerString();

        System.out.println("Введите новую фамилию клиента: ");
        String updateLastName = scannerString();

        clientController.updateClient(clientId, updateFirstName, updateLastName);
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            switchClientMenu();
        }
    }

    public void returnAllClients(){
        List<Client> clientList = clientController.returnAllClients();
        clientList.stream().map((x)->x+"\n").forEach(System.out::println);
    }

    public void searchTheClient() throws ParseException {
        try {
        System.out.println("Введите ID клиента: ");
        int clientId = scannerInteger();
        System.out.println(clientController.searchClient(clientId));
        }
        catch (InputMismatchException e){
            System.out.println("Возможно вы ввели неккоректные данные " + e);
            System.out.println("Попробуйте снова.");
        }
        finally {
            switchClientMenu();
        }
    }
}
