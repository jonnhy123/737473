package br.univel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

/**
 * By: Jhonatan Mattana
 * 1 de jul de 2017 - 23:45:35 
 */
public class PainelCadCliente extends PainelCadClientesBase{

//	private ModeloCliente modeloCliente = new ModeloCliente();
	
	public PainelCadCliente() {
		super();
		configurarBotoes();
	}
	
	private void configurarBotoes() {
		btnSalvarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salvarDados();
			}
		});
		btnNovoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
	}

	protected void limparCampos() {
		txtCodigo.setText("");
		txtBairro.setText("");
		txtNome.setText("");
		txtEstado.setText("");
		txtCidade.setText("");
		txtEndereco.setText("");
		txtCep.setText("");
		txtCPF.setText("");
	}

	protected void salvarDados() {
		
		List<Cliente> lista = new ArrayList<>();
		
		String id = txtCodigo.getText().trim();
		String nome = txtNome.getText().trim();
		String estado = txtEstado.getText().trim();
		String cidade = txtCidade.getText().trim();
		String endereco = txtEndereco.getText().trim();
		String cep = txtCep.getText().trim();
		String cpf = txtCPF.getText().trim();
		String bairro = txtBairro.getText().trim();
		
		Cliente c = new Cliente();
		
		c.setId(id);
		c.setNome(nome);
		c.setEstado(estado);
		c.setCidade(cidade);
		c.setEndereco(endereco);
		c.setCep(cep);
		c.setCpf(cpf);
		c.setBairo(bairro);
		lista.add(c);
		
		ClienteDao dao = new ClienteDao();
		dao.salvar(lista);
		
		JOptionPane.showMessageDialog(null, "Cliente salvo.");
	}

}
