package com.dscexpen.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.Logger;



public class ReadMesszage extends Thread {
	Logger logger=Logger.getLogger(ReadMesszage.class);

	//BufferedReader br=null;
	String message=null;
	PrintWriter os=null;
	Socket socket = null;
	//String address=PropertyConfig.getProperty("MESSAGE_IP");
//	int port=Integer.parseInt(PropertyConfig.getProperty("MESSAGE_PORT"));

	public ReadMesszage(String message) throws IOException{
		this.message=message;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 1; i++) {
				socket = new Socket("10.240.91.140",7886);
			//	logger.info("连接已建立: "+socket);
				os =new PrintWriter(socket.getOutputStream(),true);
				os.println(message);
				logger.info("发送短信的内容:"+message);
				os.flush();
				InputStream is = socket.getInputStream();
				byte[] bs = new byte[1024];
				is.read(bs);
				Thread.sleep(10);
				String res = new String(bs);
				System.out.println("服务端返回值为："+res);
					if("01".equals(res.trim())){
						System.out.println("服务端返回值为："+res);
						logger.info("-------发送短信成功------");
					}else if("02".equals(res.trim())){
						System.out.println("服务端返回值为："+res);
						logger.error("------发送的报文数据长度不符合------");
					}else if("05".equals(res.trim())){
						System.out.println("服务端返回值为："+res);
						logger.error("---------IP受限---------");
					}
				}
			try {
				socket.close();
			} catch (IOException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			} // 关闭Socket

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
