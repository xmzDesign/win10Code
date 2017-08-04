package lambda;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class StreamDemo {
	public static void main(String[] args) {
		ArrayList<Integer> lists = Lists.newArrayList(1,10,12,89,null,0,1,2,0,1);
		long count = lists.stream().filter(list->list!=null).count();//统计集合中非空的集合数
		System.out.println(count);
		Stream<Integer> distinct = lists.stream().distinct();
		Stream.of(distinct).forEach(param->System.out.println(param));
	}

}
