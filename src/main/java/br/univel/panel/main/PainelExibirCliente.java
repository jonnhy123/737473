package br.univel.panel.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import br.univel.classes.Cliente;
import br.univel.dao.ClienteDao;
import br.univel.modelo.ClienteModelo;
import br.univel.panel.base.PainelExibirClienteBase;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 19:11:52 
 */
public class PainelExibirCliente extends PainelExibirClienteBase{
	
	private Consumer<Cliente> consumerOnOk;
	private Runnable runnableOnCancel;
	
	public PainelExibirCliente() {
		super();
		configurarBusca();
		iniciarTabela();
	}
	
	private void iniciarTabela() {
	
		ClienteModelo modelo;
		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = dao.buscarTodos();
		modelo = new ClienteModelo(lista);
		table.setModel(modelo);
		
	}

	public void setOnOk(Consumer<Cliente> c) {
		this.consumerOnOk = c;
	}

	public void setOnCancel(Runnable r) {
		this.runnableOnCancel = r;
	}
	
	private void configurarBusca() {
		ClienteModelo model = new ClienteModelo();
		table.setModel(model);

		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscaId(txtCodigo.getText().trim().toLowerCase());
				}
				case KeyEvent.VK_DOWN:
					table.getSelectionModel().setSelectionInterval(0, 0);
					txtCodigo.transferFocus();
					return;
				case KeyEvent.VK_ESCAPE:
					if (PainelExibirCliente.this.runnableOnCancel != null) {
						PainelExibirCliente.this.runnableOnCancel.run();
					}
					return;
					default:
						buscaId(txtCodigo.getText().trim().toLowerCase());
				}
			}
		});
		
		txtNome.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscaNome(txtNome.getText().trim().toLowerCase());
				}
				case KeyEvent.VK_DOWN:
					table.getSelectionModel().setSelectionInterval(0, 0);
					txtNome.transferFocus();
					return;
				case KeyEvent.VK_ESCAPE:
					if (PainelExibirCliente.this.runnableOnCancel != null) {
						PainelExibirCliente.this.runnableOnCancel.run();
					}
					return;
					default:
						buscaNome(txtNome.getText().trim().toLowerCase());
				}
			}
		});
		
		table.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					table.transferFocusBackward();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					e.consume();
					
					int idx = table.getSelectedRow();
					if (idx != -1) {
						Cliente cliente = ((ClienteModelo)table.getModel()).getClienteAt(idx);
						if (cliente == null) {
							return;
						}
						PainelExibirCliente.this.consumerOnOk.accept(cliente);
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelExibirCliente.this.runnableOnCancel != null) {
						PainelExibirCliente.this.runnableOnCancel.run();
					}
				}
			}
		});
	}

	protected void buscaId(String palavra) {

		List<Cliente> lista = buscaNoBancoId(palavra);

		((ClienteModelo) table.getModel()).preencherResultado(lista);
	}

	private List<Cliente> buscaNoBancoId(String palavra) {
		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = new ArrayList<Cliente>();
		lista = dao.buscarPorId(palavra);
		return lista;
	}

	protected void buscaNome(String palavra) {

		List<Cliente> lista = buscaNoBancoNome(palavra);

		((ClienteModelo) table.getModel()).preencherResultado(lista);
	}

	private List<Cliente> buscaNoBancoNome(String palavra) {

		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = new ArrayList<Cliente>();
		lista = dao.buscarPorNome(palavra);
		return lista;
	}
}