package sort;

public class Selection
{
	private int data[] = null;

	public void selectionSort(int[] values)
	{
		data = values;
		int n = data.length;
		for (int i = 0; i < n - 1; i++)
		{
			int min = i;
			for (int j = i + 1; j < n; j++)
			{
				if (data[j] < data[min])
					min = j;
			}
			swap(i, min);
		}

	}

	private void swap(int idx1, int idx2)
	{
		int temp = data[idx1];
		data[idx1] = data[idx2];
		data[idx2] = temp;
	}
}
