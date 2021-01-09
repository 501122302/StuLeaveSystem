package cn.edu.jsu.zyy.tchsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.zyy.connect.DatabaseConnectionSql;



public class Operation {

	private static Connection conn=null;
	private static PreparedStatement pstmt=null;
	private static PreparedStatement pstmt2=null;
	private static String xmg;
	
	private static String xhg;
	private static String zyg;
	private static String lxg;
	private static int ksrqg;
	private static int jsrqg;
	private static String jt;
	private static String tf;
	private static String shzt;
	
   
	//ɾ������������
	public static void deleteTable(JTable table,DefaultTableModel model) throws SQLException {
		if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
			  if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������","",JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
			    model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
			    //�ӱ��������ɾ����,model1ΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
			    deleteData(table,model);
			  } else {
			    JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
			  }
			}	
}
	//ɾ�����ݿ������
    public static void deleteData(JTable table,DefaultTableModel model) throws SQLException {
        try {         
            conn=new DatabaseConnectionSql().getConnection();
            String sql1="delete from stu";
            String sql2="insert into stu(xmg,xhg,zyg,lxg,ksrqg,jsrqg,jt,tf,shzt) values(?,?,?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql1);
            pstmt.executeUpdate();
            pstmt2=conn.prepareStatement(sql2);
        	for (int i = 0; i < model.getRowCount(); i++) {// �����������
        		xmg=model.getValueAt(i, 0).toString();
        		
        		xhg=model.getValueAt(i, 1).toString();
        		zyg=model.getValueAt(i, 2).toString();
        		lxg=model.getValueAt(i, 3).toString();
        		ksrqg=(Integer) model.getValueAt(i, 4);
        		jsrqg=(Integer) model.getValueAt(i, 5);
        		jt=model.getValueAt(i, 6).toString();
        		tf=model.getValueAt(i, 7).toString();
        		shzt=model.getValueAt(i, 8).toString();
        		
        		
    			pstmt2.setString(1, xhg);//�����1��ռλ��������
          		pstmt2.setString(2, xhg);//�����2��ռλ��������
        		pstmt2.setString(3, zyg);//�����3��ռλ��������
        		pstmt2.setString(4, lxg);//�����4��ռλ��������
        		pstmt2.setInt(5, ksrqg);//�����5��ռλ��������
        		pstmt2.setInt(6, jsrqg);
        		pstmt2.setString(7, jt);
        		pstmt2.setString(8, tf);
        		pstmt2.setString(9, shzt);
        		
        		pstmt2.addBatch();//����������ȴ�ִ��
        	}
        	pstmt2.executeBatch();//����ִ�в������
        	JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
        } finally {
        	pstmt.close();
            pstmt2.close();
            conn.close();
        }
    }
   
    //�޸����ݿ������
    public static void updata(JTable table,DefaultTableModel model) throws SQLException {

        try {         
            conn=new DatabaseConnectionSql().getConnection();
            String sql1="delete from stu";
            String sql2="insert into stu(xmg,xhg,zyg,lxg,ksrqg,jsrqg,jt,tf,shzt) values(?,?,?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql1);
            pstmt.executeUpdate();
            pstmt2=conn.prepareStatement(sql2);
        	for (int i = 0; i < model.getRowCount(); i++) {// �����������
xmg=model.getValueAt(i, 0).toString();
        		
        		xhg=model.getValueAt(i, 1).toString();
        		zyg=model.getValueAt(i, 2).toString();
        		lxg=model.getValueAt(i, 3).toString();
        		ksrqg=(Integer) model.getValueAt(i, 4);
        		jsrqg=(Integer) model.getValueAt(i, 5);
        		jt=model.getValueAt(i, 6).toString();
        		tf=model.getValueAt(i, 7).toString();
        		shzt=model.getValueAt(i, 8).toString();
        		pstmt2.setString(1, xhg);//�����1��ռλ��������
          		pstmt2.setString(2, xhg);//�����2��ռλ��������
        		pstmt2.setString(3, zyg);//�����3��ռλ��������
        		pstmt2.setString(4, lxg);//�����4��ռλ��������
        		pstmt2.setInt(5, ksrqg);//�����5��ռλ��������
        		pstmt2.setInt(6, jsrqg);
        		pstmt2.setString(7, jt);
        		pstmt2.setString(8, tf);
        		pstmt2.setString(9, shzt);
        		pstmt2.addBatch();//����������ȴ�ִ��
        	}
        	pstmt2.executeBatch();//����ִ�в������
        	JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
        } finally {
        	pstmt.close();
            pstmt2.close();
            conn.close();
        }
    }
	
}