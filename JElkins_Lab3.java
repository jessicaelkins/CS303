// Jessica Elkins
// CS 303 Fall 2019
// Laboratory Assignment 3
// 9/15/19
// Merge Sort Algorithm

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class JElkins_Lab3
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

				//starting timer
				long startTimer = System.nanoTime();

				mergeSort(array, temp, 0, array.length - 1);

				// ending timer and calculating results
				long endTimer = System.nanoTime();
				sortTime = endTimer - startTimer;

			}

			//printing results
			System.out.println("Test Case:" + (row + 1) + "   Array Size:" + array.length);
			System.out.println("Merge Sort execution time:" + sortTime + " nanoseconds");
			System.out.println(" ");

		}
	}

	public static void mergeSort(int[] array, int[] temp, int low, int high)
	{
		if( low < high)
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


}