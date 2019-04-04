package sort;

import java.util.Random;
import java.util.Stack;

public class Quick
{
	private int[] values = null;

	private int partition(int left, int right)
	{
		int pivot = values[right];
		int i = left - 1;
		int j = left;

		for (; j <= right - 1; j++)
		{
			if (values[j] <= pivot)
			{
				i++;

				swap(i, j);
			}
		}
		swap(i + 1, right);
		return i + 1;
	}

	private int partition_random(int left, int right)
	{
		int pivot_idx = new Random().nextInt(right - left) + left;
		int pivot = values[pivot_idx];
		swap(pivot_idx, right);
		int index = left;

		for (int i = left; i < right; i++)
		{
			if (values[i] < pivot)
			{
				swap(i, index);
				++index;
			}
		}
		swap(index, right);
		return index;
	}

	public void last_element_pivot(int left, int right)
	{
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(left);
		stack.push(right);

		while (!stack.isEmpty())
		{
			right = stack.pop();
			left = stack.pop();

			int pivot = partition(left, right);
			if (pivot - 1 > left)
			{
				stack.push(left);
				stack.push(pivot - 1);
			}
			if (pivot + 1 < right)
			{
				stack.push(pivot + 1);
				stack.push(right);
			}
		}
	}

	public void set_array(int[] data)
	{
		this.values = data;
	}

	public int[] get_sorted_array()
	{
		return values;
	}

	private void swap(int idx1, int idx2)
	{
		int temp = values[idx1];
		values[idx1] = values[idx2];
		values[idx2] = temp;
	}

	private int medium_sort(int front, int mid, int rear)
	{
		if (values[front] > values[mid])
			swap(front, mid);
		if (values[mid] > values[rear])
			swap(mid, rear);
		if (values[front] > values[mid])
			swap(front, mid);
		swap(mid, rear - 1);
		return rear - 1;
	}

	public void medium_pivot(int left, int right)
	{

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(left);
		stack.push(right);

		while (!stack.isEmpty())
		{
			int mid = (left + right) / 2;
			int pivot = medium_sort(left, mid, right);
			int leftidx = left;
			int rightidx = right - 1;

			right = stack.pop();
			left = stack.pop();

			if (pivot - 1 > leftidx)
			{
				stack.push(leftidx);
				stack.push(pivot - 1);
			}
			if (pivot + 1 < rightidx)
			{
				stack.push(pivot + 1);
				stack.push(rightidx);
			}
		}

	}

	public void random_pivot(int left, int right)
	{

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(left);
		stack.push(right);

		while (!stack.isEmpty())
		{
			int pivot = partition_random(left, right);
			int leftidx = left;
			int rightidx = right - 1;

			right = stack.pop();
			left = stack.pop();

			if (pivot - 1 > leftidx)
			{
				stack.push(leftidx);
				stack.push(pivot - 1);
			}
			if (pivot + 1 < rightidx)
			{
				stack.push(pivot + 1);
				stack.push(rightidx);
			}
		}
	}
}
