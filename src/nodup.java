import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class nodup {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();
        String[] words = scanner.nextLine().split(" ");
        for (String s : words) {
            if (!hs.add(s)) {
                System.out.print("no");
                return;
            }
        }
        System.out.print("yes");
    }
}
