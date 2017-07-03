package br.univel.classes;

import java.math.BigDecimal;

/**
 * By: Jhonatan Mattana
 * 30 de jun de 2017 - 19:27:57 
 */
public class Produto {
	private String id;
	private String descricao;
	private BigDecimal valorDolar;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValorDolar() {
		return valorDolar;
	}
	public void setValorDolar(BigDecimal valorDolar) {
		this.valorDolar = valorDolar;
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valorDolar=" + valorDolar + "]";
	}
}
