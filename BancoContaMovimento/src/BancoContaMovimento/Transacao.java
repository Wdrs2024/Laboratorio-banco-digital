package BancoContaMovimento;
/*
public interface BancoMovimento {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, BancoMovimento contaDestino);
	
	void imprimirExtrato();
}*/

public class Transacao {
    private String tipo;
    private double valor;

    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "tipo='" + tipo + '\'' +
                ", valor=" + valor +
                '}';
    }
}