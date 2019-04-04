package sort;

public class Insertion
{

	private int data[] = null;

	public void insertionSort(int[] values)
	{
		data = values;
		int n = data.length;
		for (int i = 1; i < n; i++)
		{
			int j, tmp = data[i];
			for (j = i; j > 0 && tmp < data[j - 1]; j--)
				data[j] = data[j - 1];
			data[j] = tmp;
		}

	}

}
