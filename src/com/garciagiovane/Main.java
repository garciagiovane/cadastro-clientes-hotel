package com.garciagiovane;

import com.garciagiovane.cliente.ClienteModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

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
            System.out.print(" Opção 5 - Sair              \n");
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
                case 4:
                    pesquisarCliente(clientes, scanner);
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        } while (opcao != 6);

        //inativação
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


        //Estava vendo uma maneira de exportar os dados, pode estar incorreto.

        //exporta dados

       /*File file = new File("testecsv.csv");
         ArrayList <Cadastro> CadastroLista = new ArrayList<>();
         FileWriter fileWriter = new FileWriter(file);

         //fileWriter.append("nome, rg, cpf, cep, endereco, telefone, dt_nascimento, sexo, est_civil");
        // fileWriter.append("\n");
         //fileWriter.append("Maria, 1234567, 888.888.999.98, 123456-789, 12345-6789, 01/01/1111, F, Casada");
         //fileWriter.append("\n");
         //fileWriter.append("João, 1234567, 123.456.789.00, 123456-000, 12345-0000, 02/02/1111, M, Solteiro");
         int i;
         fileWriter.append("nome,rg,cpf,cep, endereco, telefone, dt_nascimento, sexo, est_civil");
         for(i=0;i < CadastroLista.lenght(); i++) {

             //fileWriter.append(CadastroLista.get(i).getNome() + "," + CadastroLista.get(i).getRg + "".......);

         }


         fileWriter.close();

        */
    }
}
