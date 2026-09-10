package projetoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TesteConexao {
	
	public static void listar(Connection con) throws SQLException {

	    String sqlSel = "SELECT id,nome,curso,nota FROM estudante ORDER BY nota DESC";

	    try (Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sqlSel)) {

	        System.out.println("\n--- Estudantes ---");

	        while (rs.next()) {

	            System.out.printf("%d | %s | %s | %.1f%n",
	                    rs.getInt("id"),
	                    rs.getString("nome"),
	                    rs.getString("curso"),
	                    rs.getDouble("nota"));
	        }
	    }
	}

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		
		
		
		
		String url = "jdbc:mysql://localhost:3306/escola";
		String user = "aluno_cd";
		String senha = "aluno_pw";
		try (Connection con = DriverManager.getConnection(url, user, senha)) {
		System.out.println("Conectado a: " +
		con.getMetaData().getDatabaseProductName());
		
		listar(con);
		
		String sqlIns = "INSERT INTO estudante (nome,curso,nota) VALUES (?,?,?)";
		try (PreparedStatement ps = con.prepareStatement(sqlIns)) {
			user =leia.nextLine();
		ps.setString(1, user);
		ps.setString(2, "ADS");
		ps.setDouble(3, 8.0);
		ps.executeUpdate();
		System.out.println("Estudante inserido.");
		
		listar(con);
		
		}String sqlSel = "SELECT id,nome,curso,nota FROM estudante ORDER BY nota DESC";
		try (Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSel)) {
				System.out.println("\n--- Estudantes ---");
				while (rs.next()) {
				System.out.printf("%d | %s | %s | %.1f%n",
				rs.getInt("id"), rs.getString("nome"),
				rs.getString("curso"), rs.getDouble("nota"));
				}
				}} catch (SQLException e) {
					System.out.println("Erro de banco: " + e.getMessage());
				}
				}
				}
		

	


