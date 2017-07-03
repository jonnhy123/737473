package br.univel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.univel.classes.Produto;

/**
 * By: Jhonatan Mattana
 * 30 de jun de 2017 - 21:34:27 
 */
public class LeitorProdutoUrl {

	private Pattern pattern = Pattern.compile("([0-9]+)(.*)US\\$ (.*)");
	
	public List<Produto> lerProdutos(String strUrl) {
		List<Produto> listaP = new ArrayList<Produto>();
		try {
			URL url = new URL(strUrl);
			URLConnection urlCon = url.openConnection();
			
			InputStream is = urlCon.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader in = new BufferedReader(isr);
			
			String linha;
			
			while ((linha = in.readLine()) != null) {
				if (linha.matches("[0-9]+.*")) {
					Produto p = lerProduto(linha);
					listaP.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaP;
	}

	private Produto lerProduto(String linha) {
Matcher mat = pattern.matcher(linha);
		
		Produto produto = new Produto();
		if (mat.matches()) {
			String strId = mat.group(1).trim();
			produto.setId(strId);
//			produto.setId(Long.parseLong(strId));
			
			String desc = mat.group(2).trim();
			produto.setDescricao(desc);
			
			String strValorOrg = mat.group(3).trim();
			String strValorSemponto = strValorOrg.replaceAll("\\,", "");
			String strValorIngles = strValorSemponto.replaceAll(",", ".");
			produto.setValorDolar(new BigDecimal(strValorIngles));
		}else{
			throw new RuntimeException("Linha inválida: "+linha);
		}
		
		return produto;
	}

}
