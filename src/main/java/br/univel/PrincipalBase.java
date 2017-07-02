package br.univel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 * By: Jhonatan Mattana
 * 30 de jun de 2017 - 21:07:54 
 */
public class PrincipalBase extends JFrame {

	private JPanel contentPane;
	protected JMenu mnMenu;
	protected JMenuItem mntmBaixarLista;
	protected JMenuItem mntmExibirLista;
	protected JMenuItem mntmCadastrarCliente;
	protected JMenuItem mntmEditarCliente;
	protected JMenuItem mntmRealizarOramento;
	protected JTabbedPane tabbedPane;

	/**
	 * Create the frame.
	 */
	public PrincipalBase() {
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 610);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		mntmBaixarLista = new JMenuItem("Baixar Lista");
		mnMenu.add(mntmBaixarLista);
		
		mntmExibirLista = new JMenuItem("Exibir Lista");
		mnMenu.add(mntmExibirLista);
		
		mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mnMenu.add(mntmCadastrarCliente);
		
		mntmEditarCliente = new JMenuItem("Editar Cliente");
		mnMenu.add(mntmEditarCliente);
		
		mntmRealizarOramento = new JMenuItem("Realizar Or\u00E7amento");
		mnMenu.add(mntmRealizarOramento);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
	}

}
