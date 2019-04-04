package sort;

public class ArrayMinHeap
{
	private int maxCount;
	private int currentCount;
	private HeapNode pData[];

	public void createArrayMinHeap(int maxcount)
	{
		if (maxcount > 0)
		{
			maxCount = maxcount;
			currentCount = 0;
			pData = new HeapNode[maxCount + 1];
			for (int i = 0; i < maxCount + 1; i++)
				pData[i] = new HeapNode();
		}
	}

	public void insertMinHeapAH(int val)
	{
		currentCount++;
		int currentidx = currentCount;
		int parentidx = currentidx / 2;
		pData[currentidx].data = val;

		while (currentidx > 0 && (pData[currentidx].data) < pData[parentidx].data)
		{
			int temp = pData[currentidx].data;
			pData[currentidx].data = pData[parentidx].data;
			pData[parentidx].data = temp;
			currentidx = parentidx;
			parentidx = currentidx / 2;

		}

	}

	public void removeMinHeapAH()
	{
		HeapNode pReturn = null;
		HeapNode pTemp = null;
		int parent = 1, child = 2;
		if (pData != null && currentCount > 0)
		{
			pReturn = new HeapNode();
			pReturn.data = pData[1].data;
			pTemp = pData[currentCount];
			currentCount--;
			while (child <= currentCount)
			{
				if ((child < currentCount) && (pData[child].data < pData[child + 1].data))
					child++;
				if (pTemp.data >= pData[child].data)
					break;
				pData[parent] = pData[child];
				parent = child;
				child = child * 2;
			}
			pData[parent] = pTemp;
		}
	}

	public void removeArrayMinHeap()
	{
		if (pData != null)
		{
			if (pData != null)
				pData = null;
		}
	}

	public void displayArrayHeap()
	{
		if (pData != null)
		{
			for (int i = 1; i <= currentCount; i++)
			{
				System.out.println(pData[i].data);
			}
		}
	}
}
