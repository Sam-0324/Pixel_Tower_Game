import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Start {
    public static void main(String[] args) {
        try{
            File b = new File(Objects.requireNonNull(Start.class.getResource("Addons/")).getPath());
            Read.Reads(b);
        } catch(Exception E){
            E.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请选择角色。");
        try {
            String a = br.readLine();
            System.out.println(a);
        } catch (IOException E) {
            E.printStackTrace();
        }
    }
}