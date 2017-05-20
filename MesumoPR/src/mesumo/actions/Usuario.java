package mesumo.actions;


import com.opensymphony.xwork2.ActionSupport;


public class Usuario extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String	userlogin;
	private String	usernom;
	private String	userpwd;
	
	public String execute(){
		String ir=ERROR;
		if(getUserlogin().equals("mauro") && getUserpwd().equals("123")){
			setUsernom("Master del universo");
			ir = SUCCESS;
		}
		return ir;
	}
	
	public String getUserlogin() {
		return userlogin;
	}
	public void setUserlogin(String userlogin) {
		this.userlogin = userlogin;
	}
	public String getUsernom() {
		return usernom;
	}
	public void setUsernom(String usernom) {
		this.usernom = usernom;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
}
