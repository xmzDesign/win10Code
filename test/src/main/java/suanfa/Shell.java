package suanfa;
/**
 * 先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）
 * 分别进行直接插入排序，然后依次缩减增量再进行排序，
 * 待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序
 * @author Minzhe Xu	2017年3月27日下午2:26:12
 *
 */
public class Shell {
	public static void sort(int [] a,int n){
		int i,j,gap;
		for(gap=n/2;gap>0;gap/=2){//每次的循环缩小一半的步长
			for(i=0;i<gap;i++){//以第一组   作为循环比较的开始点
				for(j=i+gap;j<n;j+=gap){//比较各个分组   例如比较1,4,7,10
					if(a[j]<a[j-gap]){
						int temp=a[j];
						int k=j-gap;
						while(k>=0&&a[k]>temp){
							a[k+gap]=a[k];
							k-=gap;
						}
						a[k+gap]=temp;
					}
				}
			}
		}
	}

}
