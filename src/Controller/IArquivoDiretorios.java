package Controller;

import java.io.IOException;

public interface IArquivoDiretorios {
	public void leDiretorio (String path) throws IOException;
	public void criaArq (String path, String nome) throws IOException; //-> para o codigo de Fruts
	public void criaArq (String path, String ano, String mes) throws IOException;
	public void leTxt (String absolutePath) throws IOException;
	public void leArq (String absolutePath) throws IOException; //-> para o codigo de Fruts
	public void leArq (String path, String nome, String ano, String mes, int media) throws IOException;
}