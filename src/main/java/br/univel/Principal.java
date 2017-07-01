package br.univel;

import java.awt.EventQueue;
import java.util.List;

/**
 * By: Jhonatan Mattana
 * 30 de jun de 2017 - 21:28:44 
 */
public class Principal extends PrincipalBase{

	public Principal() {
		configurarBotoes();
	}
	
	private void configurarBotoes() {
		baixarLista();
	}

	private void baixarLista() {
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
					PrincipalBase frame = new PrincipalBase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}