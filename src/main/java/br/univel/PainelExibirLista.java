package br.univel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 04:34:18 
 */
public class PainelExibirLista extends PainelExibirListaBase{
	
	private Consumer<Produto> consumerOnOk;
	private Runnable runnableOnCancel;
	
	public PainelExibirLista() {
		super();
		configurarBusca();
	}

	public void setOnOk(Consumer<Produto> p) {
		this.consumerOnOk = p;
	}

	public void setOnCancel(Runnable r) {
		this.runnableOnCancel = r;
	}
	
	private void configurarBusca() {
		ProdutoModelo model = new ProdutoModelo();
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
					if (PainelExibirLista.this.runnableOnCancel != null) {
						PainelExibirLista.this.runnableOnCancel.run();
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
					busca(txtNome.getText().trim().toLowerCase());
				}
				case KeyEvent.VK_DOWN:
					table.getSelectionModel().setSelectionInterval(0, 0);
					txtNome.transferFocus();
					return;
				case KeyEvent.VK_ESCAPE:
					if (PainelExibirLista.this.runnableOnCancel != null) {
						PainelExibirLista.this.runnableOnCancel.run();
					}
					return;
					default:
						busca(txtNome.getText().trim().toLowerCase());
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
						Produto produto = ((ProdutoModelo)table.getModel()).getProdutotAt(idx);
						if (produto == null) {
							return;
						}
						PainelExibirLista.this.consumerOnOk.accept(produto);
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelExibirLista.this.runnableOnCancel != null) {
						PainelExibirLista.this.runnableOnCancel.run();
					}
				}
			}
		});
	}

	protected void buscaId(String palavra) {

		List<Produto> lista = buscaNoBancoId(palavra);

		((ProdutoModelo) table.getModel()).preencherResultado(lista);
	}

	private List<Produto> buscaNoBancoId(String palavra) {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> lista = new ArrayList<Produto>();
		lista = dao.buscarPorId(palavra);
		PainelEditarClienteBase p = new PainelEditarClienteBase();
		return lista;
	}

	protected void busca(String palavra) {

		List<Produto> lista = buscaNoBanco(palavra);

		((ProdutoModelo) table.getModel()).preencherResultado(lista);
	}

	private List<Produto> buscaNoBanco(String palavra) {

		ProdutoDao dao = new ProdutoDao();
		List<Produto> lista = new ArrayList<Produto>();
		lista = dao.buscarPorNome(palavra);
		PainelEditarClienteBase p = new PainelEditarClienteBase();
		return lista;
	}
}
