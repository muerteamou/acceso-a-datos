package vista;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Util.HibernateUtil;
import model.Equipo;

public class main {

	public static void main(String[] args) {
		SessionFactory sesFactory = HibernateUtil.getSessionFactory();

		Session sesion = sesFactory.openSession();

		Query hqlSelect = sesion.createQuery("from Equipo where nombre=:nombre");
		hqlSelect.setString("nombre", "Warriors");

		Equipo e = (Equipo) hqlSelect.uniqueResult();

		sesion.close();
		System.out.println(e.getNombre());
	}

}
