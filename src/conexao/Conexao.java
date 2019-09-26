package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import insumos.Filmes;

public class Conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;	
	
	 public Conexao(){
		
		url = "jdbc:postgresql://localhost:5432/bilheteria";
		usuario = "postgres";
		senha = "123456";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha); 
			System.out.println("Conexao OK!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}
	 
	public int executaUpdate(String sql) {
		
		try {
			java.sql.Statement stm = con.createStatement();
			int res = stm.executeUpdate(sql);
			con.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public ResultSet executaBusca (String sql) {	
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			con.close();	
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void adicionaFilme(Filmes filme) throws SQLException{
        String sql = "insert into db_filme (nome_filme,duracao_filme,lugar_filme,preco_filme)"+"values(?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1,filme.getNome());
        stmt.setInt(2,filme.getDuracao());
        stmt.setInt(3,filme.getLugares());
        stmt.setFloat(4,filme.getPreco());

        stmt.execute();
        stmt.close();

    }
	
	
}