package melodi.annotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import com.sun.xml.internal.ws.util.StringUtils;

import melodi.internal.Circonstant;
import melodi.internal.Concept;
import melodi.internal.Item;
import melodi.internal.Items;
import melodi.internal.Segment;
import melodi.main.IO_MIG;
import melodi.se.SE;
import jxl.*;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;
import jxl.format.Border;
import jxl.format.BorderLineStyle;

public class WriteExcel {

	public static char remplace;

	public static void main(String[] args) throws IOException {

		remplace = ' ';

		BufferedReader buff = new BufferedReader(new FileReader("list.txt"));
		String str = null;
		while ((str = buff.readLine()) != null) {
			// TODO Auto-generated method stub
			try {
				run(str);
			} catch (IOException | WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		}

	}

	public static void run(String name) throws IOException,
			RowsExceededException, WriteException {

		WritableWorkbook workbook = Workbook.createWorkbook(new File(
				"./annotation/Phase_3/LARA_tab/" + name + ".xls"));
		WritableSheet sheet = workbook.createSheet("Document Annotation", 0);

		preparTab(sheet);

		// Un fichier de tableau par document d'annotation
		String doc_julien = "./annotation/Phase_2/Julien/LARA_corpus/" + name
				+ ".html";
		String doc_sophie = "./annotation/Phase_2/Sophie/LARA_xml/" + name
				+ ".html";
		String doc_m_jp = "./annotation/Phase_2/M_Jp/LARA_xml/" + name
				+ ".html";

		// Ouvrir les fichiers d'annotation [okay]
		IO_MIG io_julien = new IO_MIG();
		io_julien.readThis(doc_julien);
		LinkedList<SE> chain_julien = io_julien.getChain();

		IO_MIG io_sophie = new IO_MIG();
		io_sophie.readThis(doc_sophie);
		LinkedList<SE> chain_sophie = io_sophie.getChain();

		IO_MIG io_m_jp = new IO_MIG();
		io_m_jp.readThis(doc_m_jp);
		LinkedList<SE> chain_m_jp = io_m_jp.getChain();

		// Gestion (minime) d'erreur
		if (chain_m_jp.size() != chain_sophie.size()) {
			System.err.println("Erreur");
			System.exit(0);
		}
		if (chain_m_jp.size() != chain_julien.size()) {
			System.err.println("Erreur");
			System.exit(0);
		}

		// For Each SE
		for (int i = 0; i < chain_m_jp.size(); i++) {

			System.out.println("# SE " + i);

			// Cellule SE
			int deb_se = (i + 1) * 4 - 1;
			int fin_se = (deb_se + 3);
			addCellFormat(sheet, 0, deb_se, 0, fin_se, "SE " + i);

			// Features SE
			SE se_julien = chain_julien.get(i);
			SE se_sophie = chain_sophie.get(i);
			SE se_m_jp = chain_m_jp.get(i);

			// Axe Rhétorique
			addCellFormat(sheet, 1, deb_se, 1, deb_se + 1,
					axeRhetorique(se_julien));
			addCellFormat(sheet, 2, deb_se, 2, deb_se + 1,
					axeRhetorique(se_sophie));
			addCellFormat(sheet, 3, deb_se, 3, deb_se + 1,
					axeRhetorique(se_m_jp));
			addCellFormat(sheet, 1, deb_se + 2, 3, deb_se + 3, "");

			// Axe Intentionnel
			addCellFormat(sheet, 4, deb_se, 4, deb_se + 1,
					axeIntentionnel(se_julien));
			addCellFormat(sheet, 5, deb_se, 5, deb_se + 1,
					axeIntentionnel(se_sophie));
			addCellFormat(sheet, 6, deb_se, 6, deb_se + 1,
					axeIntentionnel(se_m_jp));
			addCellFormat(sheet, 4, deb_se + 2, 6, deb_se + 3, "");

			// Axe Sémantique
			addCellFormat(sheet, 7, deb_se, 7, deb_se + 1,
					axeSemantique(se_julien));
			addCellFormat(sheet, 8, deb_se, 8, deb_se + 1,
					axeSemantique(se_sophie));
			addCellFormat(sheet, 9, deb_se, 9, deb_se + 1,
					axeSemantique(se_m_jp));
			addCellFormat(sheet, 7, deb_se + 2, 9, deb_se + 3, "");

			// Contextuel/Non-Contextuel
			addCellFormat(sheet, 10, deb_se, 10, deb_se + 1,
					contextuel(se_julien));
			addCellFormat(sheet, 11, deb_se, 11, deb_se + 1,
					contextuel(se_sophie));
			addCellFormat(sheet, 12, deb_se, 12, deb_se + 1,
					contextuel(se_m_jp));
			addCellFormat(sheet, 10, deb_se + 2, 12, deb_se + 3, "");

			// Concept amorce
			addCellFormat(sheet, 13, deb_se, 13, deb_se + 1,
					concept_amorce(se_julien));
			addCellFormat(sheet, 14, deb_se, 14, deb_se + 1,
					concept_amorce(se_sophie));
			addCellFormat(sheet, 15, deb_se, 15, deb_se + 1,
					concept_amorce(se_m_jp));
			addCellFormat(sheet, 13, deb_se + 2, 15, deb_se + 3, "");

			// Concepts items
			addCellFormat(sheet, 16, deb_se, 16, deb_se + 1,
					concepts_items(se_julien));
			addCellFormat(sheet, 17, deb_se, 17, deb_se + 1,
					concepts_items(se_sophie));
			addCellFormat(sheet, 18, deb_se, 18, deb_se + 1,
					concepts_items(se_m_jp));
			addCellFormat(sheet, 16, deb_se + 2, 18, deb_se + 3, "");

			// Circonstant amorce
			addCellFormat(sheet, 19, deb_se, 19, deb_se + 1,
					circonstant_amorce(se_julien));
			addCellFormat(sheet, 20, deb_se, 20, deb_se + 1,
					circonstant_amorce(se_sophie));
			addCellFormat(sheet, 21, deb_se, 21, deb_se + 1,
					circonstant_amorce(se_m_jp));
			addCellFormat(sheet, 19, deb_se + 2, 21, deb_se + 3, "");

			// Circonstant items
			addCellFormat(sheet, 22, deb_se, 22, deb_se + 1,
					circonstant_items(se_julien));
			addCellFormat(sheet, 23, deb_se, 23, deb_se + 1,
					circonstant_items(se_sophie));
			addCellFormat(sheet, 24, deb_se, 24, deb_se + 1,
					circonstant_items(se_m_jp));
			addCellFormat(sheet, 22, deb_se + 2, 24, deb_se + 3, "");
		}

		workbook.write();
		workbook.close();

	}

	public static String circonstant_items(SE currentSE) {
		String circonstant_items = "";

		Items itemsList = currentSE.getItems();
		int index = 0;
		for (Item item : itemsList) {

			Circonstant circonstant = item.getCirconstant();
			for (Segment seg : circonstant) {
				circonstant_items += seg.getText() + "[" + index + "]" + "("
						+ seg.getIndice_begin() + "," + seg.getIndice_end()
						+ ")" + ";";
			}

			index++;
		}

		if (circonstant_items.equals("")) {
			circonstant_items = "" + remplace;
		}
		return circonstant_items;
	}

	public static String circonstant_amorce(SE currentSE) {
		String circonstant_amorce = "";

		if(currentSE.getPrimer() != null){
		Circonstant circonstant = currentSE.getPrimer().getCirconstant();

		for (Segment seg : circonstant) {
			circonstant_amorce += seg.getText() + "(" + seg.getIndice_begin()
					+ "," + seg.getIndice_end() + ")" + ";";
		}

		if (circonstant_amorce.equals("")) {
			circonstant_amorce = "" + remplace;
		}
		}
		else{
			circonstant_amorce = "" + remplace;
		}

		return circonstant_amorce;
	}

	public static String concepts_items(SE currentSE) {
		String concepts_items = "";

		Items itemsList = currentSE.getItems();
		int index = 0;
		for (Item item : itemsList) {
			Concept concept_item = item.getConcept();
			for (Segment seg : concept_item) {
				concepts_items += seg.getText() + "[" + index + "]" + "("
						+ seg.getIndice_begin() + "," + seg.getIndice_end()
						+ ")" + ";";
			}
			index++;
		}

		if (concepts_items.equals("")) {
			concepts_items = "" + remplace;
		}

		return concepts_items;
	}

	public static String concept_amorce(SE currentSE) {
		String concept_amorce = "";

		if (currentSE.getPrimer() != null ) {
			Concept concept_primer = currentSE.getPrimer().getConcept();

			for (Segment seg : concept_primer) {
				concept_amorce += seg.getText() + "(" + seg.getIndice_begin()
						+ "," + seg.getIndice_end() + ")" + ";";
			}

			if (concept_amorce.equals("")) {
				concept_amorce = "" + remplace;
			}
		} else {
			concept_amorce = "" + remplace;
		}

		return concept_amorce;
	}

	public static String contextuel(SE currentSE) {
		String contextuel = "";

		contextuel = currentSE.getAxe_semantiqueContext();
		if (contextuel.equals("non_contextuelle")) {
			contextuel = "N";
		} else {
			contextuel = "C";
		}

		return contextuel;
	}

	public static String axeSemantique(SE currentSE) {
		String axe_semantique_return = "";

		if (currentSE.getAxe_semantique().equals("")) {
			axe_semantique_return = "" + remplace;
		} else {
			axe_semantique_return = currentSE.getAxe_semantique();
		}

		return axe_semantique_return;
	}

	public static String axeIntentionnel(SE currentSE) {
		String axe_intentionnel_return = "";
		
		String [] tab = "0,0,0,0,0,0,0".split(",");
		

		for (String value : currentSE.getAxe_intentionnel()) {
			axe_intentionnel_return += value + ";";
		}

		if (axe_intentionnel_return.equals("")) {
			axe_intentionnel_return = "" + remplace;
		}

		System.out.println(axe_intentionnel_return);
		if(axe_intentionnel_return.contains("descriptive")){
			tab[0]="1";
		}
		if(axe_intentionnel_return.contains("explicative")){
			tab[1]="1";
		}
		if(axe_intentionnel_return.contains("procedurale")){
			tab[2]="1";
		}
		if(axe_intentionnel_return.contains("autre_intentionnel")){
			tab[3]="1";
		}
		if(axe_intentionnel_return.contains("narrative")){
			tab[4]="1";
		}
		if(axe_intentionnel_return.contains("prescriptive")){
			tab[5]="1";
		}
		if(axe_intentionnel_return.contains("argumentative")){
			tab[6]="1";
		}
		

		return combine(tab, ",");
	}
	
	static String combine(String[] s, String glue)
	{
	  int k=s.length;
	  if (k==0)
	    return null;
	  StringBuilder out=new StringBuilder();
	  out.append(s[0]);
	  for (int x=1;x<k;++x)
	    out.append(glue).append(s[x]);
	  return out.toString();
	}

	public static String axeRhetorique(SE currentSE) {

		String axe_rethorique_return = "";
		if (currentSE.getAxe_rhetorique().equals("")) {
			axe_rethorique_return = "" + remplace;
		} else {

			if (currentSE.getAxe_rhetorique().equals("paradigmatique")) {
				axe_rethorique_return = "para";
			} else if (currentSE.getAxe_rhetorique().equals("syntagmatique")) {
				axe_rethorique_return = "synta";
			}
		}

		return axe_rethorique_return;
	}

	private static void addCellFormat(WritableSheet sheet, int col, int row,
			int col_fin, int row_fin, String text) throws WriteException {
		addCell(sheet, Border.ALL, BorderLineStyle.THIN, col, row, text);
		sheet.mergeCells(col, row, col_fin, row_fin);
	}

	private static void addCell(WritableSheet sheet, Border border,
			BorderLineStyle borderLineStyle, int col, int row, String desc)
			throws WriteException {

		WritableCellFormat cellFormat = new WritableCellFormat();
		cellFormat.setBorder(border, borderLineStyle);
		cellFormat.setAlignment(Alignment.CENTRE);
		cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		Label label = new Label(col, row, desc, cellFormat);
		sheet.addCell(label);
	}

	public static void preparTab(WritableSheet sheet)
			throws RowsExceededException, WriteException {

		addCellFormat(sheet, 1, 0, 3, 2, "Axe rhétorique");
		addCellFormat(sheet, 4, 0, 6, 2, "Axe intentionnel");
		addCellFormat(sheet, 7, 0, 9, 2, "Axe sémantique");
		addCellFormat(sheet, 10, 0, 12, 2, "Contextuel/non-Contextuel");
		addCellFormat(sheet, 13, 0, 15, 2, "Concept amorce");
		addCellFormat(sheet, 16, 0, 18, 2, "Concept(s) items");
		addCellFormat(sheet, 19, 0, 21, 2, "Circonstant amorce");
		addCellFormat(sheet, 22, 0, 24, 2, "Circonstant(s) items");
	}

}
