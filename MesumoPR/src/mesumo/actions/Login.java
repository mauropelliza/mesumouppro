package mesumo.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import mesumo.daos.InterfazDAOUsuarios;
import mesumo.daos.OraDaoUsuarios;
import mesumo.entities.BusquedaE;
import mesumo.entities.UsuarioE;
import mesumo.util.HibernateUtil;

public class Login extends ActionSupport implements SessionAware{
	private String username;
	private String userpass;  
	SessionMap<String,String> sessionmap;  
	
	@Override
	public void setSession(Map map) {  
	    sessionmap=(SessionMap)map;  
	    sessionmap.put("login","true");  
	}  

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	
	@SuppressWarnings("unused")
	public String execute(){
//		InterfazDAOUsuarios dao = new OraDaoUsuarios();
//		UsuarioE user = dao.validar(username, userpass);
//		sessionmap.put("usid",user.getId().toString());
//        sessionmap.put("usalias",user.getUsuario());
//	    
//        if(user != null){  
//	        return "success";  
//	    }  
//	    else{  
//	        return "error";  
//	    }
        
		InterfazDAOUsuarios dao = new OraDaoUsuarios();
		if ((username != null && userpass != null)) {
			UsuarioE user = dao.validar(username, userpass);
			sessionmap.put("usid",user.getId().toString());
	        sessionmap.put("usalias",user.getUsuario());
		
	        if(user != null){  
		        return "success";  
		    }  
		    else{  
		        return "error";  
		    } 
		} else {
			sessionmap.put("usid","VISITA");
	        sessionmap.put("usalias","VISITA");
	        
	        return SUCCESS;
		}
	}  
	  
	public String entradaSinSesion(){
		return SUCCESS;
	}
	  
	public String logout(){  
	    sessionmap.invalidate();  
	    return "success";  
	}
//https://www.javatpoint.com/struts-2-login-and-logout-example	

}
