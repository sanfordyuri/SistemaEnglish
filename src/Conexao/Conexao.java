/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Yuri Sanford
 */
public class Conexao {
        
    	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/english","root","");
	}

	public static void createTable() throws ClassNotFoundException, SQLException {
		if(getConnection() != null) {
			PreparedStatement stm = null;
			stm = (PreparedStatement) getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `english`(`palavra` VARCHAR(64), `palavra_traduzida` VARCHAR(64), `frase` VARCHAR(64), `frase_traduzida` VARCHAR(64), `data` VARCHAR(64))");
			stm.executeUpdate();
		}
	}

        
}
