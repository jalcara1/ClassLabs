import java.util.List;

public class ViewStudent {
	public void viewStudent(ModelStudent student) {
		System.out.println("Student data " + student);
	}
	public void viewStudents(List<ModelStudent> students) {
		System.out.println("Students data");
		for(ModelStudent student : students) {
			System.out.println("Student data " + student);
		}		
	}
}
