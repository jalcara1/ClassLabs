import java.util.List;

public interface IStudentDao {
	//Methods to database access
	public boolean register(ModelStudent student);
	public List<ModelStudent> getStudent();
	public boolean update(ModelStudent student);
	public boolean delete(ModelStudent student);	
}
