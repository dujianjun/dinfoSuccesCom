package com.dscexpen.internet;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;


public class SendMessage {

	protected static Logger logger=Logger.getLogger(SendMessage.class);

	public Boolean sendMessage(String in_MobileNumber,String in_Sms){
		String messageHeader="<?xml version=\"1.0\" encoding=\"GB18130\"?><Root>";
		String messageTail="</Root>";
		String in_Public_PrivateFlag="C";//对公/对私标识 C:对私
		String in_SendSystemFalg="ITSM";//系统标识 ：运维平台
		String in_SendSystemSerialNo=UUID.randomUUID().toString();//系统流水号

		String in_BusinessCode="20226";//业务代码		
		String in_InterfaceVersion="1.0";

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss");
		String in_SendDate = dateFormat.format(date);//发送日期
		String in_SendTime = timeFormat.format(date);//发送时间
		String message=null;
		message=messageHeader+"<Public_PrivateFlag>"+in_Public_PrivateFlag+"</Public_PrivateFlag>"
				+"<SendSystemFlag>"+in_SendSystemFalg+"</SendSystemFlag>"
				+"<SystemSerialNo.>"+in_SendSystemSerialNo+"</SystemSerialNo.>"
				+"<BusinessCode>"+in_BusinessCode+"</BusinessCode>"
				+"<SendDate>"+in_SendDate+"</SendDate>"
				+"<SendTime>"+in_SendTime+"</SendTime>"
				+"<InterfaceVersion>"+in_InterfaceVersion+"</InterfaceVersion>"
				+"<MobileNumber>"+in_MobileNumber+"</MobileNumber>"
				+"<Sms>"+in_Sms+"</Sms>"
				+messageTail;
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);//是否分组显示数据，即每3位为一个分组，分组间以英文半角逗号分隔，false：不分组，true:分组
		numberFormat.setMaximumIntegerDigits(4);//设置数值的整数部分允许的最大位数
		numberFormat.setMinimumIntegerDigits(4);//设置数值的整数部分允许的最小位数
		String messageLength=null;
		try {
			messageLength = numberFormat.format(message.getBytes("GBK").length);
			message=messageLength+message+"\r";
			new Thread(new ReadMesszage(message)).start();
		} catch (Exception e) {
			logger.error("---------------发送短信失败----------------");
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
