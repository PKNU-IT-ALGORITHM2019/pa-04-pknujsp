package sort;

public class Merge
{

	private int data[] = null;
	private int buff[] = null;

	public void mergeSort(int[] values)
	{
		data = values;
		buff = new int[data.length];
		__mergeSort(0, data.length - 1);
		buff = null;

	}

	private void __mergeSort(int left, int right)
	{
		if (left < right)
		{
			int i;
			int center = (left + right) / 2;
			int p = 0, j = 0, k = left;
			__mergeSort(left, center);
			__mergeSort(center + 1, right);

			for (i = left; i <= center; i++)
				buff[p++] = data[i];
			while (i <= right && j < p)
				data[k++] = (buff[j] <= data[i]) ? buff[j++] : data[i++];
			while (j < p)
				data[k++] = buff[j++];
		}
	}

}
