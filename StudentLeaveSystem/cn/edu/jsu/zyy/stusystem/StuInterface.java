package cn.edu.jsu.zyy.stusystem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import cn.edu.jsu.zyy.connect.DatabaseConnectionSql;
import cn.edu.jsu.zyy.register.AddSucess;
 
/**
 * ѧ�����ϵͳģ��
 */
 
 
 
public class StuInterface extends JFrame implements ActionListener{
 
	     JFrame frame;
		JButton jb1=new JButton("ѧ���������");
		JButton jb2=new JButton("ѧ����������");
		JButton jb3=new JButton("��ѯ��ټ�¼");
		JButton jb4=new JButton("�ύ");
		JButton jb5=new JButton("�˳�");
		
		 static JTextArea jt;
		 static  JTextField xmg;
		 static JTextField xhg;
		 static JTextField zyg;
		 static JTextField lxg;
		 static JTextField ksrqg;
		 static JTextField jsrqg;
		 private final JLabel lblNewLabel = new JLabel("bg");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Systemter a=
				new StuInterface();	}
 
	
public StuInterface(){
	
	
	
	this.setTitle("ѧ�����ϵͳ");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setLayout(null);
	
//	 
	  jb1.setOpaque(false);
	  jb1.setFont(new Font("΢���ź�",Font.PLAIN,18));
	  jb2.setOpaque(false);
	  jb2.setFont(new Font("΢���ź�",Font.PLAIN,18));
	  jb3.setOpaque(false);
	  jb3.setFont(new Font("΢���ź�",Font.PLAIN,18));
	  jb4.setOpaque(false);
	  jb4.setFont(new Font("΢���ź�",Font.PLAIN,18));
	  jb5.setOpaque(false);
	  jb5.setFont(new Font("΢���ź�",Font.PLAIN,18));
	  
	 jb1.setBackground(new Color(233,240,247));
	 jb2.setBackground(new Color(233,240,247));
	 jb3.setBackground(new Color(233,240,247));
	 jb4.setBackground(new Color(233,240,247));
	 jb5.setBackground(new Color(233,240,247));
	 
	 
	JLabel jl=new JLabel("�������");
	JLabel xm=new  JLabel("����");
	JLabel xh=new JLabel("ѧ��");
	JLabel zy=new JLabel("רҵ");
	JLabel lx=new JLabel("��ϵ");
	JLabel ksrq=new JLabel("��ʼ����");
	JLabel jsrq=new JLabel("��������");
	JLabel qjsy=new JLabel("�������");
	
	
	 jl.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 xm.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 xh.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 zy.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 lx.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 ksrq.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 jsrq.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 qjsy.setFont(new Font("΢���ź�",Font.PLAIN,18));
	  
	 xmg=new JTextField();
	 xhg=new JTextField();
	 zyg=new JTextField();
	 lxg=new JTextField();
	 ksrqg=new JTextField();
	 jsrqg=new JTextField();
	//JTextField qjsyg=new JTextField();
	 jt=new JTextArea();
	 
	 xmg.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 xhg.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 zyg.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 lxg.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 ksrqg.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 jsrqg.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 jt.setFont(new Font("΢���ź�",Font.PLAIN,18));
	 
	 xmg.setBorder(null);
	 xhg.setBorder(null);
	 zyg.setBorder(null);
	 lxg.setBorder(null);
	 ksrqg.setBorder(null);
	 jsrqg.setBorder(null);
	// qjsyg.setBorder(null);
 
	jb1.setBounds(5, 0, 233, 50);
	jb2.setBounds(236, 0, 223, 50);
	jb3.setBounds(457, 0, 223, 50);
	
	jl.setBounds(300,51,620,50);
	
	xm.setBounds(188,92,60,50);
	xmg.setBounds(68,102,110,30);
	
	xh.setBounds(32,92,50,50);
	xhg.setBounds(227,102,110,30);
	
	zy.setBounds(350,90,50,50);
	zyg.setBounds(389,102,110,30);
	
	lx.setBounds(517,90,50,50);
	lxg.setBounds(556,102,110,30);
	
	ksrq.setBounds(30,135,90,50);
	ksrqg.setBounds(105,145,170,30);
	
	jsrq.setBounds(300,135,90,50);
	jsrqg.setBounds(375,145,170,30);
	
	qjsy.setBounds(30,210,90,100);
	//jt.setBounds(30,210,90,100);
	jt.setBounds(105,200,555,130);
	
	
	jb4.setBounds(30,380,100,50);
	jb5.setBounds(140,380,100,50);
	//this.add(upper);
	
	getContentPane().add(jb1);
	getContentPane().add(jb2);
	getContentPane().add(jb3);
	getContentPane().add(jl);
	getContentPane().add(xm);
	getContentPane().add(xmg);
	getContentPane().add(zy);
	getContentPane().add(zyg);
	getContentPane().add(xh);
	getContentPane().add(xhg);
	getContentPane().add(lx);
	getContentPane().add(lxg);
	getContentPane().add(ksrq);
	getContentPane().add(ksrqg);
	getContentPane().add(jsrq);
	getContentPane().add(jsrqg);
	getContentPane().add(qjsy);
	//this.add(qjsyg);
	getContentPane().add(jt);
	getContentPane().add(jb4);
	getContentPane().add(jb5);
	lblNewLabel.setIcon(new ImageIcon("D:\\\u684C\u9762\u56FE\u7247\\ef4166b6ebe918bd422b44e842636631(1).jpg"));
	lblNewLabel.setBounds(-45, -15, 771, 530);
	getContentPane().add(lblNewLabel);
	
	jb1.addActionListener(this);	
	jb2.addActionListener(this);	
	jb3.addActionListener(this);	
	jb4.addActionListener(this);	
	jb5.addActionListener(this);	
	
	this.setVisible(true);
}
 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 // String input = e.getActionCommand();
		  if( e.getSource().equals(jb5))
	        {
				this.dispose();
	           System.exit( 0 );
 
		       
			}

	       
		  if(e.getSource().equals(jb4)){
			  DatabaseConnectionSql c = new DatabaseConnectionSql();

				Connection conn = c.getConnection();

				PreparedStatement ps = null;
				try {
					ps = conn
							.prepareStatement("insert into stu(xmg,xhg,zyg,lxg,ksrqg,jsrqg,jt,tf,shzt) values(?,?,?,?,?,?,?,?,?)");

					ps.setString(1, xmg.getText().trim());
					ps.setString(2, xhg.getText().trim());
					ps.setString(3, zyg.getText().trim());
					ps.setString(4, lxg.getText().trim());
					ps.setString(5, ksrqg.getText().trim());
					ps.setString(6, jsrqg.getText().trim());
					ps.setString(7, jt.getText().trim());
					ps.setString(8,"��");
					ps.setString(9,"�ȴ����" );
					ps.execute();

					//new prompt();
					frame.removeNotify();
					JOptionPane.showMessageDialog(null, "�뵥��");
					new AddSucess();
				//  System.out.println("�ɹ�");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
  
			
			  File f = new File("d:\\student1.txt");
				//�ֽ������
				FileOutputStream fos=null;
				
				try {
					fos = new FileOutputStream(f);
				
					String s="����:"+"  "+xmg.getText()+"\r\n";
					String s1="ѧ��:"+"  "+xhg.getText()+"\r\n";
					String s2="רҵ:"+"  "+zyg.getText()+"\r\n";
					String s3="��ϵ:"+"  "+lxg.getText()+"\r\n";
					String s4="��ʼ:"+"  "+ksrqg.getText()+"\r\n";
					String s5="����:"+"  "+jsrqg.getText()+"\r\n";
					String s6 = "�������:"+"  "+jt.getText()+"\r\n";//���У�/r/n
					String s7="�����Ϣ���ύ,�ȴ����ͨ��"+"\r\n";
					//�����ֽ�����
					byte []btyes = new byte[10024];
					fos.flush();
					fos.write(s.getBytes());
					fos.write(s1.getBytes());
					fos.write(s2.getBytes());
					fos.write(s3.getBytes());
					fos.write(s4.getBytes());
					fos.write(s5.getBytes());
					fos.write(s6.getBytes());
					fos.write(s7.getBytes());
					fos.flush();
					
				} catch (Exception e1) {
					e1.printStackTrace();
					// TODO: handle exception
				}finally{
					try {
						fos.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "�ύ�ɹ�");
				xmg.setText("");
				xhg.setText("");
				zyg.setText("");
				lxg.setText("");
				ksrqg.setText("");
				jsrqg.setText("");
				jt.setText("");
				
				
				
			}  
		
		if(e.getSource().equals(jb3)){
			
			StudentLeaveRecord SLR=new StudentLeaveRecord();
			this.dispose();

		}  
		if(e.getSource().equals(jb2)){
			JOptionPane.showMessageDialog(null, "�Բ��𣬸ù���δ��ͨ");
		}  
		if(e.getSource().equals(jb1)){
			JOptionPane.showMessageDialog(null, "���Ѵ��ڵ�ǰ����");
		}  }
	}   
