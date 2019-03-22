package com.dscexpen.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SendText extends Thread {
	public static void main(String[] args) throws Exception {

		// SendText st = new SendText();
		// st.sendSms();
		// for(int i=0;i<1;i++){
		SendText st = new SendText();
		st.start();
		// }
	}

	/*public static String enToCn(String str) throws UnsupportedEncodingException {
		if (str == null) {
			return str;
		} else {
			return new String(str.getBytes("ISO-8859-1"), "GBK");
		}
	}

	public static String cnToen(String str) throws UnsupportedEncodingException {
		if (str == null) {
			return str;
		} else {
			return new String(str.getBytes("GBK"), "ISO-8859-1");
		}
	}*/

	public void run() {
		String des = "";// 返回报文
		Socket socket = null;
		PrintWriter os = null;
		long s = System.currentTimeMillis();
		// System.out.print(s);
		String sendTxt = null;
		for (int i = 0; i < 1; i++) {
			try {

				 socket = new Socket("10.240.91.140",7886);

//				 socket = new Socket("10.240.88.217",7885);
				os = new PrintWriter(socket.getOutputStream());

	
			//	sendTxt = "0521<?xml version=\"1.0\" encoding=\"GB18030\"?><Root><Public_PrivateFlag>C</Public_PrivateFlag><SendSystemFlag>ATMM</SendSystemFlag><SystemSerialNo.>20170829150105</SystemSerialNo.><BusinessCode>20257</BusinessCode><SendDate>20170829</SendDate><SendTime>150105</SendTime><InterfaceVersion>1.0</InterfaceVersion><Sms>设备编号为[18003148]的设备于[2017-08-28 14:26:15]发生通讯中断,凭条打印机故障,已持续1469分钟,请安排维修. 设备装机地址:中山西路2368号;设备型号为:GRGBANKING  ATM.</Sms><MobileNumber>13052365127</MobileNumber></Root>";
				sendTxt = "0408<?xml version=\"1.0\" encoding=\"GB18030\"?><Root><Public_PrivateFlag>C</Public_PrivateFlag><SendSystemFlag>ITSM</SendSystemFlag><SystemSerialNo.>af3b012d-d541-48ae-b7bd-0494790c2608</SystemSerialNo.><BusinessCode>20226</BusinessCode><SendDate>20170925</SendDate><SendTime>103302</SendTime><InterfaceVersion>1.0</InterfaceVersion><MobileNumber>17621531809</MobileNumber><Sms>[289342, 289554, 289575]</Sms></Root>";
				System.out.println("发送报文：" + sendTxt);
				System.out.println(sendTxt.getBytes().length);
				System.out.println(sendTxt.length());
				os.println(sendTxt);
				os.flush();
				// socket.setSoTimeout(1000);
				InputStream is = socket.getInputStream();
				byte[] bs = new byte[1024];
				is.read(bs);
				des = new String(bs);
				System.out.println("返回报文：" + des.trim());
				System.out.println("连接次数:" + i);
				Thread.sleep(10);
				// if (new StringBuffer(des.trim()).reverse().substring(0, 2)
				// .equals("00")) {
				// System.out.println("cg");
				// return "0";// 成功
				// } else {
				// System.out.println("sb "
				// + new StringBuffer(des.trim()).reverse().substring(
				// 0, 2));
				// return "1";// 失败
				// }
				// System.out.println("总共用时(ms):"+ (System.currentTimeMillis() -
				// s));

			} catch (SocketTimeoutException t) {
				System.out.println("等待超时!" + t.getMessage());
				t.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			} // 关闭Socket

		}

		// return "";
	}

	/*
	 * 如果不满长度,右补空格
	 */
	/*public static String getLeftUsefulStr(String str, int length) {
		int strLen = str.getBytes().length;// 字符长度
		int last = 0;// 剩余长度

		if (strLen < length) {
			last = length - strLen;
		}

		StringBuffer sb = new StringBuffer(str);

		for (int i = 0; i < last; i++) {
			sb.append(" ");
		}

		return sb.toString();
	}*/
}