package cn.edu.jsu.zyy.tchsystem;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
 
import javax.swing.*;
public class TchInterface extends JFrame implements ActionListener{
 
	/**
	 * ����Ա�鿴ѧ�������Ϣģ��
	 */
 
	JButton jb1=new JButton("��������Ϣ");
	JButton jb2=new JButton("���������Ϣ");
	JButton jb3=new JButton("ѧ����ټ�¼");
	JButton jb4=new JButton("ͨ�����");
	JButton jb6=new JButton("��˲�ͨ��");
	JButton jb5=new JButton("�˳�");
	JTextArea jt=new JTextArea();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		TchInterface s1=new TchInterface();
	}

public TchInterface(){
	this.setTitle("����Ա���������Ϣϵͳ");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(null);
	
	
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
	jb6.setOpaque(false);
	jb6.setFont(new Font("΢���ź�",Font.PLAIN,18));
	jb1.setBackground(new Color(233,240,247));
	jb2.setBackground(new Color(233,240,247));
    jb3.setBackground(new Color(233,240,247));
    jb4.setBackground(new Color(233,240,247));
    jb5.setBackground(new Color(233,240,247));
    jb6.setBackground(new Color(233,240,247));
 
 
 
	jb1.setBounds(5, 0, 233, 50);
	jb2.setBounds(236, 0, 223, 50);
	jb3.setBounds(457, 0, 223, 50);
	jb4.setBounds(230, 400, 223, 50);
	jb5.setBounds(450, 400, 223, 50);
	jb6.setBounds(10, 400, 223, 50);
	
	
	jt.setBounds(30,80,620,300);
	jt.setEditable(false);//����ı������ⲿ����
	 jt.setFont(new Font("΢���ź�",Font.PLAIN,18));
	jb1.addActionListener(this);	
	jb2.addActionListener(this);	
	jb3.addActionListener(this);
	jb4.addActionListener(this);
	jb5.addActionListener(this);
	jb6.addActionListener(this);
	
    this.add(jb1);
    this.add(jb2);
    this.add(jb3);
    this.add(jb4);
    this.add(jb5);
    this.add(jb6);
    this.add(jt);
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
		  if(e.getSource().equals(jb5)){
				this.dispose();
			}  
		
		if(e.getSource().equals(jb3)){this.dispose();
			Show s=new Show();
			s.setLocationRelativeTo(null);// �������
			s.setVisible(true);// ����ɼ�
			this.removeNotify();
			
		}  
		if(e.getSource().equals(jb2)){
			JOptionPane.showMessageDialog(null, "�Բ��𣬸ù�������ά����ͨ");
		}  
		if(e.getSource().equals(jb1)){
			JOptionPane.showMessageDialog(null, "���Ѵ��ڵ�ǰ����");
		}  
		if(e.getSource().equals(jb4)){
			JOptionPane.showMessageDialog(null, "������");
			  File f = new File("d:\\student1.txt");
			  File f1 = new File("d:\\student2.txt");
			//�ֽ������
			FileOutputStream fos=null;
			FileOutputStream fos1=null;
			
			try {
				fos = new FileOutputStream(f);
				fos1 = new FileOutputStream(f1);
			
					String s1 = jt.getText()+"\r\n";//���У�/r/n
					String s2 = "���״̬:"+"  "+"��ͨ�����";
					String s3=jt.getText()+"\r\n";
				//�����ֽ�����
				byte []btyes = new byte[10024];
				
			
				fos.write(s1.getBytes());
				fos.write(s2.getBytes());
				fos1.write(s3.getBytes());
				fos1.write(s2.getBytes());
				
			} catch (Exception e1) {
				e1.printStackTrace();
				// TODO: handle exception
			}finally{
				try {
					fos.close();
					fos1.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		//	JOptionPane.showMessageDialog(null, "�ύ�ɹ�");
		
		
			
			jt.setText("");
		}  
		if(e.getSource().equals(jb6)){
			JOptionPane.showMessageDialog(null, "�����Ϣ������");
			  File f = new File("d:\\student1.txt");
			
			//�ֽ������
			FileOutputStream fos=null;
		
			try {
				fos = new FileOutputStream(f);
			
			
					String s1 = jt.getText()+"\r\n";//���У�/r/n
					String s2 = "���״̬:"+"  "+"��˲�ͨ�������ʧ��";
					
				//�����ֽ�����
				byte []btyes = new byte[10024];
				
			
				fos.write(s1.getBytes());
				fos.write(s2.getBytes());
			
				
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
			jt.setText("");
			}}}
	
	}
 
