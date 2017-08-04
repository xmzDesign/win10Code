/**
 * 
 */
package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Minzhe Xu	2017年7月23日下午10:01:25
 *	建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
 *保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。示例代码如下：
 */
public class SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {  
			singleThreadExecutor.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		}
	}
	
	

}
