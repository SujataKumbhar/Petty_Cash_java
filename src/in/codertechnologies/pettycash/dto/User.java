
package in.codertechnologies.pettycash.dto;


public class User
{
	private String uname ,pass, newpass,oldpass;

	@Override
	public String toString() {
		return "User [uname=" + uname + ", pass=" + pass + ", newpass=" + newpass + ", oldpass=" + oldpass + "]";
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public String getOldpass() {
		return oldpass;
	}

	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}


}
