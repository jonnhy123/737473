package br.univel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 09:14:36 
 */
public class ModeloCliente extends AbstractTableModel{

	List<Cliente> listaCliente = new ArrayList<>();
	
	public ModeloCliente() {
		this((List<Cliente>)null);
	}
	
	public ModeloCliente(List<Cliente> lista){
		listaCliente = lista;
	}
	
	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return listaCliente.size();
	}

	@Override
	public String getColumnName(int coluna) {
		switch (coluna) {
		case 0:
			return "Código";
		case 1:
			return "Nome";
		case 2:
			return "Bairro";
		case 3:
			return "Endereço";
		case 4:
			return "Cidade";
		case 5:
			return "Estado";
		case 6:
			return "CPF";
		case 7:
			return "Cep";
		}
		return super.getColumnName(coluna);
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		
		Cliente c = listaCliente.get(row);
		
		switch (column) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getBairo();
		case 3:
			return c.getEndereco();
		case 4:
			return c.getCidade();
		case 5:
			return c.getEstado();
		case 6:
			return c.getCpf();
		case 7:
			return c.getCpf();
		}
		
		throw new RuntimeException("Coluna "+column+" não encontrada.");
	}

	public void adicionar(Cliente c) {
		ClienteDao dao = new ClienteDao();
		dao.salvar(c);
	}
}
