package melodi.annotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import melodi.internal.Circonstant;
import melodi.internal.Concept;
import melodi.internal.Item;
import melodi.internal.Items;
import melodi.internal.MarqueurRelation;
import melodi.internal.Segment;
import melodi.main.IO_MIG;
import melodi.se.SE;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcel_V2_27_03_2014 {

	public static String remplace;
	public static WritableSheet sheet;
	public static WritableWorkbook workbook;
	
	public static int indexTotalSE;

	public static void main(String[] args) throws IOException {

		String corpus = "LARA";
		String codeur = "Jp";
		BufferedReader buff = new BufferedReader(new FileReader("list_doc_"+corpus+".txt"));
		String str = null;
		
		indexTotalSE = 0;
		
		String out = "./laratcorpus_22_04_14/output/" + corpus + "_"+ codeur + "_v2" + ".xls";
		workbook = Workbook.createWorkbook(new File(out));
		sheet = workbook.createSheet("Document Annotation", 0);

		// preparTab(sheet);

		remplace = "NA";

		int index = 0;
		while ((str = buff.readLine()) != null) {
			// TODO Auto-generated method stub
			try {
				int temp = index;
				index = run(str, corpus, codeur, temp);
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
		System.out.println("Ecriture de : "+ out);

	}

	public static int run(String name, String crpus, String cdr, int last) throws IOException,
			RowsExceededException, WriteException {

		// Un fichier de tableau par document d'annotation
		// Phase 2
		String currFileDoc = "./laratcorpus_22_04_14/"+cdr+"/"+crpus+"_corpus/" + name
				+ ".html";
		
//		// Phase 1
//		String currFileDoc = "./annotation/Phase_1/"+cdr+"/"+crpus+"_corpus/" + name
//		+ ".html";

		// Ouvrir les fichiers d'annotation
		IO_MIG io_LARAt_app = new IO_MIG();
		io_LARAt_app.readThis(currFileDoc);
		LinkedList<SE> current_chain_SE = io_LARAt_app.getChain();

		
		// Ecriture des haut de colonnes
		addCellFormat(sheet,0,0,"idSE_total");
		addCellFormat(sheet,1,0,"idSE_doc");
		addCellFormat(sheet,2,0,"doc");
		addCellFormat(sheet,3,0,"corpus");
		addCellFormat(sheet,4,0,"coder");
		
		addCellFormat(sheet,5,0,"axe_visuel");
		addCellFormat(sheet,6,0,"axe_ret");
		addCellFormat(sheet,7,0,"axe_int_desc");
		addCellFormat(sheet,8,0,"axe_int_expl");
		addCellFormat(sheet,9,0,"axe_int_proc");
		addCellFormat(sheet,10,0,"axe_int_autre");
		addCellFormat(sheet,11,0,"axe_int_narr");
		addCellFormat(sheet,12,0,"axe_int_presc");
		addCellFormat(sheet,13,0,"axe_int_arg");
		addCellFormat(sheet,14,0,"axe_sem_up");
		addCellFormat(sheet,15,0,"axe_sem");
		addCellFormat(sheet,16,0,"contextuel");
		addCellFormat(sheet,17,0,"start_SE");
		addCellFormat(sheet,18,0,"end_SE");
		addCellFormat(sheet,19,0,"start_primer");
		addCellFormat(sheet,20,0,"end_primer");
		addCellFormat(sheet,21,0,"start_enumeration");
		addCellFormat(sheet,22,0,"end_enumeration");
		addCellFormat(sheet,23,0,"concept_primer");
		addCellFormat(sheet,24,0,"circ_primer");
		addCellFormat(sheet,25,0,"marq_primer");
		addCellFormat(sheet,26,0,"nb_concept_primer");
		addCellFormat(sheet,27,0,"nb_circ_primer");
		addCellFormat(sheet,28,0,"nb_marq_primer");
		addCellFormat(sheet,29,0,"nb_items");
		addCellFormat(sheet,30,0,"nb_concept_items");
		addCellFormat(sheet,31,0,"nb_circ_items");
		addCellFormat(sheet,32,0,"nb_marq_items");
		addCellFormat(sheet,33,0,"text_SE");
		addCellFormat(sheet,34,0,"text_primer");
		addCellFormat(sheet,35,0,"text_items");
		addCellFormat(sheet,36,0,"text_concept_primer");
		addCellFormat(sheet,37,0,"text_circ_primer");
		addCellFormat(sheet,38,0,"text_marq_primer");
		addCellFormat(sheet,39,0,"text_concept_items");
		addCellFormat(sheet,40,0,"text_circ_items");
		addCellFormat(sheet,41,0,"text_marq_items");
		addCellFormat(sheet,42,0,"comment");

		
		

		// For Each SE
		for (int i = 0; i < current_chain_SE.size(); i++) {

			System.out.println("# SE " + i);
			int index = i + 1;
			index = index + last;

			// Features SE
			SE current_se = current_chain_SE.get(i);
			
			
			/**
			 *  GET DATA
			 */
			// A = idSE_total
			// 
			String idSE_total = indexTotalSE + "";
			indexTotalSE++;

			// B = idSE_doc
			String idSE_doc = ""+i;
			
			// C = doc
			String doc = name;
			
			// D = corpus
			String corpus = crpus;
			
			// E = coder
			String coder = cdr;
			
			
			// F = axe_visuel {H,V,NA}
			String axe_visuel = axeVisuel(current_se);
			
			// G = axe_ret {P,S,H,B,NA}
			String axe_ret = axeRhetorique(current_se);
			
			// __ axe_int __ {0,1}
			// H = axe_int_desc
			// I = axe_int_expl
			// J = axe_int_proc
			// K = axe_int_autre
			// L = axe_int_narr
			// M = axe_int_presc
			// N = axe_int_arg
			String str[] = axeIntentionnel(current_se).split(",");
			String axe_int_desc = str[0];
			String axe_int_expl = str[1] ;
			String axe_int_proc = str[2];
			String axe_int_autre = str[3];
			String axe_int_narr = str[4];
			String axe_int_presc = str[5];
			String axe_int_arg = str[6];
			
			
			// O = axe_sem_up {visee_onto, metaling, autre, NA}
			String axe_sem_up = axeSemantiqueUp(current_se);
			
			// P = axe_sem =  {isa,partof,instanceof,onto_autre,hyper,mero,homo,syno,multi,lexical_autre,sem_autre,NA}
			String axe_sem = axeSemantique(current_se);
			
			// Q = contextuel {C, N, NA}
			String contextuel = contextuel(current_se);
			
			
			// R = start_SE {#nb}
			String start_SE = start_SE(current_se);
					
			// S = end_SE {#nb}
			String end_SE = end_SE(current_se);
			
			// T = start_primer {#nb}
			String start_primer = start_primer(current_se);
			
			// U = end_primer {#nb}
			String end_primer = end_primer(current_se);
			
			// V = start_enumeration {#nb}
			String start_enumeration = start_enumeration(current_se);
					
			// W = end_enumeration {#nb}
			String end_enumeration = end_enumeration(current_se);
			
			// X = concept_primer {0,1}
			String concept_primer = concept_primer(current_se);
					
					
			// Y = circ_primer {0,1}
			String circ_primer = circ_primer(current_se);
			
			// Z = marq_primer {0,1}
			String marq_primer = marq_primer(current_se);
			
			// AA = nb_concept_primer {#nb}
			String nb_concept_primer = nb_concept_primer(current_se);
			
			// AB = nb_circ_primer {#nb}
			String nb_circ_primer = nb_circ_primer(current_se);
			
			// AC = nb_marq_primer {#nb}
			String nb_marq_primer = nb_marq_primer(current_se);
			
			// AD = nb_items {#nb}
			String nb_items = nb_items(current_se);
			
			// AE = nb_concept_items {#nb}
			String nb_concept_items = nb_concept_items(current_se);
			
			// AF = nb_circ_items {#nb}
			String nb_circ_items = nb_circ_items(current_se);
			
			// AG = nb_marq_items {#nb}
			String nb_marq_items = nb_marq_items(current_se);
			
			
			// AH = text_SE {string}
			String text_SE = text_SE(current_se);
			
			// AI = text_primer {string}
			String text_primer = text_primer(current_se);
			
			// AJ = text_items (string)
			String text_items = text_items(current_se);
			
			
			
			// AK = text_concept_primer
			String text_concept_primer = text_concept_primer(current_se);
			
			// AL = text_circ_primer
			String text_circ_primer = text_circ_primer(current_se);
			
			// AM = text_marq_primer
			String text_marq_primer = text_marq_primer(current_se);
			
			// AN = text_concept_items
			String text_concept_items = text_concept_items(current_se);
			
			// AO = text_circ_items
			String text_circ_items = text_circ_items(current_se);
			
			// AP = text_marq_items
			String text_marq_items = text_marq_items(current_se);
			
			
			// AQ = comment
			String comment = comment(current_se);

			
			/**
			 *  WRITE DATA
			 */
	
			addCellFormat(sheet,0,index,idSE_total);
			
			addCellFormat(sheet,1,index,idSE_doc);

			addCellFormat(sheet,2, index,doc);

			addCellFormat(sheet,3,index,corpus);
			
			addCellFormat(sheet,4,index,coder);
			
			addCellFormat(sheet,5,index,axe_visuel);
			
			addCellFormat(sheet,6,index,axe_ret);
			
			// axe_int
			addCellFormat(sheet,7,index,axe_int_desc);
			addCellFormat(sheet,8,index,axe_int_expl);
			addCellFormat(sheet,9,index,axe_int_proc);
			addCellFormat(sheet,10,index,axe_int_autre);
			addCellFormat(sheet,11,index,axe_int_narr);
			addCellFormat(sheet,12,index,axe_int_presc);
			addCellFormat(sheet,13,index,axe_int_arg);
			
			// axe_semantique
			addCellFormat(sheet,14,index,axe_sem_up);
			addCellFormat(sheet,15,index,axe_sem);
			
			// contextuel
			addCellFormat(sheet,16,index,contextuel);
			
			// 3ème ligne tableaux
			addCellFormat(sheet,17,index,start_SE);
			addCellFormat(sheet,18,index,end_SE);
			addCellFormat(sheet,19,index,start_primer);
			addCellFormat(sheet,20,index,end_primer);
			addCellFormat(sheet,21,index,start_enumeration);
			addCellFormat(sheet,22,index,end_enumeration);
			
			// 4ème ligne
			addCellFormat(sheet,23,index,concept_primer);
			addCellFormat(sheet,24,index,circ_primer);
			addCellFormat(sheet,25,index,marq_primer);
			
			addCellFormat(sheet,26,index,nb_concept_primer);
			addCellFormat(sheet,27,index,nb_circ_primer);
			addCellFormat(sheet,28,index,nb_marq_primer);
			
			
			//5ème ligne
			addCellFormat(sheet,29,index,nb_items);
			addCellFormat(sheet,30,index,nb_concept_items);
			addCellFormat(sheet,31,index,nb_circ_items);
			addCellFormat(sheet,32,index,nb_marq_items);
			
			//6ème ligne
			addCellFormat(sheet,33,index,text_SE);
			addCellFormat(sheet,34,index,text_primer);
			addCellFormat(sheet,35,index,text_items);
			
			//7ème ligne
			addCellFormat(sheet,36,index,text_concept_primer);
			addCellFormat(sheet,37,index,text_circ_primer);
			addCellFormat(sheet,38,index,text_marq_primer);
			
			//8ème ligne
			addCellFormat(sheet,39,index,text_concept_items);
			addCellFormat(sheet,40,index,text_circ_items);
			addCellFormat(sheet,41,index,text_marq_items);
			
			//9ème ligne
			addCellFormat(sheet,42,index,comment);
			
			
		}

		last = last + current_chain_SE.size();
		return last;

	}
	
	public static String comment(SE currentSE){
		String comment = "";
		
	    if(currentSE.getAnnotation().getComment() != null){
	    	comment = currentSE.getAnnotation().getComment();
	    			
	    }
	    else{
	    	comment = "" + remplace;
		}
	    
	    if(comment.equals("")){
	    	comment = "" + remplace;
	    }
	    
		return comment;
	}
	
	public static String text_primer(SE currentSE){
		String text_primer = "";
		
		if(currentSE.getPrimer() != null){
			text_primer = currentSE.getPrimer().getText();
		}
		else{
			text_primer = ""+remplace;
		}
		
		return text_primer;
	}
	
	public static String text_concept_items(SE currentSE){
		String text_concept_items = "";
		
		Items itemsList = currentSE.getItems();
		int index_item = 0;
		for (Item item : itemsList) {
			
			Concept concept = item.getConcept();
			
			int index_seg = 0;
			for(Segment seg : concept){
				text_concept_items += "<"+seg.getIndice_begin()+">"+"["+seg.getText()+"]"+"<"+seg.getIndice_end()+">"+"("+index_seg+")"+"{"+index_item+"}#";
			    index_seg++;
			}
			index_item++;
		}
		
		if (text_concept_items.equals("")) {
			text_concept_items = "" + remplace;
		}
		
		return text_concept_items;
	}
	
	public static String text_marq_items(SE currentSE){
		String text_marq_items = "";
		
		Items itemsList = currentSE.getItems();
		int index_item = 0;
		for (Item item : itemsList) {
			
			MarqueurRelation marqueur = item.getMarqueurRel();
			
			int index_seg = 0;
			for(Segment seg : marqueur){
				text_marq_items += "<"+seg.getIndice_begin()+">"+"["+seg.getText()+"]"+"<"+seg.getIndice_end()+">"+"("+index_seg+")"+"{"+index_item+"}#";
			    index_seg++;
			}
			
			index_item++;
		}
		
		
		if (text_marq_items.equals("")) {
			text_marq_items = "" + remplace;
		}
		
		return text_marq_items;
	}
	
	public static String text_circ_items(SE currentSE){
		String text_circ_items = "";
		
		
		Items itemsList = currentSE.getItems();
		int index_item = 0;
		for (Item item : itemsList) {
			
			Circonstant circonstant = item.getCirconstant();
			
			int index_seg = 0;
			for(Segment seg : circonstant){
				text_circ_items += "<"+seg.getIndice_begin()+">"+"["+seg.getText()+"]"+"<"+seg.getIndice_end()+">"+"("+index_seg+")"+"{"+index_item+"}#";
			    index_seg++;
			}
			
			index_item++;
		}
		
		
		if (text_circ_items.equals("")) {
			text_circ_items = "" + remplace;
		}
		
		return text_circ_items;
	}
	
	public static String text_marq_primer(SE currentSE){
		String text_marq_primer = "";
		if(currentSE.getPrimer() != null){
			
			MarqueurRelation marqueurs = currentSE.getPrimer().getMarqueurRel();
			
			int index_seg = 0;
			for(Segment seg : marqueurs){
				text_marq_primer += "<"+seg.getIndice_begin()+">"+"["+seg.getText()+"]"+"<"+seg.getIndice_end()+">"+"("+index_seg+")#";
				index_seg++;
			}
			
		}
		else{
			text_marq_primer = ""+remplace;
		}
		
		if(text_marq_primer.equals("")){
			text_marq_primer = ""+remplace;
		}
		
		return text_marq_primer;
		
	}
	
	public static String text_circ_primer(SE currentSE){
		String text_circ_primer = "";
		
		if(currentSE.getPrimer() != null){
			
			Circonstant circonstant = currentSE.getPrimer().getCirconstant();
			
			int index_seg = 0;
			for(Segment seg : circonstant){
				text_circ_primer += "<"+seg.getIndice_begin()+">"+"["+seg.getText()+"]"+"<"+seg.getIndice_end()+">"+"("+index_seg +")#";
				index_seg++;
			}
			
		}
		else{
			text_circ_primer = ""+remplace;
		}
		
		if(text_circ_primer.equals("")){
			text_circ_primer = ""+remplace;
		}
		
		return text_circ_primer;
		
	}
	
	
	public static String text_concept_primer(SE currentSE){
		
		String text_concept_primer = "";
		
		if(currentSE.getPrimer() != null){
			
			Concept concept = currentSE.getPrimer().getConcept();
			
			int index_seg = 0;
			for (Segment seg : concept) {
				text_concept_primer += "<"+seg.getIndice_begin()+">"+"["+seg.getText()+"]"+"<"+seg.getIndice_end()+">"+"("+index_seg+")#";
				index_seg++;
			}
						
			
			
		}
		else{
			text_concept_primer = ""+remplace;
		}
		
		if(text_concept_primer.equals("")){
			text_concept_primer = ""+remplace;
		}
		
		return text_concept_primer;
	}
	
	
	public static String text_items(SE currentSE){
		String text_items = "";
		
		Items itemsList = currentSE.getItems();
		int index_item = 0;
		for (Item item : itemsList) {
			
			text_items += "<"+item.getIndice_begin()+">"+"["+item.getText()+"]"+"<"+item.getIndice_end()+">"+"{"+ index_item + "}#";
			index_item++;
		}
		
		if (text_items.equals("")) {
			text_items = "" + remplace;
		}
		
		return text_items;
	}
	
	
	
	
	public static String text_SE(SE currentSE){
		String text_SE = "";
		
		text_SE = currentSE.getText();
				
		return text_SE;
	}
	
	public static String nb_items(SE currentSE){
		String nb_items = "";
		
		int nb = 0;

		Items itm = currentSE.getItems();
		nb = itm.size();
		
		nb_items = nb + "";
		
		return nb_items;
	}
	
	public static String  nb_concept_items(SE currentSE){
		String nb_concept_items = "";
		
		Items itemsList = currentSE.getItems();
		
		int index = 0;
		for (Item item : itemsList) {

			Concept concept = item.getConcept();
			nb_concept_items += concept.size()+"<"+index+">#";

			index++;
		}

		if (nb_concept_items.equals("")) {
			nb_concept_items = "" + remplace;
		}
		
		return nb_concept_items;
	}
	
	public static String nb_circ_items(SE currentSE){
		String nb_circ_items = "";
		
		Items itemsList = currentSE.getItems();
		
		int index = 0;
		for (Item item : itemsList) {
			Circonstant circonstant = item.getCirconstant();
			nb_circ_items += circonstant.size()+"<"+index+">#";
		}
		
		if(nb_circ_items.equals("")){
			nb_circ_items = "" + remplace;
		}
		return nb_circ_items;
	}
	
	public static String nb_marq_items(SE currentSE){
		String nb_marq_items = "";
		
		Items itemsList = currentSE.getItems();
		
		int index = 0;
		for (Item item : itemsList) {
			
			MarqueurRelation marqueurrelation = item.getMarqueurRel();
			nb_marq_items += marqueurrelation.size()+"<"+index+">#";
			
		}
		if(nb_marq_items.equals("")){
			nb_marq_items = ""+remplace;
		}
		
		
		return nb_marq_items;
		
	}
	
	public static String nb_marq_primer(SE currentSE){
		String nb_marq_primer = "";
		
		if(currentSE.getPrimer() != null){
			nb_marq_primer = currentSE.getPrimer().getMarqueurRel().size() + "";
		}
		else{
			nb_marq_primer = ""+remplace;
		}
		return nb_marq_primer;
	}
	
	public static String nb_circ_primer(SE currentSE){
		String nb_circ_primer = "";
		
		if(currentSE.getPrimer() != null){
			
			nb_circ_primer = currentSE.getPrimer().getCirconstant().size() + "";
			
		}
		else{
			nb_circ_primer = ""+remplace;
		}
		return nb_circ_primer;
		
	}
	
	public static String nb_concept_primer(SE currentSE){
		String nb_concept_primer = "";
		
		if(currentSE.getPrimer() != null){
			
			nb_concept_primer = currentSE.getPrimer().getConcept().size() + "";
			
		}
		else{
			nb_concept_primer = ""+remplace;
		}
		return nb_concept_primer;
	}
	
	public static String  marq_primer(SE currentSE){
		String marq_primer = "";
		
		if(currentSE.getPrimer() != null){
			if(currentSE.getPrimer().getMarqueurRel().size() > 0){
				marq_primer = "1";
			}
			else{
				marq_primer = "0";
			}
		}
		else{
			marq_primer = ""+remplace;
		}
		
		return marq_primer;
		
	}
	
	public static String circ_primer(SE currentSE){
		String circ_primer = "";
		
		if(currentSE.getPrimer() != null){
			
			if(currentSE.getPrimer().getCirconstant().size()  > 0){
				circ_primer = "1";
			}
			else{
				circ_primer = "0";
			}
		}
		else{
			circ_primer = ""+remplace;
		}
		return circ_primer;
	}
	
	public static String concept_primer(SE currentSE){
		String concept_primer = "";
		
		if (currentSE.getPrimer() != null) {
			
			if( currentSE.getPrimer().getConcept().size() > 0){
				concept_primer = "1";
			}
			else{
				concept_primer = "0";
			}
		}
		else{
			concept_primer = "" + remplace;
		}
		return concept_primer;
	}
	
	
	public static String start_enumeration(SE currentSE){
		
		String start_enumeration = ""+remplace;
		
		Items itm = currentSE.getItems();
		if(itm.size() != 0){
			Item first_item = itm.get(0);
			
			start_enumeration = first_item.getIndice_begin() + "";
		}else{
			
		}
		
		return start_enumeration;
	}
	
	public static String end_enumeration(SE currentSE){
		
		String end_enumeration = ""+remplace;
		
		
		Items itm = currentSE.getItems();
		if(itm.size() != 0){
			Item  last_item = itm.get(itm.size()-1);
			
			end_enumeration = last_item.getIndice_end() + "";
		}
		else{
			
		}
		
		return end_enumeration ;
	}
	
	
	
	public static String start_primer(SE currentSE){
		
		String start_primer = "";
		
		if (currentSE.getPrimer() != null) {
			start_primer = currentSE.getPrimer().getIndice_begin() + "";
		}
		else{
			start_primer = "" + remplace;
		}
		return start_primer;
		
	}
	
	public static String end_primer(SE currentSE){
		
		String end_primer = "";
		
		if (currentSE.getPrimer() != null) {
			end_primer = currentSE.getPrimer().getIndice_end() + "";
		}
		else{
			end_primer = "" + remplace;
		}
		return end_primer;
		
	}
	
	
	public static String start_SE(SE currentSE){
		
		return ""+currentSE.getIndice_begin();
	}
	
	public static String end_SE(SE currentSE){
		
		return ""+currentSE.getIndice_end();
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

		if (currentSE.getPrimer() != null) {
			Circonstant circonstant = currentSE.getPrimer().getCirconstant();

			for (Segment seg : circonstant) {
				circonstant_amorce += seg.getText() + "("
						+ seg.getIndice_begin() + "," + seg.getIndice_end()
						+ ")" + ";";
			}

			if (circonstant_amorce.equals("")) {
				circonstant_amorce = "" + remplace;
			}
		} else {
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

		if (currentSE.getPrimer() != null) {
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

	public static String length_moy_item(SE currentSE) {
		int moy = 0;
		int sum = 0;
		int denom = 0;

		Items itm = currentSE.getItems();
		for (Item item : itm) {
			sum = sum + item.getSurface().length();
			denom++;
		}
		moy = sum / denom;

		return moy + "";
	}

	public static String nbItems_withConcept(SE currentSE) {
		int nb = 0;

		Items itm = currentSE.getItems();
		for (Item item : itm) {
			if (item.getConcept() != null) {
				if (item.getConcept().size() >= 1) {
					nb++;
				}
			}
		}

		return nb + "";
	}

	public static String nbItems(SE currentSE) {
		int nb = 0;

		Items itm = currentSE.getItems();
		nb = itm.size();
		return nb + "";
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
	
	public static String axeSemantiqueUp(SE currentSE){
		String axe_semantique_up_return = "";
		
		if (currentSE.getAxe_semantique().equals("")) {
			axe_semantique_up_return = "" + remplace;
		} else {
			
			if(currentSE.getAxe_semantique().equals("isA")){
				axe_semantique_up_return = "visee_onto";
			}
			else if(currentSE.getAxe_semantique().equals("instanceOf")){
				axe_semantique_up_return = "visee_onto";
			}
			else if(currentSE.getAxe_semantique().equals("autre_ontologique")){
				axe_semantique_up_return = "visee_onto";
			}
			else if(currentSE.getAxe_semantique().equals("partOf")){
				axe_semantique_up_return = "visee_onto";
			}
			else if(currentSE.getAxe_semantique().equals("hyperonymie")){
				axe_semantique_up_return = "metaling";
			}
			else if(currentSE.getAxe_semantique().equals("homonymie")){
				axe_semantique_up_return = "metaling";
			}
			else if(currentSE.getAxe_semantique().equals("meronymie")){
				axe_semantique_up_return = "metaling";
			}
			else if(currentSE.getAxe_semantique().equals("synonymie")){
				axe_semantique_up_return = "metaling";
			}
			else if(currentSE.getAxe_semantique().equals("multilingue")){
				axe_semantique_up_return = "metaling";
			}
			else if(currentSE.getAxe_semantique().equals("autre_lexical")){
				axe_semantique_up_return = "metaling";
			}
			else if(currentSE.getAxe_semantique().equals("autre_semantique")){
				axe_semantique_up_return = "autre";
			}
			else{
				axe_semantique_up_return = ""+remplace;
			}
			
		}
		return axe_semantique_up_return;
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

		String[] tab = "0,0,0,0,0,0,0".split(",");

		for (String value : currentSE.getAxe_intentionnel()) {
			axe_intentionnel_return += value + ";";
		}

		if (axe_intentionnel_return.equals("")) {
			axe_intentionnel_return = "" + remplace;
		}

		System.out.println(axe_intentionnel_return);
		if (axe_intentionnel_return.contains("descriptive")) {
			tab[0] = "1";
		}
		if (axe_intentionnel_return.contains("explicative")) {
			tab[1] = "1";
		}
		if (axe_intentionnel_return.contains("procedurale")) {
			tab[2] = "1";
		}
		if (axe_intentionnel_return.contains("autre_intentionnel")) {
			tab[3] = "1";
		}
		if (axe_intentionnel_return.contains("narrative")) {
			tab[4] = "1";
		}
		if (axe_intentionnel_return.contains("prescriptive")) {
			tab[5] = "1";
		}
		if (axe_intentionnel_return.contains("argumentative")) {
			tab[6] = "1";
		}

		return combine(tab, ",");
	}

	static String combine(String[] s, String glue) {
		int k = s.length;
		if (k == 0)
			return null;
		StringBuilder out = new StringBuilder();
		out.append(s[0]);
		for (int x = 1; x < k; ++x)
			out.append(glue).append(s[x]);
		return out.toString();
	}

	public static String axeRhetorique(SE currentSE) {

		String axe_rethorique_return = "";
		if (currentSE.getAxe_rhetorique().equals("")) {
			axe_rethorique_return = "" + remplace;
		} else {

			if (currentSE.getAxe_rhetorique().equals("paradigmatique")) {
				axe_rethorique_return = "P";
			} else if (currentSE.getAxe_rhetorique().equals("syntagmatique")) {
				axe_rethorique_return = "S";
			} else if (currentSE.getAxe_rhetorique().equals("hybride")) {
				axe_rethorique_return = "H";
			} else if (currentSE.getAxe_rhetorique().equals("bivalente")) {
				axe_rethorique_return = "B";
			}
			else{
				axe_rethorique_return = "" + remplace;
			}
		}

		return axe_rethorique_return;
	}

	private static void addCellFormat(WritableSheet sheet, int col, int row, String text) throws WriteException {
		addCell(sheet, col, row, text);
		// sheet.mergeCells(col, row, col_fin, row_fin);
	}

	private static void addCell(WritableSheet sheet, int col, int row,
			String desc) throws WriteException {

		// WritableCellFormat cellFormat = new WritableCellFormat();
		// cellFormat.setBorder(border, borderLineStyle);
		// cellFormat.setAlignment(Alignment.CENTRE);
		// cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		Label label = new Label(col, row, desc);
		sheet.addCell(label);
	}

//	public static void preparTab(WritableSheet sheet)
//			throws RowsExceededException, WriteException {
//
//		addCellFormat(sheet, 1, 0, 3, 2, "Axe rhétorique");
//		addCellFormat(sheet, 4, 0, 6, 2, "Axe intentionnel");
//		addCellFormat(sheet, 7, 0, 9, 2, "Axe sémantique");
//		addCellFormat(sheet, 10, 0, 12, 2, "Contextuel/non-Contextuel");
//		addCellFormat(sheet, 13, 0, 15, 2, "Concept amorce");
//		addCellFormat(sheet, 16, 0, 18, 2, "Concept(s) items");
//		addCellFormat(sheet, 19, 0, 21, 2, "Circonstant amorce");
//		addCellFormat(sheet, 22, 0, 24, 2, "Circonstant(s) items");
//	}

	public static String axeVisuel(SE currentSE) {

		String value = currentSE.getAxe_visuel();
		if (value.equals("Horizontale")) {
			return "H";
		} else if (value.equals("Verticale")) {
			return "V";
		} else {
			return remplace;
		}
	}

}
