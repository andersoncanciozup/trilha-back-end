package br.com.zup.cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramaPrincipal {

    static Map<String, Cliente> clientes = new HashMap<String, Cliente>();

    private static void menu() {
        System.out.println("Digite 1 - criar novo cliente");
        System.out.println("Digite 2 - consultar cliente pelo cpf");
        System.out.println("Digite 3 - listar todos os cliente");
        System.out.println("Digite 4 - alterar cliente pelo cpf");
        System.out.println("Digite 5 - remover cliente pelo cpf");
        System.out.println("Digite 0 - sair do programa");
    }
 
    public static String criarCliente(Scanner sc) {
        Cliente cliente = new Cliente();

        System.out.println("Digite o número do cpf");
        cliente.setCpf(sc.nextLine());
        System.out.println("Dgitie o e-mail");
        cliente.setEmail(sc.nextLine());
        System.out.println("Digite o endereço");
        cliente.setEndereco(sc.nextLine());
        System.out.println("Digite a idade");
        cliente.setIdade(sc.nextInt());
        sc.nextLine();
        System.out.println("Digite o nome");
        cliente.setNome(sc.nextLine());
        System.out.println("Digite o número do telefone");
        cliente.setTelefone(sc.nextLine());

        clientes.put(cliente.getCpf(), cliente);

        return "Cliente criado com sucesso";
    }

    public static Cliente consutlarCliente(Scanner sc) {
        System.out.println("Digite o cpf");
        String cpfLido = sc.nextLine();

        return clientes.get(cpfLido);
    }

    public static String removerCliente(Scanner sc) {
        System.out.println("Digite o cpf");
        String cpfLido = sc.nextLine();

        clientes.remove(cpfLido);
        return "Cliente removido com sucesso";

    }
    
    public static String alteraCliente(Scanner sc) {
        System.out.println("Digite o número do cpf");
        String cpfLido = sc.nextLine();
        
        if (clientes.containsKey(cpfLido)) {
            
            Cliente cliente = new Cliente();
            
            cliente.setCpf(cpfLido);
            System.out.println("Dgitie o e-mail");
            cliente.setEmail(sc.nextLine());
            System.out.println("Digite o endereço");
            cliente.setEndereco(sc.nextLine());
            System.out.println("Digite a idade");
            cliente.setIdade(sc.nextInt());
            sc.nextLine();
            System.out.println("Digite o nome");
            cliente.setNome(sc.nextLine());
            System.out.println("Digite o número do telefone");
            cliente.setTelefone(sc.nextLine());
              
           clientes.put(cpfLido, cliente);
           
            return "Cliente alterado com sucesso";
        }
        
        return "Cliente não encontrado";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            menu();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(criarCliente(sc));
                    break;
                case 2:
                    System.out.println(consutlarCliente(sc));
                    break;
                case 3:                    
                    clientes.forEach((k,v) -> System.out.println(v));
                    break;
                case 4:
                    System.out.println(alteraCliente(sc));
                    break;
                case 5:
                    System.out.println(removerCliente(sc));
                    break;
                case 0:
                    System.out.println("Volte sempre");
                default:
                    System.out.println("Opção inválida, tente outra vez");
                    break;
            }
        } while (opcao != 0);
        sc.close();

    }


}
