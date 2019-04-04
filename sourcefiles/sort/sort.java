package sort;

import java.util.Arrays;
import java.util.Random;

public class sort
{
	static long starttime, endtime;
	static final int low = 1000;
	static final int mid = 10000;
	static final int high = 100000;

	public static void main(String[] args)
	{
		System.out.println(
				"-----------------------------------------------------------------------------------------------------");
		System.out.println(
				"         Random1000    Reverse1000    Random10000    Reverse10000    Random100000    Reverse100000");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------");

		random_int[] randomint = set_random_int();
		int[] reverse_1000 = get_reverse_int(low);

		int[] reverse_10000 = get_reverse_int(mid);

		int[] reverse_100000 = get_reverse_int(high);

		System.out.print("Bubble          ");
		avgBubble(randomint, low);
		Bubble(reverse_1000);
		avgBubble(randomint, mid);
		Bubble(reverse_10000);
		avgBubble(randomint, high);
		Bubble(reverse_100000);
		System.out.println();

		System.out.print("Selection       ");
		avgSelection(randomint, low);
		Selection(reverse_1000);
		avgSelection(randomint, mid);
		Selection(reverse_10000);
		avgSelection(randomint, high);
		Selection(reverse_100000);
		System.out.println();

		System.out.print("Insertion       ");
		avgInsertion(randomint, low);
		Insertion(reverse_1000);
		avgInsertion(randomint, mid);
		Insertion(reverse_10000);
		avgInsertion(randomint, high);
		Insertion(reverse_100000);
		System.out.println();

		System.out.print("Merge           ");
		avgMerge(randomint, low);
		Merge(reverse_1000);
		avgMerge(randomint, mid);
		Merge(reverse_10000);
		avgMerge(randomint, high);
		Merge(reverse_100000);
		System.out.println();

		System.out.print("Quick1          ");
		avgQuick_1(randomint, low);
		Quick_1(reverse_1000);
		avgQuick_1(randomint, mid);
		Quick_1(reverse_10000);
		avgQuick_1(randomint, high);
		Quick_1(reverse_100000);
		System.out.println();

		System.out.print("Quick2          ");
		avgQuick_2(randomint, low);
		Quick_2(reverse_1000);
		avgQuick_2(randomint, mid);
		Quick_2(reverse_10000);
		avgQuick_2(randomint, high);
		Quick_2(reverse_100000);
		System.out.println();

		System.out.print("Quick3          ");
		avgQuick_3(randomint, low);
		Quick_3(reverse_1000);
		avgQuick_3(randomint, mid);
		Quick_3(reverse_10000);
		avgQuick_3(randomint, high);
		Quick_3(reverse_100000);
		System.out.println();

		System.out.print("Heap            ");
		avgHeap(randomint, low);
		Heap(reverse_1000);
		avgHeap(randomint, mid);
		Heap(reverse_10000);
		avgHeap(randomint, high);
		Heap(reverse_100000);
		System.out.println();

		System.out.print("Library         ");
		avgLibrary(randomint, low);
		Library(reverse_1000);
		avgLibrary(randomint, mid);
		Library(reverse_10000);
		avgLibrary(randomint, high);
		Library(reverse_100000);
		System.out.println();

		System.out.println(
				"-----------------------------------------------------------------------------------------------------");

	}

	static private random_int[] set_random_int()
	{
		random_int[] randomint_class = new random_int[10];
		for (int i = 0; i < 10; i++)
		{
			randomint_class[i] = new random_int(get_random_int(low), get_random_int(mid), get_random_int(high));
		}
		return randomint_class;
	}

	static private int[] get_random_int(int size)
	{
		Random rand = new Random();
		int[] random = new int[size];
		for (int i = 0; i < size; i++)
			random[i] = rand.nextInt(size + 1);
		return random;
	}

	static private int[] get_reverse_int(int size)
	{
		int[] data = new int[size];
		for (int i = 0; i < size; i++)
			data[i] = size - i;
		return data;
	}

	static private void avgBubble(random_int[] randomint, int size)
	{
		Bubble bubblesort = new Bubble();
		double total_time = 0.0;

		switch (size)
		{
		case low:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				bubblesort.bubbleSort(randomint[i].random_1000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case mid:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				bubblesort.bubbleSort(randomint[i].random_10000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case high:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				bubblesort.bubbleSort(randomint[i].random_100000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;
		}

		double avg_time = total_time / 10;
		System.out.print(Math.round(avg_time * 1000) / 1000.0 + "         ");
	}

	static private void Bubble(int[] values)
	{
		Bubble bubblesort = new Bubble();
		StartCalc();
		bubblesort.bubbleSort(values);
		double elapsed_time = EndCalc();
		System.out.print(elapsed_time + "         ");
	}

	static private void avgSelection(random_int[] randomint, int size)
	{
		Selection selectionsort = new Selection();
		double total_time = 0.0;

		switch (size)
		{
		case low:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				selectionsort.selectionSort(randomint[i].random_1000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case mid:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				selectionsort.selectionSort(randomint[i].random_10000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case high:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				selectionsort.selectionSort(randomint[i].random_100000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;
		}

		double avg_time = total_time / 10.0;
		System.out.print(Math.round(avg_time * 1000) / 1000.0 + "         ");
	}

	static private void Selection(int[] values)
	{
		Selection selectionsort = new Selection();
		StartCalc();
		selectionsort.selectionSort(values);
		double elapsed_time = EndCalc();
		System.out.print(elapsed_time + "         ");
	}

	static private void avgInsertion(random_int[] randomint, int size)
	{
		Insertion insertionsort = new Insertion();
		double total_time = 0.0;

		switch (size)
		{
		case low:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				insertionsort.insertionSort(randomint[i].random_1000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case mid:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				insertionsort.insertionSort(randomint[i].random_10000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case high:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				insertionsort.insertionSort(randomint[i].random_100000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;
		}

		double avg_time = total_time / 10.0;
		System.out.print(Math.round(avg_time * 1000) / 1000.0 + "         ");
	}

	static private void Insertion(int[] values)
	{
		Insertion insertionsort = new Insertion();
		StartCalc();
		insertionsort.insertionSort(values);
		double elapsed_time = EndCalc();
		System.out.print(elapsed_time + "         ");
	}

	static private void avgMerge(random_int[] randomint, int size)
	{
		Merge mergesort = new Merge();
		double total_time = 0.0;

		switch (size)
		{
		case low:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				mergesort.mergeSort(randomint[i].random_1000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case mid:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				mergesort.mergeSort(randomint[i].random_10000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case high:
			for (int i = 0; i < 10; i++)
			{
				StartCalc();
				mergesort.mergeSort(randomint[i].random_100000);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;
		}

		double avg_time = total_time / 10;
		System.out.print(Math.round(avg_time * 1000) / 1000.0 + "         ");
	}

	static private void Merge(int[] values)
	{
		Merge mergesort = new Merge();
		StartCalc();
		mergesort.mergeSort(values);
		double elapsed_time = EndCalc();
		System.out.print(elapsed_time + "         ");
	}

	static private void avgQuick_1(random_int[] randomint, int size)
	{
		Quick quick_1 = new Quick();
		double total_time = 0.0;

		switch (size)
		{
		case low:
			for (int i = 0; i < 10; i++)
			{
				quick_1.set_array(randomint[i].random_1000);
				StartCalc();
				quick_1.last_element_pivot(0, 999);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case mid:
			for (int i = 0; i < 10; i++)
			{
				quick_1.set_array(randomint[i].random_10000);
				StartCalc();
				quick_1.last_element_pivot(0, 9999);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case high:
			for (int i = 0; i < 10; i++)
			{
				quick_1.set_array(randomint[i].random_100000);
				StartCalc();
				quick_1.last_element_pivot(0, 99999);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;
		}

		double avg_time = total_time / 10;
		System.out.print(Math.round(avg_time * 1000) / 1000.0 + "         ");
	}

	static private void Quick_1(int[] values) // last element
	{
		Quick quick_1 = new Quick();
		quick_1.set_array(values);
		StartCalc();
		quick_1.last_element_pivot(0, values.length - 1);
		double elapsed_time = EndCalc();
		System.out.print(elapsed_time + "         ");
		quick_1 = null;
	}

	static private void avgQuick_2(random_int[] randomint, int size)
	{
		Quick quick_2 = new Quick();
		double total_time = 0.0;

		switch (size)
		{
		case low:
			for (int i = 0; i < 10; i++)
			{
				quick_2.set_array(randomint[i].random_1000);
				StartCalc();
				quick_2.medium_pivot(0, 999);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case mid:
			for (int i = 0; i < 10; i++)
			{
				quick_2.set_array(randomint[i].random_10000);
				StartCalc();
				quick_2.medium_pivot(0, 9999);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case high:
			for (int i = 0; i < 10; i++)
			{
				quick_2.set_array(randomint[i].random_100000);
				StartCalc();
				quick_2.medium_pivot(0, 99999);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;
		}

		double avg_time = total_time / 10;
		System.out.print(Math.round(avg_time * 1000) / 1000.0 + "         ");
	}

	static private void Quick_2(int[] values) // medium
	{
		Quick quick_2 = new Quick();
		quick_2.set_array(values);
		StartCalc();
		quick_2.medium_pivot(0, values.length - 1);
		double elapsed_time = EndCalc();
		System.out.print(elapsed_time + "         ");
		quick_2 = null;
	}

	static private void avgQuick_3(random_int[] randomint, int size)
	{
		Quick quick_3 = new Quick();
		double total_time = 0.0;

		switch (size)
		{
		case low:
			for (int i = 0; i < 10; i++)
			{
				quick_3.set_array(randomint[i].random_1000);
				StartCalc();
				quick_3.random_pivot(0, 999);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case mid:
			for (int i = 0; i < 10; i++)
			{
				quick_3.set_array(randomint[i].random_10000);
				StartCalc();
				quick_3.random_pivot(0, 9999);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case high:
			for (int i = 0; i < 10; i++)
			{
				quick_3.set_array(randomint[i].random_100000);
				StartCalc();
				quick_3.random_pivot(0, 99999);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;
		}

		double avg_time = total_time / 10;
		System.out.print(Math.round(avg_time * 1000) / 1000.0 + "         ");
	}

	static private void Quick_3(int[] values) // random
	{
		Quick quick_3 = new Quick();
		quick_3.set_array(values);
		StartCalc();
		quick_3.random_pivot(0, values.length - 1);
		double elapsed_time = EndCalc();
		System.out.print(elapsed_time + "         ");
		quick_3 = null;
	}

	static private void avgLibrary(random_int[] randomint, int size)
	{

		double total_time = 0.0;

		switch (size)
		{
		case low:
			for (int i = 0; i < 10; i++)
			{
				int[] forsort = randomint[i].random_1000;
				StartCalc();
				Arrays.sort(forsort);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case mid:
			for (int i = 0; i < 10; i++)
			{
				int[] forsort = randomint[i].random_10000;
				StartCalc();
				Arrays.sort(forsort);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case high:
			for (int i = 0; i < 10; i++)
			{
				int[] forsort = randomint[i].random_100000;
				StartCalc();
				Arrays.sort(forsort);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;
		}

		double avg_time = total_time / 10;
		System.out.print(Math.round(avg_time * 1000) / 1000.0 + "         ");
	}

	static private void Library(int[] values) // Library
	{
		int[] forsort = values;
		StartCalc();
		Arrays.sort(forsort);
		double elapsed_time = EndCalc();
		System.out.print(elapsed_time + "         ");
		forsort = null;
	}

	static private void avgHeap(random_int[] randomint, int size)
	{

		double total_time = 0.0;

		switch (size)
		{
		case low:
			for (int i = 0; i < 10; i++)
			{
				ArrayMinHeap minheap = new ArrayMinHeap();
				minheap.createArrayMinHeap(low);
				StartCalc();
				for (int j = 0; j < low; j++)
					minheap.insertMinHeapAH(randomint[i].random_1000[j]);

				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case mid:
			for (int i = 0; i < 10; i++)
			{
				ArrayMinHeap minheap = new ArrayMinHeap();
				minheap.createArrayMinHeap(mid);
				StartCalc();
				for (int j = 0; j < low; j++)
					minheap.insertMinHeapAH(randomint[i].random_10000[j]);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;

		case high:
			for (int i = 0; i < 10; i++)
			{
				ArrayMinHeap minheap = new ArrayMinHeap();
				minheap.createArrayMinHeap(high);
				StartCalc();
				for (int j = 0; j < low; j++)
					minheap.insertMinHeapAH(randomint[i].random_100000[j]);
				double elapsed_time = EndCalc();
				total_time = total_time + elapsed_time;
			}
			break;
		}

		double avg_time = total_time / 10;
		System.out.print(Math.round(avg_time * 1000) / 1000.0 + "         ");
	}

	static private void Heap(int[] values) // Heap
	{
		ArrayMinHeap minheap = new ArrayMinHeap();
		minheap.createArrayMinHeap(values.length);
		StartCalc();
		for (int i = 0; i < values.length; i++)
			minheap.insertMinHeapAH(values[i]);
		double elapsed_time = EndCalc();
		System.out.print(elapsed_time + "         ");
	
	}

	static private void StartCalc()
	{
		starttime = System.currentTimeMillis();
	}

	static private double EndCalc()
	{
		endtime = System.currentTimeMillis();
		double elapsed_time = (endtime - starttime) / 1000.0;
		return elapsed_time;
	}
}
