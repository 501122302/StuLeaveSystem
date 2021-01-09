package cn.edu.jsu.zyy.tchsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.jsu.zyy.connect.DatabaseConnectionSql;

public class DataOperate {
	private static String firstName = "��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	// ����Ů������
	private static String girl = "���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	// ������������
	private static String boy = "ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
	public static int getNum(int i,int j) {
		return (int) (Math.random()*(j-i+1)+i);
	}
	public static StringBuilder getStuno() {
		StringBuilder s=new StringBuilder("2019401");
		StringBuilder xh=new StringBuilder(String.valueOf(getNum(0, 999)));
		if(xh.length()==1) {
			xh.insert(0,"00");
		}else if(xh.length()==2) {
			xh.insert(0,"0");
		}
		s.append(xh);
		return s;
	}
	public static String getChineseName() {
		String first,second,three;
		three="";
		int index=getNum(0, firstName.length()-1);
		first=firstName.substring(index,index+1);
		int way=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(way==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0, str.length()-1);
        second=str.substring(index,index+1);
        if(getNum(0,1)==1) {
        	index=getNum(0, str.length()-1);
            three=str.substring(index,index+1);
        }
		return first+second+three;
	}
	public static String getWay() {
		String way="QQ";
		if(getNum(0,1)==1) {
			way="WX";
		}
		return way;
	}
	//�õ����ݿ��������Ϣ
	public static Vector<Vector> getRow() throws SQLException{
		Vector<Vector> rows=new Vector<>();
		String sql="select * from stu";
		DatabaseConnectionSql d=new DatabaseConnectionSql();
		Connection c=(Connection) d.getConnection();
		PreparedStatement p=c.prepareStatement(sql);
		ResultSet r=p.executeQuery();
		while(r.next()) {
			Vector row=new Vector<>();
			Collections.addAll(row, r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getInt(5),r.getInt(6),r.getString(7),r.getString(8),r.getString(9));
			rows.add(row);
		}
		return rows;
	}
	 public static void main(String[] args) {
	    	addCJ();
	    }
	    public static void addCJ() {//���ӳɼ�
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	String sql="insert into stu(xmg,xhg,zyg,lxg,ksrqg,jsrqg,jt,tf,shzt) values(?,?,?,?,?,?,?,?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	        	ArrayList<String> alist=new ArrayList<String>();//���弯��
	    		for(int i=1;i<=300;) {
	    			String xh=getStuno().toString();//�����ȡѧ��
	    			if(!alist.contains(xh)) {//�ж�ѧ���Ƿ�Ψһ
	    				alist.add(xh);//��ѧ�ż��뼯��
	    				String xm=getChineseName();//�����ȡ����
	    				int zy=getNum(50, 100);//�����ȡ�ɼ�
	    				String way = getWay();
	    				pstmt.setString(1, xh);//�����1��ռλ��������
	    	    		pstmt.setString(2, xm);//�����2��ռλ��������
	    	    		pstmt.setString(3, "�������");//�����3��ռλ��������
	    	    		
	    	    		pstmt.setString(4, way);
	    	    		pstmt.setInt(5, zy);
	    	    		pstmt.setInt(6, zy);
	    	    		pstmt.setString(7, xm);
	    	    		pstmt.setString(8, "��");
	    	    		pstmt.setString(9, "�ȴ����");
	    	    		
	    	    		pstmt.addBatch();//����������ȴ�ִ��
	    				i++;//ѧ��Ψһ��ѭ����������ִ��
	    			}
	    		}
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "sucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			Vector row=new Vector();//����������
	    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ѧ��
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
	    			row.add(rs.getString(3));
	    			row.add(rs.getString(4));
	    			row.add(rs.getInt(5));//��ȡ�������ֶγɼ�
	    			row.add(rs.getInt(6));
	    			row.add(rs.getString(7));
	    			row.add(rs.getString(8));
	    			row.add(rs.getString(9));
	    			
	    			
	    			rows.add(row);//����������ӵ���¼������
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//��������������
	    }

}


