package View;

import java.io.IOException;
import javax.swing.JOptionPane;
import Controller.IArquivoDiretorios;
import Controller.SteamController;

public class PrincipalSteam {
	public static void main(String[] args) {
		IArquivoDiretorios metodo = new SteamController();
		int opc = 0;
		String ano, mes;

		while (opc != 9) {
			opc = Integer.parseInt(
					JOptionPane.showInputDialog("--------------------------------"
							+"\n       DADOS STEAM  "
							+ "\n| 1 - Visualizar Dados  | "
							+ "\n| 2 - Gerar Arquivo        |"
							+ "\n| 3 - Fechar Programa |"
							+ "\n--------------------------------"));
			try {
				switch (opc) {
				case 1:
					ano = JOptionPane.showInputDialog("Digite o Ano: ");
					mes = JOptionPane.showInputDialog("Digite o Mês (em ingles): ");
					int media = Integer.parseInt(JOptionPane.showInputDialog("Digite a média: "));
					metodo.leArq("C:\\TEMP", "SteamCharts.csv", ano, mes, media);
					break;
				case 2:
					ano = JOptionPane.showInputDialog("Digite o Ano: ");
					mes = JOptionPane.showInputDialog("Digite o Mês(em ingles): ");
					metodo.criaArq("C:\\TEMP", ano, mes);
					break;
				case 3:
					opc = 3;
					System.exit(0);
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}