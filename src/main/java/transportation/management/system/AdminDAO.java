package transportation.management.system;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO {

	public static int adminLogin(String uname, String password) throws SQLException {
		Connection con = ConnectionClass.getConnection();

		String query = "select * from admin where username=? and password=?";

		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setString(1, uname);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			return 1;
		}
		return 0;
	}

	public static int registerManager(String brance, String uname, String password, String DateOfjoining,
			String dateOfBirth, Double salary, int id) throws SQLException {
		Connection con = ConnectionClass.getConnection();
		int i = 0;
		String query = "insert into manager values(?,?,?,?,?,?,?) ";
		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setString(1, brance);
		pstmt.setString(2, uname);
		pstmt.setString(3, password);
		pstmt.setString(4, DateOfjoining);
		pstmt.setString(5, dateOfBirth);
		pstmt.setDouble(6, salary);
		pstmt.setInt(7, id);
		i = pstmt.executeUpdate();

		return i;

	}

	@SuppressWarnings("deprecation")
	public static int truckRegister(String truckModel, String truckNumber, String choice, String insuranceCompanyName,
			String ownerName, long mobileNumber1, String staringPoint, String endingPoint, String joiningdate)
			throws SQLException {
		Connection con = ConnectionClass.getConnection();

		String[] d = joiningdate.split("-");
		Date date = new Date(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
		int i = 0;
		String query = "insert into truckTable values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, truckModel);
		pstmt.setString(2, truckNumber);
		pstmt.setString(3, choice);
		pstmt.setString(4, insuranceCompanyName);
		pstmt.setString(5, ownerName);
		pstmt.setLong(6, mobileNumber1);
		pstmt.setString(7, staringPoint);
		pstmt.setString(8, endingPoint);
		pstmt.setDate(9, date);
		i = pstmt.executeUpdate();
		return i;
	}

	public static ArrayList<UserBean> findingManager(String managerName) throws SQLException {
		Connection con = ConnectionClass.getConnection();
		ArrayList<UserBean> al = new ArrayList<>();

		String query = "select * from manager where uname like ?";

		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setString(1, managerName + "%");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			UserBean ub = new UserBean();
			ub.setManagerId(rs.getInt("id"));
			ub.setManagerName(rs.getString("uname"));
			ub.setSalary(rs.getDouble("salary"));
			al.add(ub);
		}

		return al;
	}

	public static UserBean viewManagerAlldetail(int id) throws SQLException {
		Connection con = ConnectionClass.getConnection();
		UserBean ub = null;

		String query = "select * from manager where id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			ub = new UserBean();
			ub.setBranch(rs.getString("branch"));
			ub.setManagerId(rs.getInt("id"));
			ub.setManagerName(rs.getString("uname"));
			ub.setSalary(rs.getDouble("salary"));
			ub.setPassword(rs.getString("password"));
			ub.setDateOfJoining(rs.getString("DATEOFJOINING"));
			ub.setDateOfBirth(rs.getString("DATEOFBIRTH"));
		}
		return ub;
	}

	public static TruckBean truckDetails(String truckNumber) {
		TruckBean tb = null;
		try {
			System.out.println("select * from truckTable where TRUCKNUMBER='" + truckNumber + "'");
			Connection con = ConnectionClass.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("select * from truckTable where TRUCKNUMBER='" + truckNumber.trim() + "'");

			ResultSet rs1 = pstmt.executeQuery();

			if (rs1.next()) {
				tb = new TruckBean();
				tb.setTruckNumber(rs1.getString("TRUCKNUMBER"));
				tb.setTruckModel(rs1.getString("TRUCKMODEL"));
				tb.setInsurance(rs1.getString("INSURANCECOMPANYNAME"));
				tb.setOwnerName(rs1.getString("OWNERNAME"));
				tb.setStartingPoint(rs1.getString("STARTINGPOINT"));
				tb.setEndingPoint(rs1.getString("ENDINGPOINT"));
				tb.setMobileNo(rs1.getLong("MOBILENUMBER"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tb;
	}

	public static int deleteManager(int id1) throws SQLException {
		Connection con = ConnectionClass.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("delete from manager where ID=?");
		
		pstmt.setInt(1, id1);
		
		int i = pstmt.executeUpdate();
		
		return i;
	}
	
	

}