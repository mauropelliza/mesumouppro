package mesumo.actions;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import mesumo.entities.BusquedaE;
import mesumo.util.HibernateUtil;

@SuppressWarnings("serial")
public class Busquedas extends ActionSupport {
	
	BusquedaE busq;
	List<BusquedaE> listaBusquedas;
	
	public String execute() {
		String estado = ERROR;
		saveElement(busq);
		listaBusquedas = listarBusquedas();
		estado = SUCCESS;
//		HibernateUtil.getSessionFactory().close();
		return estado;	
	}
	
	public String cargarLista() {
		String estado = ERROR;
		listaBusquedas = listarBusquedas();
		estado = SUCCESS;
//		HibernateUtil.getSessionFactory().close();
		return estado;	
	}
	
	public String cargarListaPorCategoria() {
		listaBusquedas = listarPorCategorias();
		return SUCCESS;
	}
	
	public String traerDetalle() {
		String estado = ERROR;//hay que cambiarlo
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        busq = (BusquedaE) session.get(mesumo.entities.BusquedaE.class,busq.getId());
        session.getTransaction().commit();
		estado = SUCCESS;
//		HibernateUtil.getSessionFactory().close();
		return estado;
	}
	
	public String borrarAccion() {
		String estado = ERROR;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.delete(busq);
		session.getTransaction().commit();
		estado = SUCCESS;
		listaBusquedas = listarBusquedas();
		return estado;	
	}
	
	private void saveElement(BusquedaE bs) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        session.save(bs);
        session.getTransaction().commit();
    }
 
    private List listarBusquedas() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from mesumo.entities.BusquedaE order by fechapublicacion").list();
        session.getTransaction().commit();
        return result;
    }
    
    private List listarPorCategorias() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from mesumo.entities.BusquedaE b  where b.idcategoria = :idcat order by b.fechapublicacion";
        List result = session.createQuery(hql)
        .setParameter("idcat", busq.getIdcategoria())
        .list();
        session.getTransaction().commit();
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