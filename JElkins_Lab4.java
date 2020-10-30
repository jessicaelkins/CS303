// Jessica Elkins
// CS 303 Fall 2019
// Laboratory Assignment 4
// 9/22/19
// Heap Sort Algorithm

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class JElkins_Lab4
{

	public static void main(String[] args) throws IOException
	{
		//storing the file names and the files sizes in arrays
		String[] fileNames = { "input_100.txt", "input_1000.txt", "input_5000.txt", "input_10000.txt", "input_50000.txt"};
		int[] arraySize = {100, 1000, 5000, 10000, 50000};

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
			int ind = 0;

			for(int column = 0; column < inputArrays[row].length; column++)
			{
				array[column] = inputArrays[row][column];

				//starting timer
				long startTimer = System.nanoTime();

				heapSort(array);

				// ending timer and calculating results
				long endTimer = System.nanoTime();
				sortTime = endTimer - startTimer;

				ind++;
			}

			//print statements
			System.out.println("Test Case:" + (row + 1) + "   Array Size:" + array.length);
			System.out.println("Heap Sort execution time:" + sortTime + " nanoseconds");
			System.out.println(" ");

		}
	}

	public static void heapSort(int[] array)
	{
		int temp;
		int heapSize = array.length;

		// build max heap structure
		buildMaxHeap(array, heapSize);

		int length = array.length;

		for(int a = length-1; a >= 0; a--)
		{
			//move biggest element to end of the sorted list
			temp = array[0];
			array[0] = array[a];
			array[a] = temp;

			// decreasing heap size
			heapSize = array.length - 1;

			// re-heap array
			maxHeapify(array, heapSize, 0);
		}

	}

	public static void buildMaxHeap(int[] array, int heapSize)
	{
		for(int k = (array.length / 2) - 1; k >= 0; k--)
		{
			maxHeapify(array, heapSize, k);
		}
	}

	public static void maxHeapify(int[] array, int heapSize, int i)
	{
		int l = 2*i+1;
		int r = 2*i+2;
		int largest = i;
		int temp;

		if( l < heapSize && array[l] > array[largest])
		{
			// left is largest
			largest = l;
		}
		else
		{
			// parent is largest
			largest = i;
		}

		if(r < heapSize && array[r] > array[largest])
		{
			// right is largest
			largest = r;
		}
		// if parent is not the largest
		if(largest != i)
		{
			// exchange parent with largest
			temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;

			maxHeapify(array, heapSize, largest);
		}
	}

}