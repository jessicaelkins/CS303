// Reverse Quick Sort Algorithm

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;

public class quickSortRev
{
	public static void main(String[] args) throws IOException
	{
		//storing the file names and the files sizes in arrays
		String[] fileNames = { "input_Random.txt", "input_ReversedSorted.txt", "input_Sorted.txt"};
		int[] arraySize = {1024, 1024, 1024};
		String[] fileType = {"Random", "Reversed Sorted", "Sorted"};

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

		int index = 0;
		long sortTime = 0;

		// going through each row of the 2D array and storing it into a 1D array to pass it
		// as a parameter in the heap sort algorithm
		for(int row = 0; row < inputArrays.length; row++)
		{
			int[] array = new int[arraySize[index]];
			index++;

			for(int column = 0; column < inputArrays[row].length; column++)
			{
				array[column] = inputArrays[row][column];

				//starting timer
				long startTimer = System.nanoTime();

				int length = array.length;

				quick_Sort(array, 0, length - 1);

				// ending timer and calculating results
				long endTimer = System.nanoTime();
				sortTime = endTimer - startTimer;
			}

			//print statements
			System.out.println("Test Case:" + (row + 1) + "   File Name: " + fileType[row]);
			System.out.println("Quick Sort execution time:" + sortTime + " nanoseconds");
			System.out.println(" ");

		}

	}


	public static void quick_Sort(int[] array, int p, int r)
	{

		if(p < r)
		{
			int q = partition(array, p, r);
			//recursively sorting elements
			quickSort(array, p, q-1);
			quickSort(array, q+1, r);

		}
	}

	public static int partition(int[] array, int p, int r)
	{
		int x = array[r];
		int i = p-1;
		int temp;

		for(int j = p; j < r; j++)
		{
			if(array[j] < x)
			{
				i = i + 1;
				// exchanging array[i] with array[j]
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
			//exchanging array[i+1] with array[r]
			temp = array[i + 1];
			array[i + 1] = array[r];
			array[r] = temp;

			return (i + 1);
	}


}