package mesumo.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class UsuarioE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 872354371994575834L;
	@Id
    @GeneratedValue
    @Column(name="ID")
	private Integer	id;
	@Column(name="NOMBRE")
	private String	nombre;
	@Column(name="APELLIDO")
	private String	apellido;
	@Column(name="USUARIO")
	private String	usuario;
	@Column(name="PASSWORD")
	private String	password;
	@Column(name="HASH")
	private String	hash;
	@Column(name="DNI")
	private Integer	dni;
	@Column(name="HDIRECCION")
	private String	hdireccion;
	@Column(name="HEMAIL")
	private String	hemail;
	@Column(name="HNOMBRE")
	private String	hnombre;
	@Column(name="HTELEFONO")
	private String	htelefono;
	
	public UsuarioE () {
		
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

}
