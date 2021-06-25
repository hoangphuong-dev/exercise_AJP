package QuanLySinhVien_GiaoVien;

public class Teacher extends Person {
	private String lop_day;
	private float luong_mot_gio;
	private int so_gio_trong_thang;

	// contructor
	public Teacher() {
		super();
	}

	public Teacher(String name, String dOb, String address, String lop_day, float luong_mot_gio,
			int so_gio_trong_thang) {
		super(name, dOb, address);
		this.lop_day = lop_day;
		this.luong_mot_gio = luong_mot_gio;
		this.so_gio_trong_thang = so_gio_trong_thang;
	}

	// method
	@Override
	public void inputInfo() {
		super.inputInfo();
		System.out.println("Nhap lop day cua giao vien : ");
		setLop_day(Person.input.nextLine());
		System.out.println("Nhap luong mot gio day : ");
		setLuong_mot_gio(Person.input.nextFloat());
		System.out.println("So gio day trong thang : ");
		setSo_gio_trong_thang(Person.input.nextInt());
		input.nextLine();

	}

	public void showInfo() {
		super.showInfo();
		System.out.println("Lớp dạy : " + getLop_day());
		System.out.println("Lương 1 giờ dạy :" + getLuong_mot_gio());
		System.out.println("Số giờ dạy trong tháng : " + getSo_gio_trong_thang());
	}

	public float luong_thu_nhan() {
		float luong_thuc_nhan = 0;
		String ki_tu_cuoi = getLop_day().substring(getLop_day().length() - 1); // lấy kí tự cuối của lớp dạy
		if ("G".equals(ki_tu_cuoi) || "H".equals(ki_tu_cuoi) || "K".equals(ki_tu_cuoi) || "I".equals(ki_tu_cuoi)) {
			luong_thuc_nhan = luong_mot_gio * so_gio_trong_thang;
		}
		if ("L".equals(ki_tu_cuoi) || "M".equals(ki_tu_cuoi)) {
			luong_thuc_nhan = (luong_mot_gio * so_gio_trong_thang + 200000);
		}
		return luong_thuc_nhan;
	}

	// get and set
	public String getLop_day() {
		return lop_day;
	}

	public float getLuong_mot_gio() {
		return luong_mot_gio;
	}

	public int getSo_gio_trong_thang() {
		return so_gio_trong_thang;
	}

	public void setLop_day(String lop_day) {
		this.lop_day = lop_day;
	}

	public void setLuong_mot_gio(float luong_mot_gio) {
		this.luong_mot_gio = luong_mot_gio;
	}

	public void setSo_gio_trong_thang(int so_gio_trong_thang) {
		this.so_gio_trong_thang = so_gio_trong_thang;
	}

}
