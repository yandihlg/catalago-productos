package es.yan.mipymes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Esta clase es el Servicio que gestiona las Mipymes inscritas al la tienda
 */
@Service
public class MipymesService {

	@Autowired
	private MipymesRepository mipymesRepository;

	/**
	 * realiza la persistencia en base de datos de la mipymes pasada por parametro
	 * 
	 * @param mipymes Mipyme que se quiere guardar en la BD
	 * @return retorna la Mipymes almacenada en la BD
	 */
	@Transactional
	public Mipymes createMipymes(Mipymes mipymes) {
		return mipymesRepository.save(mipymes);
	}

	/**
	 * Devuelve una Mipyme dado el id de la misma si y solo si esta habilitada como
	 * cliente nuestro
	 * 
	 * @param id id de la Mipyme
	 * @return Mipyme si existe y esta habilitada en caso contrario null
	 */
	public Mipymes getMipymesById(Long id) {
		Mipymes mipyme = mipymesRepository.findById(id).orElse(null);
		if (mipyme != null && mipyme.isEnable()) {
			return mipyme;
		}
		return null;
	}

	/**
	 * Este metodo devuelve un listado de las mipymes que hay en la bas de de datos
	 * que esten habilitadas como clientes nuestros
	 * 
	 * @return Lista de Mipymes
	 */
	public List<Mipymes> getAllMipymes() {
		return mipymesRepository.findAll().stream().filter(m -> m.isEnable()).collect(Collectors.toList());
	}

	/**
	 * Este metodo me permite dar de alta o de baja a una mipyme como cliente
	 * nuestra
	 * 
	 * @param id     identificador de la Mipymes
	 * @param enable valor que se quiere cambiar, si esta true, la mipyme saldrá en
	 *               el listado de mypymes que son clientes nuestros en caso
	 *               contrario no
	 * @return retornará la Mipyme modificada
	 */
	@Transactional
	public Mipymes enableOrUnableMipymeById(Long id, boolean enable) {
		Mipymes unableMipyme = mipymesRepository.findById(id).orElse(null);
		if (unableMipyme != null) {
			unableMipyme.setEnable(enable);
			mipymesRepository.save(unableMipyme);
		}
		return unableMipyme;
	}
}
