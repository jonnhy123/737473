package br.univel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 02:29:01 
 */
public class Conexao {
	
	private static Conexao self;
	private Connection con;
	
	private static final String url = "jdbc:postgresql://localhost:5432/master10";
	private static final String pas = "univel";
	private static final String banco = "postgres";
	private static final String driver = "org.postgresql.Driver";
	
	public Conexao() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,banco,pas);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Conexao.this.con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}));
		
	}
	
	public static final synchronized Conexao getInstance(){
		if (self == null) {
			self = new Conexao();
		}
		return self;
	}
	
	public Connection getConnection(){
		return this.con;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Só pode haver um.");
	}
}
