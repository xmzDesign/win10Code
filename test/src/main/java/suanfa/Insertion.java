package suanfa;
/**
 * 插入排序
 * 从第一个元素开始，该元素可以认为已经被排序取出下一个元素，
 * 在已经排序的元素序列中从后向前扫描如果该元素小于前面的元素（已排序），
 * 则依次与前面元素进行比较如果小于则交换，
 * 直到找到大于该元素的就则停止；
 * 如果该元素大于前面的元素（已排序），
 * 则重复步骤2重复步骤2~4 直到所有元素都排好序 。
 * @author Minzhe Xu	2017年4月1日下午1:06:22
 *
 */
public class Insertion {
	public static void sort(int [] a){
		int n=a.length;
		for(int i=1;i<n;i++){
			
			for(int j=i;j>0&&Example.less(a[j], a[j-1]);j--){
				Example.exch(a, j, j-1); 
			}
		}
	}

}
