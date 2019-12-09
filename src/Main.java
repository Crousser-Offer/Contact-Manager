import util.Input;
import util.Contact;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Input input = new Input();
    static Scanner scan = new Scanner(System.in);
    final static String directory = "src";
    final static String fileName = "contacts.txt";
    public static HashMap<String, Contact> contactList;

    public static void main(String[] args) throws IOException {
        Path contactsPath = Paths.get(directory, fileName);
        List<String> lines = Files.readAllLines(Paths.get(directory, fileName));
//        contactList = buildHashMap(lines);

        System.out.println("Welcome to the Contacts Manager!");


        System.out.println("Please select an option");
        System.out.println("1 - View contacts");
        System.out.println("2 - Add a new contact");
        System.out.println("3 - Search a contact by name");
        System.out.println("4 - Delete an existing contact");
        System.out.println("5 - Exit");
        int selection = input.getInt(1, 5);


        switch (selection) {
            case 1:
                System.out.println("Here are your contacts");
                showContacts();
                break;
            case 2:
                System.out.println("Please enter first and last name of your contact");
                String userInput = scan.nextLine();
                System.out.println("What is your contacts phone number?");
                String userInput1 = scan.nextLine();
                break;
            case 3:
                System.out.println("Type in the contact you are looking for");
                break;
            case 4:
                System.out.println("Delete a contact");
                break;
            case 5:
                System.out.println("Leave Contact Manager");
        }
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
