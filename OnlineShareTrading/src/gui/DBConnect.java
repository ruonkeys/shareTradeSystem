package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DBConnect {
	private Connection cn;
	private PreparedStatement ps;
	private ArrayList<Record> cmpnyList;
	public DBConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sharetrade","root","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int insertCmpnyDetails(CompanyDetails c)
	{
		int queryExecute=0;
		try
		{
		ps=(PreparedStatement) cn.prepareStatement("insert into companydetails(`cmpnyname`,`cmpnylogopath`,`cmpnycode`,`cmpnylink`,`address`," +
				"`sharetotal`,`sharecost`,`cmpnydescription`,`phone`)values(?,?,?,?,?,?,?,?,?);");
		ps.setString(1, c.getCmpnyName());
		ps.setString(2, c.getCmpnyLogoPath());
		ps.setInt(3, c.getCmpnyCode());
		ps.setString(4, c.getCmpnyLink());
		ps.setString(5, c.getAddress());
		ps.setInt(6, c.getShareTotal());
		ps.setInt(7, c.getShareCost());
		ps.setString(8, c.getCmpnyDescription());
		ps.setString(9, c.getPhone());
		queryExecute=ps.executeUpdate();
//		System.out.println("no of queries executed "+queryExecute);
		
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("select cmpnyid,sharecost,sharetotal from companydetails where cmpnyname = '"+c.getCmpnyName()+"';");
		rs.next();
		int id=rs.getInt(1);
		int cost=rs.getInt(2);
		int shareNum=rs.getInt(3);
//		System.out.println(id);
		int i=st.executeUpdate("insert into sharedate (`cmpnyid`,`date`,`sharecost`,`sharenum`)" +
				" values ("+id+",STR_TO_DATE('"+c.getDate()+"', '%d/%m/%Y'),"+cost+","+shareNum+");");
//		System.out.println("statement exe "+i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.println("reached");
			return 0;
		}
		finally
		{
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return queryExecute;
	}
	
	public int addMoreShares(CompanyShares c)
	{
		int queryExecute = 0;
		try
		{
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery("select cmpnyid,sharetotal from companydetails where cmpnycode = "+c.getCmpnyCode()+";");
		rs.next();
		int id = rs.getInt(1);
		int oldShares = rs.getInt(2);
		int newShares = oldShares+c.getShareTotal();
		queryExecute = st.executeUpdate("update companydetails set " +
				"sharetotal="+newShares+",sharecost="+c.getShareCost()+" where cmpnycode="+c.getCmpnyCode()+";");
		
		int i=st.executeUpdate("insert into sharedate (`cmpnyid`,`date`,`sharecost`,`sharenum`)" +
				" values ("+id+",STR_TO_DATE('"+c.getDate()+"', '%d/%m/%Y'),"+c.getShareCost()+","+c.getShareTotal()+");");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return queryExecute;
	}
	
	public List<Record> getCmpnyList()
	{
		cmpnyList = new ArrayList<Record>();
		try 
		{
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from companydetails ");
			while(rs.next())
			{
				Record rc = new Record(rs.getInt("cmpnyid"), rs.getString("cmpnyname"),rs.getString("cmpnylogopath"), 
						rs.getInt("cmpnycode"), rs.getString("cmpnylink"),
						rs.getString("address"), rs.getInt("sharetotal"),rs.getInt("sharecost"),
						rs.getString("cmpnydescription"),rs.getString("phone"));
				cmpnyList.add(rc);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cmpnyList;
	}
	
	public boolean deleteCmpny(int cmpnyCode)
	{
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs=st.executeQuery("select cmpnyid from companydetails where cmpnycode="+cmpnyCode+"; ");
			rs.next();
			int cmpnyId=rs.getInt(1);
			st.executeUpdate("delete from companydetails where cmpnyid="+cmpnyId+";");
			st.executeUpdate("delete from sharedate where cmpnyid="+cmpnyId+";");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public int updateDetails(GeneralDetails c, int cmpnyId)
	{
		int queryExecute=0;
		try
		{
			Statement st = cn.createStatement();
			queryExecute=st.executeUpdate("update companydetails set cmpnyname='"+c.getCmpnyName()+"'," +
					"cmpnylogopath='"+c.getCmpnyLogoPath()+"',cmpnycode="+c.getCmpnyCode()+",cmpnylink='"+c.getCmpnyLink()+"',address='"+c.getAddress()+"'," +
									"cmpnydescription='"+c.getCmpnyDescription()+"',phone='"+c.getPhone()+"'" +
											"where cmpnyid="+cmpnyId+";");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return queryExecute;
	}
	
	public ResultSet getDetails(int cmpnyId)
	{
		ResultSet rs = null;
		try
		{
			Statement st = cn.createStatement();
			rs = st.executeQuery("select * from companydetails where cmpnyid="+cmpnyId+";");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
