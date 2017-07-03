package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.classes.Orcamento;

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
				o.setCodProduto(rs.getString(1));
				o.setCodCliente(rs.getString(2));
				o.setNomeProduto(rs.getString(3));
				o.setNomeCliente(rs.getString(4));
				o.setPrecoProduto(rs.getString(5));
				o.setQtdProduto(rs.getString(6));
				o.setVlwTotal(rs.getString(7));
				
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
