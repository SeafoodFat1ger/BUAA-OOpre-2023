import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        MyScanner scanner1 = new MyScanner();
        Manager manager = new Manager();
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            i -= scanner1.handleInput(nextLine);
            manager.match(nextLine);
        }
        scanner.close(); // 关闭scanner
    }
}


