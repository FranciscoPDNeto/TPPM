	package src.model.dao;

	import java.util.List;
	import model.domain.TipoExame;

	/**
	 *
	 * @author yasminaraujo
	 */
	public interface IEspecialidadeDAO {
	    public List<Especialidade> listarEspecialidade() throws ClassNotFoundException, Exception;
	}
