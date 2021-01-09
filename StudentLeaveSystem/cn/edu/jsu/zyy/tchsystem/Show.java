package cn.edu.jsu.zyy.tchsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class Show extends JFrame {
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private JTextField txtKey;

	public static void main(String[] args) {
		Show frame = new Show();// ʵ��������
		frame.setLocationRelativeTo(null);// �������
		frame.setVisible(true);// ����ɼ�
	}

	/**
	 * ���幹�췽���������弰���.
	 */
	public Show() {
		setTitle("\u5B66\u751F\u8BF7\u5047\u8BB0\u5F55\u53CA\u72B6\u6001");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 1213, 746);// ���ô���λ�����С
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 82, 1116, 617);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "����","ѧ��","רҵ","��ϵ","��ʼ����","��������","�������","�Ƿ����","���״̬");
		String sql="select * from stu";//�����ѯ���
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// �����ݿ��ж�ȡ����������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setRowSorter(sorter);//���ñ���������
		
		scrollPane.setViewportView(table);
		
		JLabel lblKey = new JLabel("����ؼ��֣�");
		lblKey.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		lblKey.setBackground(Color.LIGHT_GRAY);
		lblKey.setForeground(Color.BLACK);
		lblKey.setBounds(44, 10, 138, 45);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		txtKey.setBounds(233, 10, 222, 45);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		//��������
		JButton btnFind = new JButton("����");
		btnFind.setFont(new Font("�����п�", Font.PLAIN, 20));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=txtKey.getText().trim();//��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//�Ƿ����������ֵ
				}else {
					sorter.setRowFilter(null);//�����ˣ���ʾ��������
				}
				
			}
		});
		btnFind.setBounds(478, 10, 109, 45);
		contentPane.add(btnFind);
		
		//ɾ������
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setFont(new Font("�����п�", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Operation().deleteTable(table, model);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(746, 10, 109, 45);
		contentPane.add(btnNewButton);
		
		//�޸�����
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("�����п�", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�޸�������","",JOptionPane.YES_NO_OPTION) == 0)
				try {
					new Operation().updata(table, model);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(893, 10, 109, 45);
		contentPane.add(btnNewButton_1);
		
		//��������
		JButton btnNewButton_2 = new JButton("\u589E\u52A0");
		btnNewButton_2.setFont(new Font("�����п�", Font.PLAIN, 20));

		btnNewButton_2.setBounds(609, 10, 109, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				TchSystem CS = new TchSystem();
				dispose();
				
			}
		});
		btnNewButton_2_1.setFont(new Font("�����п�", Font.PLAIN, 20));
		btnNewButton_2_1.setBounds(1037, 10, 109, 44);
		contentPane.add(btnNewButton_2_1);
	}
}