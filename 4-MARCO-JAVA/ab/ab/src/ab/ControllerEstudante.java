package ab;


import java.sql.*;
import java.util.ArrayList;
import java.awt.*;

public class ControllerEstudante {
	public static void adicionarEstudante(int codigo, String nome, double teste1, double teste2) throws SQLException, ClassNotFoundException{
		Conexao c = new Conexao();
		Connection con=c.conectar();
		PreparedStatement stmt = null;
		
		stmt=(PreparedStatement) con.prepareStatement("insert into estudante values(?,?,?,?)");
		stmt.setInt(1, codigo);
		stmt.setString(2, nome);
		stmt.setDouble(3, teste1);
		stmt.setDouble(4, teste2);
		
		stmt.executeUpdate();
		con.close();
	}
	public static ArrayList<Estudante> listaDeEstudantes() throws SQLException, ClassNotFoundException{
		Conexao c = new Conexao();
		Connection con =c.conectar();
		PreparedStatement stmt = null;
		ArrayList<Estudante> estudantes = new ArrayList<Estudante>();
		
		stmt =(PreparedStatement) con.prepareStatement("SELECT * from estudante");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			int codigo = rs.getInt(1);
			String nome = rs.getString(2);
			double teste1 = rs.getDouble(3);
			double teste2 = rs.getDouble(4);
			estudantes.add(new Estudante(codigo, nome, teste1, teste2));
		}
		con.close();
		return estudantes;
	}
	public static void actualizar(int codigo, String nome, double teste1, double teste2) throws SQLException, ClassNotFoundException{
		Conexao c = new Conexao();
		Connection con=c.conectar();
		PreparedStatement stmt = null;
		stmt=(PreparedStatement) con.prepareStatement("UPDATE" + " estudante set nome=?, teste1=?, teste2=? where codigo=?");
		stmt.setString(1, nome);
		stmt.setDouble(2,teste1);
		stmt.setDouble(3,teste2);
		stmt.setInt(4, codigo);
		
		stmt.executeUpdate();
		con.close();
		
}
	public static void removerEstudante(int codigo) throws SQLException, ClassNotFoundException{
		Conexao c = new Conexao();
		Connection con=c.conectar();
		PreparedStatement stmt = null;
		
		stmt=(PreparedStatement) con.prepareStatement("DELETE from estudante where codigo=?");
		stmt.setInt(1, codigo);
		stmt.executeUpdate();
		con.close();
			
		}
	}
	
