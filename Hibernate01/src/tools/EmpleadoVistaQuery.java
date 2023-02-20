package tools;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Empleados;

public class EmpleadoVistaQuery {

	public void mostrarEmp() {
		// Obtenemos la sessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// Obtenemos la sesion
		Session sesion = sessionFactory.openSession();
		// Creamos la consulta
		Query q = sesion.createQuery("from Empleados");
		// La ejecutamos y obtenemos el resultado en forma lista
		List<Empleados> emps = q.list();
		// Recorremos la lista y mostramos los empleados
		for (Empleados emp : emps) {
			System.out.println(emp);
		}
		// Cerramos la sesion
		sesion.close();
	}

}
