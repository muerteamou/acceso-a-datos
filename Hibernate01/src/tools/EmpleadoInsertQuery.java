package tools;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmpleadoInsertQuery {

	public void insertarEmp() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session sesion = sessionFactory.openSession();

		Transaction tx = sesion.beginTransaction();

		String hqlInsert = ("insert into Empleados (emp_no, apellido, dpto_no) select ?,?,? ");
		Query queryInsert = sesion.createQuery(hqlInsert);
	
	}

}
