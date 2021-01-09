package cn.edu.jsu.zyy.tchsystem;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TchSystem extends JFrame implements ActionListener{
 
	/**
	 *辅导员管理请假信息系统
	 */
 
	JButton jb1=new JButton("审核请假信息");
	JButton jb2=new JButton("审核销假信息");
	JButton jb3=new JButton("学生请假记录");
	
	JButton jb4=new JButton("退出");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TchSystem CS=new TchSystem();
	}
	
public TchSystem(){
	this.setTitle("辅导员管理请假信息系统");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setLayout(null);
	
	
	jb1.setOpaque(false);
	jb1.setFont(new Font("微软雅黑",Font.PLAIN,18));
	jb2.setOpaque(false);
	jb2.setFont(new Font("微软雅黑",Font.PLAIN,18));
	jb3.setOpaque(false);
	jb3.setFont(new Font("微软雅黑",Font.PLAIN,18));
	jb4.setOpaque(false);
	jb4.setFont(new Font("微软雅黑",Font.PLAIN,18));
	jb1.setBackground(new Color(233,240,247));
	jb2.setBackground(new Color(233,240,247));
    jb3.setBackground(new Color(233,240,247));
    jb4.setBackground(new Color(233,240,247));
 
 
	jb1.setBounds(5, 0, 233, 50);
	jb2.setBounds(236, 0, 223, 50);
	jb3.setBounds(457, 0, 223, 50);
	jb4.setBounds(457, 400, 223, 50);
	jb1.addActionListener(this);	
	jb2.addActionListener(this);	
	jb3.addActionListener(this);
	jb4.addActionListener(this);
    getContentPane().add(jb1);
    getContentPane().add(jb2);
    getContentPane().add(jb3);
    getContentPane().add(jb4);
    
    JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u4F60\u7684\u64CD\u4F5C");
    lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 60));
    lblNewLabel.setForeground(Color.PINK);
    lblNewLabel.setBounds(111, 143, 458, 143);
    getContentPane().add(lblNewLabel);
    this.setVisible(true);
}
 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  if(e.getSource().equals(jb4)){
				this.dispose();
			}  
	
		if(e.getSource().equals(jb3)){
			Show frame=new Show();
			frame.setLocationRelativeTo(null);// 窗体居中
			frame.setVisible(true);// 窗体可见
			this.removeNotify();
		}  
		if(e.getSource().equals(jb2)){
			JOptionPane.showMessageDialog(null, "对不起，该功能正在维护");
		}  
		if(e.getSource().equals(jb1)){
			//JOptionPane.showMessageDialog(null, "你已处于当前界面");
			TchInterface s1=new TchInterface();
			this.dispose();
		}  
	
	}
}
