/*
 * hny003 
 * Henrik Nytun
 * studentnr:235187 
 *
 */




package quadruple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.princeton.cs.algs4.Stopwatch;

public class firstAlgorithm {
	
	public static String[] sortedList(String filename) throws IOException {

		ArrayList<String> list = new ArrayList<String>();

		String sCurrentLine;
		BufferedReader br;
		br = new BufferedReader(new FileReader(filename));
		while ((sCurrentLine = br.readLine()) != null) {
			list.add(sCurrentLine);
		}

		String[] array = new String[list.size()];
		int count = 0;
		for (String s : list) {
			array[count++] = s;
		}

		TopDownMergeSort.sort(array); //sort in order to use binarysearch
		return array;
	}
	
	public static boolean binarySearch(String target, String[] searchArray){
		
		
		
		
		int midIndex = (searchArray.length/2);
		int lowIndex = 0;
		int highIndex = (searchArray.length-1);
		
		while((highIndex-lowIndex) != 1) //while there is more than 2 routes
		{
			int compare = target.compareTo(searchArray[midIndex]);
			
			if(compare < 0) //means that our string is to the left of midIndex
			{
				highIndex = midIndex;
				midIndex = highIndex/2;
				
			}
			else if(compare > 0)
			{
				lowIndex = midIndex;
				midIndex = midIndex + (highIndex-midIndex)/2;
			}
			else
			return true; //this means we found our String :D (strings are equal)	
			
		}
		
		//when there is only two left in our search
		if(searchArray[highIndex].equals(target)){
			return true;
		}
		if(searchArray[lowIndex].equals(target)){
			return true;
		}
		
		return false; //if we did not find our target
			
		
		
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException
	{
		
		Stopwatch timer = new Stopwatch();
		
		String pathA = "/home/henrik/workspace/quadruple/src/quadruple/namesA.txt";
		String pathB = "/home/henrik/workspace/quadruple/src/quadruple/namesB.txt";
		String pathC = "/home/henrik/workspace/quadruple/src/quadruple/namesC.txt";
		String pathD = "/home/henrik/workspace/quadruple/src/quadruple/namesD.txt";
		
		String[] first = sortedList(pathA);
		String[] second = sortedList(pathB);
		String[] third = sortedList(pathC);
		String[] fourth = sortedList(pathD);
		
		
		
		
		
		for(int i = 0;i<first.length;i++)
		{
			
			if(binarySearch(first[i], second) 
				&& binarySearch(first[i], third)
				&& binarySearch(first[i], fourth)){
				
				
			
				System.out.println(first[i] + " exists in all 4 lists!");
				break;
			}
				
			                        	
		}
		//System.out.println("Estimated time:" + timer.elapsedTime());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
