package mesumo.entities;


import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BUSQUEDAS")
public class BusquedaE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1417500704896943284L;
	@Id
    @GeneratedValue
    @Column(name="ID")
	private Integer id;
	@Column(name="TITULO")
	private String titulo;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="IDCATEGORIA")
	private Integer idcategoria;
	@Column(name="IDUSUARIO")
	private Integer idusuario;
	@Column(name="FECHAPUBLICACION")
	private Timestamp fechapublicacion;
	
	public BusquedaE() {
		
	}
	
	private String getFechaFormat(Timestamp date, String pattern) {
		long l = date.getTime();
		Date d = new Date(l);
		Locale espan = new Locale("es","ES");
		SimpleDateFormat format = new SimpleDateFormat(pattern,espan);
		
		return format.format(d);
	}
	
	public Integer getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Timestamp getFechapublicacion() {
		return fechapublicacion;
	}
	public String getFechapublicacionForm() {
		if (fechapublicacion == null)
			return "";
		else{
			Timestamp tms = new Timestamp(getFechapublicacion().getTime());
			return getFechaFormat(tms, "dd 'de' MMMM 'de' yyyy");
		}
	}
	public void setFechapublicacion(Timestamp fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}
}
