package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fluxocaixa.Caixa;
import insumos.Cedulas;
import insumos.Filmes;
import insumos.Impressora;

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
	
	public void insertFilme(Filmes filme) throws SQLException{
        String sql = "insert into db_filme (nome_filme,"
        		+ "duracao_filme,lugar_filme,preco_filme)"+"values(?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1,filme.getNome());
        stmt.setInt(2,filme.getDuracao());
        stmt.setInt(3,filme.getLugares());
        stmt.setFloat(4,filme.getPreco());

        stmt.execute();
        stmt.close();

    }
	
	public void insertCedula(Cedulas cedula) throws SQLException{
        String sql = "insert into db_cedula (descricao_cedula,valor_cedula,qtd_cedula)"+"values(?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1,cedula.getDescricao());
        stmt.setFloat(2,cedula.getValor());
        stmt.setInt(3,cedula.getQuantidade());

        stmt.execute();
        stmt.close();

    }
	
	
	
	//PARTE DOS UPDATES
	public void updateCedulas(Cedulas cedula) throws SQLException {
		 java.sql.Statement stmt = con.createStatement();
		String sql = "UPDATE db_cedula SET qtd_cedula='"+cedula.getQuantidade()+
					"' WHERE descricao_cedula = '"+cedula.getDescricao().toString()+"'";
        stmt.executeUpdate(sql);

        stmt.close();

    }
	
	public void updatePapelImpressora(Impressora impressora) throws SQLException {
		 java.sql.Statement stmt = con.createStatement();
		String sql = "UPDATE db_impressora SET qtd_impressoes_impressora='"+impressora.getQuantidade()+
					"' WHERE id_impressora = '1'";
       stmt.executeUpdate(sql);

       stmt.close();

   }
	public void updateCaixa(Caixa caixa) throws SQLException {
		 java.sql.Statement stmt = con.createStatement();
		String sql = "UPDATE db_caixa SET num_vendas_caixa='"+caixa.getNumVendas()+"',total_vendas_caixa='"+caixa.getValorTotal()+
					"' WHERE id_caixa = '1'";
       stmt.executeUpdate(sql);

       stmt.close();

   }

	
	
	
	//GET DADOS
	
	 public Caixa getCaixa() throws SQLException {
		 	Caixa caixa = new Caixa();
	        String sql = "SELECT * FROM db_caixa";
	        ResultSet resul = executaBusca(sql);
	        
	        while(resul.next()){
	        caixa.setNumVendas(resul.getInt("num_vendas_caixa"));
	        caixa.setValorTotal(resul.getFloat("total_vendas_caixa"));  
	        }  
	        return caixa;
	    }
	    
	 public ArrayList<Cedulas> getListaCedulas() throws SQLException {
		 	ArrayList<Cedulas> listaCedulas = new ArrayList<Cedulas>();
		 	
		 	String sql = "SELECT * FROM db_cedula";
	        ResultSet resul = executaBusca(sql);
	        
	       
	        while(resul.next()){
	        Cedulas novaCedula = new Cedulas();
	        novaCedula.setDescricao(resul.getString("descricao_cedula"));
	        novaCedula.setValor(resul.getFloat("valor_cedula"));
	        novaCedula.setQuantidade(resul.getInt("qtd_cedula"));
	        
	        listaCedulas.add(novaCedula);
	        //System.out.println(novaCedula.getNumVendas());
	        //System.out.println(caixa.getValorTotal());
	        }
	       return listaCedulas;
	        
	        
	        
	    }
	
	
}