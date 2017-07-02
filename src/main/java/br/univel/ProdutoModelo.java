package br.univel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * By: Jhonatan Mattana
 * 30 de jun de 2017 - 21:31:49 
 */
public class ProdutoModelo extends AbstractTableModel{

	private static List<Produto> listaProdutoDeClasse = new ArrayList<>();

	public ProdutoModelo(List<Produto> listaProdutoContrutor) {
			listaProdutoDeClasse = listaProdutoContrutor;
	}

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return listaProdutoDeClasse.size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "ID";
		case 1:
			return "Descrição";
		case 2:
			return "Valor Dolár";
		}
		return super.getColumnName(column);
	}

	
	public Object getValueAt(int row, int column) {

		Produto p = listaProdutoDeClasse.get(row);
		
		switch (column) {
		case 0:
			return p.getId();
		case 1:
			return p.getDescricao();
		case 2:
			p.getValorDolar();
		}
		
		throw new RuntimeException("Coluna "+column+"não encontrada");
	}

	public void salvar(List<Produto> listaProduto) {
		ProdutoDao dao = new ProdutoDao();
		
		List<Produto> minhaLista = new ArrayList<>();

		for (int i = 0; i < listaProduto.size(); i++) {
			Produto p = new Produto();
			Long id = listaProduto.get(i).getId();
			String descricao = listaProduto.get(i).getDescricao();
			BigDecimal vlrDolar = listaProduto.get(i).getValorDolar();
			p.setId(id);
			p.setDescricao(descricao);
			p.setValorDolar(vlrDolar);
			
			minhaLista.add(p);
		}
		dao.salvar(minhaLista);
	}
}
