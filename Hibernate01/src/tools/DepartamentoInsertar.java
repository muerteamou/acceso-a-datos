package tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import modelo.Departamentos;

public class DepartamentoInsertar {

	public static void main(String[] args) {
		
		//Obtenemos la SessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//Obtenemos una sesion
		Session sesion = sessionFactory.openSession();
		
		//Creamos una transacción
		Transaction tx = sesion.beginTransaction();
		System.out.println("Vamos a insertar una fila en Departamento");
		Departamentos dep = new Departamentos();
		dep.setDptoNo(11);
		dep.setDnombre("RRHH");
		dep.setLoc("Grañen");
		
		//insertamos el objeto y commit para fijar la operación
		
		try {
			sesion.save(dep);
			tx.commit();
			
			System.out.println("Departamento insertado");
		}catch(ConstraintViolationException cve){
			System.out.println("Problemas al guardar: Registro duplicado");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problemas al guardar: " + e.getMessage());
		}
		//cerramos la sesión
		sesion.close();
		System.exit(0);
	}

}
