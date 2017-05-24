package mesumo.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

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
	
	public String execute(){
		UsuarioE user = validar(username, userpass);
	    if(user != null){  
	        return "success";  
	    }  
	    else{  
	        return "error";  
	    }  
	}  
	  

	  
	public String logout(){  
	    sessionmap.invalidate();  
	    return "success";  
	}
//https://www.javatpoint.com/struts-2-login-and-logout-example	
	public UsuarioE validar(String username, String userpass){

		UsuarioE us = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        String hql = "from mesumo.entities.UsuarioE u  where u.usuario = :nom and u.password = :pw";
        us = (UsuarioE) session.createQuery(hql).setParameter("nom", username).setParameter("pw", userpass)
        		.getSingleResult();
        session.getTransaction().commit();
          
		return us;
	} 

}
