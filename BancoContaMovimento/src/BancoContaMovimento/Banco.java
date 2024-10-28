package BancoContaMovimento;

/*import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}*/


import java.util.HashSet;
import java.util.Set;

public class Banco {
    private Set<Cliente> clientes;

    public Banco() {
        this.clientes = new HashSet<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Clientes cadastrados:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }
}