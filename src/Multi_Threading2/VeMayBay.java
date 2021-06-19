package Multi_Threading2;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VeMayBay implements Serializable {
	private String maChuyenBay;
	private String tenChuyenBay;
	private String ngayBay;
	private String hanhLy;
	private int giaVe;

	// contructor
	public VeMayBay() {
	}

	public VeMayBay(String maChuyenBay, String tenChuyenBay, String ngayBay, String hanhLy, int giaVe) {
		this.maChuyenBay = maChuyenBay;
		this.tenChuyenBay = tenChuyenBay;
		this.ngayBay = ngayBay;
		this.hanhLy = hanhLy;
		this.giaVe = giaVe;
	}

	// method
	public void input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập mã chuyến bay : ");
		while (true) {
			setMaChuyenBay(input.nextLine());
			String chuoi_yeu_cau = "";
			if (maChuyenBay.startsWith("VJ")) {
				chuoi_yeu_cau = "VJ[1-9]{1}[0-9]{2}";
			} else if (maChuyenBay.startsWith("VN")) {
				chuoi_yeu_cau = "VN[1-9]{1}[0-9]{2}[0-9]?";
			} else if (maChuyenBay.startsWith("JET")) {
				chuoi_yeu_cau = "JET[1-9]{1}[0-9]{2}";
			} else {
				System.err.println("Nhập lại : ");
				continue;
			}

			Pattern pattern = java.util.regex.Pattern.compile(chuoi_yeu_cau);
			java.util.regex.Matcher matcher = pattern.matcher(maChuyenBay);

			if (matcher.find()) {
				break;
			} else {
				System.err.println("Nhập lại : ");
			}
		}

		System.out.println("Nhập tên chuyến bay : ");
		setTenChuyenBay(input.nextLine());
		System.out.println("Nhập ngày bay : ");
		setNgayBay(input.nextLine());
		System.out.println("Nhập hành lý : ");
		setHanhLy(input.nextLine());
		System.out.println("Nhập giá vé : ");
		setGiaVe(input.nextInt());

	}

	static void displayHeader() {
		System.out.println(String.format("%10s %10s %10s %10s %10s %10s %20s %10s %10s", "Mã", "|", "Tên", "|", "Ngày bay",
				"|", "Hành lý", "|", "Giá vé"));
		System.out.println(String.format("%s",
				"-------------------------------------------------------------------------------------------------------------------------"));
	}

	public void display() {
		System.out.println(String.format("%10s %10s %10s %10s %10s %10s %20s %10s %10d", getMaChuyenBay(), "|", getTenChuyenBay(), "|",
				getNgayBay(), "|", getHanhLy(), "|", getGiaVe()));
	}

	// setter and getter
	public String getMaChuyenBay() {
		return maChuyenBay;
	}

	public String getTenChuyenBay() {
		return tenChuyenBay;
	}

	public String getNgayBay() {
		return ngayBay;
	}

	public String getHanhLy() {
		return hanhLy;
	}

	public int getGiaVe() {
		return giaVe;
	}

	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}

	public void setTenChuyenBay(String tenChuyenBay) {
		this.tenChuyenBay = tenChuyenBay;
	}

	public void setNgayBay(String ngayBay) {
		this.ngayBay = ngayBay;
	}

	public void setHanhLy(String hanhLy) {
		this.hanhLy = hanhLy;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}

	@Override
	public String toString() {
		return "VeMayBay [maChuyenBay=" + maChuyenBay + ", tenChuyenBay=" + tenChuyenBay + ", ngayBay=" + ngayBay
				+ ", hanhLy=" + hanhLy + ", giaVe=" + giaVe + "]";
	}

}
