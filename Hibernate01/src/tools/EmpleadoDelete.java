package tools;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Empleados;

public class EmpleadoDelete {

	public void borrarEmp() {

		// Obtenemos la sessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// Obtenemos la sesion
		Session sesion = sessionFactory.openSession();

		// Creamos la transaccion

		Transaction tx = sesion.beginTransaction();
		Scanner s = new Scanner(System.in);
		System.out.println("Introduce el numero de empleado a borrar.");

		int numEmp = s.nextInt();
		// Leemos el objeto que deseamos borrar
		try {
			Empleados emp = (Empleados) sesion.load(Empleados.class, (int) numEmp);
			sesion.delete(emp); // borramos el empleado
			System.out.println("Empleado borrado.");
			
		} catch (ObjectNotFoundException e) {
			System.out.println("El empleado no existe");
			borrarEmp();
		}
		tx.commit(); //Confirmamos la transacción
		//Cerramos la sesion.
		s.close();
		sesion.close();
	}
}