package transportaion.manager;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transportation.management.system.ConnectionClass;
import transportation.management.system.TruckBean;
import transportation.management.system.UserBean;

public class ManagerDAO {

	public static int loginManager(String branch, String uname, String password) throws SQLException {
		Connection con = ConnectionClass.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from manager where branch=? and uname=? and password=?");
			
			pstmt.setString(1,branch);
			pstmt.setString(2,uname);
			pstmt.setString(3,password);
			
			 rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs.next()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public static ArrayList<TruckBean> comingTrucks(String branch)
	{
		Connection con = ConnectionClass.getConnection();
		TruckBean tb=null;
		ArrayList<TruckBean> al=new ArrayList<TruckBean>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from trucktable where ENDINGPOINT=?");
			pstmt.setString(1, branch);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				tb=new TruckBean();
				tb.setTruckModel(rs.getString("TRUCKMODEL"));
				tb.setTruckNumber(rs.getString("TRUCKNUMBER"));
				tb.setOwnerName(rs.getString("OWNERNAME"));
				tb.setStartingPoint(rs.getString("STARTINGPOINT"));
				al.add(tb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
		
	}
	
		public static ArrayList<TruckBean> updateStatus(){
		Connection con = ConnectionClass.getConnection();
		TruckBean tb=null;
		ArrayList<TruckBean> al=new ArrayList<TruckBean>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from trucktable");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tb=new TruckBean();
				tb.setTruckModel(rs.getString("TRUCKMODEL"));
				tb.setTruckNumber(rs.getString("TRUCKNUMBER"));
				tb.setStartingPoint(rs.getString("STARTINGPOINT"));
				tb.setEndingPoint(rs.getString("ENDINGPOINT"));
				tb.setStatus(rs.getString("STATUS"));
				al.add(tb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

		public static int updatedNewStatus(String newStatus, String truckNumber) throws SQLException {
			Connection con = ConnectionClass.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("update  trucktable set status=? where trucknumber=?");
			
			pstmt.setString(1,newStatus );
			pstmt.setString(2,truckNumber.trim());
			
			int i = pstmt.executeUpdate();
			
			return i;
			
		}

		public static ArrayList<TruckBean> beforeOneMonthInstalledTrucks() throws SQLException {
			Connection con = ConnectionClass.getConnection();
			
			ArrayList<TruckBean> al=new ArrayList<TruckBean>();
			TruckBean tb=null;
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM trucktable WHERE joiningdate >= ADD_MONTHS(SYSDATE, -1) AND joiningdate < SYSDATE");
		
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tb=new TruckBean();
				tb.setTruckModel(rs.getString("TRUCKMODEL"));
				tb.setTruckNumber(rs.getString("TRUCKNUMBER"));
				tb.setOwnerName(rs.getString("OWNERNAME"));
				tb.setStartingPoint(rs.getString("STARTINGPOINT"));
				tb.setEndingPoint(rs.getString("ENDINGPOINT"));
				tb.setJoiningdate(rs.getDate("JOININGDATE"));
				al.add(tb);
			}
			return al;
		}
		
		public static ArrayList<TruckBean> rootOfTruck(String startingPoint,String endingPoint) {
			Connection conn = ConnectionClass.getConnection();
			TruckBean tb=null;
			ArrayList<TruckBean> al=new ArrayList<TruckBean>();
			
			try {
				PreparedStatement pstmt=conn.prepareStatement("select * from trucktable where startingpoint=? and endingpoint=?");
				pstmt.setString(1, startingPoint);
				pstmt.setString(2, endingPoint);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					tb=new TruckBean();
					tb.setTruckModel(rs.getString("TRUCKMODEL"));
					tb.setTruckNumber(rs.getString("TRUCKNUMBER"));
					tb.setOwnerName(rs.getString("OWNERNAME"));
					tb.setMobileNo(rs.getLong("MOBILENUMBER"));
					tb.setInsurance(rs.getString("INSURANCECOMPANYNAME"));
					al.add(tb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return al;
		}

		public static int  ContactToAdmin(String name, String email, long phone, String message) throws SQLException {
			Connection con = ConnectionClass.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("insert into transportquery values(?,?,?,?)");
			
			pstmt.setString(1, name);
			pstmt.setString(2,email);
			pstmt.setLong(3,phone);
			pstmt.setString(4, message);
			
			int i = pstmt.executeUpdate();
			
			return i;
		}
}
