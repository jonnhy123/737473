package br.univel;

import java.util.List;

/**
 * By: Jhonatan Mattana
 * 3 de jul de 2017 - 07:13:08 
 */
public class PainelExibirOrcamento extends PainelExibirOrcamentoBase{
	
	public PainelExibirOrcamento() {
		iniciarTabela();
	}

	private void iniciarTabela() {
		OrcamentoDao dao = new OrcamentoDao();
		List<Orcamento> lista = dao.buscarTodos();
		OrcamentoModelo modelo;
		modelo = new OrcamentoModelo(lista);
		table.setModel(modelo);
	}
}
