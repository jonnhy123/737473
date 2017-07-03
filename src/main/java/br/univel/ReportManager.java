package br.univel;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Locale;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * By: Jhonatan Mattana
 * 3 de jul de 2017 - 07:56:38 
 */
public class ReportManager {

		private String file = "C:\\Users\\User-01\\JaspersoftWorkspace\\Trabalho\\Orcamento.jasper";
		
		public void exportar() {
			JasperPrint print = getPrint();
			String nomePdf = "teste.pdf";
			try {
				JasperExportManager.exportReportToPdfFile(print,nomePdf);
				Desktop.getDesktop().open(new File(nomePdf));
			} catch (JRException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private JasperPrint getPrint(){
			Connection con = Conexao.getInstance().getConnection();
			try {
				return JasperFillManager.fillReport(file, null, con);
			} catch (JRException e) {
				throw new RuntimeException(e);
			}
		}

		public void imprimir() {
			JasperPrint print = getPrint();
			Locale local = Locale.getDefault();
			JasperViewer.viewReport(print,false,local);
		}
}