package QuanLyThietBiMayTinh;

public class Monitor extends Device {
	private String size;

	// contructor
	public Monitor() {
		super();
	}

	public Monitor(Integer id, String name, String manufacturer, String importedDate, String size) {
		super(id, name, manufacturer, importedDate);
		this.size = size;
	}

	// method
	@Override
	void input() {
		super.inputInfo();
		System.out.println("Nhập kích thước màn : ");
		setSize(input.nextLine());
	}

	@Override
	void display() {
		System.out.println(super.toString());
		System.out.println(toString());

	}
	// set and get
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Monitor [size=" + size + "]";
	}

}
