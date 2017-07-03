package br.univel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 19:31:14 
 */
public class ClienteModelo extends AbstractTableModel{

	private List<Cliente> listaClienteDeClasse = new ArrayList<>();

	public ClienteModelo() {
		this((List<Cliente>)null);
	}
	
	public ClienteModelo(List<Cliente> listaProdutoContrutor) {
		this.listaClienteDeClasse = listaProdutoContrutor;
		fireTableDataChanged();
	}

	void preencherResultado(List<Cliente> resultado) {
		this.listaClienteDeClasse = resultado;
		fireTableDataChanged();
	}
	

	public int getColumnCount() {
		return 8;
	}

	public int getRowCount() {
		return listaClienteDeClasse.size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "ID";
		case 1:
			return "Nome";
		case 2:
			return "Bairro";
		case 3:
			return "Endereco";
		case 4:
			return "Estado";
		case 5:
			return "Cidade";
		case 6:
			return "Cep";
		case 7:
			return "CPF";
		}
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {

		Cliente c = listaClienteDeClasse.get(row);
		
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
			return c.getEstado();
		case 5:
			return c.getCidade();
		case 6:
			return c.getCpf();
		case 7:
			return c.getCep();
		}
		throw new RuntimeException("Coluna "+column+"não encontrada");
	}

//	public void salvar(List<Cliente> listaCliente) {
//
//		ClienteDao dao = new ClienteDao();
//		
//		List<Cliente> minhaLista = new ArrayList<>();
//
//		for (int i = 0; i < listaCliente.size(); i++) {
//			Cliente c = new Cliente();
//			
//			c.setId(listaCliente.get(i).getId());
//			c.setNome(listaCliente.get(i).getNome());
//			c.setBairo(listaCliente.get(i).getBairo());
//			c.setEndereco(listaCliente.get(i).getEndereco());
//			c.setEstado(listaCliente.get(i).getEstado());
//			c.setCidade(listaCliente.get(i).getCidade());
//			c.setCpf(listaCliente.get(i).getCpf());
//			c.setCep(listaCliente.get(i).getCep());
//			
//			minhaLista.add(c);
//		}
//		dao.salvar(minhaLista);
//	}

	public Cliente getClienteAt(int idx) {
		if (idx >= this.listaClienteDeClasse.size()) {
			return null;
		}
		return this.listaClienteDeClasse.get(idx);
	}

}