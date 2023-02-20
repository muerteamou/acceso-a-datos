package tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Departamentos;

public class DepartamentoXNumero {

	public static void main(String[] args) {

		//Crea un ejemplar de SessionFactory
		SessionFactory sesFactory = HibernateUtil.getSessionFactory();
		
		Session sesion = sesFactory.openSession();
		
		// Inicializamos a null
		
		Departamentos depart = null;
		
		depart= (Departamentos) sesion.get(Departamentos.class, (int) 11);
		
		if(depart!=null) {
			System.out.println("Nombre del dpto " + depart.getDnombre());
			System.out.println("Localización " + depart.getLoc());
		}
		else {
			System.out.println("No existe el departamento");
		}
		sesion.close();
		System.exit(0);
	}

}
