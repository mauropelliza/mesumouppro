package mesumo.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import mesumo.daos.InterfazDAOUsuarios;
import mesumo.daos.OraDaoUsuarios;
import mesumo.entities.UsuarioE;
import mesumo.util.HibernateUtil;

public class Registrarse extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private Integer	id;
	private String	nombre;
	private String	apellido;
	private String	usuario;
	private String	password;
	private String	hash;
	private Integer	dni;
	private String	hdireccion;
	private String	hemail;
	private String	hnombre;
	private String	htelefono;

	public String registrar(){
	 
	    UsuarioE ue = new UsuarioE();
	    ue.setNombre(getNombre());
	    ue.setApellido(getApellido());
	    ue.setUsuario(getUsuario());
	    ue.setPassword(getPassword());
	    ue.setHash(getHash());
	    ue.setDni(getDni());
	    ue.setHdireccion(getHdireccion());
	    ue.setHemail(getHemail());
	    ue.setHnombre(getHnombre());
	    ue.setHtelefono(getHtelefono());
	    InterfazDAOUsuarios dao = new OraDaoUsuarios();
	    dao.saveOne(ue);
	    //TODO hay que meter el usuario en la sesion

	    return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getHdireccion() {
		return hdireccion;
	}

	public void setHdireccion(String hdireccion) {
		this.hdireccion = hdireccion;
	}

	public String getHemail() {
		return hemail;
	}

	public void setHemail(String hemail) {
		this.hemail = hemail;
	}

	public String getHnombre() {
		return hnombre;
	}

	public void setHnombre(String hnombre) {
		this.hnombre = hnombre;
	}

	public String getHtelefono() {
		return htelefono;
	}

	public void setHtelefono(String htelefono) {
		this.htelefono = htelefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
