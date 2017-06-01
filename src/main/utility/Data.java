package main.utility;

public class Data {
	private String sso;
	private String pwd;
	private String pin;
	
	public Data(String sso, String pwd, String pin) {
		this.sso = sso;
		this.pwd = pwd;
		this.pin = pin;
	}
	
	public Data(){
		this.sso = "";
		this.pwd = "";
		this.pin = "";
	}
	
	public Data(Data obj){
		this.sso = obj.sso;
		this.pwd = obj.pwd;
		this.pin = obj.pin;
	}

	public String getSso() {
		return sso;
	}

	public boolean setSso(String sso) {
		if(sso.length() != 9)
			return false;
		else{
			this.sso = sso;
			return true;
		}
	}

	public String getPwd() {
		return pwd;
	}

	public boolean setPwd(String pwd) {
		if(pwd.length() == 0){
			return false;
		}
		else{
			this.pwd = pwd;
			return true;
		}
	}

	public String getPin() {
		return pin;
	}

	public boolean setPin(String pin) {
		if(pin.length() >= 12 && pin.length() <= 14){
			this.pin = pin;
			return true;
		}
		else
			return false;
	}

	@Override
	public String toString() {
		return "SSO = " + sso + "\nPassword = " + pwd + "\nPin + Token = " + pin;
	}
	
	
}
