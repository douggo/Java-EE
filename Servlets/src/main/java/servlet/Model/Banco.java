package servlet.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Google");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Valve");
		Banco.empresas.add(empresa1);
		Banco.empresas.add(empresa2);
	}
	
	
	public void adicionaEmpresa(Empresa empresa) {
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(Banco.empresas);
	}

}
