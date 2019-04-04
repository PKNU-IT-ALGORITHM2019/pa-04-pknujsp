package sort;

public class Bubble
{
	private int[] data = null;

	public void bubbleSort(int[] values)
	{
		data = values;
		int k = 0, n = data.length;
		while (k < n - 1)
		{
			int last = n - 1;
			for (int j = n - 1; j > k; j--)
			{
				if (data[j - 1] > data[j])
				{
					swap(j - 1, j);
					last = j;
				}
			}
			k = last;
		}
		
	}

	private void swap(int idx1, int idx2)
	{
		int temp = data[idx1];
		data[idx1] = data[idx2];
		data[idx2] = temp;
	}

}
