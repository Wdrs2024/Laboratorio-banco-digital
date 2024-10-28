package BancoContaMovimento;

/*
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}
}
*/

import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca extends Conta {
    private List<Transacao> transacoes;

    public ContaPoupanca(String numero, Cliente cliente) {
        super(numero, cliente);
        this.transacoes = new ArrayList<>();
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao("DEPOSITO", valor));
        } else {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao("SAQUE", valor));
        } else {
            throw new IllegalArgumentException("Saldo insuficiente. Saldo disponível: " + saldo);
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        transacoes.add(new Transacao("TRANSFERÊNCIA", valor));
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}