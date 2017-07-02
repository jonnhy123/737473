package br.univel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * By: Jhonatan Mattana
 * 30 de jun de 2017 - 21:28:44 
 */
public class Principal extends PrincipalBase{

	private static PainelCadCliente instanciaUnica_C = null;
	private static PainelOrcamentos instanciaUnica_O = null;
	
	public Principal() {
		super();
		setTitle("MASTER10 TECNOLOGIA");
		configurarBotoes();
	}
	
	private void configurarBotoes() {
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
			tabbedPane.addTab("Orçamento", wrapper);
		}else{
			JOptionPane.showMessageDialog(null, "Proibido dublicar aba.");
		}
	}

	protected void cadastrarCliente() {
		//Aplicando padrão Singleton
		if (instanciaUnica_C == null) {
			instanciaUnica_C = new PainelCadCliente();
			final PainelWrapper wrapper = new PainelWrapper();
			wrapper.setConteudo(instanciaUnica_C);
			wrapper.setTitulo("Cadastro de clientes");
			
			wrapper.setFecharPainel(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.remove(wrapper);
					instanciaUnica_C = null;
				}
			});
			tabbedPane.addTab("Clientes", wrapper);
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
