package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
/**
 * NIO总结：
 * 主要要注意三个对象
 * selector：选择器  ：选择器类管理着一个被注册的通道集合的信息和它们的就绪状态
 * channel：通道：用于在字节缓冲区和位于通道另一侧的实体（通常是一个文件或套接字）之间有效地传输数据
 * SelectionKey：1个键表示了一个特定的通道对象和一个特定的选择器对象之间的注册关系，在Selector下定义
 * 代码步骤: 1.获得一个通道，设置其属性
 * 		   2.获得一个选择器，并将通道和选择器绑定到一起，设置其接受属性
 * 		   3.死循环检测是否有事件到达，由于SelectionKey连接着选择器和通道的关系，通过SelectionKey获取已有事件的channel
 * 
 * 
 * NIO 有一个主要的类Selector,这个类似一个观察者，
 * 只要我们把需要探知的socketchannel告诉Selector,
 * 我们接着做别的事情，当有事件发生时，他会通知我们，
 * 传回一组SelectionKey,我们读取这些Key,就会获得我们刚刚注册过的socketchannel,
 * 然后，我们从这个Channel中读取数据，放心，包准能够读到，接着我们可以处理这些数据。
 * Selector内部原理实际是在做一个对所注册的channel的轮询访问，不断的轮询(目前就这一个算法)，
 * 一旦轮询到一个channel有所注册的事情发生，比如数据来了，他就会站起来报告，
 * 交出一把钥匙，让我们通过这把钥匙来读取这个channel的内容。
 * 		 
 * 
 * @author Minzhe Xu	2017年3月20日上午11:18:18
 *
 */
public class NIOServer {
	//通道管理器
	private Selector  selector;
	/** 
     * 获得一个ServerSocket通道，并对该通道做一些初始化的工作 
     * @param port  绑定的端口号 
     * @throws IOException 
     */  
	public void initServer(int port) throws IOException{
		//获得一个ServerSocket通道
		ServerSocketChannel serverChannel=ServerSocketChannel.open();
		//设置通道为非阻塞
		serverChannel.configureBlocking(false);
		//将通道对应的ServerSocket绑定到端口
		serverChannel.socket().bind(new InetSocketAddress(port));
		//获得一个通道容器
		this.selector=Selector.open();
		//将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件，注册该事件后
		//当该事件到达后，selector.select()会返回,如果该事件没到达selector.select()会一直阻塞
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
	/** 
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理 
     * @throws IOException 
     */  
	public void listen() throws IOException{
		System.out.println("服务端开启成功");
		while(true){
			//当注册的事件到达时，方法返回，否则，该方法一直阻塞
			selector.select();
			//检查已经注册在这个选择器上的所有的通信的信道是否有需要的事件发生
			Iterator<SelectionKey> ite=this.selector.selectedKeys().iterator();
			while(ite.hasNext()){
				//1个键表示了一个特定的通道对象和一个特定的选择器对象之间的注册关系
				SelectionKey key=ite.next();
				//删除已选的key，以防重复处理
				ite.remove();
				//客户端请求连接事件
				if(key.isAcceptable()){
					ServerSocketChannel server=(ServerSocketChannel) key.channel();
					//获得和客户端连接的通道
					SocketChannel channel=server.accept();
					//设置成非阻塞
					channel.configureBlocking(false);
					
					//这里可以给客户端发送消息
					channel.write(ByteBuffer.wrap(new String("向客户端发送的一条消息").getBytes()));
					
					//在和客户端连接成功之后，为了可以接受到客户端的信息，需要给通道设置设置读的权限
					channel.register(this.selector, SelectionKey.OP_READ);
				}else if(key.isReadable()){
					read(key);
				}
			}
		}
	}
	/**
	 * 处理读取客户端发来的信息
	 * @param key
	 * @throws IOException
	 */
	private void read(SelectionKey key) throws IOException {
		//服务器可读取消息：得到事件发生的socket通道
		SocketChannel channel=(SocketChannel) key.channel();
		//创建读取的缓存区
		ByteBuffer buffer=ByteBuffer.allocate(10);
		channel.read(buffer);
		byte[] data=buffer.array();
		String msg=new String(data).trim();
		System.out.println("服务端收到的消息"+msg);
		ByteBuffer outBuffer=ByteBuffer.wrap(msg.getBytes());
		channel.write(outBuffer);//将消息会送给客户端
	}
	/**
	 * 启动服务端测试
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		NIOServer server=new NIOServer();
		server.initServer(8000);
		server.listen();
	}

}
