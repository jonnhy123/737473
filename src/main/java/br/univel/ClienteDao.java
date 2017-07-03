package br.univel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 09:24:08 
 */
public class ClienteDao {

	private Connection con;
	
	private static final String excluirCliente = "DELETE FROM cliente WHERE ID = ?";
	private static final String adiconar = "INSERT INTO cliente (id,nome,bairro,endereco,"
			+ "estado,cidade,cep,cpf) VALUES (?,?,?,?,?,?,?,?)";
	private static final String buscarTodos = "SELECT * FROM cliente";
	
	public List<Cliente> buscarTodos(){
		List<Cliente> lista = new ArrayList<>();
		con = Conexao.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(buscarTodos);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setBairo(rs.getString(3));
				c.setEndereco(rs.getString(4));
				c.setEstado(rs.getString(5));
				c.setCidade(rs.getString(6));
				c.setCep(rs.getString(7));
				c.setCpf(rs.getString(8));
				
				lista.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void salvar(List<Cliente> minhaLista) {

		con = Conexao.getInstance().getConnection();

		try {
		    PreparedStatement ps = con.prepareStatement(adiconar);
		    
		    for (Cliente c : minhaLista) {
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
		    	ps.setString(7, cpf);
		    	ps.setString(8, cep);

		    	ps.execute();
			}
		} catch (SQLException e) {
			System.out.println("Erro no SQL adicionar.\n" + e);
		}
	}

	public List<Cliente> buscarPorId(String palavra) {
		con = Conexao.getInstance().getConnection();
		List<Cliente> lista = new ArrayList<>();
		String buscar = "SELECT * FROM cliente WHERE id LIKE '"+palavra+"%'";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(buscar);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setBairo(rs.getString(3));
				c.setEndereco(rs.getString(4));
				c.setEstado(rs.getString(5));
				c.setCidade(rs.getString(6));
				c.setCpf(rs.getString(7));
				c.setCep(rs.getString(8));
				
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
		
	public List<Cliente> buscarPorNome(String palavra) {
		con = Conexao.getInstance().getConnection();
		List<Cliente> lista = new ArrayList<>();
		String buscar = "SELECT * FROM cliente WHERE nome ILIKE '%"+palavra+"%'";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(buscar);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setBairo(rs.getString(3));
				c.setEndereco(rs.getString(4));
				c.setEstado(rs.getString(5));
				c.setCidade(rs.getString(6));
				c.setCpf(rs.getString(7));
				c.setCep(rs.getString(8));
				
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	public void excluirCliente(String intValorCampoDeTexto) {
		con = Conexao.getInstance().getConnection();
		
		try {
			String id = intValorCampoDeTexto;
			PreparedStatement ps = con.prepareStatement(excluirCliente);
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro no SQL excluirItem.\n" + e);
		}
	}

}
