package QuanLySinhVien_GiaoVien;

public class Student extends Person {
	private String id_student;
	private float avg_mark;
	private String email;
	// contructor
	public Student() {
		super();
	}

	public Student(String name, String dOb, String address, String id_student, float avg_mark, String email) {
		super(name, dOb, address);
		this.id_student = id_student;
		this.avg_mark = avg_mark;
		this.email = email;
	}
	// method 
	public void inputInfo() {
		super.inputInfo();
		System.out.println("Nhap id Student : ");
		setId_student(Person.input.nextLine());
		System.out.println("Nhap diem trung binh : ");
		setAvg_mark(Person.input.nextFloat());
		input.nextLine();
		System.out.println("Nhap email : ");
		setEmail(Person.input.nextLine());
	}
	public void showInfo() {
		super.showInfo();
		System.out.println("Id Student : " + getId_student());
		System.out.println("Avg Marks " + getAvg_mark());
		System.out.println("Email : " + getEmail());
	}
	public boolean check_hoc_bong() {
		if(avg_mark >= 8.0) {
			return true;
		}
		return false;
	}
	
	// setter and getter
	public String getId_student() {
		return id_student;
	}

	public float getAvg_mark() {
		return avg_mark;
	}

	public String getEmail() {
		return email;
	}

	public void setId_student(String id_student) {
		this.id_student = id_student;
	}

	public void setAvg_mark(float avg_mark) {
		this.avg_mark = avg_mark;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
