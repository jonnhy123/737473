package br.univel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 09:24:08 
 */
public class ClienteDao {

	private Connection con;
	
	private static final String adiconar = "INSERT INTO cliente (id,nome,bairro,endereco,"
			+ "estado,cidade,cep,cpf) VALUES (?,?,?,?,?,?,?,?)";
	
	public void salvar(Cliente c) {

		con = Conexao.getInstance().getConnection();

		try {
		    PreparedStatement ps = con.prepareStatement(adiconar);
		    
		    String id = c.getId();
			String nome = c.getNome();
			String bairro = c.getBairo();
			String endereco = c.getEndereco();
			String cidade = c.getCidade();
			String estado = c.getEstado();
			String cpf = c.getCpf();
			String cep = c.getCep();
		    
			ps.setString(1, id);
			ps.setString(2, nome);
			ps.setString(3, bairro);
			ps.setString(4, endereco);
			ps.setString(5, estado);
			ps.setString(6, cidade);
			ps.setString(7, cep);
			ps.setString(8, cep);
			
			ps.execute();
			} catch (SQLException e) {
				System.out.println("Erro no SQL adicionar.\n" + e);
			}

		}

}
