// Jessica Elkins
// CS 303 Fall 2019
// Laboratory Assignment 6
// 10/6/19
// Novel Sorting Ideas

import java.util.Arrays;

public class Lab6_part1
{
	public static void main(String[] args)
	{
		int[] array = {32, 7, 28, 13, 96, 5, 0, 12};
		System.out.println("Array not sorted:  " + Arrays.toString(array));

		sort(array);

		System.out.println("Array sorted:      " + Arrays.toString(array));
		System.out.println(" ");
	}


	public static void sort(int[] array)
	{
		int temp;
		int length = array.length - 1;

		for(int i = 0; i < array.length/2; i++)
		{
			//finding index of the smallest value
			int minIndex = i;
			for(int j = i; j <= (length); j++)
			{
				if(array[j] < array[minIndex])
				{
					minIndex = j;
				}
			}

			// putting the smallest element at the beginning
			temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;

			// finding the index of the largest value
			int maxIndex = length;
			for(int k = i; k <= (length); k++)
			{
				if(array[k] > array[maxIndex])
				{
					maxIndex = k;
				}
			}

			//putting the largest element at the end of the array
			temp = array[maxIndex];
			array[maxIndex] = array[length];
			array[length] = temp;

			length--;
		}

	}
}
