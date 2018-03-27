public class CrudDemo {
	public static void main(String[] args) {
		
		ModelStudent student = new ModelStudent("1023254381", "201520094001", "Jesus Liberio", 16, "Finanzas");
		
		//Controller
		ControllerStudent controller = new ControllerStudent();
		//Save student throught the controller
		controller.register(student);
		//See students
		controller.showStudents();
		//Student update by Age
		student.setId("1018257927");
		student.setName("Jarlan Moreco");
		controller.update(student);
		//See updates
		controller.showStudents();
		//Delete Student by Age
		student.setId("1018257927");
		controller.delete(student);
	}	
}
