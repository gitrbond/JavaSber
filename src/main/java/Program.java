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
        String inputFileName = "client2.json";
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(inputFileName));

            // convert JSON string to User object
            Client client = gson.fromJson(reader, Client.class);
            //System.out.println(client);

            Object clientSpecified = new Object();
            reader = Files.newBufferedReader(Paths.get(inputFileName));

            /*switch (client.clientType) {
                case ("HOLDING"):
                    clientSpecified = gson.fromJson(reader, Holding.class);
                    break;
                case ("LEGAL_ENTITY"):
                    clientSpecified = gson.fromJson(reader, LegalEntity.class);
                    break;
                case ("INDIVIDUAL"):
                    clientSpecified = gson.fromJson(reader, Individual.class);
                    break;
            }*/

            clientSpecified = ClientType.valueOf(client.clientType).createClient(gson, reader);

            // print user object
            System.out.println(clientSpecified);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

enum ClientType {
    INDIVIDUAL{
        public Object createClient(Gson gson, Reader reader) {
            return gson.fromJson(reader, Individual.class);
        }
    },
    LEGAL_ENTITY{
        public Object createClient(Gson gson, Reader reader) {
            return gson.fromJson(reader, LegalEntity.class);
        }
    },
    HOLDING{
        public Object createClient(Gson gson, Reader reader) {
            return gson.fromJson(reader, Holding.class);
        }
    };

    public abstract Object createClient(Gson gson, Reader reader);
}