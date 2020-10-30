// Jessica Elkins
// CS 303 Fall 2019
// Laboratory Assignment 2
// 9/8/19
// Insertion Sort Algorithm

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class JElkins_Lab2
{

	public static void main(String[] args) throws IOException
	{
		// two variables that will change with each test
		String fileName = "input_500000.txt";
		int arraySize = 500000;

		// reading the file
		File file = new File(fileName);
		Scanner inputFile = new Scanner(file);

		int[] inputArray = new int[arraySize];
		int index = 0;

		// sorting the file into an array
		while( inputFile.hasNextInt())
		{
			inputArray[index++] = inputFile.nextInt();
		}

		// closing the file
		inputFile.close();

		// starting timer
		long startTimer = System.nanoTime();

		// calling insertion sort method
		insertionSort(inputArray);

		// ending timer
		long endTimer = System.nanoTime();

		// calculating sorting time
		long sortTime = endTimer - startTimer;

		// printing results
		System.out.println("Array size: " + arraySize);
		System.out.println("Sort time: " + sortTime + " nanoseconds");
		System.out.println(" ");

	}

	// Insertion sort method
	public static void insertionSort(int inputArray[])
	{
		for(int j = 1; j < inputArray.length; j++)
		{
			int key = inputArray[j];
			int i = j - 1;

			while( i >= 0 && inputArray[i] > key)
			{
				inputArray[i + 1] = inputArray[i];
				i = i - 1;
			}

			inputArray[i + 1] = key;
		}
	}


}