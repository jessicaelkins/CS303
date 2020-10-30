// Jessica Elkins
// CS 303 Fall 2019
// Laboratory Assignment 3
// 9/15/19
// Modified Merge Sort Algorithm

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class JElkins_ModMerge
{

	public static void main(String[] args) throws IOException
	{
		//storing the file names and the files sizes in arrays
		String[] fileNames = { "input_100.txt" , "input_1000.txt" , "input_5000.txt" , "input_10000.txt" , "input_50000.txt" , "input_100000.txt" , "input_500000.txt" };
		int[] arraySize = {100 , 1000 , 5000 , 10000 , 50000 , 100000 , 500000};

		//creating a two-dimensional array to hold all the values from the imported files
		int[][] inputArrays = new int[fileNames.length][];

		// reading the files
		for(int i=0; i < fileNames.length; i++)
		{

			Scanner inputFile = new Scanner(new File(fileNames[i]));
			inputArrays[i] = new int[arraySize[i]];

			for(int j = 0; inputFile.hasNextInt(); j++)
			{
				inputArrays[i][j] = inputFile.nextInt();
			}
				inputFile.close();
		}


		int ind = 0;
		long sortTime = 0;

		// going through each row of the 2D array and storing it into a 1D array to pass it
		// as a parameter in the merge sort algorithm
		for(int row = 0; row < inputArrays.length; row++)
		{
			int[] array = new int[arraySize[ind]];
			ind++;

			for(int column = 0; column < inputArrays[row].length; column++)
			{
				array[column] = inputArrays[row][column];
				int[] temp = new int[array.length];

				// starting timer
				long startTimer = System.nanoTime();

				mergeSort(array, temp, 0, array.length - 1);

				// stopping timer and calculating time
				long endTimer = System.nanoTime();
				sortTime = endTimer - startTimer;

			}

			// printing results
			System.out.println("Test Case:" + (row + 1) + "  Array Size:" + array.length);
			System.out.println("Modified Merge Sort execution time:" + sortTime + " nanoseconds");
			System.out.println(" ");

		}
	}

	public static void mergeSort(int[] array, int[] temp, int low, int high)
	{
		// cutoff value for insertion sort
		int cutOff = 100;

		if( high - low <= cutOff)
		{
			// sorts the arrays smaller than the cutoff value with
			//modified insertion sort
			modInsertion(array, low, high);
		}
		else
		{
			int mid = (high + low) / 2;
			mergeSort(array, temp, low, mid);
			mergeSort(array, temp, mid+1, high);
			merge(array, temp, low, mid, high);
		}
	}

	public static void merge(int[] array, int[] temp, int low, int mid, int high)
	{
		// merging array[low...high] with array[low+1...high]

		int i = low;
		int j = mid + 1;

		// copying array to temp array
		for( int k = low; k <= high; k++)
		{
			temp[k] = array[k];
		}

		// merging temp array back to array
		for(int t = low; t <= high; t++)
		{
			if(i > mid)
			{
				//left half empty, copy from the right
				array[t] = temp[j];
				j = j + 1;
			}
			else if(j > high)
			{
				// right half empty, copy from the left
				array[t] = temp[i];
				i = i + 1;
			}
			else if(temp[j] < temp[i])
			{
				// copy form the right
				array[t] = temp[j];
				j = j +1;
			}
			else
			{
				//copy from the left
				array[t] = temp[i];
				i = i + 1;
			}
		}

	}

	public static void modInsertion(int array[], int low, int high)
	{
		for(int j = low; j <= high; j++)
		{
			int key = array[j];
			int i = j - 1;

			while( i >= 0 && array[i] > key)
			{
				array[i + 1] = array[i];
				i = i - 1;
			}

			array[i + 1] = key;
		}
	}


}