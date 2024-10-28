package BancoContaMovimento;

import java.util.HashSet;
import java.util.Set;
    
public class Cliente {
    
    private String nome;
    private String cpf;
    private Set<Conta> contas; // Mudado para plural e inicializado
    
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.contas = new HashSet<>(); // Inicializando o Set
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public Set<Conta> getContas() {
        return contas;
    }
    
    public void setNome(String nome) {
         this.nome = nome;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void adicionarConta(Conta conta) {
        if (contas.add(conta)) {
             System.out.println("Conta adicionada com sucesso.");
        } else {
             System.out.println("Conta já existente.");
        }
    }
    
    public void removerConta(Conta conta) {
        if (contas.remove(conta)) {
            System.out.println("Conta removida com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
    
    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println(nome + " não possui contas.");
        } else {
            System.out.println("Contas de " + nome + ":");
            for (Conta conta : contas) {
                System.out.println(" - " + conta);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
            "nome='" + nome + '\'' +
            ", cpf='" + cpf + '\'' +
            '}';
        }
}
    

                

                


    

        