package mesumo.actions;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mesumo.daos.InterfazDAOBusquedas;
import mesumo.daos.OraDaoBusquedas;
import mesumo.entities.BusquedaE;
import mesumo.util.HibernateUtil;

@SuppressWarnings("serial")
public class Busquedas extends ActionSupport {
	
	BusquedaE busq;
	List<BusquedaE> listaBusquedas;
	Map acconsess = null;
	Integer sessidusuario = null;
	
	public Busquedas () {
		acconsess = (Map) ActionContext.getContext().get("session");
		if (acconsess != null) {
			String aux = (String)acconsess.get("usid");
			if (aux != null) {
			 sessidusuario = Integer.parseInt(aux);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public String execute() {
		String estado = ERROR;
		
		
		
		busq.setFechapublicacion(new Timestamp(System.currentTimeMillis()));
		InterfazDAOBusquedas daob = new OraDaoBusquedas();
		int result = daob.saveOne(busq);
		listaBusquedas = daob.getMany(sessidusuario,null);
		if (result == 0)	estado = SUCCESS;
		return estado;	
	}
	
	public String cargarLista() {
		String estado = ERROR;
		InterfazDAOBusquedas daob = new OraDaoBusquedas();
		listaBusquedas = daob.getMany(sessidusuario,null);
		estado = SUCCESS;
		return estado;	
	}
	
	public String cargarListaPorCategoria() {
		int cat = busq.getIdcategoria();
		InterfazDAOBusquedas daob = new OraDaoBusquedas();
		listaBusquedas = daob.getMany(null, cat);
		return SUCCESS;
	}
	
	public String traerDetalle() {
		String estado = ERROR;//hay que cambiarlo
		InterfazDAOBusquedas daob = new OraDaoBusquedas();
		busq = daob.getOne(busq);
		estado = SUCCESS;
		return estado;
	}
	
	public String borrarAccion() {
		String estado = ERROR;
		InterfazDAOBusquedas daob = new OraDaoBusquedas();
		int result = daob.deleteOne(busq);
//		listaBusquedas = listarBusquedas(sessidusuario);
		listaBusquedas = daob.getMany(sessidusuario, null);
		if(result == 0) {
			estado = SUCCESS;
		}
		return estado;	
	}
	 
    private List listarBusquedas(Integer idusuario) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = session.getTransaction();
        List result = null;
        try { 
			if(!tr.isActive()) {   
		        session.beginTransaction();
		        result = session.createQuery("from mesumo.entities.BusquedaE b where b.idusuario = :idusuario order by b.fechapublicacion")
		        		.setParameter("idusuario", idusuario).list();
		        tr.commit();
			}
		}catch (Exception e) { 
			tr.rollback();
		}
        return result;
    }
    
    private List listarPorCategorias() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List result = null;
        Transaction tr = session.getTransaction();
        try { 
			if(!tr.isActive()) {
		        String hql = "from mesumo.entities.BusquedaE b  where b.idcategoria = :idcat order by b.fechapublicacion";
		        result = session.createQuery(hql)
		        .setParameter("idcat", busq.getIdcategoria())
		        .list();
		        tr.commit();
			}
		}catch (Exception e) { 
			tr.rollback();
		}
        return result;
    }

	public BusquedaE getBusq() {
		return busq;
	}

	public void setBusq(BusquedaE busq) {
		this.busq = busq;
	}

	public List<BusquedaE> getListaBusquedas() {
		return listaBusquedas;
	}

	public void setListaBusquedas(List<BusquedaE> listaBusquedas) {
		this.listaBusquedas = listaBusquedas;
	}
 
	public Map getAcconsess() {
		return acconsess;
	}

	public void setAcconsess(Map acconsess) {
		this.acconsess = acconsess;
	}

	public Integer getSessidusuario() {
		return sessidusuario;
	}

	public void setSessidusuario(Integer sessidusuario) {
		this.sessidusuario = sessidusuario;
	}
	
}