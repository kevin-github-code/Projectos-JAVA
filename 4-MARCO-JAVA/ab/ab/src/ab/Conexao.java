package ab;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class Conexao {
	
	Connection conexion = null;
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost/estudantes";
	
	public Connection conectar (){
		try{
			if(conexion==null){
				Class.forName(driver);
				conexion = DriverManager.getConnection(url , "root", "");
				
				JOptionPane.showMessageDialog(null, "Conexao feita com sucesso");
			}
		}catch(HeadlessException | ClassNotFoundException | SQLException e){
			System.out.println(e);
			
		}
		return conexion;
	}
	public static void main(String[] args){
		ViewEstudante frame = new ViewEstudante();        
        frame.setVisible(true);
		Conexao con = new Conexao();
		con.conectar();
	}

}

