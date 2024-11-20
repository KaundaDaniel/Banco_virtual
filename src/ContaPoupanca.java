public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    boolean sacar(double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }else if    (this.getSaldo() < valor) {
            System.out.println("Saldo insuficiente para saque");
            return false;
        }
        return false;
    }

    @Override
    boolean depositar(double valor, Conta conta) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }else {
            System.out.println("Valor do deposito inválido");
            return false;
        }

    }

    @Override
    boolean transferir(double valor, Conta conta) {
        if (this.sacar(valor)) {
            conta.depositar(valor, this);
            return true;
        }else if (this.sacar(valor)) {
            System.out.println("Transferência não realizada");
            return false;
        }
        return false;
    }

    @Override
    boolean consultarSaldo(Conta conta) {
        System.out.println("Saldo da conta poupança: " + this.getSaldo());
        return false;
    }
}
