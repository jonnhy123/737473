package br.univel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * By: Jhonatan Mattana
 * 2 de jul de 2017 - 05:33:45 
 */
public class PainelEditarClienteBase extends JPanel {

	protected JTextField txtNome;
	protected JTextField txtEndereco;
	protected JTextField txtBairro;
	protected JTextField txtCidade;
	protected JFormattedTextField txtCep;
	protected JFormattedTextField txtCPF;
	protected JTextField txtCodigo;
	protected JButton btnSalvarDados;
	protected JButton btnNovoCliente;
	protected JButton btnExcluirClientes;
	protected JTable table;
	protected JButton btnVerClientes;
	protected JTextField txtEstado;
	
	//Formatar campos de texto
	private MaskFormatter setMascara(String mascara){
		 MaskFormatter mask = null; 
			try{
				 mask = new MaskFormatter(mascara);	
	}catch(java.text.ParseException ex){
		} return mask;
	}
	
	/**
	 * Create the panel.
	 */
	public PainelEditarClienteBase() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panel.add(lblNome, gbc_lblNome);
		
		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.anchor = GridBagConstraints.WEST;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 0;
		panel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(45);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 1;
		panel.add(lblEndereo, gbc_lblEndereo);
		
		txtEndereco = new JTextField();
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.anchor = GridBagConstraints.WEST;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtEndereco.gridx = 1;
		gbc_txtEndereco.gridy = 1;
		panel.add(txtEndereco, gbc_txtEndereco);
		txtEndereco.setColumns(45);
		
		JLabel lblBairro = new JLabel("Bairro:");
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.EAST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 0;
		gbc_lblBairro.gridy = 2;
		panel.add(lblBairro, gbc_lblBairro);
		
		txtBairro = new JTextField();
		GridBagConstraints gbc_txtBairro = new GridBagConstraints();
		gbc_txtBairro.anchor = GridBagConstraints.WEST;
		gbc_txtBairro.insets = new Insets(0, 0, 5, 0);
		gbc_txtBairro.gridx = 1;
		gbc_txtBairro.gridy = 2;
		panel.add(txtBairro, gbc_txtBairro);
		txtBairro.setColumns(45);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 3;
		panel.add(lblEstado, gbc_lblEstado);
		
		txtEstado = new JTextField();
		GridBagConstraints gbc_txtEstado = new GridBagConstraints();
		gbc_txtEstado.anchor = GridBagConstraints.WEST;
		gbc_txtEstado.insets = new Insets(0, 0, 5, 0);
		gbc_txtEstado.gridx = 1;
		gbc_txtEstado.gridy = 3;
		panel.add(txtEstado, gbc_txtEstado);
		txtEstado.setColumns(45);
		
		JLabel lblTelefone = new JLabel("Cidade:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 4;
		panel.add(lblTelefone, gbc_lblTelefone);
		
		txtCidade = new JTextField();
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.anchor = GridBagConstraints.WEST;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 0);
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 4;
		panel.add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(25);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 5;
		panel.add(label, gbc_label);
		
		JLabel lblCdigo = new JLabel("Cep:");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 6;
		panel.add(lblCdigo, gbc_lblCdigo);
		
		txtCep = new JFormattedTextField((setMascara("#####.###")));
		GridBagConstraints gbc_txtCep = new GridBagConstraints();
		gbc_txtCep.anchor = GridBagConstraints.WEST;
		gbc_txtCep.insets = new Insets(0, 0, 5, 0);
		gbc_txtCep.gridx = 1;
		gbc_txtCep.gridy = 6;
		panel.add(txtCep, gbc_txtCep);
		txtCep.setColumns(12);
		
		JLabel lblCpf = new JLabel("CPF:");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.EAST;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 7;
		panel.add(lblCpf, gbc_lblCpf);
		
		txtCPF = new JFormattedTextField(setMascara("###.###.###.##"));
		GridBagConstraints gbc_txtCPF = new GridBagConstraints();
		gbc_txtCPF.anchor = GridBagConstraints.WEST;
		gbc_txtCPF.insets = new Insets(0, 0, 5, 0);
		gbc_txtCPF.gridx = 1;
		gbc_txtCPF.gridy = 7;
		panel.add(txtCPF, gbc_txtCPF);
		txtCPF.setColumns(12);
		
		JLabel lblCdigo_1 = new JLabel("C\u00F3digo:");
		GridBagConstraints gbc_lblCdigo_1 = new GridBagConstraints();
		gbc_lblCdigo_1.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblCdigo_1.gridx = 0;
		gbc_lblCdigo_1.gridy = 8;
		panel.add(lblCdigo_1, gbc_lblCdigo_1);
		
		txtCodigo = new JTextField();
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.anchor = GridBagConstraints.WEST;
		gbc_txtCodigo.gridx = 1;
		gbc_txtCodigo.gridy = 8;
		panel.add(txtCodigo, gbc_txtCodigo);
		txtCodigo.setColumns(6);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnSalvarDados = new JButton("Salvar dados");
		GridBagConstraints gbc_btnSalvarDados = new GridBagConstraints();
		gbc_btnSalvarDados.anchor = GridBagConstraints.EAST;
		gbc_btnSalvarDados.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvarDados.gridx = 0;
		gbc_btnSalvarDados.gridy = 0;
		panel_1.add(btnSalvarDados, gbc_btnSalvarDados);
		
		btnNovoCliente = new JButton("Novo cliente");
		GridBagConstraints gbc_btnNovoCliente = new GridBagConstraints();
		gbc_btnNovoCliente.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovoCliente.gridx = 1;
		gbc_btnNovoCliente.gridy = 0;
		panel_1.add(btnNovoCliente, gbc_btnNovoCliente);
		
		btnExcluirClientes = new JButton("Excluir cliente");
		GridBagConstraints gbc_btnExcluirClientes = new GridBagConstraints();
		gbc_btnExcluirClientes.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluirClientes.gridx = 2;
		gbc_btnExcluirClientes.gridy = 0;
		panel_1.add(btnExcluirClientes, gbc_btnExcluirClientes);
		
		btnVerClientes = new JButton("Ver clientes");
		GridBagConstraints gbc_btnVerClientes = new GridBagConstraints();
		gbc_btnVerClientes.gridx = 3;
		gbc_btnVerClientes.gridy = 0;
		panel_1.add(btnVerClientes, gbc_btnVerClientes);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_2.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

}
