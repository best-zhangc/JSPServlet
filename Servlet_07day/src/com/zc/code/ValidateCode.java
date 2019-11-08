package com.zc.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateCode extends HttpServlet{
	public void service (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		//0、创建空白图片
		BufferedImage image = new BufferedImage(100, 25,BufferedImage.TYPE_INT_RGB) ;
		
		//1、获取图片画笔
		Graphics g = image.getGraphics();
		Random r = new Random();
		
		//2、设置画笔颜色
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		
		//3、绘制矩形背景
		g.fillRect(0, 0, 100, 30);
		
		//4、调用自定义方法，获取长度为5的字母 数字 组合字符串
		String  number = getNumber(5);
		HttpSession session = request.getSession();
		session.setAttribute("code", number);
		g.setColor(new Color(0, 0, 0));
		g.setFont(new Font(null, Font.BOLD, 24));
		
		//5、设置字体颜色后 ，绘制字符串
		g.drawString(number, 5, 25);
		
		
		//6、绘制八条干扰线
		for (int  i = 0;   i<10;  i++) {
			g.setColor(new Color(
					r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(100), r.nextInt(25), r.nextInt(100), r.nextInt(25));
		}
		
		response.setContentType("image/jpeg");
		ServletOutputStream ops = response.getOutputStream() ;
		ImageIO.write(image, "jpeg", ops) ;
		ops.close();
	}

	private String getNumber(int size) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" ;
		String  number = "" ;
		Random r = new Random() ;
		for (int 	i = 0; i < size; i++) {
			number += str.charAt(r.nextInt(str.length())) ; 
		}
		return number;
	}

}
