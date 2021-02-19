import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) {
        //System.out.println("I work!");

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("client1.json"));

            // convert JSON string to User object
            Client client = gson.fromJson(reader, Client.class);
            //System.out.println(client);

            //Object clientSpecified = new Object();
            reader = Files.newBufferedReader(Paths.get("client2.json"));
            switch (client.clientType) {
                case ("HOLDING"):
                    Holding clientSpecified = gson.fromJson(reader, Holding.class);
                    System.out.println(clientSpecified);
                    break;
                case ("LEGAL_ENTITY"):
                    LegalEntity clientSpecified2 = gson.fromJson(reader, LegalEntity.class);
                    System.out.println(clientSpecified2);
                    break;
                case ("INDIVIDUAL"):
                    Individual clientSpecified3 = gson.fromJson(reader, Individual.class);
                    System.out.println(clientSpecified3);
                    break;
            }
            // print user object
            //System.out.println(clientSpecified);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

