// Jessica Elkins
// CS 303 Fall 2019
// Laboratory Assignment 5
// 9/29/19
// Median Three Quick Sort Algorithm

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class medianThreeSort
{
	public static void main(String[] args) throws IOException
	{
		//storing the file names and the files sizes in arrays
		String[] fileNames = { "input_16.txt", "input_32.txt", "input_64.txt", "input_128.txt", "input_256.txt", "input_512.txt", "input_1024.txt", "input_2048.txt", "input_4096.txt", "input_8192.txt"};
		int[] arraySize = {16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};

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

			quickSort(array, 0, length - 1);

			// ending timer and calculating results
			long endTimer = System.nanoTime();
			sortTime = endTimer - startTimer;
		}

			//print statements
			System.out.println("Test Case:" + (row + 1) + "   Array Size: " + array.length);
			System.out.println("Median Three Quick Sort execution time:" + sortTime + " nanoseconds");
			System.out.println(" ");

		}
	}


	public static void quickSort(int[] array, int p, int r)
	{

		if(p < r)
		{
			int n = r - p + 1;

			// determining pivot value
			int m = medianThree(array, p, n/2 , r);

			// exchanging array[m] with array[r]
			int temp = array[m];
			array[m] = array[r];
			array[r] = temp;

			int q = partition(array, p, r);
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
				//exchanging array[i] with array[j]
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

	public static int medianThree(int[] array, int first, int mid, int last)
	{
		int temp;

		// sorting the first, middle, and last element

		if(array[first] > array[mid])
		{
			temp = first;
			first = mid;
			mid = temp;
		}

		if(array[last] < array[mid])
		{
			temp = last;
			last = mid;
			mid = temp;
		}

		if(array[first] > array[mid])
		{
			temp = first;
			first = mid;
			mid = temp;
		}

		//returning mid as pivot
		return mid;
	}


}