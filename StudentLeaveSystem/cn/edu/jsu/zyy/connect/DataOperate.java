package cn.edu.jsu.zyy.connect;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.Vector;

import javax.swing.JOptionPane;

public class DataOperate {

	public static int getNum(int start, int end) {// 随机返回返回指定范围间的整数

		// Math.random()随机返回0.0至1.0之间的数

		return (int) (Math.random() * (end - start + 1) + start);

	}

	// 随机返回帐号

	public static StringBuilder getStuno() {// 不使用String，因为需要大量拼接字符串

		StringBuilder zh = new StringBuilder("2019");// 学号前7位相同

		StringBuilder zh1 = new StringBuilder(String.valueOf(getNum(1, 9999)));// 随机取后3位

		if (zh1.length() == 1) {

			zh1 = zh1.insert(0, "0000");// 如果是1位数，前面增加2个0

			zh = zh.append(zh1);// 前6位与后3位拼接成学号

		} else if (zh1.length() == 2) {

			zh1 = zh1.insert(0, "000");// 如果是2位数，前面增加1个0

			zh = zh.append(zh1);

		} else if (zh1.length() == 3) {

			zh1 = zh1.insert(0, "00");

			zh = zh.append(zh1);

		}else if (zh1.length() == 4) {

			zh1 = zh1.insert(0, "0");

			zh = zh.append(zh1);}

		else {

			zh = zh.append(zh1);

		}

		return zh;

	}
	
	
	
	
	public static StringBuilder getPw() {// 不使用String，因为需要大量拼接字符串

		

		StringBuilder mm = new StringBuilder(String.valueOf(getNum(1, 999)));// 随机取后3位

		if (mm.length() == 1) {

			mm = mm.insert(0, "000");// 如果是1位数，前面增加2个0

		

		} else if (mm.length() == 2) {

			mm = mm.insert(0, "00");// 如果是2位数，前面增加1个0

			

		} else if (mm.length() == 3) {

			mm = mm.insert(0, "0");

			
		}
		else {

			mm=mm;

		}

		return mm;

	}


	
	// 获取标识

	public static String getTag() {

		String tag = "";

		int sex = getNum(0, 1);

		if (sex == 0) {

			tag = "学生";

		}

		else

			tag = "辅导员";

		return tag;

	}
	
	
	
	
	
	

	public static void main(String[] args) {

		addCJ();

	}

	public static void addCJ() {// 增加成绩

		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// 使用1中定义的连接数据库的类

		String sql = "insert into [user](zh,mm,tag) values(?,?,?)";// 使用占位符定义插入语句

		try (Connection conn = dbcs.getConnection(); // 获取数据库接

				PreparedStatement pstmt = conn.prepareStatement(sql);) {// 实例化PreparedStatement

			ArrayList<String> alist = new ArrayList<String>();// 定义集合

			for (int i = 1; i <= 100;) {

				String zh = getStuno().toString();// 随机获取学号
				String mm=getPw().toString();

				if (!alist.contains(zh)) {// 判断学号是否唯一

					alist.add(zh);// 将学号加入集合

					String tag = getTag();

					
					pstmt.setString(1, zh);// 定义第1个占位符的内容

					pstmt.setString(2, mm);// 定义第2个占位符的内容

					pstmt.setString(3, tag);// 定义第3个占位符的内容

					
					pstmt.addBatch();

					i++;// 学号唯一，循环继续往下执行

				}

			}
			
			pstmt.executeBatch();// 批量执行插入操作

			JOptionPane.showMessageDialog(null, "sucess");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public static Vector<Vector> getSelectAll(String sql) {

		Vector<Vector> rows = new Vector<Vector>();// 定义要返回的所有记录集合

		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// 使用1中定义的连接数据库的类

		try (Connection conn = dbcs.getConnection(); // 获取数据库接

				PreparedStatement pstmt = conn.prepareStatement(sql);) {// 实例化PreparedStatement

			ResultSet rs = pstmt.executeQuery();// 执行查询语句，结果放到数据集中

			while (rs.next()) {// 遍历数据集

				Vector row = new Vector();// 定义行数据

				row.add(rs.getString(1));// 获取第一个字段学号

				row.add(rs.getString(2));// 获取第二个字段姓名

				row.add(rs.getString(3));// 获取第三个字段性别

			

				rows.add(row);// 将行数据添加到记录集合中

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return rows;// 返回所有行数据

	}

}