package threetier.emp;

public class Emp {
int eno,deptid;
String ename;
public Emp(int eno, int deptid, String ename) {
	this.eno = eno;
	this.deptid = deptid;
	this.ename = ename;
}
@Override
public String toString() {
	return "Emp [eno=" + eno + ", deptid=" + deptid + ", ename=" + ename + "]";
}
public Emp() {
	// TODO Auto-generated constructor stub
}
public int getEno() {
	return eno;
}
public void setEno(int eno) {
	this.eno = eno;
}
public int getDeptid() {
	return deptid;
}
public void setDeptid(int deptid) {
	this.deptid = deptid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}


}
