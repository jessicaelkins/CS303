// Jessica Elkins
// CS 303 Fall 2019
// Laboratory Assignment 1
// 9/1/19
// In this assignment, I am implementing linear search
// and binary search algorithms.

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Arrays;
import java.io.*;

public class JElkins_Lab1
{

	public static void main(String[] args) throws IOException
	{
		// setting up the random array size
		int arraySize = 1048576;
		int numberRange = arraySize + 1;

		// initialized the random array
		int[] randomArray = new int[arraySize];
		Random randomNumber = new Random();

		// assigning random number to each index
		for(int j = 0; j < randomArray.length; j++)
		{
			randomArray[j] = randomNumber.nextInt(numberRange);
		}

		// reading the input file
		String fileName = "input_1000.txt";
		File file = new File(fileName);
		Scanner inputFile = new Scanner(file);

		int[] keyArray = new int[1000];
		int index = 0;

		// putting values from the input file into an array
		while( inputFile.hasNextInt())
		{
			keyArray[index++] = inputFile.nextInt();
		}

		inputFile.close();

		int keyIndex = 0;

		// starting linear search timer
		long startTimer = System.nanoTime();

		// searching for each key using linear search algorithm
		for(int k = 0; k < keyArray.length; k++)
		{
			int linearKey = keyArray[keyIndex];
			int linearResult = Linear(randomArray, linearKey);
			keyIndex++;

		}

		// ending linear search timer
		long endTimer = System.nanoTime();

		// calculating time for linear search
		long linearTime = endTimer - startTimer;

		// sorting the array to prep it for binary search
		Arrays.sort(randomArray);

		keyIndex = 0;

		// setting values for the parameters
		int high = randomArray.length - 1;
		int low = 0;

		// starting the binary search timer
		long startTimer2 = System.nanoTime();

		// searching for each key using the binary search algorithm
		for(int s = 0; s < keyArray.length; s++)
		{
			int binaryKey = keyArray[keyIndex];
			int binaryResult = Binary(randomArray, binaryKey, low, high);
		    keyIndex++;
		}

		// ending the binary search timer
		long endTimer2 = System.nanoTime();

		// calculating the time for binary search
		long binaryTime = endTimer2 - startTimer2;

		// print statements
		System.out.println("Array size: " + randomArray.length);
		System.out.println("Execution time for Linear Search: " + (linearTime / 1000000) + " milliseconds");
		System.out.println("Execution time for Binary Search: " + (binaryTime / 1000000) + " milliseconds");
		System.out.println(" ");
	}

	public static int Linear(int randomArray[], int linearKey)
	{
		// searching each element of the array
		for(int i = 0; i < randomArray.length; i++)
		{
			if (randomArray[i] == linearKey)
				return i;
		}

		// element not found
		return -1;
	}

	public static int Binary(int randomArray[], int binaryKey, int low, int high)
	{
		// element not found
		if(high < low)
		{
			return -1;
		}

		// calculating middle element
		int mid = (high + low) / 2;

		if (binaryKey == randomArray[mid])
		{
			// key was found
			return mid;
		}
		else if ( binaryKey < randomArray[mid])
		{
			// middle - 1 is new high value
			return Binary(randomArray, binaryKey, low, mid - 1);
		}
		else
		{
			// middle + 1 is new low value
			return Binary(randomArray, binaryKey, mid + 1, high);
		}

	}

}