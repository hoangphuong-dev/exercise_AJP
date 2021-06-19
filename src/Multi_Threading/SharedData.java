package Multi_Threading;

public class SharedData {
	public String[] userList = { "Nguyễn Ngọc Lan", "Trần Văn Đức", "Phan Mai Duyên", "Hoàng Trọng Phương",
			"Nguyễn Mai Anh" };
	public String[] addressList = { "Hà Nội", "Quảng Ninh", "Ninh Bình", "Thanh Hoá", "Hải Dương" };

	public SharedData() {
		super();
	}

	public SharedData(String[] userList, String[] addressList) {
		super();
		this.userList = userList;
		this.addressList = addressList;
	}

}
