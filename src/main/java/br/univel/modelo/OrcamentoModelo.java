package br.univel.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.classes.Orcamento;

/**
 * By: Jhonatan Mattana
 * 3 de jul de 2017 - 06:59:29 
 */
public class OrcamentoModelo extends AbstractTableModel{

	List<Orcamento> lista = new ArrayList<>();
	
	public OrcamentoModelo(List<Orcamento> _lista) {
		this.lista = _lista;
	}
	
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "CódProduto";
		case 1:
			return "Nome produto";
		case 2:
			return "Preço produto";
		case 3:
			return "Qtd produto";
		case 4:
			return "Valor total";
		case 5:
			return "CódCliente";
		case 6:
			return "Nome cliente";
		}
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		Orcamento o = lista.get(row);
		
		switch (column) {
		case 0:
			return o.getCodProduto();
		case 1:
			return o.getNomeProduto();
		case 2:
			return o.getPrecoProduto();
		case 3:
			return o.getQtdProduto();
		case 4:
			return o.getVlwTotal();
		case 5:
			return o.getCodCliente();
		case 6:
			return o.getNomeCliente();
		}

		throw new RuntimeException("Coluna "+column+" não encontrada.");
	}
}
