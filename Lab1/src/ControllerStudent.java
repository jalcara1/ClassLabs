import java.util.List;
import java.util.ArrayList;

public class ControllerStudent {
	private ViewStudent viewS = new ViewStudent(); 
	
	public ControllerStudent() {
		
	}
	//Call DAO Pattern to register student
	public void register(ModelStudent student) {
		IStudentDao dao = new ImplStudentDao();
		dao.register(student);
	}
	//Call DAO Pattern to update student
	public void update(ModelStudent student){
		IStudentDao dao = new ImplStudentDao();
		dao.update(student);
	}
	//Call DAO Pattern to delete student
	public void delete(ModelStudent student) {
		IStudentDao dao = new ImplStudentDao();
		dao.delete(student);
	}
	//Call DAO Pattern to show students
	public void showStudents() {
		List<ModelStudent> students = new ArrayList<ModelStudent>();
		IStudentDao dao = new ImplStudentDao();
		students = dao.getStudent();
		viewS.viewStudents(students);
	}
}
