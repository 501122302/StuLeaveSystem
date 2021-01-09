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
	private static String firstName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
	// 定义女生的名
	private static String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
	// 定义男生的名
	private static String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
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
		int way=getNum(0,1);//随机取性别，例如1为男生，0为女生
        String str=boy;//定义名字为男生字符串
        int length=boy.length();//获取男生字符串的长度
        if(way==0){//如果随机获取为0，则名字改为女生
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
	//得到数据库里面的信息
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
	    public static void addCJ() {//增加成绩
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	String sql="insert into stu(xmg,xhg,zyg,lxg,ksrqg,jsrqg,jt,tf,shzt) values(?,?,?,?,?,?,?,?,?)";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	        	ArrayList<String> alist=new ArrayList<String>();//定义集合
	    		for(int i=1;i<=300;) {
	    			String xh=getStuno().toString();//随机获取学号
	    			if(!alist.contains(xh)) {//判断学号是否唯一
	    				alist.add(xh);//将学号加入集合
	    				String xm=getChineseName();//随机获取姓名
	    				int zy=getNum(50, 100);//随机获取成绩
	    				String way = getWay();
	    				pstmt.setString(1, xh);//定义第1个占位符的内容
	    	    		pstmt.setString(2, xm);//定义第2个占位符的内容
	    	    		pstmt.setString(3, "软件工程");//定义第3个占位符的内容
	    	    		
	    	    		pstmt.setString(4, way);
	    	    		pstmt.setInt(5, zy);
	    	    		pstmt.setInt(6, zy);
	    	    		pstmt.setString(7, xm);
	    	    		pstmt.setString(8, "否");
	    	    		pstmt.setString(9, "等待审核");
	    	    		
	    	    		pstmt.addBatch();//加入批处理等待执行
	    				i++;//学号唯一，循环继续往下执行
	    			}
	    		}
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "sucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			Vector row=new Vector();//定义行数据
	    			row.add(rs.getString(1));//获取第一个字段学号
	    			row.add(rs.getString(2));//获取第二个字段姓名
	    			row.add(rs.getString(3));
	    			row.add(rs.getString(4));
	    			row.add(rs.getInt(5));//获取第三个字段成绩
	    			row.add(rs.getInt(6));
	    			row.add(rs.getString(7));
	    			row.add(rs.getString(8));
	    			row.add(rs.getString(9));
	    			
	    			
	    			rows.add(row);//将行数据添加到记录集合中
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//返回所有行数据
	    }

}


