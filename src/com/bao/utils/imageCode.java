package com.bao.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class imageCode extends HttpServlet {

	private final static int WIDTH  = 120;
	private final static int HEIGHT = 40;
	
	private StringBuffer sb = new StringBuffer();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer sb = new StringBuffer();
		//����ͼ�ζ���
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		//�õ�Graphics����
		Graphics g = image.getGraphics();
		
		//���ñ�����ɫ
		setBackground(g);
		
		//���߿�
		setBorder(g);
		
		//��������
		drawRadomLine(g);
		
		//д�����
		String ss = drawRadomNum((Graphics2D)g);
		
		
		//��ͼƬд�������
		response.setContentType("image/jpeg");
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		this.getServletContext().setAttribute("verifyCode", ss);
	
	}
	

	private String drawRadomNum(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.setFont(new Font("����",Font.BOLD,30));
		
		String num = "ADCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		
		
		int x = 10;
		//ɾ���ַ���������������
		this.sb.delete(0, sb.length());
		for(int i=0;i<4;i++){
			
			int degre = new Random().nextInt(30);
			int index = new Random().nextInt(36);
			
			String ch = num.charAt(index)+"";
			g.rotate(degre*Math.PI/180, x, 20);
			g.drawString(ch,x,30);
			g.rotate(-degre*Math.PI/180, x, 20);
			x = x+25;
		
			sb.append(num.charAt(index));
		}
		
		String str = new String(sb);
		return str;
	}

	private void setBorder(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, WIDTH-3, HEIGHT-3);
	}


	private void drawRadomLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		//ѭ������Ļ��������
		for(int i=0;i<4;i++){
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			
			g.drawLine(x1, y1, x2, y2);
		}
		
	}



	private void setBackground(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request,response);
	}

}
