import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine().toUpperCase();
        String c = br.readLine().toUpperCase();

        String s2 = s1.replaceAll(c, "");
        System.out.println(s1.length() - s2.length());
    }
}