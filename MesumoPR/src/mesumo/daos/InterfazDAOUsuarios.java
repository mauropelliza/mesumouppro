package mesumo.daos;

import java.util.List;
import mesumo.entities.UsuarioE;

public interface InterfazDAOUsuarios {
	public int saveOne(UsuarioE user);
	public List getMany();
	public int deleteOne(UsuarioE user);
	public UsuarioE getOne(UsuarioE user);
	public UsuarioE validar(String username, String userpass);
	

}
