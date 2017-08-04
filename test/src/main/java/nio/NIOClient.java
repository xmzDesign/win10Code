package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


public class NIOClient {
	//通道管理器
	private Selector selector;
	
	public void initClient(String ip,int port) throws IOException{
		//获得一个Socket通道
		SocketChannel channel=SocketChannel.open();
		//设置通道为非阻塞
		channel.configureBlocking(false);
		//获得一个通道管理器
		this.selector=Selector.open();
		// 客户端连接服务器,其实方法执行并没有实现连接，需要在listen()方法中调  
        //用channel.finishConnect();才能完成连接  
        channel.connect(new InetSocketAddress(ip,port));  
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。  
        channel.register(selector, SelectionKey.OP_CONNECT); 
	}
	
	public void listen() throws IOException{
		while(true){
			selector.select();
			//获得selector中选中的项的迭代器
			Iterator<SelectionKey> ite = this.selector.selectedKeys().iterator();
			while(ite.hasNext()){
				SelectionKey key = (SelectionKey) ite.next();  
                // 删除已选的key,以防重复处理  
                ite.remove();  
                //连接事件发生
                if(key.isConnectable()){
                	SocketChannel channel=(SocketChannel) key.channel();
                	//如果正在连接，则完成连接
                	if(channel.isConnectionPending()){
                		channel.finishConnect();
                	}
                	channel.configureBlocking(false);
                	
                	//在这里可以给服务端发送消息
                	channel.write(ByteBuffer.wrap(new String("向服务端发送了一条信息").getBytes()));
                	//在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。  
                    channel.register(this.selector, SelectionKey.OP_READ);  
                }else if(key.isReadable()){
                	 read(key);
                }
			}
		}
	}

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
	 * 启动客户端测试
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		NIOClient client = new NIOClient();  
        client.initClient("localhost",8000);  
        client.listen();  
	}

}
