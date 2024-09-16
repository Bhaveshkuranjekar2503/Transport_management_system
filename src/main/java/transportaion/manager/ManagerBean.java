package transportaion.manager;

import java.io.Serializable;

public class ManagerBean implements Serializable{

	private String managerBranch,managerName,managerPassword,managerDOJ,managerDOB;
	private double managerSalary;
	private int managerId;
	public String getManagerBranch() {
		return managerBranch;
	}
	public void setManagerBranch(String managerBranch) {
		this.managerBranch = managerBranch;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	public String getManagerDOJ() {
		return managerDOJ;
	}
	public void setManagerDOJ(String managerDOJ) {
		this.managerDOJ = managerDOJ;
	}
	public String getManagerDOB() {
		return managerDOB;
	}
	public void setManagerDOB(String managerDOB) {
		this.managerDOB = managerDOB;
	}
	public double getManagerSalary() {
		return managerSalary;
	}
	public void setManagerSalary(double managerSalary) {
		this.managerSalary = managerSalary;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	
}
