package cn.edu.jsu.zyy.mainsurface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import cn.edu.jsu.zyy.stulogin.StuLogin;
import cn.edu.jsu.zyy.tchlogin.TchLogin;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Mainsurface extends JFrame{	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
//	private int i=0;

	public Mainsurface() 
	{ 
	setTitle("欢迎进入学生请假系统");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(600,470);
	this.setLocation(300,120);
	JPanel A=new JPanel();
	A.setBackground(Color.WHITE);
	ImageIcon im =new ImageIcon("D:\\桌面图片\\QQ浏览器截图\\QQ浏览器截图20210106213627.png");
    
    JLabel lblNewLabel_1_1 = new JLabel("\u4E3B\u529F\u80FD\u4E00\u89C8");
    lblNewLabel_1_1.setFont(new Font("华文琥珀", Font.PLAIN, 16));
    lblNewLabel_1_1.setBackground(Color.PINK);
    A.add(lblNewLabel_1_1);
    
    JMenuBar menuBar = new JMenuBar();
    A.add(menuBar);
    
    JMenu mnNewMenu = new JMenu("\u5B66\u751F");
    mnNewMenu.setBackground(Color.GREEN);
    mnNewMenu.setForeground(Color.DARK_GRAY);
    mnNewMenu.setFont(new Font("华光行楷_CNKI", Font.PLAIN, 15));
    menuBar.add(mnNewMenu);
    
    JButton btnNewButton_1 = new JButton("\u8BF7\u5047\u7533\u8BF7");
    mnNewMenu.add(btnNewButton_1);
    
    JButton btnNewButton = new JButton("\u9500\u5047\u7533\u8BF7");
    mnNewMenu.add(btnNewButton);
    
    JButton btnNewButton_2 = new JButton("\u67E5\u770B\u5B66\u751F\u8BF7\u5047\u8BB0\u5F55");
    mnNewMenu.add(btnNewButton_2);
    
    JMenu mnNewMenu_1 = new JMenu("\u8F85\u5BFC\u5458");
    mnNewMenu_1.setBackground(Color.ORANGE);
    mnNewMenu_1.setFont(new Font("华文行楷", Font.PLAIN, 15));
    A.add(mnNewMenu_1);
    
    JButton btnNewButton_3 = new JButton("\u5BA1\u6838\u8BF7\u5047");
    mnNewMenu_1.add(btnNewButton_3);
    
    JButton btnNewButton_5 = new JButton("\u5BA1\u6838\u9500\u5047");
    mnNewMenu_1.add(btnNewButton_5);
    
    JButton btnNewButton_4 = new JButton("\u67E5\u8BE2\u5B66\u751F\u8BF7\u5047\u8BB0\u5F55");
    mnNewMenu_1.add(btnNewButton_4);
    
    JButton btnNewButton_6_1 = new JButton("\u5220\u9664\u5B66\u751F\u8BF7\u5047\u8BB0\u5F55");
    mnNewMenu_1.add(btnNewButton_6_1);
    
    JButton btnNewButton_7_1 = new JButton("\u4FEE\u6539\u5B66\u751F\u8BF7\u5047\u8BB0\u5F55");
    mnNewMenu_1.add(btnNewButton_7_1);
    JLabel a=new JLabel(im);
	A.add(a);
	JPanel B=new JPanel(new BorderLayout());
	B.setBackground(Color.PINK);
    getContentPane().setLayout(null);
    JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,A,B);//分屏的方式：左右HORIZONTAL_SPLIT，上下VERTICAL_SPLIT
    jSplitPane.setBounds(0, 0, 586, 433);
    jSplitPane.setDividerLocation(300);//左边占的长度
    getContentPane().add(jSplitPane);
    jSplitPane.setDividerSize(0);//分界线的宽度 设置为0 即不显示出分界线
    A.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    B.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    
    JLabel w=new JLabel(" 我  是 ");
    JButton g=new JButton("辅导员");
    g.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    
    JPanel G=new JPanel();    
    G.setBackground(Color.ORANGE);
    G.add(g);
    g.setContentAreaFilled(false);
    
    JButton x=new JButton("学生");
    x.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    JPanel X=new JPanel();
    X.add(x);
    X.setBackground(Color.GREEN);
    x.setContentAreaFilled(false);
    
    B.add(w,BorderLayout.NORTH);
    w.setHorizontalAlignment(SwingConstants.CENTER);//居中
    w.setPreferredSize(new Dimension(0,150));//宽度150
    w.setFont(new Font("楷体",Font.PLAIN,25));
    B.add(X,BorderLayout.CENTER);
    B.add(G,BorderLayout.SOUTH);
    G.setPreferredSize(new Dimension(0,200));//宽度200
    
    x.addActionListener(new ActionListener()    //监听学生按钮
			{

		public void actionPerformed(ActionEvent e)
		{
			
              new StuLogin(); 
              
              setVisible(false);
		}
			});
    
    g.addActionListener(new ActionListener()   //监听管理员按钮
    		{
    	public void actionPerformed(ActionEvent e)
		{
              new TchLogin(); 
              setVisible(false);
		}
    		});
    
	}
	
	public static void main(String[] args)
	{		
		Mainsurface mf=new Mainsurface();
		mf.setVisible(true);
		mf.setResizable(false);
	}
//	public void removeVisible() {
//		if(i==1) {
//			this.setVisible(false);
//		}
//	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
	
	

