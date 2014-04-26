package melodi.annotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import melodi.internal.Circonstant;
import melodi.internal.Concept;
import melodi.internal.Item;
import melodi.internal.Items;
import melodi.internal.Segment;
import melodi.main.IO_MIG;
import melodi.se.SE;

public class WriteExcel2 {

	static WritableWorkbook workbook;
	static WritableSheet sheet;
	public static char remplace;

	public static void main(String[] args) throws IOException {
		
		
		workbook = Workbook.createWorkbook(new File(
				"./annotation/Phase_3/Annotation_V1/corpus_DARA_V1_sophie.xls"));
		sheet = workbook.createSheet("Document Annotation", 0);

		remplace = ' ';

		BufferedReader buff = new BufferedReader(new FileReader("list_dara.txt"));
		String str = null;
		int last = 0;
		while ((str = buff.readLine()) != null) {
			// TODO Auto-generated method stub
			try {
				last = run(str, last);
			} catch (IOException | WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		}
		
		workbook.write();
		try {
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static LinkedList<SE> returnLinkedList(String path){
		// Ouvrir les fichiers d'annotation [okay]
	
		IO_MIG io_julien = new IO_MIG();
		io_julien.readThis(path);
		LinkedList<SE> chain_julien = io_julien.getChain();
		
		return chain_julien;
	}

	public static int run(String name, int last) throws IOException,
			RowsExceededException, WriteException {



//		preparTab(sheet);

		// Un fichier de tableau par document d'annotation

		LinkedList<SE> chain_julien = returnLinkedList("./annotation/Phase_1/Sophie/DARA_corpus/" + name
				+ ".html");


		// For Each SE
		
		int count = last;
		for (int i = 0; i < chain_julien.size(); i++) {

			System.out.println("# SE " + i);


			// Cellule SE
			int deb_se = i + last;
			System.out.println("# SE " + deb_se);
			addCellFormat(sheet, deb_se, 0, "SE " + count);
			addCellFormat(sheet, deb_se, 1, i+"");
			addCellFormat(sheet, deb_se, 2, name);
			addCellFormat(sheet, deb_se, 3, "DARA_corpus");

			// Features SE
			SE se_julien = chain_julien.get(i);
			
			
			// SE - Primer
			addCellFormat(sheet, deb_se, 4, se_julien.getIndice_begin()+"");
			addCellFormat(sheet, deb_se, 5, se_julien.getIndice_end()+"");
			
			addCellFormat(sheet, deb_se, 6, primerIndice_Begin(se_julien));
			addCellFormat(sheet, deb_se, 7, primerIndice_End(se_julien));
			
			// SE - Orientation
			addCellFormat(sheet, deb_se, 8, axeVisuel(se_julien) );
			addCellFormat(sheet, deb_se, 9, axeVisuel_nav(se_julien) );
			
			// SE -items
			addCellFormat(sheet, deb_se, 10, se_julien.getItems().size()+"");
			addCellFormat(sheet, deb_se, 11, items(se_julien)+"");
			
			// SE - clot
			addCellFormat(sheet, deb_se, 12, hasCloture(se_julien));
			addCellFormat(sheet, deb_se, 13, beginCloture(se_julien));
			addCellFormat(sheet, deb_se, 14, endCloture(se_julien));
			
			
			
			// iteration
			count++;
		}

		
		
		return count;

	}
	
	public static String beginCloture(SE currentSE){
		
		if(currentSE.getClot() != null){
			return currentSE.getClot().getIndice_begin()+"";
		}
		else{
			return "NA";
		}
	}
	
	public static String endCloture(SE currentSE){
		
		if(currentSE.getClot() != null){
			return currentSE.getClot().getIndice_end()+"";
		}
		else{
			return "NA";
		}
	}
	
	public static String hasCloture(SE currentSE){
		
		if(currentSE.getClot() != null){
			return "1";
		}
		else{
			return "0";
		}
		
	}
	
	public static String items(SE currentSE){
		
		Items itemsList = currentSE.getItems();
		int index = 0;
		String items_vector = "";
		for (Item item : itemsList) {
				items_vector +=  item.getIndice_begin() + "," + item.getIndice_end()
						+ ",";
			index++;
		}

		if (items_vector.equals("")) {
			items_vector = "NA";
		}
		
		
		
		return items_vector;
	}
	
	public static String axeVisuel_nav(SE currentSE){
		
		String value = currentSE.getAxe_visuel_nav_hyp();
		
		if(value.equals("Hypertextuelle")){
			return "H";
		}
		else if(value.equals("Navigationnelle")){
			return "N";
		}
		else{
		return "NA";
		}
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
	
	public static String primerIndice_Begin(SE currentSE){
		if(currentSE.getPrimer() != null){
			return currentSE.getPrimer().getIndice_begin()+"";
		}
		else{
			return "";
		}
	}

	public static String primerIndice_End(SE currentSE){
		if(currentSE.getPrimer() != null){
			return currentSE.getPrimer().getIndice_end()+"";
		}
		else{
			return "NA";
		}
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
	
	private static void addCellFormat(WritableSheet sheet, int row, int col,
			 String text) throws WriteException {
		addCell(sheet, Border.ALL, BorderLineStyle.THIN, col, row, text);
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
