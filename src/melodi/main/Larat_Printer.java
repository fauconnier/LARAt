package melodi.main;

import melodi.tools.PrinterAnnotation;

public class Larat_Printer {
	
	public static void main(String[] args) {
		
		/**
		 * Consensus : Edit - 29/05/2014
		 */
		String docname = "Volcan";
		int index_doc = 6;
		String annotateur = "Jp";
		PrinterAnnotation printer = new PrinterAnnotation(annotateur, docname, index_doc);
		printer.run();
		
		// Toponyme -> hyperonymes
		// Objet abstrait -> autreontologique.
	}
}
