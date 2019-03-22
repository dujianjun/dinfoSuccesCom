package com.dscexpen.tools.fenye;

/**
 * 分页工具类
 * @author Administrator
 *
 */
public class PageUtil {

	/**
	 * 获取分页代码
	 * @param targetUrl 目标地址
	 * @param totalNum 总记录数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 * @return
	 */
	public static String getPagation(String targetUrl,int totalNum,int currentPage,int pageSize){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			return "<span id='result'><font color=red>未查询到数据！</font></span>";
		}
		StringBuffer pageCode=new StringBuffer();
		pageCode.append("<li><a href='"+targetUrl+"page=1'>首页</a></li>");
		if(currentPage<1){
			pageCode.append("<li class='disabled'><a href='javascript：void(0);'>上一页</a></li>");
		}else if(currentPage>=1){
			pageCode.append("<li><a href='"+targetUrl+"page="+(currentPage-1)+"' class='pageCode'>上一页</a></li>");
		}
		
		for(int i=currentPage-2;i<=currentPage+2;i++){
			if(i<1 || i>totalPage){
				continue;
			}
			if(i==currentPage){
				pageCode.append("<li class='active'><a href='#'>"+i+"</a></li>");
			}else{
				pageCode.append("<li><a href='"+targetUrl+"page="+i+"' class='pageCode'>"+i+"</a></li>");
			}
			
		}
		
		if(currentPage>totalPage){
			pageCode.append("<li class='disabled'><a href='javascript：void(0);'>下一页</a></li>");
		}else if(currentPage<=totalPage) {
			pageCode.append("<li><a href='"+targetUrl+"page="+(currentPage+1)+"' class='pageCode'>下一页</a></li>");
		}
		pageCode.append("<li><a href='"+targetUrl+"page="+totalPage+"' class='pageCode'>尾页</a></li>");
		pageCode.append("<li><span>当前页:<font id='runpage' style=\"color:#ff9900\">"+currentPage+"</font></span><span>共<font style=\"color:#ff9900\" id='total'>"+totalPage+"</font>&nbsp;页<spqn></li>");
		pageCode.append("<li><form action='"+targetUrl+"' style=\"float:left\" method='get' onsubmit=\"return toVaild()\"><span>跳转到</span><input type=\"text\" class=\"page_text\" name=\"go\" id='go'><a href='#'>页</a>");
		pageCode.append("<input type='submit' value='GO' class='pageCode button29 pageCode'></form></li>");
		
		return pageCode.toString();
	}
	
	
}
