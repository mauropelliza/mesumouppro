package mesumo.actions;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import mesumo.daos.InterfazDAOBusquedas;
import mesumo.daos.OraDaoBusquedas;
import mesumo.entities.BusquedaE;

@SuppressWarnings("serial")
public class Busquedas extends ActionSupport {
	
	BusquedaE busq;
	List<BusquedaE> listaBusquedas;
	Map acconsess = null;
	Integer sessidusuario = null;
	Integer page;
	Integer ultimaPagina;
	Integer requester;
	
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
		Integer count = daob.getCount(busq.getIdcategoria());
		ultimaPagina =calcularUltimaPagina(count);
		listaBusquedas = daob.getMany(sessidusuario,null,page,count);
		if (result == 0)	estado = SUCCESS;
		return estado;	
	}
	
	public String cargarLista() {
		InterfazDAOBusquedas daob = new OraDaoBusquedas();
		Integer count = daob.getCount(null);
		ultimaPagina =calcularUltimaPagina(count);
		listaBusquedas = daob.getMany(sessidusuario,null,page,count);
		return SUCCESS;	
	}
	
	public String cargarListaPorCategoria() {
		InterfazDAOBusquedas daob = new OraDaoBusquedas();
		Integer count = daob.getCount(busq.getIdcategoria());
		ultimaPagina =calcularUltimaPagina(count);
		listaBusquedas = daob.getMany(null, busq.getIdcategoria(),page,count);
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
		Integer count = daob.getCount(busq.getIdcategoria());
		ultimaPagina =calcularUltimaPagina(count);
		listaBusquedas = daob.getMany(sessidusuario, null,page,count);
		if(result == 0) {
			estado = SUCCESS;
		}
		return estado;	
	}
	
	private Integer calcularUltimaPagina(Integer count) {
		Float f = new Float(count);
		f = (float) (f/5.00);
		Integer ent = f.intValue();
		if (f > ent) {
			ent++;
		}

		return ent;
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getUltimaPagina() {
		return ultimaPagina;
	}

	public void setUltimaPagina(Integer ultimaPagina) {
		this.ultimaPagina = ultimaPagina;
	}

	public Integer getRequester() {
		return requester;
	}

	public void setRequester(Integer requester) {
		this.requester = requester;
	}
	
}