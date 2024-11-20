public class ConraCorrente  extends  Conta{
    public ConraCorrente(Cliente titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    boolean sacar(double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    @Override
    boolean depositar(double valor, Conta conta) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }
        return false;
    }

    @Override
    boolean transferir(double valor, Conta conta) {
        if (this.sacar(valor)) {
            conta.depositar(valor, this);
            return true;
        }else{
            System.out.println("Transferência não realizada");
            return false;
        }

    }

    @Override
    boolean consultarSaldo(Conta conta) {
        System.out.println("Saldo da conta corrente: " + this.getSaldo());
        return true;


    }
}
