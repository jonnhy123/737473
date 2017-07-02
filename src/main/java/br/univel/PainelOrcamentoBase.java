package br.univel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 00:52:06 
 */
public class PainelOrcamentoBase extends JPanel {
	protected JTextField txtf;
	protected JTextField textField_1;
	protected JTextField textField_2;
	protected JTextField textField_3;
	protected JTextField textField_4;
	protected JTextField textField_5;
	protected JTextField textField_6;
	protected JTable tabela;
	protected JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public PainelOrcamentoBase() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 177, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_Produtos = new JPanel();
		panel_Produtos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		GridBagConstraints gbc_panel_Produtos = new GridBagConstraints();
		gbc_panel_Produtos.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Produtos.fill = GridBagConstraints.BOTH;
		gbc_panel_Produtos.gridx = 0;
		gbc_panel_Produtos.gridy = 0;
		add(panel_Produtos, gbc_panel_Produtos);
		GridBagLayout gbl_panel_Produtos = new GridBagLayout();
		gbl_panel_Produtos.columnWidths = new int[]{0, 0, 0};
		gbl_panel_Produtos.rowHeights = new int[]{0, 0, 0};
		gbl_panel_Produtos.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Produtos.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_Produtos.setLayout(gbl_panel_Produtos);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 0;
		panel_Produtos.add(lblCdigo, gbc_lblCdigo);
		
		txtf = new JTextField();
		txtf.setName("");
		txtf.setActionCommand("");
		txtf.setToolTipText("");
		GridBagConstraints gbc_txtf = new GridBagConstraints();
		gbc_txtf.anchor = GridBagConstraints.WEST;
		gbc_txtf.insets = new Insets(0, 0, 5, 0);
		gbc_txtf.gridx = 1;
		gbc_txtf.gridy = 0;
		panel_Produtos.add(txtf, gbc_txtf);
		txtf.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.anchor = GridBagConstraints.EAST;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 1;
		panel_Produtos.add(lblProduto, gbc_lblProduto);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_Produtos.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		GridBagConstraints gbc_lblPreo = new GridBagConstraints();
		gbc_lblPreo.anchor = GridBagConstraints.EAST;
		gbc_lblPreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreo.gridx = 0;
		gbc_lblPreo.gridy = 2;
		panel_Produtos.add(lblPreo, gbc_lblPreo);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_Produtos.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_Clientes = new JPanel();
		panel_Clientes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		GridBagConstraints gbc_panel_Clientes = new GridBagConstraints();
		gbc_panel_Clientes.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Clientes.fill = GridBagConstraints.BOTH;
		gbc_panel_Clientes.gridx = 0;
		gbc_panel_Clientes.gridy = 2;
		add(panel_Clientes, gbc_panel_Clientes);
		GridBagLayout gbl_panel_Clientes = new GridBagLayout();
		gbl_panel_Clientes.columnWidths = new int[]{0, 0, 0};
		gbl_panel_Clientes.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_Clientes.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Clientes.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_Clientes.setLayout(gbl_panel_Clientes);
		
		JLabel lblCdigo_1 = new JLabel("C\u00F3digo:");
		GridBagConstraints gbc_lblCdigo_1 = new GridBagConstraints();
		gbc_lblCdigo_1.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo_1.gridx = 0;
		gbc_lblCdigo_1.gridy = 0;
		panel_Clientes.add(lblCdigo_1, gbc_lblCdigo_1);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 0;
		panel_Clientes.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		panel_Clientes.add(lblNome, gbc_lblNome);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 1;
		panel_Clientes.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		GridBagConstraints gbc_lblCelular = new GridBagConstraints();
		gbc_lblCelular.anchor = GridBagConstraints.EAST;
		gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelular.gridx = 0;
		gbc_lblCelular.gridy = 2;
		panel_Clientes.add(lblCelular, gbc_lblCelular);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 2;
		panel_Clientes.add(textField_5, gbc_textField_5);
		textField_5.setColumns(15);
		
		JLabel lblQtdProdutos = new JLabel("Qtd produtos:");
		GridBagConstraints gbc_lblQtdProdutos = new GridBagConstraints();
		gbc_lblQtdProdutos.anchor = GridBagConstraints.EAST;
		gbc_lblQtdProdutos.insets = new Insets(0, 0, 0, 5);
		gbc_lblQtdProdutos.gridx = 0;
		gbc_lblQtdProdutos.gridy = 3;
		panel_Clientes.add(lblQtdProdutos, gbc_lblQtdProdutos);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.WEST;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 3;
		panel_Clientes.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_Tabela = new JPanel();
		GridBagConstraints gbc_panel_Tabela = new GridBagConstraints();
		gbc_panel_Tabela.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Tabela.fill = GridBagConstraints.BOTH;
		gbc_panel_Tabela.gridx = 0;
		gbc_panel_Tabela.gridy = 4;
		add(panel_Tabela, gbc_panel_Tabela);
		GridBagLayout gbl_panel_Tabela = new GridBagLayout();
		gbl_panel_Tabela.columnWidths = new int[]{0, 0};
		gbl_panel_Tabela.rowHeights = new int[]{111, 0};
		gbl_panel_Tabela.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_Tabela.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_Tabela.setLayout(gbl_panel_Tabela);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_Tabela.add(scrollPane, gbc_scrollPane);
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		
		JPanel panel_VlrTotal = new JPanel();
		GridBagConstraints gbc_panel_VlrTotal = new GridBagConstraints();
		gbc_panel_VlrTotal.insets = new Insets(0, 0, 5, 0);
		gbc_panel_VlrTotal.fill = GridBagConstraints.BOTH;
		gbc_panel_VlrTotal.gridx = 0;
		gbc_panel_VlrTotal.gridy = 5;
		add(panel_VlrTotal, gbc_panel_VlrTotal);
		GridBagLayout gbl_panel_VlrTotal = new GridBagLayout();
		gbl_panel_VlrTotal.columnWidths = new int[]{0, 0, 0};
		gbl_panel_VlrTotal.rowHeights = new int[]{0, 0};
		gbl_panel_VlrTotal.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_VlrTotal.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_VlrTotal.setLayout(gbl_panel_VlrTotal);
		
		JLabel lblNewLabel = new JLabel("Valor total:");
		lblNewLabel.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_VlrTotal.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 0;
		panel_VlrTotal.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_CamposProdutos = new JPanel();
		GridBagConstraints gbc_panel_CamposProdutos = new GridBagConstraints();
		gbc_panel_CamposProdutos.insets = new Insets(0, 0, 5, 0);
		gbc_panel_CamposProdutos.anchor = GridBagConstraints.EAST;
		gbc_panel_CamposProdutos.fill = GridBagConstraints.VERTICAL;
		gbc_panel_CamposProdutos.gridx = 0;
		gbc_panel_CamposProdutos.gridy = 1;
		add(panel_CamposProdutos, gbc_panel_CamposProdutos);
		GridBagLayout gbl_panel_CamposProdutos = new GridBagLayout();
		gbl_panel_CamposProdutos.columnWidths = new int[]{0, 0, 0};
		gbl_panel_CamposProdutos.rowHeights = new int[]{0, 0};
		gbl_panel_CamposProdutos.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_CamposProdutos.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_CamposProdutos.setLayout(gbl_panel_CamposProdutos);
		
		JButton btnLimparCampos = new JButton("Limpar campos");
		GridBagConstraints gbc_btnLimparCampos = new GridBagConstraints();
		gbc_btnLimparCampos.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimparCampos.gridx = 0;
		gbc_btnLimparCampos.gridy = 0;
		panel_CamposProdutos.add(btnLimparCampos, gbc_btnLimparCampos);
		
		JButton btnSelecionarProduto = new JButton("Selecionar produto");
		GridBagConstraints gbc_btnSelecionarProduto = new GridBagConstraints();
		gbc_btnSelecionarProduto.gridx = 1;
		gbc_btnSelecionarProduto.gridy = 0;
		panel_CamposProdutos.add(btnSelecionarProduto, gbc_btnSelecionarProduto);
		
		JPanel panel_CamposClientes = new JPanel();
		GridBagConstraints gbc_panel_CamposClientes = new GridBagConstraints();
		gbc_panel_CamposClientes.fill = GridBagConstraints.BOTH;
		gbc_panel_CamposClientes.gridx = 0;
		gbc_panel_CamposClientes.gridy = 3;
		add(panel_CamposClientes, gbc_panel_CamposClientes);
		GridBagLayout gbl_panel_CamposClientes = new GridBagLayout();
		gbl_panel_CamposClientes.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_CamposClientes.rowHeights = new int[]{0, 0};
		gbl_panel_CamposClientes.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_CamposClientes.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_CamposClientes.setLayout(gbl_panel_CamposClientes);
		
		JButton btnLimparCampos_1 = new JButton("Limpar campos");
		GridBagConstraints gbc_btnLimparCampos_1 = new GridBagConstraints();
		gbc_btnLimparCampos_1.anchor = GridBagConstraints.EAST;
		gbc_btnLimparCampos_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimparCampos_1.gridx = 0;
		gbc_btnLimparCampos_1.gridy = 0;
		panel_CamposClientes.add(btnLimparCampos_1, gbc_btnLimparCampos_1);
		
		JButton btnRealizarOramento = new JButton("Realizar or\u00E7amento");
		GridBagConstraints gbc_btnRealizarOramento = new GridBagConstraints();
		gbc_btnRealizarOramento.insets = new Insets(0, 0, 0, 5);
		gbc_btnRealizarOramento.gridx = 1;
		gbc_btnRealizarOramento.gridy = 0;
		panel_CamposClientes.add(btnRealizarOramento, gbc_btnRealizarOramento);
		
		JButton btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 2;
		gbc_btnSalvar.gridy = 0;
		panel_CamposClientes.add(btnSalvar, gbc_btnSalvar);
		
		JButton btnVerOramentos = new JButton("Ver or\u00E7amentos");
		GridBagConstraints gbc_btnVerOramentos = new GridBagConstraints();
		gbc_btnVerOramentos.gridx = 3;
		gbc_btnVerOramentos.gridy = 0;
		panel_CamposClientes.add(btnVerOramentos, gbc_btnVerOramentos);
		
	}

}
