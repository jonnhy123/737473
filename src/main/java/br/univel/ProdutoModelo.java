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

	private static List<Produto> listaProdutoDeClasse;
	
	public ProdutoModelo(List<Produto> listaProdutoContrutor) {
		if (listaProdutoDeClasse == null) {
			listaProdutoDeClasse = new ArrayList<Produto>();
		}else{
			listaProdutoDeClasse = listaProdutoContrutor;
		}
	}

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return listaProdutoDeClasse.size();
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
		
		throw new RuntimeException("Coluna "+column+"n�o encontrada");
	}

	public void salvar(List<Produto> listaProduto) {
		ProdutoDao dao = new ProdutoDao();
		
		List<Produto> minhaLista = new ArrayList<Produto>();

		for (int i = 0; i < listaProduto.size(); i++) {
			Produto p = new Produto();
			Long id = listaProduto.get(i).getId();
			String descricao = listaProduto.get(i).getDescricao();
			BigDecimal vlrDolar = listaProduto.get(i).getValorDolar();
			
			minhaLista.add(p);
		}
		dao.salvar(minhaLista);
	}
}
