package br.univel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * By: Jhonatan Mattana
 * 1 de jul de 2017 - 23:45:35 
 */
public class PainelCadCliente extends PainelCadClientesBase{

	private ModeloCliente modeloCliente = new ModeloCliente();
	
	public PainelCadCliente() {
		super();
		configurarBotoes();
	}
	
	private void configurarBotoes() {
		salvarDados();
	}

	private void salvarDados() {
		btnSalvarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				
				modeloCliente.adicionar(c);
				
				JOptionPane.showMessageDialog(null, "Cliente salvo.");
			}
		});
	}
}
