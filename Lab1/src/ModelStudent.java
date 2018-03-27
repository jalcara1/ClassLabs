
public class ModelStudent {
	
	private String code;
	private String name;
	private int age;
	private String career;
	
	public ModelStudent() {
		// TODO Auto-generated constructor stub
	}
	public ModelStudent(String code, String name, int age, String career) {
		this.code = code;
		this.name = name;
		this.age = age;
		this.career = career;
	}	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	@Override
	public String toString() {
		return this.code+", "+this.name+", "+this.age+", "+this.career;
	}
}
