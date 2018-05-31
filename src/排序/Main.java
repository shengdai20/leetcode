package 排序;

public class Main {

	public static void main(String[] args) {
		int[] buff = {5, 6, 2, 3, 8, 7};
		//冒泡
	//	BubleSort(buff);
		//快排
	//	QuickSort(buff, 0, buff.length - 1);
		//直接插入
	//	InsertSort(buff);
		//选择排序
	//	SelectSort(buff);
		//归并排序
	//	MergeSort(buff, 0, buff.length - 1);
		//希尔排序
		ShellSort(buff);
		for(int i = 0; i < buff.length; i++) {
			System.out.print(buff[i] + ",");
		}
	}
	
	//希尔排序
	private static void ShellSort(int[] buff) {
		//gap是希尔间隔
		for(int gap = buff.length / 2; gap > 0; gap /= 2) {
			//按间隔分组进行直接插入排序
			for(int i = gap; i < buff.length; i++) {
				int tmp = buff[i], j = i - gap;
				for( ; j >= 0 && buff[j] >= tmp; j -= gap) {
					buff[j + gap] = buff[j];
				}
				buff[j + gap] = tmp;
			}
		}
	}
	
	//归并排序
	private static void MergeSort(int[] buff, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			MergeSort(buff, low, mid);
			MergeSort(buff, mid + 1, high);
			Merge(buff, low, mid, high);
		}
	}
	private static void Merge(int[] buff, int low, int mid, int high) {
		int[] tmp = new int[buff.length];
		//i是第一个小组的下标，j是第二个小组的下标，k是结果数组的下标
		int i, j, k;
		//辅助数组
		for(k = low; k <= high; k++) {
			tmp[k] = buff[k];
		}
		//将原数组分成两组进行归并，这两组用两个下标来掌控
		for(i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
			if(tmp[i] <= tmp[j]) {
				buff[k] = tmp[i++];
			}
			else {
				buff[k] = tmp[j++];
			}
		}
		//如果两组中有没归并完的，则依次放入结果数组中
		while(i <= mid) {
			buff[k++] = tmp[i++];
		}
		while(j <= high) {
			buff[k++] = tmp[j++];
		}
	}
	
	//选择排序
	private static void SelectSort(int[] buff) {
		for(int i = 0; i < buff.length - 1; i++) {
			int mi_pos = i;
			//从未排序的序列中找出最小的
			for(int j = i + 1; j < buff.length; j++) {
				if(buff[j] < buff[mi_pos]) {
					mi_pos = j;
				}
			}
			//将最小值换到前面
			if(mi_pos != i) {
				int tmp = buff[i];
				buff[i] = buff[mi_pos];
				buff[mi_pos] = tmp;
			}
		}
	}
	
	//直接插入
	private static void InsertSort(int[] buff) {
		for(int i = 1; i < buff.length; i++) {
			int tmp = buff[i], j;
			for(j = i; j > 0 && buff[j - 1] >= tmp; j--) {
				buff[j] = buff[j - 1];
			}
			buff[j] = tmp;
		}
	}
	
	//快排
	private static void QuickSort(int[] buff, int low, int high) {
		if(low >= high) {
			return;
		}
		int pivort = Partition(buff, low, high);
		QuickSort(buff, low, pivort - 1);
		QuickSort(buff, pivort + 1, high);
	}
	private static int Partition(int[] buff, int low, int high) {
		//以数组第一个数作为哨兵
		int tmp = buff[low];
		while(low < high) {
			while(low < high && buff[high] >= tmp) {
				high--;
			}
			buff[low] = buff[high];
			while(low < high && buff[low] <= tmp) {
				low++;
			}
			buff[high] = buff[low];
		}
		buff[low] = tmp;
		return low;
	}
	
	//冒泡
	private static void BubleSort(int[] buff) {
		for(int i = 0; i < buff.length; i++) {
			for(int j = 0; j < buff.length - 1; j++) {
				if(buff[j] > buff[j + 1]) {
					int tmp = buff[j];
					buff[j] = buff[j + 1];
					buff[j + 1] = tmp;
				}
			}
		}
	}

}
