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

import mesumo.entities.BusquedaE;
import mesumo.util.HibernateUtil;

@SuppressWarnings("serial")
public class Busquedas extends ActionSupport {
	
	BusquedaE busq;
	List<BusquedaE> listaBusquedas;
	Map acconsess = (Map) ActionContext.getContext().get("session");
	Integer sessidusuario = Integer.parseInt( (String)acconsess.get("usid") );
	
	public String execute() {
		String estado = ERROR;
		busq.setFechapublicacion(new Timestamp(System.currentTimeMillis()));
		saveElement(busq);
		listaBusquedas = listarBusquedas(null);
		estado = SUCCESS;
		return estado;	
	}
	
	public String cargarLista() {
		String estado = ERROR;
		listaBusquedas = listarBusquedas(sessidusuario);
		estado = SUCCESS;
		return estado;	
	}
	
	public String cargarListaPorCategoria() {
		listaBusquedas = listarPorCategorias();
		return SUCCESS;
	}
	
	public String traerDetalle() {
		String estado = ERROR;//hay que cambiarlo
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.getTransaction();	
		try { 
			if(!tr.isActive()) {   
		        tr.begin();
		        busq = (BusquedaE) session.get(mesumo.entities.BusquedaE.class,busq.getId());
		        tr.commit();
				estado = SUCCESS;
			}
		}catch (Exception e) { 
			tr.rollback();
		}
		return estado;
	}
	
	public String borrarAccion() {
		String estado = ERROR;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.getTransaction();	
		try { 
			if(!tr.isActive()) {   
				tr.begin();
				session.delete(busq);
				tr.commit();
				estado = SUCCESS;
				listaBusquedas = listarBusquedas(sessidusuario);
			}
		}catch (Exception e) { 
			tr.rollback();
		}
		return estado;	
	}
	
	private void saveElement(BusquedaE bs) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = session.getTransaction();
        try { 
			if(!tr.isActive()) {   
		        tr.begin();
		        session.save(bs);
		        tr.commit();
			}
		}catch (Exception e) { 
			tr.rollback();
		}
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
 
	
}