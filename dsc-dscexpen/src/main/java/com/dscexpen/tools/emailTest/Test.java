package com.dscexpen.tools.emailTest;

public class Test {

	public static void main(String[] args){   
		MailSenderInfo mailInfo = new MailSenderInfo();    
		mailInfo.setMailServerHost("smtp.test.com.cn");
		mailInfo.setMailServerPort("587");    
		mailInfo.setValidate(true);    
		mailInfo.setUserName("test@test.com.cn");
		mailInfo.setPassword("test");//您的邮箱密码
		mailInfo.setFromAddress("test@test.com.cn");
		mailInfo.setToAddress("test@test.com.cn");
		mailInfo.setSubject("发的推送服务");
		StringBuffer demo = new StringBuffer();  
		demo.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")  
		.append("<html>")  
		.append("<head>")  
		.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")  
		.append("<title>邮件</title>")  
		.append("<style type=\"text/css\">")  
		.append(".test{font-family:\"Microsoft Yahei\";font-size: 18px;color: red;}")  
		.append("</style>")  
		.append("</head>")  
		.append("<body>")
		.append("<div>") 
		.append("信息办:") 
		.append("</div>")
		.append("<div>飞快的设计费：<div>")
		.append("<table border='1'><tr><td><strong>序号</strong></td><td><strong>内容</strong></td><td><strong>发表时间</strong></td>"+
				"<td><strong>发表人</strong></td><td><strong>联系方式</strong></td></tr><tr><td ><span >")
				.append("11")
				.append("</span></td><td ><span >")
				.append("22")
				.append("</span></td><td ><span >")
				.append("33")
				.append("</span></td><td ><span >")
				.append("44")
				.append("</span></td><td ><span >")
				.append("55")
				.append("</span></td></tr></table>")
				.append(" <div>本邮件由系统自动发送，内容仅供参考，无需回复。如需退订，或有其他业务诉求，请致电021-123456。</div>")
				.append("<div>信息化办公室</div>")  
				.append("<div>发送日期</div>")  
				.append("</body>")  
				.append("</html>");  
		mailInfo.setContent(demo.toString());  
		SimpleMailSender sms = new SimpleMailSender();   
		//    sms.sendTextMail(mailInfo);//发送文体格式    
		SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式   
	}  
}
