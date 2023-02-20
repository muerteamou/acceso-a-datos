package vista;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Util.HibernateUtil;
import model.Equipo;

public class GenericRepository<T> {

	private SessionFactory sessionFactory;

	public GenericRepository() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	public Equipo getById(Class<T> type, int id) {
		Session session = sessionFactory.openSession();
		System.out.println(id);
		Equipo entity = (Equipo) session.get(Equipo.class, id);
		session.close();
		return entity;
	}

	public void update(T entity) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}

	public void create(T entity) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(T entity) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	public List<T> getAll(Class<T> type) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from " + type.getSimpleName());
		List<T> entities = query.list();
		session.close();
		return entities;
	}

	public static Equipo selectEquipo(String nombre) {

		SessionFactory sesFactory = HibernateUtil.getSessionFactory();

		Session sesion = sesFactory.openSession();

		Query hqlSelect = sesion.createQuery("from Equipo where nombre=:nombre");
		hqlSelect.setString("nombre", nombre);

		Equipo e = (Equipo) hqlSelect.uniqueResult();

		sesion.close();

		return e;
	}

	public static void main(String[] args) {
		GenericRepository<Equipo> e = new GenericRepository<Equipo>();

		//System.out.println((e.selectEquipo("Warriors")));

		List<Equipo> list = e.getAll(Equipo.class);
		System.out.println(e.selectEquipo("Warriors"));


		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Equipo equipo = (Equipo) iterator.next();
			System.out.println(equipo);
		}
	}

}