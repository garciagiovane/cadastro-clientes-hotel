# cadastro-clientes-hotel
Repositório para armazenar o código fonte do CRUD de clientes do sistema de hotelaria, para a cadeira de arquitetura de software da FADERGS

package clientemenu;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteMenu {

    public static void main(String[] args) {
        
        ArrayList <Cadastro> CadastroLista = new ArrayList<>(); //
        
        Scanner menu = new Scanner (System.in);

        int opcao;
        
do{   // Inicio do while principal

            Scanner ler = new Scanner(System.in);  //Scanner para ler as informações
                
            //Menu principal
            
            System.out.print("\nMenu de Operação Cliente");
            System.out.print("\n");
            System.out.print(" Opção 1 - Novo Cadastro     \n");
            System.out.print(" Opção 2 - Edição         \n");
            System.out.print(" Opção 3 - Inativação          \n");
            System.out.print(" Opção 4 - Pesquisa             \n");
            System.out.print(" Opção 5 - Sair              \n");
            System.out.print("\n");
            System.out.print("Digite uma opção: ");
            
            opcao = menu.nextInt();
 
switch (opcao) {
        
    case 1:
               
        Cadastro cad = new Cadastro();
                
        System.out.print("\nNovo Cadastro Selecionado\n");
    
        String nm,s,end, ec;  
        int dn;
        int cep1, cpf1, rg1, tele;
        
        System.out.println( " Digite seu Nome Completo: " );
        nm = ler.nextLine();
        cad.setNomeCompleto(nm);
        
        System.out.println( " Digite a Data de Nascimento: Ex:01011999 ( Somente números ): " );
        dn = ler.nextInt();
        cad.setDataNascimento(dn);
    
        System.out.println( " Digite o sexo ( Masculino ou Feminino ): " );
        s = ler.nextLine();
        cad.setSexo(s);
   
        System.out.println( " Digite seu Endereço: " );
        end = ler.nextLine();
        cad.setEndereço(end);
        
        System.out.println( " Digite o CEP ( Somente números ): " );
        cep1 = ler.nextInt();
        cad.setCep(cep1);
    
        System.out.println( " Digite o CPF ( Somente números ): " );
        cpf1 = ler.nextInt();
        cad.setCpf(cpf1);
    
        System.out.println( " Digite Estado Civil ( Solteiro(a), Casado(a), Viúvo(a): " );
        ec = ler.nextLine();
        cad.setEstadoCivil(ec);
    
        System.out.println( " Digite o RG: " );
        rg1 = ler.nextInt();
        cad.setRg(rg1);
    
        System.out.println( " Digite o seu DDD e Telefone: " );
        tele = ler.nextInt();
        cad.setTelefone(tele);
    
                
        CadastroLista.add(cad);
        
            break;

    case 2:
            System.out.print("\nEdição\n");
            break;

    case 3:
            System.out.print("\nInativação\n");
            break;
                
    case 4:
            
         System.out.print("\nPesquisa\n");
        
        int cpf2,i;
        
        System.out.println( " Digite seu CPF: " );
        cpf2 = ler.nextInt();
        
        for(i=0; i < CadastroLista.size(); i++){
        
            if(CadastroLista.get(i).getCpf() == cpf2){  

                CadastroLista.get(i).ExibirDados();
                
            }
            
        }
            
            break;
 
    case 5: 

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
        
        break;
            
                
    case 6:
                
             System.out.print("\nFinalizado\n");
             
             break;
             
    }
}while(opcao != 5);
}
}

//////////////////////////////           Nova Classe criada                          /////////////////////////

package clientemenu;
import java.util.Scanner;
public class Cadastro {

    private String nomeCompleto;
    private int dataNascimento ;
    private String sexo;
    private String endereço;
    private int cep;
    private int cpf;
    private String estadoCivil;
    private int rg;
    private int telefone;
   
    public void Cadastro(){
        
    String nm,s,end, ec;  
    int dn;
    int cep1, cpf1, rg1, tele;
        
    }
    
    public void ExibirDados(){
        
        System.out.println( " Nome Completo: " +getNomeCompleto() );
        System.out.println( " Data de Nascimento: " +getDataNascimento() );
        System.out.println( " Sexo: " +getSexo() );
        System.out.println( " Endereço: " +getEndereço() );
        System.out.println( " CEP: " +getCep() );
        System.out.println( " CPF: " +getCpf() );
        System.out.println( " Estado Civil: " +getEstadoCivil() );
        System.out.println( " RG: " +getRg() );
        System.out.println( " Telefone: " +getTelefone() );
        
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

}  

