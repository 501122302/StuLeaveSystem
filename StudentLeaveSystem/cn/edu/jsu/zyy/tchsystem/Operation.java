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
	
   
	//删除表格里的数据
	public static void deleteTable(JTable table,DefaultTableModel model) throws SQLException {
		if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
			  if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？","",JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
			    model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
			    //从表格数据中删除行,model1为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
			    deleteData(table,model);
			  } else {
			    JOptionPane.showMessageDialog(null, "请选择要删除的行");
			  }
			}	
}
	//删除数据库的数据
    public static void deleteData(JTable table,DefaultTableModel model) throws SQLException {
        try {         
            conn=new DatabaseConnectionSql().getConnection();
            String sql1="delete from stu";
            String sql2="insert into stu(xmg,xhg,zyg,lxg,ksrqg,jsrqg,jt,tf,shzt) values(?,?,?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql1);
            pstmt.executeUpdate();
            pstmt2=conn.prepareStatement(sql2);
        	for (int i = 0; i < model.getRowCount(); i++) {// 遍历表格数据
        		xmg=model.getValueAt(i, 0).toString();
        		
        		xhg=model.getValueAt(i, 1).toString();
        		zyg=model.getValueAt(i, 2).toString();
        		lxg=model.getValueAt(i, 3).toString();
        		ksrqg=(Integer) model.getValueAt(i, 4);
        		jsrqg=(Integer) model.getValueAt(i, 5);
        		jt=model.getValueAt(i, 6).toString();
        		tf=model.getValueAt(i, 7).toString();
        		shzt=model.getValueAt(i, 8).toString();
        		
        		
    			pstmt2.setString(1, xhg);//定义第1个占位符的内容
          		pstmt2.setString(2, xhg);//定义第2个占位符的内容
        		pstmt2.setString(3, zyg);//定义第3个占位符的内容
        		pstmt2.setString(4, lxg);//定义第4个占位符的内容
        		pstmt2.setInt(5, ksrqg);//定义第5个占位符的内容
        		pstmt2.setInt(6, jsrqg);
        		pstmt2.setString(7, jt);
        		pstmt2.setString(8, tf);
        		pstmt2.setString(9, shzt);
        		
        		pstmt2.addBatch();//加入批处理等待执行
        	}
        	pstmt2.executeBatch();//批量执行插入操作
        	JOptionPane.showMessageDialog(null, "删除成功");
        } finally {
        	pstmt.close();
            pstmt2.close();
            conn.close();
        }
    }
   
    //修改数据库的数据
    public static void updata(JTable table,DefaultTableModel model) throws SQLException {

        try {         
            conn=new DatabaseConnectionSql().getConnection();
            String sql1="delete from stu";
            String sql2="insert into stu(xmg,xhg,zyg,lxg,ksrqg,jsrqg,jt,tf,shzt) values(?,?,?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql1);
            pstmt.executeUpdate();
            pstmt2=conn.prepareStatement(sql2);
        	for (int i = 0; i < model.getRowCount(); i++) {// 遍历表格数据
xmg=model.getValueAt(i, 0).toString();
        		
        		xhg=model.getValueAt(i, 1).toString();
        		zyg=model.getValueAt(i, 2).toString();
        		lxg=model.getValueAt(i, 3).toString();
        		ksrqg=(Integer) model.getValueAt(i, 4);
        		jsrqg=(Integer) model.getValueAt(i, 5);
        		jt=model.getValueAt(i, 6).toString();
        		tf=model.getValueAt(i, 7).toString();
        		shzt=model.getValueAt(i, 8).toString();
        		pstmt2.setString(1, xhg);//定义第1个占位符的内容
          		pstmt2.setString(2, xhg);//定义第2个占位符的内容
        		pstmt2.setString(3, zyg);//定义第3个占位符的内容
        		pstmt2.setString(4, lxg);//定义第4个占位符的内容
        		pstmt2.setInt(5, ksrqg);//定义第5个占位符的内容
        		pstmt2.setInt(6, jsrqg);
        		pstmt2.setString(7, jt);
        		pstmt2.setString(8, tf);
        		pstmt2.setString(9, shzt);
        		pstmt2.addBatch();//加入批处理等待执行
        	}
        	pstmt2.executeBatch();//批量执行插入操作
        	JOptionPane.showMessageDialog(null, "修改成功");
        } finally {
        	pstmt.close();
            pstmt2.close();
            conn.close();
        }
    }
	
}