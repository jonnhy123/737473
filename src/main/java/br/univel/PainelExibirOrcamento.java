package br.univel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * By: Jhonatan Mattana
 * 3 de jul de 2017 - 07:13:08 
 */
public class PainelExibirOrcamento extends PainelExibirOrcamentoBase{
	
	public PainelExibirOrcamento() {
		iniciarTabela();
		configurarBotoes();
	}

	private void configurarBotoes() {
		super.btnGerarReltorio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});
		super.btnImprimirRelatrio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imprimirRelatorio();
			}
		});
	}

	protected void imprimirRelatorio() {
		ReportManager rm = new ReportManager();
		rm.imprimir();
	}

	protected void gerarRelatorio() {
		ReportManager rm = new ReportManager();
		rm.exportar();
	}

	private void iniciarTabela() {
		OrcamentoDao dao = new OrcamentoDao();
		List<Orcamento> lista = dao.buscarTodos();
		OrcamentoModelo modelo;
		modelo = new OrcamentoModelo(lista);
		table.setModel(modelo);
	}
}
