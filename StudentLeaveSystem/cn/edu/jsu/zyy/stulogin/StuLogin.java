package cn.edu.jsu.zyy.stulogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.zyy.connect.DatabaseConnectionSql;
import cn.edu.jsu.zyy.mainsurface.Mainsurface;
import cn.edu.jsu.zyy.register.AddUser;
import cn.edu.jsu.zyy.stusystem.StuInterface;

public class StuLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuLogin frame = new StuLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StuLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JTextField fieldAccount = new JTextField(1000);

		JPasswordField fieldPassword = new JPasswordField(1000);
		JButton jb1 = new JButton("登 录");
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnectionSql c = new DatabaseConnectionSql();

				Connection conn = c.getConnection();

				// 获取帐号
				String account = fieldAccount.getText();
				// 获取密码
				String pwd = new String(fieldPassword.getPassword());
				String flag = "学生";

				PreparedStatement ps = null;
				ResultSet rs = null;
				
				

				try {
					ps = conn.prepareStatement("select *from [user] where zh=? and mm=? and tag=?");

					ps.setString(1, account);
					ps.setNString(2, pwd);
					ps.setString(3, "学生");

					rs = ps.executeQuery();
					if (rs.next()) {
			            
						// 登录成功
						
							JOptionPane.showMessageDialog(null, "登录成功");
							dispose();
							setVisible(false);
							StuInterface s = new StuInterface();
							
						

					} else {
						// 登录失败
						JOptionPane pane = new JOptionPane("用户或密码错误");
						JDialog dialog = pane.createDialog("警告");
						dialog.show();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton jb2 = new JButton("\u9000 \u51FA");
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Mainsurface mf=new Mainsurface();
				mf.setVisible(true);
				mf.setResizable(false);
			}
		});

		JLabel label = new JLabel("    \u5E10 \u53F7:");
		JLabel label1 = new JLabel(" 密 码   ");
		JLabel label2 = new JLabel("请假系统登录界面");
		ButtonGroup bg = new ButtonGroup();

		this.setTitle("学生用户登录界面.....");
		this.setBounds(550, 200, 794, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setVisible(true);

		//jb2.addActionListener(this);

		jb1.setBackground(new Color(233, 240, 247));
		jb1.setForeground(Color.RED);
		jb2.setBackground(new Color(233, 240, 247));
		jb2.setForeground(Color.PINK);

		//JLabel label = new JLabel("    \u8D26 \u53F7:");

		label.setOpaque(false);
		label.setBounds(145, 165, 100, 50);

		label.setFont(new Font("华文行楷", Font.PLAIN, 20));

		jb1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 18));

		jb2.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 18));
		fieldAccount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		fieldAccount.setBackground(Color.LIGHT_GRAY);

		fieldAccount.setBorder(null);

		jb1.setOpaque(false);
		jb2.setOpaque(false);
		jb1.setBorder(null);
		jb2.setBorder(null);

		getContentPane().add(label);
		fieldAccount.setBounds(250, 163, 300, 50);
		getContentPane().add(fieldAccount);

		label1 = new JLabel("    \u5BC6 \u7801:");

		label1.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		label1.setFont(new Font("华文行楷", Font.PLAIN, 20));

		label1.setBounds(145, 250, 100, 50);
		getContentPane().add(label1);
		fieldPassword.setBackground(Color.LIGHT_GRAY);
		fieldPassword.setBounds(250, 252, 300, 50);
		fieldPassword.setBorder(null);
		getContentPane().add(fieldPassword);

		getContentPane().add(jb1);
		getContentPane().add(jb2);

		jb1.setBounds(250, 350, 59, 50);
		jb2.setBounds(491, 350, 59, 50);
		//jb1.addActionListener(this);
		label2.setForeground(Color.BLUE);

		label2.setBounds(300, 50, 200, 50);
		label2.setFont(new Font("华光大标宋_CNKI", Font.PLAIN, 20));
		getContentPane().add(label2);

		JButton jb1_1 = new JButton("\u6CE8 \u518C");
		jb1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddUser();
				dispose();
				//setVisible(false);
				//frame.setVisible(false);
			}
		});
		jb1_1.setOpaque(false);
		jb1_1.setForeground(Color.MAGENTA);
		jb1_1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 18));
		jb1_1.setBorder(null);
		jb1_1.setBackground(new Color(233, 240, 247));
		jb1_1.setBounds(371, 350, 59, 50);
		getContentPane().add(jb1_1);
		
		JLabel lblNewLabel = new JLabel("bg\r\n");
		lblNewLabel.setIcon(new ImageIcon("D:\\\u684C\u9762\u56FE\u7247\\a0350d54648796504dc60975ea01c92b.jpg"));
		lblNewLabel.setBounds(-28, 0, 808, 463);
		getContentPane().add(lblNewLabel);
		

		this.setVisible(true);
	}

}
