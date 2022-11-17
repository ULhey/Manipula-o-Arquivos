package View;

import java.io.IOException;

import javax.swing.JOptionPane;

import Controller.FrutsController;
import Controller.IArquivoDiretorios;

public class PrincipalFruts {
	public static void main(String[] args) {
		// escrever no arquivo
//		String path = "C:\\TEMP";
//		String nome = "Anotações";
//		IArquivoDiretorios ad = new ArquivosDiretorios();
//		try {
//			ad.criaTxt(path, nome);
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}

		// leitura do txt
//		String absolutePath = "C:\\TEMP\\Anotações.txt";
//		IArquivoDiretorios ad = new ArquivosDiretorios();
//		try {
//			ad.leTxt(absolutePath);
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
//		}

		// leitura do excel
		String path = "C:\\TEMP\\generic_food.csv";
		IArquivoDiretorios ad = new FrutsController();
		try {
			ad.leArq(path);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}	
	}
}