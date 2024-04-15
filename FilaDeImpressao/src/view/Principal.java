package view;

import lib.model.Fila;
import controller.ImpressoraController;
import javax.swing.JOptionPane;

public class Principal
{
	public static void main(String[] args)
	{
		Fila<String> fila = new Fila<>();
		ImpressoraController ic = new ImpressoraController();
		int opc;

		while (true) {
			opc = menu();
			if (opc == 0) {
				String nome = documentoValido();
				ic.insereDocumento(fila, nome);
			} else if (opc == 1)
				ic.imprime(fila);
			else
				break;
		}
		JOptionPane.showMessageDialog(null, "Aplicação encerrada!");
	}

	private static int menu()
	{
		String[] opcs = {"Inserir documento", "Imprimir", "Sair"};
		return JOptionPane.showOptionDialog(
			null, "Selecione a opção desejada", "Impressora",
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
			opcs, opcs[2]);
	}

	private static String documentoValido()
	{
		String nome;

		while (true) {
			nome = JOptionPane.showInputDialog("Informe o nome do arquivo\n" + 
			"(ID_PC;nome_do_arquivo):");
			if (ehValido(nome)) break;
			JOptionPane.showMessageDialog(null, "Formato de nome inválido");
		}
		return nome;
	}

	private static boolean ehValido(String nome)
	{
		return nome.matches("[0-9]+;[a-zA-Z_0-9]+.[a-z]+");
	}
}
