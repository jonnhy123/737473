package br.univel.panel.base;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

/**
 * By: Jhonatan Mattana
 * 3 de jul de 2017 - 07:08:53 
 */
public class PainelExibirOrcamentoBase extends JPanel {
	protected JTable table;
	protected JButton btnImprimirRelatrio;
	protected JButton btnGerarReltorio;

	/**
	 * Create the panel.
	 */
	public PainelExibirOrcamentoBase() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnGerarReltorio = new JButton("Gerar relat\u00F3rio ");
		GridBagConstraints gbc_btnGerarReltorio = new GridBagConstraints();
		gbc_btnGerarReltorio.anchor = GridBagConstraints.EAST;
		gbc_btnGerarReltorio.insets = new Insets(0, 0, 0, 5);
		gbc_btnGerarReltorio.gridx = 0;
		gbc_btnGerarReltorio.gridy = 0;
		panel.add(btnGerarReltorio, gbc_btnGerarReltorio);
		
		btnImprimirRelatrio = new JButton("Imprimir relat\u00F3rio");
		GridBagConstraints gbc_btnImprimirRelatrio = new GridBagConstraints();
		gbc_btnImprimirRelatrio.gridx = 1;
		gbc_btnImprimirRelatrio.gridy = 0;
		panel.add(btnImprimirRelatrio, gbc_btnImprimirRelatrio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tabela de or\u00E7amentos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}

}
