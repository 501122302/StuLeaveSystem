package cn.edu.jsu.zyy.connect;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.Vector;

import javax.swing.JOptionPane;

public class DataOperate {

	public static int getNum(int start, int end) {// ������ط���ָ����Χ�������

		// Math.random()�������0.0��1.0֮�����

		return (int) (Math.random() * (end - start + 1) + start);

	}

	// ��������ʺ�

	public static StringBuilder getStuno() {// ��ʹ��String����Ϊ��Ҫ����ƴ���ַ���

		StringBuilder zh = new StringBuilder("2019");// ѧ��ǰ7λ��ͬ

		StringBuilder zh1 = new StringBuilder(String.valueOf(getNum(1, 9999)));// ���ȡ��3λ

		if (zh1.length() == 1) {

			zh1 = zh1.insert(0, "0000");// �����1λ����ǰ������2��0

			zh = zh.append(zh1);// ǰ6λ���3λƴ�ӳ�ѧ��

		} else if (zh1.length() == 2) {

			zh1 = zh1.insert(0, "000");// �����2λ����ǰ������1��0

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
	
	
	
	
	public static StringBuilder getPw() {// ��ʹ��String����Ϊ��Ҫ����ƴ���ַ���

		

		StringBuilder mm = new StringBuilder(String.valueOf(getNum(1, 999)));// ���ȡ��3λ

		if (mm.length() == 1) {

			mm = mm.insert(0, "000");// �����1λ����ǰ������2��0

		

		} else if (mm.length() == 2) {

			mm = mm.insert(0, "00");// �����2λ����ǰ������1��0

			

		} else if (mm.length() == 3) {

			mm = mm.insert(0, "0");

			
		}
		else {

			mm=mm;

		}

		return mm;

	}


	
	// ��ȡ��ʶ

	public static String getTag() {

		String tag = "";

		int sex = getNum(0, 1);

		if (sex == 0) {

			tag = "ѧ��";

		}

		else

			tag = "����Ա";

		return tag;

	}
	
	
	
	
	
	

	public static void main(String[] args) {

		addCJ();

	}

	public static void addCJ() {// ���ӳɼ�

		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// ʹ��1�ж�����������ݿ����

		String sql = "insert into [user](zh,mm,tag) values(?,?,?)";// ʹ��ռλ������������

		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��

				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����PreparedStatement

			ArrayList<String> alist = new ArrayList<String>();// ���弯��

			for (int i = 1; i <= 100;) {

				String zh = getStuno().toString();// �����ȡѧ��
				String mm=getPw().toString();

				if (!alist.contains(zh)) {// �ж�ѧ���Ƿ�Ψһ

					alist.add(zh);// ��ѧ�ż��뼯��

					String tag = getTag();

					
					pstmt.setString(1, zh);// �����1��ռλ��������

					pstmt.setString(2, mm);// �����2��ռλ��������

					pstmt.setString(3, tag);// �����3��ռλ��������

					
					pstmt.addBatch();

					i++;// ѧ��Ψһ��ѭ����������ִ��

				}

			}
			
			pstmt.executeBatch();// ����ִ�в������

			JOptionPane.showMessageDialog(null, "sucess");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public static Vector<Vector> getSelectAll(String sql) {

		Vector<Vector> rows = new Vector<Vector>();// ����Ҫ���ص����м�¼����

		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// ʹ��1�ж�����������ݿ����

		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��

				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����PreparedStatement

			ResultSet rs = pstmt.executeQuery();// ִ�в�ѯ��䣬����ŵ����ݼ���

			while (rs.next()) {// �������ݼ�

				Vector row = new Vector();// ����������

				row.add(rs.getString(1));// ��ȡ��һ���ֶ�ѧ��

				row.add(rs.getString(2));// ��ȡ�ڶ����ֶ�����

				row.add(rs.getString(3));// ��ȡ�������ֶ��Ա�

			

				rows.add(row);// ����������ӵ���¼������

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return rows;// ��������������

	}

}