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
 * 2 de jul de 2017 - 01:48:09 
 */
public class PainelOrcamentos extends PainelOrcamentoBase{
	
	private Consumer<Cliente> consumerClienteOnOk;
	private Runnable runnableClienteOnCancel;
	
	private Consumer<Produto> consumerProdutoOnOk;
	private Runnable runnableProdutoOnCancel;
	
	public PainelOrcamentos() {
			super();
			iniciaTabelaP();
			iniciarTabela();
			buscaDeClientes();
			buscaDeProdutos();
			configurarBotoes();
	}

	private void iniciaTabelaP() {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> lista = dao.selectFrom();
		ProdutoModelo modelo;
		modelo = new ProdutoModelo(lista);
		table_Produto.setModel(modelo);
	}

	public void iniciarTabela() {
		ClienteModelo modelo;
		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = dao.buscarTodos();
		modelo = new ClienteModelo(lista);
		table_Cliente.setModel(modelo);
	}
	
	private void buscaDeProdutos() {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> lista = dao.selectFrom();
		ProdutoModelo modelo;
		modelo = new ProdutoModelo(lista);
		table_Produto.setModel(modelo);

		txtCodigoProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscaIdProduto(txtCodigoProduto.getText().trim().toLowerCase());
				}
				case KeyEvent.VK_DOWN:
					table_Produto.getSelectionModel().setSelectionInterval(0, 0);
					txtCodigoProduto.transferFocus();
					return;
				case KeyEvent.VK_ESCAPE:
					if (PainelOrcamentos.this.runnableProdutoOnCancel != null) {
						PainelOrcamentos.this.runnableProdutoOnCancel.run();
					}
					return;
					default:
						buscaIdProduto(txtCodigoProduto.getText().trim().toLowerCase());
				}
			}
		});
		
		table_Produto.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					table_Produto.transferFocusBackward();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					e.consume();
					
					int idx = table_Produto.getSelectedRow();
					if (idx != -1) {
						Produto produto = ((ProdutoModelo)table_Produto.getModel()).getProdutotAt(idx);
						if (produto == null) {
							return;
						}
						PainelOrcamentos.this.consumerProdutoOnOk.accept(produto);
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelOrcamentos.this.runnableProdutoOnCancel != null) {
						PainelOrcamentos.this.runnableProdutoOnCancel.run();
					}
				}
			}
		});
	}

	protected void buscaIdProduto(String palavra) {

		List<Produto> lista = buscaNoBancoIdProduto(palavra);

		((ProdutoModelo) table_Produto.getModel()).preencherResultado(lista);
	}

	private List<Produto> buscaNoBancoIdProduto(String palavra) {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> lista = new ArrayList<Produto>();
		lista = dao.buscarPorId(palavra);
		PainelEditarClienteBase p = new PainelEditarClienteBase();
		return lista;
	}

	protected void buscaProduto(String palavra) {

		List<Produto> lista = buscaNoBancoProduto(palavra);

		((ProdutoModelo) table_Produto.getModel()).preencherResultado(lista);
	}

	private List<Produto> buscaNoBancoProduto(String palavra) {

		ProdutoDao dao = new ProdutoDao();
		List<Produto> lista = new ArrayList<Produto>();
		lista = dao.buscarPorNome(palavra);
		PainelEditarClienteBase p = new PainelEditarClienteBase();
		return lista;
	}

	public void setOnOkCliente(Consumer<Cliente> c) {
		this.consumerClienteOnOk = c;
	}
	
	public void setOnCancelCliente(Runnable r) {
		this.runnableClienteOnCancel = r;
	}

	public void setOnOkProduto(Consumer<Produto> p) {
		this.consumerProdutoOnOk = p;
	}

	public void setOnCancelProduto(Runnable r) {
		this.runnableProdutoOnCancel = r;
	}
	
	private void configurarBotoes() {
		super.btnLimparCamposProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCamposP();
			}
		});
		super.btnLimparCamposCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCamposC();
			}
		});
		super.btnRealizarOramento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selececinarProduto();
			}
		});
		super.btnSelecionarProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecionarProduto();
			}
		});
		super.btnSelecionarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecionarCliente();
			}
		});
		super.btnRealizarOramento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				realizarOrcamento();
			}
		});
		super.btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
	}
	
	protected void salvar() {
		OrcamentoDao dao = new OrcamentoDao(); 
		List<Orcamento> lista = new ArrayList<>();
		Orcamento o = new Orcamento();
		
		o.setCodProduto(txtCodigoCliente.getText().trim());
		o.setNomeProduto(txtProdutoProduto.getText().trim());
		o.setPrecoProduto(txtPrecoProduto.getText().trim());
		o.setQtdProduto(txtQtdCliente.getText().trim());
		o.setCodCliente(txtCodigoCliente.getText().trim());
		o.setNomeCliente(txtNomeCliente.getText().trim());
		o.setVlwTotal(txtVlrTotal.getText().trim());
		
		lista.add(o);
		dao.salvar(lista);
		
		limparCamposC();
		limparCamposP();
		
		JOptionPane.showMessageDialog(null, "Orçamento salvo.");
	}

	protected void realizarOrcamento() {
		int qtd = Integer.parseInt(txtQtdCliente.getText().trim());
		int preco = Integer.parseInt(txtPrecoProduto.getText().trim());
		
		int total = qtd * preco;
		
		String strTotal = String.valueOf(total);
		txtVlrTotal.setText(strTotal);
		
		JOptionPane.showMessageDialog(null, "Orçamento realizado, confira o valor total no final da tela.");
	}

	protected void selecionarCliente() {
		int indiceLinha = table_Cliente.getSelectedRow();
		txtCodigoCliente.setText(table_Cliente.getValueAt(indiceLinha, 0).toString());
		txtNomeCliente.setText(table_Cliente.getValueAt(indiceLinha, 1).toString());
		txtQtdCliente.requestFocus();
	}

	protected void selecionarProduto() {
		int indiceLinha = table_Produto.getSelectedRow();
		txtCodigoProduto.setText(table_Produto.getValueAt(indiceLinha, 0).toString());
		txtProdutoProduto.setText(table_Produto.getValueAt(indiceLinha, 1).toString());
		txtPrecoProduto.setText(table_Produto.getValueAt(indiceLinha, 2).toString());
	}

	private void buscaDeClientes() {

		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = dao.buscarTodos();
		ClienteModelo model;
		model = new ClienteModelo(lista);
		table_Cliente.setModel(model);

		txtCodigoCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscaId(txtCodigoCliente.getText().trim().toLowerCase());
				}
				case KeyEvent.VK_DOWN:
					table_Cliente.getSelectionModel().setSelectionInterval(0, 0);
					txtCodigoCliente.transferFocus();
					return;
				case KeyEvent.VK_ESCAPE:
					if (PainelOrcamentos.this.runnableClienteOnCancel != null) {
						PainelOrcamentos.this.runnableClienteOnCancel.run();
					}
					return;
					default:
						buscaId(txtCodigoCliente.getText().trim().toLowerCase());
				}
			}
		});
		
		table_Cliente.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					table_Cliente.transferFocusBackward();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					e.consume();
					
					int idx = table_Cliente.getSelectedRow();
					if (idx != -1) {
						Cliente cliente = ((ClienteModelo)table_Cliente.getModel()).getClienteAt(idx);
						if (cliente == null) {
							return;
						}
						PainelOrcamentos.this.consumerClienteOnOk.accept(cliente);
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelOrcamentos.this.runnableClienteOnCancel != null) {
						PainelOrcamentos.this.runnableClienteOnCancel.run();
					}
				}
			}
		});
	}

	protected void buscaId(String palavra) {

		List<Cliente> lista = buscaNoBancoId(palavra);

		((ClienteModelo) table_Cliente.getModel()).preencherResultado(lista);
	}

	private List<Cliente> buscaNoBancoId(String palavra) {
		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = new ArrayList<Cliente>();
		lista = dao.buscarPorId(palavra);
		return lista;
	}

	protected void buscaNome(String palavra) {

		List<Cliente> lista = buscaNoBancoNome(palavra);

		((ClienteModelo) table_Cliente.getModel()).preencherResultado(lista);
	}

	private List<Cliente> buscaNoBancoNome(String palavra) {

		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = new ArrayList<Cliente>();
		lista = dao.buscarPorNome(palavra);
		return lista;
	}

	protected void selececinarProduto() {
		
	}

	protected void limparCamposC() {
		txtCodigoCliente.setText("");
		txtNomeCliente.setText("");
		txtQtdCliente.setText("");
		txtVlrTotal.setText("");
	}

	private void limparCamposP() {
		txtCodigoProduto.setText("");
		txtPrecoProduto.setText("");
		txtProdutoProduto.setText("");
		txtVlrTotal.setText("");
	}
}
