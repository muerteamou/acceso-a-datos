package tools;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Equipo;

public class EquipoVistaQuery {

	public void mostrarEquipo(String eq) {
		// Obtenemos la sessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// Obtenemos la sesion
		Session sesion = sessionFactory.openSession();
		
		// Creamos la consulta
		Query q = sesion.createQuery("from Equipo where name = ?");
		q.setString(1, eq );
		
		// La ejecutamos y obtenemos el resultado en forma lista
		List<Equipo>teams = q.list();
		// Recorremos la lista y mostramos los empleados
		for (Equipo team : teams) {
			System.out.println(team);
		}
		// Cerramos la sesion
		sesion.close();
	}

}
