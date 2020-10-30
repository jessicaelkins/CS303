import java.util.Scanner;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class bubbleSort
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
		// as a parameter in the bubble sort algorithm
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

			bubble_Sort(array);

			// ending timer and calculating results
			long endTimer = System.nanoTime();
			sortTime = endTimer - startTimer;

			//print statements
			System.out.println("Test Case:" + (row + 1) + "   File Type:" + fileType[row]);
			System.out.println("Bubble Sort execution time:" + sortTime + " nanoseconds");
			System.out.println(" ");
		}


	}

	public static void bubble_Sort(int[] array)
	{
		int n = array.length - 1;

		for(int i = 1; i < n; i++)
		{
			for(int j = n; j >= i; j--)
			{
				if(array[j] < array[j-1])
				{
					// swap array[j] with array[j-1]
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}

}

