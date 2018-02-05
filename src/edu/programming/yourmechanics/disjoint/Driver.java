package edu.programming.yourmechanics.disjoint;

import java.io.*;
import java.util.ArrayList;

/**
 * The driver program that reads add/remove instructions from csv input and
 * creates disjoint set and writes to the output file
 * @author Arushee Garg
 * @version 1.0
 */

public class Driver {

	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			throw new IllegalArgumentException(
					"Please provide two params one for input csv file and other for output text file");
		}

		String inputFile = args[0];
		String outputFile = args[1];

		BufferedReader br = null;
		BufferedWriter out = null;
		String line = "";
		String splitBy = ",";

		try {
			File file = new File(outputFile);
			/*
			 * This logic will make sure that the file gets created if it is not present at
			 * the specified location
			 */
			if (!file.exists()) {
				file.createNewFile();
			}

			br = new BufferedReader(new FileReader(inputFile));

			out = new BufferedWriter(new FileWriter(file));

			/* initialize the arrayList and Disjoint Class which holds this list */
			ArrayList<Interval> list = new ArrayList<>();
			DisjointSet disjoint = new DisjointSet(list);

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] input = line.replace(" ","").split(splitBy);

				String op = input[0];
				/*Assuming the intervals provided are valid i.e low <= high*/
				Integer low = Integer.parseInt(input[1]);
				Integer high = Integer.parseInt(input[2]);

				if(low > high) throw new IllegalArgumentException("not a valid interval");
				// append to text output file
				System.out.println(op + " " + low + " " + high);

				/* use the disjoint set method to take the input */
				disjoint.union(op, low, high);

				System.out.println(disjoint.printList());

				/* write to the output file */
				out.write(disjoint.printList() + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/* closing both the files */
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
