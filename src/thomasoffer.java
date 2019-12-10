import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class thomasoffer {

    final static String folder = "data";
    final static String fileName = "contacts.txt";

    // CRUD app
    public static void main(String[] args) {




            Path dataDirectory = Paths.get(folder);
            Path dataFile = Paths.get(folder, fileName);
            List<String> contactsList = Arrays.asList("Thomas");

            try{

                if (Files.notExists(dataDirectory)) {
                    Files.createDirectories(dataDirectory);
                }

                if (!Files.exists(dataFile)) {
                    Files.createFile(dataFile);
                }

                Path filepath = Paths.get("data", "contacts.txt");

                //
                Files.write(filepath, contactsList);

                Files.write(
                        filepath,
                        Arrays.asList("Jw"), // list with one item
                        StandardOpenOption.APPEND
                );

                List<String> newContactsList = Files.readAllLines(filepath);

                for (int i = 0; i < newContactsList.size(); i += 1) {
                    System.out.println((i + 1) + ": " + newContactsList.get(i));
                }

                List<String> tempList = new ArrayList<>();
                for (String contact : newContactsList) {

                    // Update cream instead of milk
                    if (contact.equals("")) {
                        tempList.add("Jacob");
                        continue;
                    }

                    // Delete
                    if(contact.equals("Thomas")){
                        continue;
                    }

                    // An item is being added
                    tempList.add(contact);
                }

                // Writes the file with the final tempList
                Files.write(filepath, tempList);
                ;
            }catch (IOException ex){
                ex.printStackTrace();
            }


        }
    }


