public class CrudDemo {
	public static void main(String[] args) {
		
		ModelStudent student = new ModelStudent("201810034010", "Julio Mirlo", 17 , "Economia");
		
		//Controller
		ControllerStudent controller = new ControllerStudent();
		//Save student throught the controller
		controller.register(student);
		//See students
		controller.showStudents();
		//Student update by Age
		student.setAge(1);
		student.setName("Kike");
		controller.update(student);
		//Delete Student by Age
		student.setAge(1);
		controller.delete(student);
	}	
}
