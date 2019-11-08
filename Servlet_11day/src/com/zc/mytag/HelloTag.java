package com.zc.mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport{
	private String str;
	private int count;
	//重写doTag()方法
	@Override
	public void doTag() throws JspException , IOException{
		PageContext ctx = (PageContext) getJspContext();
		JspWriter out  = ctx.getOut();
		for (int i = 0; i <count ; i++) {
			out.print(str+"<br/><br>");
		}
	}
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
