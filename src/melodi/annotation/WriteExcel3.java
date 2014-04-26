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

public class WriteExcel3 {

	public static char remplace;
	public static WritableSheet sheet;
	public static WritableWorkbook workbook;
	
	public static void main(String[] args) throws IOException {
		
		workbook = Workbook.createWorkbook(new File(
				"./annotation/Phase_3/LARAt_CSV/" + "LARAt_Sophie" + ".xls"));
		sheet = workbook.createSheet("Document Annotation", 0);

//		preparTab(sheet);

		remplace = ' ';

		BufferedReader buff = new BufferedReader(new FileReader("list.txt"));
		String str = null;
		
		int index = 0;
		while ((str = buff.readLine()) != null) {
			// TODO Auto-generated method stub
			try {
				int temp = index;
				index = run(str, temp);
			} catch (IOException | WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		}
		

		
		try {
			workbook.write();
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int run(String name, int last) throws IOException,
			RowsExceededException, WriteException {


		// Un fichier de tableau par document d'annotation
		String doc_julien = "./annotation/Phase_2/Julien/LARA_corpus/" + name
				+ ".html";
		String doc_sophie = "./annotation/Phase_2/Sophie/LARA_corpus/" + name
				+ ".html";

		// Ouvrir les fichiers d'annotation [okay]
		IO_MIG io_julien = new IO_MIG();
		io_julien.readThis(doc_julien);
		LinkedList<SE> chain_julien = io_julien.getChain();

		IO_MIG io_sophie = new IO_MIG();
		io_sophie.readThis(doc_sophie);
		LinkedList<SE> chain_sophie = io_sophie.getChain();


		if (chain_julien.size() != chain_julien.size()) {
			System.err.println("Erreur");
			System.exit(0);
		}

		// For Each SE
		for (int i = 0; i < chain_julien.size(); i++) {

			System.out.println("# SE " + i);
			int index = i + 1;
			index = index + last;
			
			// Features SE
			SE se_julien = chain_julien.get(i);
			SE se_sophie = chain_sophie.get(i);
			
			se_julien = se_sophie;
			
			// Cellule SE
			addCellFormat(sheet, 1, index, 1, index, "SE " + i);
			
			// nom du doc
			addCellFormat(sheet, 2, index, 2, index,
					name);
			
			// Axe Visuel
			addCellFormat(sheet, 3, index, 3, index, axeVisuel(se_julien) );
			
			
			// Axe Rhétorique
			addCellFormat(sheet, 4, index, 4, index,
					axeRhetorique(se_julien));

			// Axe Intentionnel
			String str[]=axeIntentionnel(se_julien).split(",");
			
			addCellFormat(sheet, 5, index, 5, index,
					str[0]);
			addCellFormat(sheet, 6, index, 6, index,
					str[1]);
			addCellFormat(sheet, 7, index, 7, index,
					str[2]);
			addCellFormat(sheet, 8, index, 8, index,
					str[3]);
			addCellFormat(sheet, 9, index, 9, index,
					str[4]);
			addCellFormat(sheet, 10, index, 10, index,
					str[5]);
			addCellFormat(sheet, 11, index, 11, index,
					str[6]);

			// Axe Sémantique
			addCellFormat(sheet, 12, index, 12, index,
					axeSemantique(se_julien));

			// Contextuel/Non-Contextuel
			addCellFormat(sheet, 13, index, 13, index,
					contextuel(se_julien));
			
			// Nombre d'items
			addCellFormat(sheet, 14, index, 14, index, nbItems(se_julien));
			
			// Longueur moyenne des items
			addCellFormat(sheet,15,index,15, index,length_moy_item(se_julien));
			
			// Concepts dans les items
			addCellFormat(sheet,16,index,16, index,nbItems_withConcept(se_julien));
			

			// Amorce
			
			
//			// Concept amorce
//			addCellFormat(sheet, 17, index, 17, index,
//					concept_amorce(se_julien));
//
//			// Concepts items
//			addCellFormat(sheet, 18, index, 18, index,
//					concepts_items(se_julien));
//
//			// Circonstant amorce
//			addCellFormat(sheet, 8, index, 8, index,
//					circonstant_amorce(se_julien));
//
//			// Circonstant items
//			addCellFormat(sheet, 9, index, 9, index,
//					circonstant_items(se_julien));
		}
		
		last = last +  chain_julien.size();
		return last;

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
	
	public static String length_moy_item(SE currentSE){
		int moy = 0;
		int sum = 0;
		int denom = 0;
		
		Items itm = currentSE.getItems();
		for(Item item : itm){
			sum = sum + item.getSurface().length();
			denom++;
		}
		moy = sum/denom;
		
		return moy+"";
	}
	
	public static String nbItems_withConcept(SE currentSE){
		int nb = 0;
	
		Items itm = currentSE.getItems();
		for(Item item : itm){
			if(item.getConcept() != null){
				if(item.getConcept().size() >= 1){
					nb++;
				}
			}
		}
		
		return nb+"";
	}
	
	
	public static String nbItems(SE currentSE){
		int nb = 0;
		
		Items itm = currentSE.getItems();
		nb = itm.size();
		return nb+"";
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
			} else if (currentSE.getAxe_rhetorique().equals("hybride")) {
				axe_rethorique_return = "hybr";
			}
			else if (currentSE.getAxe_rhetorique().equals("bivalente")) {
			axe_rethorique_return = "biva";
			}
		}

		return axe_rethorique_return;
	}

	private static void addCellFormat(WritableSheet sheet, int col, int row,
			int col_fin, int row_fin, String text) throws WriteException {
		addCell(sheet,  col, row, text);
//		sheet.mergeCells(col, row, col_fin, row_fin);
	}

	private static void addCell(WritableSheet sheet, int col, int row, String desc)
			throws WriteException {

//		WritableCellFormat cellFormat = new WritableCellFormat();
//		cellFormat.setBorder(border, borderLineStyle);
//		cellFormat.setAlignment(Alignment.CENTRE);
//		cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		Label label = new Label(col, row, desc);
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
	
	public static String axeVisuel(SE currentSE){
		
		String value = currentSE.getAxe_visuel();
		if(value.equals("Horizontale")){
			return "H";
		}
		else if(value.equals("Verticale")){
			return "V";
		}
		else{
		return "NA";
		}
	}

}

