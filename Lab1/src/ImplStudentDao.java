import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplStudentDao implements IStudentDao{
	@Override
	public boolean register(ModelStudent student) {
		boolean register = false;
		
		Statement stm = null;
		Connection con = null;
		
		String sql="INSERT INTO Lab1 VALUE ('"+student.getCode()+"','"+student.getName()+"','"+student.getAge()+"','"+student.getCareer()+"')";
		
		try {
			con = Connect.connect();
			stm = con.createStatement();
			stm.execute(sql);
			register = true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Class-> ImplStudentDao, Method-> regiter");
			e.printStackTrace();
		}
		return register;
	}
	@Override
	public List<ModelStudent> getStudents(){
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "SELECCT * FROM Student  ORDER BY age";
		
		List<ModelStudent> listStudent = new ArrayList<ModelStudent>();
		
		try {
			con = Connect.connect();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				ModelStudent student = new ModelStudent();
				student.setCode(rs.getString(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setCareer(rs.getString(4));
				listStudent.add(student);
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Class-> ImplStudentDao, Method-> getStudent");
			e.printStackTrace();
		}
		return listStudent;
	}
	@Override
	public boolean update(ModelStudent student) {
		Connection con = null;
		Statement stm = null;
		
		boolean update = false;
		String sql = "UPDATE Student SET code='"+student.getCode()+"', age='"+student.getAge()+"', career='"+student.getCareer()+"'" +" WHERE name="+student.getName();
		try {
			con = Connect.connect();
			stm = con.createStatement();
			stm.execute(sql);
			update = true;
		} catch (SQLException e) {
			System.out.println("Error: Class-> ImplStudentDao, Method-> update");
			e.printStackTrace();
		}
		return update;
	}
	@Override
	public boolean delete(ModelStudent student) {
		Connection con = null;
		Statement stm = null;
		
		boolean delete = false;
		String sql = "DELETE FROM Student WHERE name="+student.getName();
		try {
			con = Connect.connect();
			stm = con.createStatement();
			stm.execute(sql);
			delete = true;
		} catch (SQLException e) {
			System.out.println("Error: Class-> ImplStudentDao, Method-> delete");
			e.printStackTrace();
		}		
		return delete;
	}
}
