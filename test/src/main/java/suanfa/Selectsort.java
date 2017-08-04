package suanfa;
/**
 * 直接选择排序
 * 从无序区选一个最小的元素直接放到有序区的最后
 * 设数组为a[0…n-1]。

1.      初始时，数组全为无序区为a[0..n-1]。令i=0

2.      在无序区a[i…n-1]中选取一个最小的元素，将其与a[i]交换。交换之后a[0…i]就形成了一个有序区。

3.      i++并重复第二步直到i==n-1。排序完成。
 * @author Minzhe Xu	2017年3月27日下午2:24:54
 *
 */
public class Selectsort {
	public static void sort(int []a) {
		int min;
		for(int i=0;i<a.length;i++){
			min=i;
			for(int j=i+1;j<a.length;j++){
				if(a[min]>a[j]){
					min=j;
				}
			}
			Example.exch(a, min, i);
		}
	}

}
