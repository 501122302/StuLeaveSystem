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
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private JTextField txtKey;

	public static void main(String[] args) {
		Show frame = new Show();// 实例化窗体
		frame.setLocationRelativeTo(null);// 窗体居中
		frame.setVisible(true);// 窗体可见
	}

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	public Show() {
		setTitle("\u5B66\u751F\u8BF7\u5047\u8BB0\u5F55\u53CA\u72B6\u6001");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 1213, 746);// 设置窗体位置与大小
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(44, 82, 1116, 617);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "姓名","学号","专业","联系","开始日期","结束日期","请假事由","是否审核","审核状态");
		String sql="select * from stu";//定义查询语句
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// 从数据库中读取所有行数据

//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {//获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setRowSorter(sorter);//设置表格的排序器
		
		scrollPane.setViewportView(table);
		
		JLabel lblKey = new JLabel("输入关键字：");
		lblKey.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblKey.setBackground(Color.LIGHT_GRAY);
		lblKey.setForeground(Color.BLACK);
		lblKey.setBounds(44, 10, 138, 45);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		txtKey.setBounds(233, 10, 222, 45);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		//查找数据
		JButton btnFind = new JButton("查找");
		btnFind.setFont(new Font("华文行楷", Font.PLAIN, 20));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=txtKey.getText().trim();//获取输入关键字文本框的值
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
				}else {
					sorter.setRowFilter(null);//不过滤，显示所有数据
				}
				
			}
		});
		btnFind.setBounds(478, 10, 109, 45);
		contentPane.add(btnFind);
		
		//删除数据
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
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
		
		//修改数据
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("华文行楷", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "确定要修改数据吗？","",JOptionPane.YES_NO_OPTION) == 0)
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
		
		//增加数据
		JButton btnNewButton_2 = new JButton("\u589E\u52A0");
		btnNewButton_2.setFont(new Font("华文行楷", Font.PLAIN, 20));

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
		btnNewButton_2_1.setFont(new Font("华文行楷", Font.PLAIN, 20));
		btnNewButton_2_1.setBounds(1037, 10, 109, 44);
		contentPane.add(btnNewButton_2_1);
	}
}