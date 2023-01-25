package br.com.biblioteca.DAO;

import br.com.biblioteca.DTO.LivroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Frederico
 */
public class LivroDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LivroDTO> lista = new ArrayList<>();
    
    public void CadastrarLivro(LivroDTO livroDTO) throws ClassNotFoundException{
        String sql = "INSERT INTO biblioteca (livro_nome) VALUES (?)";
        conn = new ConexaoDAO().conexaoBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, livroDTO.getLivro());
            pstm.execute();
            pstm.close();
        } catch(SQLException e){
            
        }
    }
    public ArrayList<LivroDTO> PesquisarLivro() throws ClassNotFoundException{
        String sql = "SELECT * FROM biblioteca";
        conn = new ConexaoDAO().conexaoBD();
        
        try{
            pstm =  conn.prepareStatement(sql);
            rs =  pstm.executeQuery(sql);
            
            for(int i = 0; rs.next(); i++){
                LivroDTO livroDTO = new LivroDTO();
                livroDTO.setLivroId(rs.getInt("livro_id"));
                livroDTO.setLivro(rs.getString("livro_nome"));
            
                lista.add(livroDTO);
        }
            while (rs.next()){
                LivroDTO livroDTO = new LivroDTO();
                livroDTO.setLivroId(rs.getInt("livro_id"));
                livroDTO.setLivro(rs.getString("livro_nome"));
                
                lista.add(livroDTO);
            }
            
            pstm.close(); //fecha conexão
        }catch(SQLException e){
            
        }
        
        return lista;
    }
    
    public void ExcluirLivro(LivroDTO livroDTO) throws ClassNotFoundException{
        String sql = "DELETE FROM biblioteca WHERE id = ?";
        conn = new ConexaoDAO().conexaoBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, livroDTO.getLivroId());
            pstm.execute();
            pstm.close();  
        } catch(SQLException e){
            
        }
    }
    
    public void AlterarLivro(LivroDTO livroDTO) throws ClassNotFoundException{
        String sql = "UPDATE livro SET livro_nome = ? WHERE livro_id = ?";
        conn = new ConexaoDAO().conexaoBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,livroDTO.getLivro());
            pstm.setInt(2, livroDTO.getLivroId());
            
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Não alterou");
        }
    }
}
