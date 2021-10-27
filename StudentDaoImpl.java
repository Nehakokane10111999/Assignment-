package student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDAO{
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Student s=null;
	List<Student> slist=null;
	
	@Override
	public boolean addStudent(Student s) {
		con=DBConnectivity.getConnection();
		sql="insert into STUDENT values (?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			//setting values into the questions marks with the help of preparedStatement set methods
			ps.setInt(1, s.getSTUDENT_NO());
			ps.setString(2, s.getSTUDENT_NAME());
			ps.setDate(3,Date.valueOf(s.getSTUDENT_DOB()));
			ps.setDate(4,Date.valueOf(s.getSTUDENT_DOJ()));
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		con=DBConnectivity.getConnection();
		sql="update STUDENT set STUDENT_NAME=?, STUDENT_DOB=?,STUDENT_DOJ=? where STUDENT_NO=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, s.getSTUDENT_NAME());
			ps.setDate(2,Date.valueOf(s.getSTUDENT_DOB()));
			ps.setDate(3,Date.valueOf(s.getSTUDENT_DOJ()));
			ps.setInt(4, s.getSTUDENT_NO());
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	
		return false;
	}

	@Override
	public boolean deleteStudent(int STUDENT_NO) {
		con=DBConnectivity.getConnection();
		sql="delete from STUDENT where STUDENT_NO=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, STUDENT_NO);
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

		return false;
	}

	@Override
	public Student showStudentbyId(int STUDENT_NO) {
		con=DBConnectivity.getConnection();
		sql="select * from STUDENT where STUDENT_NO=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,STUDENT_NO);
			
			rs=ps.executeQuery();
			while(rs.next()){
				s=new Student();
				s.setSTUDENT_NO(rs.getInt(1));
				s.setSTUDENT_NAME(rs.getString(2));
				s.setSTUDENT_DOB(rs.getDate(3).toLocalDate());
				s.setSTUDENT_DOJ(rs.getDate(4).toLocalDate());
				
				return s;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

		return null;
	}

	@Override
	public List<Student> showAllStudents() {
		con=DBConnectivity.getConnection();
		sql="select * from STUDENT";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			slist=new ArrayList<>();
			while(rs.next()){
				s=new Student();
				s.setSTUDENT_NO(rs.getInt(1));
				s.setSTUDENT_NAME(rs.getString(2));
				s.setSTUDENT_DOB(rs.getDate(3).toLocalDate());
				s.setSTUDENT_DOJ(rs.getDate(4).toLocalDate());
				slist.add(s);
				
			}
			return slist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return null;
	}

}
