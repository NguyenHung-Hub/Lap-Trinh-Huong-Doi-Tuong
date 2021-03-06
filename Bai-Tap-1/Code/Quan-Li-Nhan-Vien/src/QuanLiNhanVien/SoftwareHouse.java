package QuanLiNhanVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SoftwareHouse {
	private String theName;
	private List<Employee> listEmployee;

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public SoftwareHouse(String theName) {
		super();
		setTheName(theName);
		listEmployee = new ArrayList<Employee>();
	}

	@Override
	public String toString() {
		String string = "";

		for (Employee employee : listEmployee) {
			string += employee + "\n";
		}
		
		return string;
	}

	// Thêm nhân viên
	public boolean addEmployee(Employee employee) {
		if (listEmployee.contains(employee))
			return false;
		else {
			listEmployee.add(employee);
			return true;
		}
	}

	public String displayAllStaff() {
		String string = "";

		for (Employee employee : listEmployee) {
			string += employee + "\n";
		}
		
		return string;
	}

	// Tính tổng tiền phải trả cho nhân viên
	public double getMonthlySalaryBill() {
		int sum = 0;
		for (Employee employee : listEmployee) {
			sum += employee.getMonthlySalary();
		}

		return sum;
	}

	//sap xep theo ten
	public void sortAllStaffByName() {
		Collections.sort(listEmployee, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getTheName().compareToIgnoreCase(o2.getTheName());
			}
		});
	}
	//sap xep theo ma (kieu int)
//	public void sortAllStaffByName() {
//		Collections.sort(listEmployee, new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return Integer.compare(o1, o)
//			}
//		});
//	}

	// Lấy danh sách các lập trình viên
	public SoftwareHouse displayListProgrammers() {
		SoftwareHouse list = new SoftwareHouse(theName);

		for (Employee employee : listEmployee) {
			if (employee instanceof Programmer) {
				list.addEmployee(employee);
			}
		}

		return list;
	}

	// Cập nhật phòng ban mới cho người quản lí
	public boolean updateDepartmentForAdmin(int aPayrollNo, String deptNew) {

		for (Employee employee : listEmployee) {
			if (employee instanceof Administrator)
				if (employee.getThePayrollNumber() == aPayrollNo) {
					((Administrator) employee).setTheDepartment(deptNew);
					return true;
				}
		}
		return false;
	}

	// Xóa nhân viên theo mã
	public boolean deleteEmployee(int id) {
		return listEmployee.removeIf(employee -> employee.getThePayrollNumber() == id);
	}
}
