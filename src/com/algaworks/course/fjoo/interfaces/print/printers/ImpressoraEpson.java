package com.algaworks.course.fjoo.interfaces.print.printers;

import com.algaworks.course.fjoo.interfaces.Impressora;
import com.algaworks.course.fjoo.interfaces.Imprimivel;

public class ImpressoraEpson implements Impressora {

	@Override
	public void imprimir(Imprimivel imprimivel) {
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println(imprimivel.getCabecalhoPagina());
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println(imprimivel.getCorpoPagina());
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("==                EPSON                      ==");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - ");
	}
}