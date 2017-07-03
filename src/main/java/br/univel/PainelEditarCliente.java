package br.univel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JOptionPane;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 05:39:22 
 */
public class PainelEditarCliente extends PainelEditarClienteBase{

	private Consumer<Cliente> consumerOnOk;
	private Runnable runnableOnCancel;
	private ClienteModelo modelo;
	
	public PainelEditarCliente() {
		super();
		configurarBusca();
		configurarBotoes();
		iniciarTabela();
	}

	private void configurarBotoes() {
		btnNovoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnExcluirClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirCliente();
			}
		});
	}

	protected void excluirCliente() {
		ClienteDao dao = new ClienteDao();
		dao.excluirCliente(txtCodigo.getText().trim());
		iniciarTabela();
	}

	protected void limparCampos() {
		txtCodigo.setText("");
		txtNome.setText("");
		txtBairro.setText("");
		txtEndereco.setText("");
		txtEstado.setText("");
		txtCidade.setText("");
		txtCPF.setText("");
		txtCep.setText("");
	}
	
	private void iniciarTabela() {
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
					preencherCampos();
					buscaId(txtCodigo.getText().trim().toLowerCase());
				}
				case KeyEvent.VK_DOWN:
					table.getSelectionModel().setSelectionInterval(0, 0);
					txtCodigo.transferFocus();
					return;
				case KeyEvent.VK_ESCAPE:
					if (PainelEditarCliente.this.runnableOnCancel != null) {
						PainelEditarCliente.this.runnableOnCancel.run();
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
					preencherCampos();
					buscaNome(txtNome.getText().trim().toLowerCase());
				}
				case KeyEvent.VK_DOWN:
					table.getSelectionModel().setSelectionInterval(0, 0);
					txtNome.transferFocus();
					return;
				case KeyEvent.VK_ESCAPE:
					if (PainelEditarCliente.this.runnableOnCancel != null) {
						PainelEditarCliente.this.runnableOnCancel.run();
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
						PainelEditarCliente.this.consumerOnOk.accept(cliente);
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelEditarCliente.this.runnableOnCancel != null) {
						PainelEditarCliente.this.runnableOnCancel.run();
					}
				}
			}
		});
	}

	protected void preencherCampos() {
		
		int indiceLinha = Integer.parseInt(txtCodigo.getText().trim());
		
		txtCodigo.setText(table.getValueAt(indiceLinha, 0).toString());
		txtNome.setText(table.getValueAt(indiceLinha, 1).toString());
		txtBairro.setText(table.getValueAt(indiceLinha, 2).toString());
		txtEndereco.setText(table.getValueAt(indiceLinha, 3).toString());
		txtEstado.setText(table.getValueAt(indiceLinha, 4).toString());
		txtCidade.setText(table.getValueAt(indiceLinha, 5).toString());
		txtCep.setText(table.getValueAt(indiceLinha, 6).toString());
		txtCPF.setText(table.getValueAt(indiceLinha, 7).toString());
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
