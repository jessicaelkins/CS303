// Selection Sort Algorithm

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class selectionSort
{
	public static void main(String[] args)throws IOException
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
		// as a parameter in the selection sort algorithm
		for(int row = 0; row < inputArrays.length; row++)
		{
			int[] array = new int[arraySize[index]];
			index++;

			for(int column = 0; column < inputArrays[row].length; column++)
			{
				array[column] = inputArrays[row][column];

			}

			//starting timer
			long startTimer = System.nanoTime();

			selection_Sort(array);

			// ending timer and calculating results
			long endTimer = System.nanoTime();
			sortTime = endTimer - startTimer;

			//print statements
			System.out.println("Test Case:" + (row + 1) + "   File Size:" + fileType[row]);
			System.out.println("Selection Sort execution time:" + sortTime + " nanoseconds");
			System.out.println(" ");
		}
	}

	public static void selection_Sort(int[] array)
	{
		int n = array.length - 1;

		for(int i = 0; i < n; i++)
		{
			int min = i;

			// finding the min element
			for(int j = i; j < n; j++)
			{
				if(array[j] < array[min])
				{
					min = j;
				}
			}

			if(i != min)
			{
				// swap array[min] with array[i]
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}

		}
	}
}

