package threetier.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DII implements DI {

	@Override
	public void getEmpDetailsFromDB(Integer deptid) {
		Connection con = null;
		Emp emp =new Emp();
		try {
			
			String freakjunk = 
					"select eno,ename,deptid  from emp  where deptid =  ? ";
			con=DbType.get();
			PreparedStatement stmt = con.prepareStatement(freakjunk);
						stmt.setInt(1, deptid);
						
					ResultSet rs = stmt.executeQuery();
					if(rs.next())
					{
						emp.setEno(rs.getInt("eno"));
						emp.setDeptid(deptid);
						emp.setEname(rs.getString("ename"));
						System.out.println(emp);
						while(rs.next())
						{
						emp.setEno(rs.getInt("eno"));
						emp.setEname(rs.getString("ename"));
						System.out.println(emp);
						
						}
					}
					else
						System.out.println("Deptid not found");
					
			
			
			
			stmt.close();
		
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println("id already taken, choose another id");
		}
		finally
		{
			try {
				if( con != null)
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
				
      
	}

}
