package melodi.plotannotation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

import melodi.main.IO_MIG;
import melodi.se.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.*;

import au.com.bytecode.opencsv.CSVReader;

public class MainPlotAnnotation extends JFrame {

	public MainPlotAnnotation() {
		super();
	}

	public void paint(Graphics g) {

		int a1 = 200;
		int a2 = 400;

		g.drawLine(50, a1, 700, a1);
		g.drawLine(50, a2, 700, a2);

		// unit a1_1 :
		// deb : a1_1_deb
		// deb : a1_1_fin

	}

	public static void main(String arg[]) throws IOException {

		/**
		 * Document list
		 */
		ArrayList<String> doc_list = new ArrayList<String>();
		CSVReader reader_se_a2 = new CSVReader(new FileReader(
				"data/csv_phase1/doc.csv"));
		boolean firstline_a2 = true;
		String[] nextLine;
		while ((nextLine = reader_se_a2.readNext()) != null) {
			if (!firstline_a2) {
				if (!nextLine[0].equals("")) {
					doc_list.add(nextLine[0]);
				}
			} else {
				firstline_a2 = false;
			}
		}

		// INPUT
		String doc = "Escalier";
		
		
		System.out.println("Doc = " + doc);

		// getNameDoc
		String currFileDoc = "/home/jfaucon/Thesis/Data/LARA_phase1/Julien/LARA_corpus/"
				+ doc + ".html";
		IO_MIG io_LARAt_app = new IO_MIG();
		io_LARAt_app.readThis(currFileDoc);
		LinkedList<SE> a2_SE_ll = io_LARAt_app.getChain();

		String currFileDoc2 = "/home/jfaucon/Thesis/Data/LARA_phase1/Sophie/LARA_corpus/"
				+ doc + ".html";
		IO_MIG io_LARAt_app2 = new IO_MIG();
		io_LARAt_app2.readThis(currFileDoc2);
		LinkedList<SE> a3_SE_ll = io_LARAt_app2.getChain();

		// Sanity view
		System.out.println("A2 size = " + a2_SE_ll.size());
		System.out.println("A3 size = " + a3_SE_ll.size());
		//
		//

		/**
		 * Pairs
		 */
		TreeMap<Integer, Integer> pairs = new TreeMap<Integer, Integer>();
		CSVReader reader = new CSVReader(new FileReader(
				"data/csv_phase1/pairs_review/" + doc + "_pairs_review.csv"));
		boolean firstline = true;
		while ((nextLine = reader.readNext()) != null) {

			if (!firstline) {
				// System.out.println(nextLine[0] + "\t" + nextLine[1]);
				Integer iddoc_a2 = Integer.parseInt(nextLine[1]);
				int iddoc_a3 = Integer.parseInt(nextLine[2]);

				if (!pairs.containsKey(iddoc_a2)) {
					pairs.put(iddoc_a2, iddoc_a3);
				} else {
					System.err
							.println("Erreur pairs contient déjà " + iddoc_a2);
				}
			} else {
				firstline = false;
			}
		}

		PlotAnnotation myPlot = new PlotAnnotation(pairs, a2_SE_ll, a3_SE_ll,
				doc, false);

		myPlot.plot();
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myPlot.write("data/csv_phase1/img_review/" + doc + ".png");

		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// myPlot.close();
		// do what you want to do before sleeping
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// sleep for 1000 ms
			// do what you want to do after sleeptig

		// BasicFrame frame = new BasicFrame();
		// frame.setSize(800, 600);
		// frame.setVisible(true);
	}
}