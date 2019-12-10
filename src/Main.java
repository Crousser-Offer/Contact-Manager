import util.Input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Input input = new Input();
    static Scanner scan = new Scanner(System.in);
    final static String directory = "src";
    final static String fileName = "contacts.txt";


    public static void main(String[] args) {

        System.out.println("Welcome to the Contacts Manager!");

        showMenu();
        int selection = input.getInt(1, 5);

        switch (selection) {
            case 1:
                System.out.println("Here are your contacts");
                showContacts();
                System.out.println("\n");
                break;
            case 2:
                System.out.println("Please enter first and last name of your contact");
                String userInput = scan.nextLine();
                System.out.println("What is your contacts phone number?");
                String userInput1 = scan.nextLine();
                String finalContact = userInput + " | " + userInput1;
                try {
                    Path filepath = Paths.get("src", "contacts.txt");
                    Files.write(
                            filepath,
                            Arrays.asList(finalContact),
                            StandardOpenOption.APPEND
                    );
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.printf("%s was successfully added!", finalContact);
                break;
            case 3:
                System.out.println("Please enter the contact you would like to search for");
                String search = scan.nextLine();
                try {
                    Path filepath = Paths.get("src", "contacts.txt");
                    List<String> newContactList = Files.readAllLines(filepath);
                    for (String contact : newContactList) {
                        if (contact.toLowerCase().contains(search.toLowerCase())) {
                            System.out.println(contact);
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case 4:
                System.out.println("Please Enter the contact's full name that you would like to delete.");
                String delete = scan.nextLine();
                try {
                    Path filepath = Paths.get("src", "contacts.txt");
                    List<String> tempList = new ArrayList<>();
                    List<String> newContactList = Files.readAllLines(filepath);
                    for (String contact : newContactList) {
                        if (contact.toLowerCase().contains(delete.toLowerCase())) {
                            System.out.printf("Are you sure you would like to delete %s\n", contact);
                            Boolean confirm = input.yesNo();
                            if (confirm) {
                                System.out.printf("Your contact %s was deleted", contact);
                                continue;
                            }
                        } else {
                            tempList.add(contact);
                        }
                        Files.write(filepath, tempList);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case 5:
                System.out.println("Goodbye! Thank you for using Contacts Manager");
                break;
        }
    }

    public static void showMenu(){
        System.out.println("Main Menu\n" +
                "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

    }
    public static void showContacts() {
        try {
            Path filepath = Paths.get("src", "contacts.txt");

            List<String> getNamePhoneNumber = Files.readAllLines(filepath);

            for (int i = 0; i < getNamePhoneNumber.size(); i += 1) {
                System.out.println((i + 1) + ": " + getNamePhoneNumber.get(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}

// CRUD app
//        public static void main(String[] args) {
//
//                Path dataDirectory = Paths.get(directory);
//                Path dataFile = Paths.get(directory, fileName);
//                List<String> groceryList = Arrays.asList("coffee", "milk", "sugar");
//
//                try{
//
//                        if (Files.notExists(dataDirectory)) {
//                                Files.createDirectories(dataDirectory);
//                        }
//
//                        if (!Files.exists(dataFile)) {
//                                Files.createFile(dataFile);
//                        }
//
//                        Path filepath = Paths.get("data", "groceries.txt");
//
//                        //
//                        Files.write(filepath, groceryList);
//
//                        Files.write(
//                                filepath,
//                                Arrays.asList("eggs"), // list with one item
//                                StandardOpenOption.APPEND
//                        );
//
//                        List<String> newGroceryList = Files.readAllLines(filepath);
//
//                        for (int i = 0; i < newGroceryList.size(); i += 1) {
//                                System.out.println((i + 1) + ": " + newGroceryList.get(i));
//                        }
//
//                        List<String> tempList = new ArrayList<>();
//                        for (String grocery : newGroceryList) {
//
//                                // Update cream instead of milk
//                                if (grocery.equals("milk")) {
//                                        tempList.add("cream");
//                                        continue;
//                                }
//
//                                // Delete eggs
//                                if(grocery.equals("eggs")){
//                                        continue;
//                                }
//
//                                // An item is being added
//                                tempList.add(grocery);
//                        }
//
//                        // Writes the file with the final tempList
//                        Files.write(filepath, tempList);
//
//                }catch (IOException ex){
//                        ex.printStackTrace();
//                }
//
//
//        }
//
//}

//
//final static String dir = "contacts";
//final static String fileName = "contacts.txt";
//
//public static void main(String[] args) {
//
//        Path path =  Paths.get(dir, fileName);
//
//        if(!Files.exists(path)){
//        try {
//        Files.createDirectories(path);
////                Files.createFile(path);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        }
//
//        List<String> contacts = new ArrayList<>();
//        contacts.add("Fer");
//        contacts.add("Sophie");
//        contacts.add("Vivian");
//
//        try {
//        Files.write(path, contacts);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//
//
//        try {
//        List<String> lines = Files.readAllLines(path);
//
//        for(String line : lines){
//        line = 1+line;
//        System.out.println("line.toUpperCase() = " + line.toUpperCase());
//        }
//
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//
//
//        }
//
//        }
//
//        final static String dir = "contacts";
//        final static String fileName = "contacts.txt";
//
//        public static void main(String[] args) {
//            // write your code here
//            Path path = Paths.get(dir, fileName);
//
//            if(!Files.exists(path)){
//                try {
//                    Files.createDirectories(path);
//                Files.createFile(path);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                List<String> contacts = new ArrayList<>();
//               contacts.add("John");
//
//
//                try {
//                    Files.write(path, contacts);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
