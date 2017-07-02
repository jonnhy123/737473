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

	private static PainelCadCliente instanciaUnica = null;
	
	public Principal() {
		super();
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
	}

	protected void cadastrarCliente() {
		//Aplicando padrão Singleton
		if (instanciaUnica == null) {
			instanciaUnica = new PainelCadCliente();
			final PainelWrapper wrapper = new PainelWrapper();
			wrapper.setConteudo(instanciaUnica);
			wrapper.setTitulo("Cadastro de clientes");
			
			wrapper.setFecharPainel(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.remove(wrapper);
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
