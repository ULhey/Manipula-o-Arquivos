package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class FrutsController implements IArquivoDiretorios {

	private String geraConteudoTxt() {
		StringBuffer buffer = new StringBuffer();
		String linha = " ";

		while (!linha.equals("fim")) {
			linha = JOptionPane.showInputDialog(null, "Digite uma frase: \nPara finalizar digite: fim", "Entrada",
					JOptionPane.INFORMATION_MESSAGE);
			buffer.append(linha + "\r\n");
		}
		return buffer.toString();
	}

	@Override
	public void leDiretorio(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] lista = dir.listFiles();
			for (File f : lista) {
				if (f.isDirectory()) {
					System.out.println("[" + f.getName() + "]");
				}
			}
			for (File f : lista) {
				if (f.isFile()) {
					System.out.println(f.getName());
				}
			}
		} else {
			throw new IOException("Diretório Inválido");
		}
	}

	@Override
	public void criaArq(String path, String nome) throws IOException {
		File dir = new File(path);
		File arquivo = new File(path, nome + ".txt");
		if (dir.exists()) {
			boolean arquivoExiste = false;
			if (arquivo.exists()) {
				arquivoExiste = true;
			}
			String conteudo = geraConteudoTxt();
			FileWriter fw = new FileWriter(arquivo, arquivoExiste);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(conteudo);
			pw.flush();
			pw.close();
			fw.close();
		} else {
			throw new IOException("Diretório Inválido");
		}
	}

	@Override
	public void leTxt(String absolutePath) throws IOException {
		File arquivo = new File(absolutePath);
		if (arquivo.exists()) {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	public void leArq(String absolutePath) throws IOException {
		File arquivo = new File(absolutePath);
		if (arquivo.exists()) {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			System.err.printf("| %-30s | %-50s | %-20s |", "NOME", "NOME CIENTIÍFICO", "SUB GRUPO");
			System.out.println();

			while (linha != null) {
				String vet[] = linha.trim().split(",");
				if (vet[2].equals("Fruits")) {
					System.out.printf("| %-30s | %-50s | %-20s |", vet[0], vet[1], vet[3]);
					System.out.println();
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void criaArq(String path, String ano, String mes) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leArq(String path, String nome, String ano, String mes, int media) throws IOException {
		// TODO Auto-generated method stub
		
	}
}