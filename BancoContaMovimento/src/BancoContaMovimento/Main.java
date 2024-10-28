package BancoContaMovimento;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("Sofia", "12345678900");
        ContaCorrente contaSofiContaCorrente = new ContaCorrente("CC123", cliente1, 500);
        ContaPoupanca contaSofiaPoupanca = new ContaPoupanca("CP123", cliente1);
        
        cliente1.adicionarConta(contaSofiaPoupanca);
        cliente1.adicionarConta(contaSofiContaCorrente);
        
        banco.adicionarCliente(cliente1);
        
        contaSofiaPoupanca.depositar(1000);
        contaSofiaPoupanca.sacar(200);
        
        System.out.println("Saldo da conta de " + cliente1.getNome() + ": " + contaSofiaPoupanca.getSaldo());
        
        banco.listarClientes();
        cliente1.listarContas();
    }
}
