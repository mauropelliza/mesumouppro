package mesumo.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import mesumo.entities.UsuarioE;
import mesumo.util.HibernateUtil;

public class OraDaoUsuarios implements InterfazDAOUsuarios {

	@Override
	public int saveOne(UsuarioE user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.getTransaction();	
		try { 
			if(!tr.isActive()) {   
			    session.save(user);
	            tr.commit();
			}
		}catch (Exception e) { 
			tr.rollback();
		}
		return 0;
	}

	@Override
	public List getMany() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteOne(UsuarioE user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UsuarioE getOne(UsuarioE user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.getTransaction();
		UsuarioE ue = null;
		try { 
			if(!tr.isActive()) {   
		        tr.begin();
		        ue = (UsuarioE) session.get(mesumo.entities.UsuarioE.class,user.getId());
		        tr.commit();
			}
		}catch (Exception e) { 
			tr.rollback();
		}
		return ue;
	}
	
	public UsuarioE validar(String username, String userpass){

		UsuarioE us = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.getTransaction();	
		try { 
			if(!tr.isActive()) {   
		        tr.begin();
		        String hql = "from mesumo.entities.UsuarioE u  where u.usuario = :nom and u.password = :pw";
		        us = (UsuarioE) session.createQuery(hql).setParameter("nom", username).setParameter("pw", userpass)
		        		.getSingleResult();
		        tr.commit();		        
			}
		}catch (Exception e) { 
			tr.rollback();
		}
		return us;
	} 

}
