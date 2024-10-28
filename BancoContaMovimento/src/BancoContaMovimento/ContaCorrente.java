package BancoContaMovimento;
/*
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente extends Conta {
    private double limite;
    private List<BancoMovimento> transacoes; // Corrigido para Transacao

    public ContaCorrente(Cliente cliente, double limite) {
        super(cliente);
        if (limite < 0) {
            throw new IllegalArgumentException("O limite não pode ser negativo.");
        }
        this.limite = limite;
        this.transacoes = new ArrayList<>(); // Inicializa a lista de transações
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new BancoMovimento("DEPOSITO", valor)); // Adiciona transação ao histórico
        } else {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            transacoes.add(new BancoMovimento("SAQUE", valor)); // Adiciona transação ao histórico
        } else {
            throw new IllegalArgumentException("Saldo insuficiente. Saldo disponível: " + saldo + ", Limite: " + limite);
        }
    }

    @Override
    public void transferir(double valor, BancoMovimento contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);
        transacoes.add(new BancoMovimento() {
            
        };("TRANSFERÊNCIA", valor)); // Registra a transferência
    }

    public double getLimite() {
        return limite;
    }

    public List<BancoMovimento> getTransacoes() {
        return transacoes; // Método para acessar as transações
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "agencia=" + getAgencia() +
                ", numero=" + getNumero() +
                ", saldo=" + getSaldo() +
                ", limite=" + limite +
                '}';
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato da Conta Corrente ===");
        imprimirInfosComuns();
        System.out.println("Transações:");
        for (BancoMovimento transacao : transacoes) {
            System.out.println(transacao); // Presumindo que BancoMovimento tem um método toString() adequado
        }
    }
}
*/

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente extends Conta {
    private double limite;
    private List<Transacao> transacoes;

    public ContaCorrente(String numero, Cliente cliente, double limite) {
        super(numero, cliente);
        if (limite < 0) {
            throw new IllegalArgumentException("O limite não pode ser negativo.");
        }
        this.limite = limite;
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
        if (valor <= saldo + limite) {
            saldo -= valor;
            transacoes.add(new Transacao("SAQUE", valor));
        } else {
            throw new IllegalArgumentException("Saldo insuficiente. Saldo disponível: " + saldo + ", Limite: " + limite);
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        transacoes.add(new Transacao("TRANSFERÊNCIA", valor));
    }

    public double getLimite() {
        return limite;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                ", limite=" + limite +
                '}';
    }
}