package locadoradecarros;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String endereco;
    static List<Cliente> clientes = new ArrayList<Cliente>();

    //CONSTRUTORES
    public Cliente(String nome, String telefone, String email, String cpf, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Cliente() {
    }

    //GET AND SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //MÉTODOS USADOS NO CRUD CLIENTE DA CLASSE CLIENTE
    public void Cadastrar(Cliente cliente) {
        Cliente.clientes.add(cliente);
    }

    public Cliente Consultar(String cpf) {
        int n = clientes.size();

        for (int i = 0; i < n; i++) {
            Cliente c = clientes.get(i);

            //COMPARA SE O CPF DO CLIENTE DA LISTA É IGUAL AO CPF DIGITADO PELO USUÁRIO E RETORNA O CLIENTE SE TRUE
            if (cpf.equals(c.getCpf())) {
                System.out.print("Dados do cliente:\n\n");
                System.out.println("Nome:" + c.getNome());
                System.out.println("Tel:" + c.getTelefone());
                System.out.println("Email:" + c.getEmail());
                System.out.println("Cpf:" + c.getCpf());
                System.out.println("end:" + c.getEndereco());
                return c;
            }

        }
        return null;
    }

    public void Atualizar(Cliente cliente) {

        Scanner scan = new Scanner(System.in);

        //PROCURA NA LISTA DE CLIENTES O CLIENTE QUE BATE COM O CLIENTE ENVIADO POR PARÂMETRO
        for (int i = 0; i < Cliente.clientes.size(); i++) {
            if (cliente.equals(Cliente.clientes.get(i))) {

                //RECEBE OS DADOS ATUALIZADOS DO CLIENTE
                System.out.println("Alteração dos dados do cliente de cpf: " + cliente.getCpf() );
                System.out.println("\nNome:");
                nome = scan.next();
                Cliente.clientes.get(i).setNome(nome);
                System.out.println("Telefone:");
                telefone = scan.next();
                Cliente.clientes.get(i).setTelefone(telefone);
                System.out.println("email:");
                email = scan.next();
                Cliente.clientes.get(i).setEmail(email);
                System.out.println("Endereço:");
                endereco = scan.next();
                Cliente.clientes.get(i).setEndereco(endereco);

                //SET ALTERAÇÕES DO CLIENTE
                Cliente.clientes.set(i, cliente);

                //PRINTA OS DADOS ALTERADOS
                System.out.println("\nDados atualizados do cpf: " + Cliente.clientes.get(i).getCpf());
                System.out.println("Nome:" + Cliente.clientes.get(i).getNome());
                System.out.println("Tel:" + Cliente.clientes.get(i).getTelefone());
                System.out.println("Email:" + Cliente.clientes.get(i).getEmail());
                System.out.println("Cpf:" + Cliente.clientes.get(i).getCpf());
                System.out.println("end:" + Cliente.clientes.get(i).getEndereco());
            }
        }
    }

    public void Remover(Cliente cliente) {
        Cliente.clientes.remove(cliente);
    }

}