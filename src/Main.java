import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o seu nome");
        String nome= scanner.next();
        Cliente cliente = new Cliente(nome);
        System.out.println("Digite o seu saldo");
        double saldo = scanner.nextDouble();

        ConraCorrente a = new ConraCorrente(cliente,saldo );
        System.out.println("Quanto deseja depositar");
        double deposito = scanner.nextDouble();
        a.depositar(deposito, a);
        System.out.println("Seu saldo é: " + a.getSaldo());
        System.out.println("O seu número de conta é: "+a.getNumeroConta());

        }
    }
