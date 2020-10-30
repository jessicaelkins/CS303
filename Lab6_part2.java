// Jessica Elkins
// CS 303 Fall 2019
// Laboratory Assignment 6
// 10/6/19
// Choosing a stable sorting algorithm

import java.io.*;
import java.util.*;

public class Lab6_part2
{
	public static void main(String[] args) throws IOException
	{
		String fileName = "NovelSortInput.txt";
		FileReader file = new FileReader(fileName);
      	BufferedReader inputFile = new BufferedReader(file);

		List<String> input = new ArrayList<String>();
		String line;

      	while( (line = inputFile.readLine()) != null)
		{
			if(line.length() > 0)
			{
				// adding input file to array list
				input.add(line);
			}
		}

		inputFile.close();

		// converting array list to array
		String[] array = input.toArray(new String[0]);
		String[] temp = new String[array.length];

		for(int i=0; i < array.length; i++)
		{
			//copying array to temp array
			temp[i] = array[i];
		}

		mergeSort(array, temp, 0, array.length - 1);

		for(int j=0; j < array.length; j++)
		{
			System.out.println(array[j]);
		}

    }

	public static void mergeSort(String[] array, String[] temp, int low, int high)
	{
		if( low < high)
		{
			int mid = (high + low) / 2;
			mergeSort(array, temp, low, mid);
			mergeSort(array, temp, mid+1, high);
			merge(array, temp, low, mid, high);
		}
	}

	public static void merge(String[] array, String[] temp, int low, int mid, int high)
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
			else if(temp[i].compareTo(temp[j]) > 0)
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