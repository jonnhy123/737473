package br.univel.executavel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import br.univel.LeitorProdutoUrl;
import br.univel.classes.Produto;
import br.univel.dao.ProdutoDao;
import br.univel.modelo.ProdutoModelo;
import br.univel.panel.base.PrincipalBase;
import br.univel.panel.main.PainelCadCliente;
import br.univel.panel.main.PainelEditarCliente;
import br.univel.panel.main.PainelExibirCliente;
import br.univel.panel.main.PainelExibirLista;
import br.univel.panel.main.PainelExibirOrcamento;
import br.univel.panel.main.PainelOrcamentos;
import br.univel.panel.main.PainelWrapper;

/**
 * By: Jhonatan Mattana
 * 30 de jun de 2017 - 21:28:44 
 */
public class Principal extends PrincipalBase{

	private static PainelExibirOrcamento instaciaUnicaOrcamento = null;
	private static PainelExibirCliente instaciaUnicaClientes = null;
	private static PainelCadCliente instanciaUnica_Cad = null;
	private static PainelOrcamentos instanciaUnica_O = null;
	private static PainelExibirLista instanciaUnica_Exibir = null;
	private static PainelEditarCliente instanciaUnica_Editar = null;
	
	public Principal() {
		super();
		setTitle("MASTER10 TECNOLOGIA");
		configurarBotoes();
	}
	
	private void configurarBotoes() {
		super.mntmBaixarLista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.ALT_MASK));
		super.mntmExibirLista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.ALT_MASK));
		super.mntmCadastrarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.ALT_MASK));
		super.mntmEditarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		super.mntmRealizarOramento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.ALT_MASK));
		super.mntmExibirClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, ActionEvent.ALT_MASK));
		super.mntmExibirOramentos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, ActionEvent.ALT_MASK));
		
		super.mntmBaixarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baixarLista();
			}
		});
		super.mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCliente();
			}
		});
		super.mntmRealizarOramento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarOrcamento();
			}
		});
		super.mntmExibirLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirLista();
			}
		});
		super.mntmEditarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}
		});
		super.mntmExibirClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				exibirClientes();
			}
		} );
		super.mntmExibirOramentos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirOrcamento();
			}
		});
	}

	protected void exibirOrcamento() {
		if (instaciaUnicaOrcamento == null) {
			instaciaUnicaOrcamento = new PainelExibirOrcamento();
			PainelWrapper wrapper = new PainelWrapper();
			wrapper.setConteudo(instaciaUnicaOrcamento);
			wrapper.setTitulo("Orçamentos de clientes");
			
			wrapper.setFecharPainel(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tabbedPane.remove(wrapper);
					instaciaUnicaOrcamento = null;
				}
			});
			tabbedPane.addTab("Ver orçamentos", wrapper);
		}else{
			JOptionPane.showMessageDialog(null, "Proibido dublicar aba.");
		}
	}

	protected void exibirClientes() {
		if (instaciaUnicaClientes == null) {
			instaciaUnicaClientes = new PainelExibirCliente();
			final PainelWrapper wrapper = new PainelWrapper();
			wrapper.setConteudo(instaciaUnicaClientes);
			wrapper.setTitulo("Buscar clientes");
			
			wrapper.setFecharPainel(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tabbedPane.remove(wrapper);
					instaciaUnicaClientes = null;
				}
			});
			tabbedPane.addTab("Ver clientes", wrapper);
		}else{
			JOptionPane.showMessageDialog(null, "Proibido dublicar aba.");
		}
	}

	protected void editarCliente() {
		if (instanciaUnica_Editar == null) {
			instanciaUnica_Editar = new PainelEditarCliente();
			final PainelWrapper wrapper = new PainelWrapper();
			wrapper.setConteudo(instanciaUnica_Editar);
			wrapper.setTitulo("Editar cliente");
			
			wrapper.setFecharPainel(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tabbedPane.remove(wrapper);
					instanciaUnica_Editar = null;
				}
			});
			tabbedPane.addTab("Editar clientes", wrapper);
		}else{
			JOptionPane.showMessageDialog(null, "Proibido dublicar aba.");
		}
	}

	protected void realizarOrcamento() {
		//Aplicando padrão Singleton
		if (instanciaUnica_O == null) {
			instanciaUnica_O = new PainelOrcamentos();
			final PainelWrapper wrapper = new PainelWrapper();
			wrapper.setConteudo(instanciaUnica_O);
			wrapper.setTitulo("Realizar orçamento");
			
			wrapper.setFecharPainel(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.remove(wrapper);
					instanciaUnica_O = null;
				}
			});
			tabbedPane.addTab("Realizar orçamento", wrapper);
		}else{
			JOptionPane.showMessageDialog(null, "Proibido dublicar aba.");
		}
	}

	protected void cadastrarCliente() {
		//Aplicando padrão Singleton
		if (instanciaUnica_Cad == null) {
			instanciaUnica_Cad = new PainelCadCliente();
			final PainelWrapper wrapper = new PainelWrapper();
			wrapper.setConteudo(instanciaUnica_Cad);
			wrapper.setTitulo("Cadastro de clientes");
			
			wrapper.setFecharPainel(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.remove(wrapper);
					instanciaUnica_Cad = null;
				}
			});
			tabbedPane.addTab("Cadastrar clientes", wrapper);
		}else{
			JOptionPane.showMessageDialog(null, "Proibido dublicar aba.");
		}
	}
	
	protected void exibirLista() {
		
		if (instanciaUnica_Exibir == null) {
			instanciaUnica_Exibir = new PainelExibirLista();
			ProdutoDao dao = new ProdutoDao();
			List<Produto> lista = dao.selectFrom();
			ProdutoModelo modeloProduto = new ProdutoModelo(lista);
			instanciaUnica_Exibir.table.setModel(modeloProduto);
			final PainelWrapper wrapper = new PainelWrapper();
			wrapper.setConteudo(instanciaUnica_Exibir);
			wrapper.setTitulo("Buscar produtos");
			
			wrapper.setFecharPainel(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tabbedPane.remove(wrapper);
					instanciaUnica_Exibir = null;
				}
			});
			tabbedPane.addTab("Busca de produto", wrapper);
		}else{
			JOptionPane.showMessageDialog(null, "Proibido dublicar aba.");
		}
	}

	protected void baixarLista() {
		
				ProdutoModelo modeloProduto;
				final String url = "http://www.master10.com.py/lista-txt/donwload";
				LeitorProdutoUrl lpu = new LeitorProdutoUrl();
				List<Produto> listaProduto = lpu.lerProdutos(url);
				modeloProduto = new ProdutoModelo(listaProduto);

				modeloProduto.salvar(listaProduto);
				
				JOptionPane.showMessageDialog(null, "Lista baixada com sucesso!!!");
	}
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
