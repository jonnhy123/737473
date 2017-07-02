package br.univel;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 02:22:28 
 */
public class ProdutoDao {

	private Connection con;

	public List<Produto> selectFrom (){
		con = Conexao.getInstance().getConnection();
		
		List<Produto> listaP = new ArrayList<Produto>();
		
		String selectFrom = "SELECT * FROM produto";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(selectFrom);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getString(1));
				p.setDescricao(rs.getString(2));
				p.setValorDolar(rs.getBigDecimal(3));
				listaP.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaP;
	}
	
	public void salvar(List<Produto> minhaLista) {
		con = Conexao.getInstance().getConnection();

		String insertInto = "INSERT INTO produto (id,descricao,valorDolar) VALUES (?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insertInto);
			
			for (Produto p : minhaLista) {
				ps.setString(1, p.getId());
				ps.setString(2, p.getDescricao());
				ps.setBigDecimal(3, p.getValorDolar());
				
				ps.execute();
			}
		} catch (SQLException e) {
			System.out.println("Erro no INSERT INTO");
		}
	}

	public List<Produto> buscarPorNome(String palavra) {
		con = Conexao.getInstance().getConnection();
		List<Produto> lista = new ArrayList<>();
		String buscar = "SELECT * FROM produto WHERE descricao ILIKE '%"+palavra+"%'";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(buscar);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getString(1));
				p.setDescricao(rs.getString(2));
				p.setValorDolar(rs.getBigDecimal(3));
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	public List<Produto> buscarPorId(String palavra) {
		con = Conexao.getInstance().getConnection();
		List<Produto> lista = new ArrayList<>();
		String buscar = "SELECT * FROM produto WHERE id LIKE '"+palavra+"%'";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(buscar);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getString(1));
				p.setDescricao(rs.getString(2));
				p.setValorDolar(rs.getBigDecimal(3));
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
