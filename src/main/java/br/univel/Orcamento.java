package br.univel;

/**
 * By: Jhonatan Mattana
 * 3 de jul de 2017 - 06:26:32 
 */
public class Orcamento {
	private String codProduto;
	private String nomeProduto;
	private String precoProduto;
	private String qtdProduto;
	private String codCliente;
	private String nomeCliente;
	private String vlwTotal;
	
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(String precoProduto) {
		this.precoProduto = precoProduto;
	}
	public String getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(String qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getVlwTotal() {
		return vlwTotal;
	}
	public void setVlwTotal(String vlwTotal) {
		this.vlwTotal = vlwTotal;
	}
}
