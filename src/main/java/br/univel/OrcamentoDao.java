package br.univel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * By: Jhonatan Mattana
 * 3 de jul de 2017 - 06:25:42 
 */
public class OrcamentoDao {

	private Connection con;
	
	private static final String salvar = "INSERT INTO orcamento ("
			+ "codProduto,codCliente,nomeProduto,nomeCliente,precoProduto,"
			+ "qtdProduto,vlrTotal) VALUES (?,?,?,?,?,?,?)";
	private static final String buscarTodos = "SELECT * FROM orcamento";
	
	public List<Orcamento> buscarTodos(){
		con = Conexao.getInstance().getConnection();
		List<Orcamento> lista = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(buscarTodos);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Orcamento o = new Orcamento();
				o.setCodProduto(rs.getString(0));
				o.setCodCliente(rs.getString(1));
				o.setNomeProduto(rs.getString(2));
				o.setNomeCliente(rs.getString(3));
				o.setPrecoProduto(rs.getString(4));
				o.setQtdProduto(rs.getString(5));
				o.setVlwTotal(rs.getString(6));
				
				lista.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void salvar(List<Orcamento> lista) {
		con = Conexao.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(salvar);
			for (Orcamento o : lista) {
				ps.setString(1, o.getCodProduto());
				ps.setString(2, o.getCodCliente());
				ps.setString(3, o.getNomeProduto());
				ps.setString(4, o.getNomeCliente());
				ps.setString(5, o.getPrecoProduto());
				ps.setString(6, o.getQtdProduto());
				ps.setString(7, o.getVlwTotal());
				
				ps.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
