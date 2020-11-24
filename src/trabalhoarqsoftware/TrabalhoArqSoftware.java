package trabalhoarqsoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrabalhoArqSoftware {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<ClienteModel> clientes = new ArrayList<>();

        int opcao;

do {
            System.out.print("\nMenu de Operação Cliente");
            System.out.print("\n");
            System.out.print(" Opção 1 - Novo Cadastro     \n");
            System.out.print(" Opção 2 - Edição         \n");
            System.out.print(" Opção 3 - Inativação          \n");
            System.out.print(" Opção 4 - Pesquisa             \n");
            System.out.print(" Opção 5 - Exportar CSV            \n");
            System.out.print(" Opção 6 - Sair              \n");
            System.out.print("\n");
            System.out.print("Digite uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

         switch (opcao) {
                case 1:
                    cadastrarCliente(scanner, clientes);
                    break;
                case 2:
                    editarCliente(clientes, scanner);
                    break;
                case 3:
                    inativarCliente(scanner, clientes);
                    break;
                case 4:
                    pesquisarCliente(clientes, scanner);
                    break;
                case 5:
                    exportarCsv(clientes);
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        } while (opcao != 6);

    }
    
    public static void exportarCsv(List<ClienteModel> clientes){
      	
        try {
            FileWriter arq = new FileWriter(".//teste.csv");
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.println("nomeCompleto;cpf;cep;telefone;");
                for(ClienteModel c : clientes){
                    gravarArq.println(c.toString());
                }
            arq.close();
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException ex) {
           System.out.println("Falha ao criar o arquivo!");
        }
    }
    
    public static void editarCliente(List<ClienteModel> clientes, Scanner scanner) {
        System.out.println("Digite o CPF do cliente");
        String cpf = scanner.nextLine();
        Optional<ClienteModel> clienteModel = extrairCliente(clientes, cpf);

        if (clienteModel.isPresent()) {
            ClienteModel cliente = clienteModel.get();
            clientes.remove(cliente);

            cadastrarCliente(scanner, clientes);
        } else {
            System.out.println("Cliente não encontrado");
        }
    }

    private static Optional<ClienteModel> extrairCliente(List<ClienteModel> clientes, String cpf) {
        return clientes.stream()
                .filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst();
    }

    private static void pesquisarCliente(List<ClienteModel> clientes, Scanner scanner) {
        System.out.println("\nPesquisa\n");
        System.out.println(" Digite seu CPF: ");
        String cpf = scanner.nextLine();
     
        Optional<ClienteModel> first = extrairCliente(clientes, cpf);

        if (first.isPresent())
            System.out.println(first.get().toString());
        else
            System.out.println("Cliente não encontrado");
    }

    public static void cadastrarCliente(Scanner scanner, List<ClienteModel> clientes) {

        ClienteModel cliente = new ClienteModel();

        System.out.println("Novo Cadastro Selecionado");

        System.out.println(" Digite seu Nome Completo: ");
        String nomeCompleto = scanner.nextLine();
        cliente.setNomeCompleto(nomeCompleto);

        System.out.println(" Digite a Data de Nascimento: Ex01011999 ( Somente números ): ");
        String dataNascimento = scanner.nextLine();
        cliente.setDataNascimento(dataNascimento);

        System.out.println(" Digite o sexo ( Masculino ou Feminino ): ");
        String sexo = scanner.nextLine();
        cliente.setSexo(sexo);

        System.out.println(" Digite seu Endereço: ");
        String endereco = scanner.nextLine();
        cliente.setEndereco(endereco);

        System.out.println(" Digite o CEP ( Somente números ): ");
        String cep = scanner.nextLine();
        cliente.setCep(cep);

        System.out.println(" Digite o CPF ( Somente números ): ");
        String cpf = scanner.nextLine();
        cliente.setCpf(cpf);

        System.out.println(" Digite Estado Civil ( Solteiro(a), Casado(a), Viúvo(a): ");
        String estadoCivil = scanner.nextLine();
        cliente.setEstadoCivil(estadoCivil);

        System.out.println(" Digite o RG: ");
        String rg = scanner.nextLine();
        cliente.setRg(rg);

        System.out.println(" Digite o seu DDD e Telefone: ");
        String telefone = scanner.nextLine();
        cliente.setTelefone(telefone);

        clientes.add(cliente);
        
         }
           
    public static void inativarCliente( Scanner scanner, List<ClienteModel> clientes){
        
        System.out.println("Digite seu CPF");
        String cpf = scanner.nextLine();
        
        Optional<ClienteModel> inativo = extrairCliente(clientes, cpf);

       if (inativo.isPresent()){
            
         clientes.remove(inativo.get());
        
        System.out.println(" !!! Cadastro inativado !!! ");
         
       }else{
            
        System.out.println(" !!! Cliente não encontrado !!! ");
        
    }
    
    }
}
    

