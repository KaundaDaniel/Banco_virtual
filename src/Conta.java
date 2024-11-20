import java.util.Random;

public abstract class Conta {
    private double saldo;
    private Cliente titular;
    private int numeroConta;
    private  String iban;
    Random rand = new Random();
    public Conta(Cliente titular, double saldo) {
        this.titular = titular;
        this.numeroConta =  gerarNumeroConta();
        this.iban = gerarIBAN();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    private String gerarIBAN() {
        String numeroContaString = String.format("%05d", gerarNumeroConta());
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letraEscolhida = String.valueOf(letras.charAt((int)Math.random() * letras.length()));
        return letraEscolhida + numeroContaString;
    }
    private int gerarNumeroConta(){
        return rand.nextInt(10000000);
    }

    abstract boolean sacar(double valor);

   abstract boolean depositar(double valor, Conta conta);
   abstract boolean transferir(double valor, Conta conta);
   abstract boolean consultarSaldo(Conta conta);
}
