import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner scanner = new Scanner (System.in);
        System.out.println("digite um nome");
        String nome = scanner.nextLine();
        System.out.println("Oi " +nome);
    }
}
