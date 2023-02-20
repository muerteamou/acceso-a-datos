package tools;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import modelo.Departamentos;

public class DepInsert {

	public void insertarDepartamento() {
		// Obtenemos la SessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// Obtenemos una sesion
		Session sesion = sessionFactory.openSession();

		// Creamos una transacción
		Transaction tx = sesion.beginTransaction();
		System.out.println("Vamos a crear un nuevo Departamento");
		Departamentos dep = new Departamentos();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce el número de departamento");
		
		dep.setDptoNo(s.nextInt());
		
		System.out.println("Introduce el nombre del departamento");
		s.nextLine();
		dep.setDnombre(s.nextLine());
		
		System.out.println("Introduce la localidad");
		dep.setLoc(s.nextLine());

		// insertamos el objeto y commit para fijar la operación

		try {
			sesion.save(dep);
			tx.commit();

			System.out.println("Departamento insertado");
		} catch (ConstraintViolationException cve) {
			System.out.println("Problemas al guardar: Registro duplicado");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problemas al guardar: " + e.getMessage());
		}
		// cerramos la sesión
		s.close();
		sesion.close();

	}
	
	public void insDepart(int ndpto, String nom, String loc) {
		// Obtenemos la SessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// Obtenemos una sesion
		Session sesion = sessionFactory.openSession();

		// Creamos una transacción
		Transaction tx = sesion.beginTransaction();
		Departamentos dep = new Departamentos();
		
		dep.setDptoNo(ndpto);
		dep.setDnombre(nom);
		dep.setLoc(loc);

		// insertamos el objeto y commit para fijar la operación

		try {
			sesion.save(dep);
			tx.commit();

			System.out.println("Departamento insertado");
		} catch (ConstraintViolationException cve) {
			System.out.println("Problemas al guardar: Registro duplicado");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problemas al guardar: " + e.getMessage());
		}
		// cerramos la sesión
		sesion.close();

	}

}
