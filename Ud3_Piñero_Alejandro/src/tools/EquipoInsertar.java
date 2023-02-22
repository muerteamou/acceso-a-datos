package tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import model.Equipo;

public class EquipoInsertar {

	public static void main(String[] args) {
		
		//Obtenemos la SessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//Obtenemos una sesion
		Session sesion = sessionFactory.openSession();
		
		//Creamos una transacción
		Transaction tx = sesion.beginTransaction();
		System.out.println("Vamos a insertar una fila en Departamento");
		Equipo team = new Equipo();
		team.setCiudad("prueba");
		team.setConferencia("East");;
		team.setNombre("AllStars");
		team.setDivision("Noreste");
		
		//insertamos el objeto y commit para fijar la operación
		
		try {
			sesion.save(team);
			tx.commit();
			
			System.out.println("Equipo insertado");
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
