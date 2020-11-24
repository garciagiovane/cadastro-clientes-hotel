package trabalhoarqsoftware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    
   public void create(ClienteModel cm){
       
     Connection con = ConnectionFactory.getConncetion();
     PreparedStatement stmt = null;
     
       try {
           stmt = con.prepareStatement(" INSERT INTO cadastro(nomecompleto,datanascimento,sexo,endereço,cep,cpf,estadocivil,rg,telefone) VALUES(?,?,?,?,?,?,?,?,?)");
           stmt.setString(1, cm.getNomeCompleto());
           stmt.setString(2, cm.getDataNascimento());
           stmt.setString(3, cm.getSexo());
           stmt.setString(4, cm.getEndereço());
           stmt.setString(5, cm.getCep());
           stmt.setString(6, cm.getCpf());
           stmt.setString(7, cm.getEstadoCivil());
           stmt.setString(8, cm.getRg());
           stmt.setString(9, cm.getTelefone());
           
           stmt.executeUpdate();
           
           JOptionPane.showMessageDialog(null, " Salvo com sucesso");
           
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, " Erro ao salvar"+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt);
           
       }
        
   } 
    
   public List<ClienteModel> read(){
       
     Connection con = ConnectionFactory.getConncetion();
     PreparedStatement stmt = null;
     ResultSet rs = null;
     List<ClienteModel> clientes = new ArrayList<>();
     
       try {
           stmt = con.prepareStatement("SELECT * FROM cadastro");
           rs = stmt.executeQuery();
           
           while(rs.next()){
              
               ClienteModel clientemodel = new ClienteModel();
               
               clientemodel.setId(rs.getInt("id"));
               clientemodel.setNomeCompleto(rs.getString("nomecompleto"));
               clientemodel.setDataNascimento(rs.getString("datanascimento"));
               clientemodel.setSexo(rs.getString("sexo"));
               clientemodel.setEndereco(rs.getString("endereço"));
               clientemodel.setCep(rs.getString("cep"));
               clientemodel.setCpf(rs.getString("cpf"));
               clientemodel.setEstadoCivil(rs.getString("estadocivil"));
               clientemodel.setRg(rs.getString("rg"));
               clientemodel.setTelefone(rs.getString("telefone"));
               
               clientes.add(clientemodel);
               
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           
           ConnectionFactory.closeConnection(con, stmt, rs);
           
       }
       
       return clientes;
       
   }
   
   
}
