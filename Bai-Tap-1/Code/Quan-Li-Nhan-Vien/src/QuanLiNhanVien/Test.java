/**
 * 
 */
package QuanLiNhanVien;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Nguyen-Hung
 *
 */
public class Test {
	public static void main(String[] args) {
		SoftwareHouse listEmployee = new SoftwareHouse("aName");

		Scanner scanner = new Scanner(System.in);
		int chon;
		do {
			System.out.println("1.Thêm nhân viên.");
			System.out.println("2.Xuất danh sách các nhân viên.");
			System.out.println("3.Tổng tiền lương phải cho cho nhân viên.");
			System.out.println("4.Sắp xếp danh sách nhân viên theo tên.");
			System.out.println("5.Xuất danh sách lập trình viên.");
			System.out.println("6.Cập nhật phòng ban của Người quản lí.");
			System.out.println("7.Xóa nhân viên.");
			System.out.println("0.Thoát.");
			System.out.println("Chọn chức năng:");
			chon = scanner.nextInt();

			switch (chon) {

			case 0:
				continue;
			case 1: {

				System.out.println("1.Thêm lập trình viên.");
				System.out.println("2.Thêm trưởng dự án.");
				System.out.println("3.Thêm người quản lí.");
				int case1 = scanner.nextInt();

				System.out.print("Nhập mã số:");
				int thePayrollNumber = scanner.nextInt();

				String temString = scanner.nextLine();
				System.out.print("Nhập tên:");
				String theName = scanner.nextLine();
				System.out.print("Nhập lương cơ bản:");
				double theBasicMonthlySalary = scanner.nextDouble();

				switch (case1) {
				case 0:
					return;

				case 1: {
					System.out.print("Ngôn ngữ lập trình:");
					String tempString = scanner.nextLine();
					String theLanguage = scanner.nextLine();

					listEmployee
							.addEmployee(new Programmer(thePayrollNumber, theName, theBasicMonthlySalary, theLanguage));
				}
					break;

				case 2: {
					System.out.print("Ngôn ngữ lập trình:");
					String tempString = scanner.nextLine();
					String theLanguage = scanner.nextLine();
					listEmployee.addEmployee(
							new ProjectLeader(thePayrollNumber, theName, theBasicMonthlySalary, theLanguage));
				}
					break;

				case 3: {
					String tempString = scanner.nextLine();
					System.out.print("Nhập phòng ban:");
					String theDepartment = scanner.nextLine();

					listEmployee.addEmployee(
							new Administrator(thePayrollNumber, theName, theBasicMonthlySalary, theDepartment));
				}
					break;

				default:
					System.out.println("Không có chức năng này.");
					break;
				}
			}
				break;

//
			case 2: {
				System.out.println("Danh sách nhân viên:");
				System.out.println(listEmployee.displayAllStaff());

			}
				break;

			case 3: {
				Locale locale = new Locale("en", "US");
				NumberFormat formatMoney = NumberFormat.getCurrencyInstance(locale);
				
				System.out.println("Tổng tiền lương của các nhân viên:" + formatMoney.format(listEmployee.getMonthlySalaryBill()));
			}
				break;

			case 4: {
				listEmployee.sortAllStaffByName();
				System.out.println("Danh sách sau khi sắp xếp:");
				System.out.println(listEmployee.displayAllStaff());
			}
				break;

			case 5: {
				System.out.println("Danh sách lập trình viên:");
				System.out.println(listEmployee.displayListProgrammers());
			}
				break;

			case 6: {
				System.out.println("Nhập mã số:");
				int aPayrollNo = scanner.nextInt();
				
				String tempString = scanner.nextLine();
				System.out.print("Nhập phòng ban mới:");
				String deptNew = scanner.nextLine();
				if(listEmployee.updateDepartmentForAdmin(aPayrollNo, deptNew))
					System.out.println("Cập nhật thành công.");
				else
					System.out.println("Không tìm thấy mã.");
			}
				break;

			case 7: {
				System.out.println("Nhập mã cần xóa:");
				int id = scanner.nextInt();
				if(listEmployee.deleteEmployee(id))
					System.out.println("Xóa thành công.");
				else
					System.out.println("Không tìm thấy mã");
			}
				break;

			default:
				System.out.println("Không có chức năng này.");
				break;
			}
			
			System.out.println("_______________________________________");
		} while (chon != 0);

		scanner.close();
	}
}
