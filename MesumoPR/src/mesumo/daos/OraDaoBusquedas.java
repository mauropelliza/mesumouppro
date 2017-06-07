package mesumo.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mesumo.entities.BusquedaE;
import mesumo.util.HibernateUtil;

public class OraDaoBusquedas implements InterfazDAOBusquedas {

	@Override
	public int saveOne(BusquedaE busqueda) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = session.getTransaction();
        try { 
			if(!tr.isActive()) {   
		        tr.begin();
		        session.save(busqueda);
		        tr.commit();
		        return 0;
			}
			return 1;
		}catch (Exception e) { 
			tr.rollback();
			return 1;
		}
	}

	@SuppressWarnings({ "rawtypes"})
	@Override
	public List getMany(Integer userid,Integer categoria, Integer page, Integer count) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Integer end;
        Transaction tr = session.getTransaction();
        List result = null;
        String hql = null;
        Integer from = ((page * 5) - 4);
        Integer maxResults = 5;
        if ((page * 5) > count){
        	//si el count es menor que la ultima posicion que yo quiero traer cambiio maxResults
        	maxResults = count - (5 * (page - 1));
        }
       
        
        try { 
			if(!tr.isActive()) {   
		        session.beginTransaction();
		
		        if (userid != null && categoria != null) {
		        	hql = "from mesumo.entities.BusquedaE b  where b.idusuario = :idusuario and b.idcategoria = :idcat order by b.fechapublicacion";
			        result = session.createQuery(hql)
			        .setParameter("idcat", categoria).setParameter("idusuario", userid).setFirstResult(from).setMaxResults(maxResults)
			        .list();     	
		        }else if (categoria != null){
		        	hql = "from mesumo.entities.BusquedaE b  where b.idcategoria = :idcat order by b.fechapublicacion";
		        	result = session.createQuery(hql).setParameter("idcat", categoria).setFirstResult(from).setMaxResults(maxResults).list();
		        } else if (userid != null) {
		        	hql = "from mesumo.entities.BusquedaE b where b.idusuario = :idusuario order by b.fechapublicacion";
		        	result = session.createQuery(hql).setParameter("idusuario", userid).setFirstResult(from).setMaxResults(maxResults).list();
		        } else {
		        	hql = "from mesumo.entities.BusquedaE b order by b.fechapublicacion";
		        	result = session.createQuery(hql).setFirstResult(from).setMaxResults(maxResults).list();
		        }

		        tr.commit();
			}
		}catch (Exception e) { 
			tr.rollback();
			return null;
		}
        return result;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Integer getCount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.getTransaction();
		Integer countResults = 0;
		try { 
			if(!tr.isActive()) {   
				tr.begin();
				
				String countQ = "Select count (b.id) from mesumo.entities.BusquedaE b";
				Query countQuery = session.createQuery(countQ);
				countResults = ((Long)countQuery.uniqueResult()).intValue();
				
				tr.commit();
			}
		}catch (Exception e) { 
			tr.rollback();
		}
		return countResults;
	}

	@Override
	public int deleteOne(BusquedaE busq) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.getTransaction();	
		try { 
			if(!tr.isActive()) {   
				tr.begin();
				session.delete(busq);
				tr.commit();
				return 0;
			}
			return 1;
		}catch (Exception e) { 
			tr.rollback();
			return 1;
		}
	}

	@Override
	public BusquedaE getOne(BusquedaE busq) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.getTransaction();
		BusquedaE busqueda = null;
		try { 
			if(!tr.isActive()) {   
		        tr.begin();
		        busqueda = (BusquedaE) session.get(mesumo.entities.BusquedaE.class,busq.getId());
		        tr.commit();
			}
		}catch (Exception e) { 
			tr.rollback();
		}
		return busqueda;
	}

}
