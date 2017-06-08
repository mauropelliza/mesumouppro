package mesumo.daos;

import java.util.List;
import mesumo.entities.BusquedaE;

public interface InterfazDAOBusquedas {
	public int saveOne(BusquedaE busqueda);
	public List getMany(Integer userid, Integer categoria, Integer start, Integer count);
	public int deleteOne(BusquedaE busqueda);
	public BusquedaE getOne(BusquedaE busqueda);
	public Integer getCount(Integer categoria);
	
}
