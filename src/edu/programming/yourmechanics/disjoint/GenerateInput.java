package edu.programming.yourmechanics.disjoint;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * GeneratedInput is a class to randomly generate an input file 
 * with arguments - 1) the number of input lines needed and 
 * 				    2) name of output file.
 * @author Arushee Garg
 * @version 1.0
 */
public class GenerateInput {
	
	/**
	 * Generates the random input file.
	 * @param number : number of inputs
	 * @param outputFile : filename where the file will be stored
	 */
	public void generate(int number , String outputFile) {
		
		BufferedWriter out = null;
		try {
			File file = new File(outputFile);
			/*
			 * This logic will make sure that the file gets created if it is not present at
			 * the specified location
			 */
			if (!file.exists()) {
				file.createNewFile();
			}
			
			out = new BufferedWriter(new FileWriter(file));
			
			for(int i = 0 ; i < number ; i++) {
				out.write( generateOp() + "," + generateNumbers() + "\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/* closing both the files */
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	/**
	 * Random function to generate operation
	 * @return the operation add/remove
	 */
	public String generateOp(){
		Random randomno = new Random();
		boolean bool = randomno.nextBoolean();
		
		if(bool == true) return "add";
		else return "remove";
	}
	/**
	 * Random function to generate interval. 
	 * Assumption high will be greater than low.
	 * @return a string with low and high number of the interval
	 */
	public String generateNumbers(){
		Random randomno = new Random();
		int low = randomno.nextInt(10000) + -1000;
		int high = randomno.nextInt(1000) + low;
		
		return new String(low + "," + high);
	}
	
	/* Run the main method if an random input file needs to be generated. */
	/**
	public static void main(String[] args) {
		GenerateInput input = new GenerateInput();
		input.generate(10 , "./InputFiles/inputFile.csv") ;
	}
	**/
	

}
