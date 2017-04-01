package quality;

import java.sql.SQLException;
import java.util.ArrayList;


public class CargadorAutoCompleteTextField {

	
	public ArrayList<String> generarContenidoTiposMateriaPrima() {
		 ArrayList<String> lista = new ArrayList<>();
		 MateriaPrimaTipoController mPTController = new MateriaPrimaTipoController();
		 ArrayList<MateriaPrimaTipoBean> listaDeTipos = null;
		try {
			listaDeTipos = mPTController.devolverTodosLosTipos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < listaDeTipos.size(); i++) {
			lista.add(listaDeTipos.get(i).getTipo());
		}
		return lista;
	}
}
