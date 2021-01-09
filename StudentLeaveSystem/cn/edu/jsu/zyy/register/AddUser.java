package cn.edu.jsu.zyy.register;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.edu.jsu.zyy.mainsurface.Mainsurface;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;

public class AddUser {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser window = new AddUser();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddUser() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.getContentPane().setForeground(Color.PINK);
		frame.setResizable(false);
		frame.setBackground(Color.PINK);
		frame.setTitle("\u6CE8\u518C\u754C\u9762...");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\\u684C\u9762\u56FE\u7247\\QQ\u6D4F\u89C8\u5668\u622A\u56FE\\QQ\u6D4F\u89C8\u5668\u622A\u56FE20210106212653.png"));
		frame.setBounds(400, 200, 431, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(132, 56, 54, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ÃÜÂë£º");
		lblNewLabel_1.setBounds(132, 87, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(196, 53, 100, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(196, 84,100, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("×¢²á");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
					//frame.removeNotify();
					new AddSucess();
			}
		});
		btnNewButton.setBounds(81, 169, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton returnButton = new JButton("·µ»Ø");
		returnButton.setBackground(Color.ORANGE);
		returnButton.setForeground(Color.BLACK);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Mainsurface mf=new Mainsurface();
				mf.setVisible(true);
				mf.setResizable(false);
				frame.dispose();

			}
		});
		returnButton.setBounds(251, 169, 93, 23);
		frame.getContentPane().add(returnButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u8EAB\u4EFD\uFF1A");
		lblNewLabel_2.setBounds(132, 118, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(196, 115, 100, 21);
		frame.getContentPane().add(textField_2);

	}
}
