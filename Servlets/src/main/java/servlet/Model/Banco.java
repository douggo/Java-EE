package servlet.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static int empresaId = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Google");
		empresa1.setId(empresaId++);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Valve");
		empresa2.setId(empresaId++);
		Banco.empresas.add(empresa1);
		Banco.empresas.add(empresa2);
	}
	
	
	public void adicionaEmpresa(Empresa empresa) {
		empresa.setId(empresaId++);
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(Banco.empresas);
	}
	
	public void removeEmpresa(int id) {
		Iterator<Empresa> iterator = Banco.empresas.iterator();
		while(iterator.hasNext()) {
			Empresa empresa = iterator.next();
			if(empresa.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Empresa getEmpresaById(Integer id) {
		for(Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

}
