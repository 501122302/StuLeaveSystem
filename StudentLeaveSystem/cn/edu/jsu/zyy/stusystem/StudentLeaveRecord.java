package cn.edu.jsu.zyy.stusystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
public class StudentLeaveRecord extends JFrame implements ActionListener{
 
	/**
	 * ѧ����ѯ��ټ�¼ģ��
	 */
 
	JButton jb1=new JButton("ѧ���������");
	JButton jb2=new JButton("ѧ����������");
	JButton jb3=new JButton("��ѯ��ټ�¼");
	JButton jb4=new JButton("�˳�");
	JTextArea jt=new JTextArea();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		StudentLeaveRecord SLR=new StudentLeaveRecord();
	}
 
 
 
		
	
	
public StudentLeaveRecord(){
	this.setTitle("ѧ�����ϵͳ");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setLayout(null);
	
	jt.setEditable(false);//����ı������ⲿ����
	jt.setForeground(Color.BLACK);
	jt.setFont(new Font("΢���ź�",Font.PLAIN,18));
	jb1.setOpaque(false);
	jb1.setFont(new Font("΢���ź�",Font.PLAIN,18));
	jb2.setOpaque(false);
	jb2.setFont(new Font("΢���ź�",Font.PLAIN,18));
	jb3.setOpaque(false);
	jb3.setFont(new Font("΢���ź�",Font.PLAIN,18));
	jb4.setOpaque(false);
	jb4.setFont(new Font("΢���ź�",Font.PLAIN,18));
	jb1.setBackground(new Color(233,240,247));
	jb2.setBackground(new Color(233,240,247));
    jb3.setBackground(new Color(233,240,247));
    jb4.setBackground(new Color(233,240,247));
 
 
	jb1.setBounds(5, 0, 233, 50);
	jb2.setBounds(236, 0, 223, 50);
	jb3.setBounds(457, 0, 223, 50);
	jb4.setBounds(457, 400, 223, 50);
	jt.setBounds(30,80,620,300);
	jb1.addActionListener(this);	
	jb2.addActionListener(this);	
	jb3.addActionListener(this);
	jb4.addActionListener(this);
	
    getContentPane().add(jb1);
    getContentPane().add(jb2);
    getContentPane().add(jb3);
    getContentPane().add(jb4);
    getContentPane().add(jt);
    
    JScrollBar scrollBar = new JScrollBar();
    scrollBar.setBounds(659, 80, 17, 300);
    getContentPane().add(scrollBar);
    this.setVisible(true);
 
	FileReader fr=null;
	//д���ļ����������
	//FileWriter fw=null;
	
	try {
		//����fir����
		fr = new FileReader("d:\\student1.txt");
		
		
		int n=0;//ʵ�ʶ�ȡ���ַ���
		//���뵽�ڴ�
		char c[]=new char[10024];
		while((n=fr.read(c))!=-1){
			//System.out.println(c);
			String s= new String(c,0,n);
			
			jt.setText(s);
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	
}
 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  if(e.getSource().equals(jb4)){
				this.dispose();
			}  
		
		if(e.getSource().equals(jb1)){
			StuInterface a=new StuInterface();	
			this.dispose();
		}  
		if(e.getSource().equals(jb2)){
			JOptionPane.showMessageDialog(null, "�Բ��𣬸ù���δ��ͨ");
		}  
		if(e.getSource().equals(jb3)){
			JOptionPane.showMessageDialog(null, "���Ѵ��ڵ�ǰ����");
		}  
	
	}
}