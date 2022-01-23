import player.GsonPlayer;
import player.Player;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Read {
    public static List<Player> Reads(File a) throws NullPointerException, IOException {
        File[] b;
        if (a.exists() && a.isDirectory()) {
            b = a.listFiles(new Filter(".json"));
            if (b == null) throw new NullPointerException();
        } else throw new IOException("File path not found/not a directory!(Not NPE)");
        List<Player> L = new ArrayList<>();
        Gson gson = new Gson();
        for (File F:b) {
            Player P = new Player(gson.fromJson(Read.readF(F), GsonPlayer.class));
            System.out.println(P);
            L.add(P);
        }
        return L;
    }
    public static String readF(File F){
        try (Scanner reader = new Scanner(new FileReader(F))) {
            StringBuilder tempString = new StringBuilder();
            while (reader.hasNextLine()) {
                tempString.append(reader.nextLine()).append("\n");
            }
            System.out.println(tempString);
            return tempString.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}