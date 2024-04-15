package controller;

import lib.model.Fila;

public class ImpressoraController
{
	public ImpressoraController()
	{
		super();
	}

	public void insereDocumento(Fila<String> f, String doc)
	{
		f.insert(doc);
	}

	public void imprime(Fila<String> f)
	{
		try {
			while (!f.isEmpty()) {
				String arq = f.remove();
				System.out.print("#PC: ");
				int i = 0;
				while (arq.charAt(i) != ';')
					System.out.print(arq.charAt(i++));
				System.out.print(" - Arquivo: ");
				while (++i < arq.length())
					System.out.print(arq.charAt(i));
				System.out.println();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Não há arquivos na fila!");
		}
	}
}