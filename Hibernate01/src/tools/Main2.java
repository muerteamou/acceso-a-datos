package tools;

import java.sql.*;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransientPropertyValueException;
import org.hibernate.exception.ConstraintViolationException;

import modelo.Departamentos;
import modelo.Empleados;

public class Main2 {

	public static void main(String[] args) {
		
		//Obtenemos la SessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//Obtenemos una sesion
		Session sesion = sessionFactory.openSession();
		
		//Creamos una transacción
		Transaction tx = sesion.beginTransaction();
		System.out.println("Vamos a insertar un registro en Empleados");
		
		//Definimos el objeto que queremos insertar en primer
		//lugar: objeto Departamento; y asignarlo; para crear la Clave Foranea
		
		Departamentos dep = new Departamentos();
		dep.setDptoNo(11);
		
		//
		Empleados emp = new Empleados();

		emp.setDepartamentos(dep);
		emp.setEmpNo(11);
		emp.setApellido("Alex");
		emp.setDir((short)1);
		emp.setFechaAlta(Date.valueOf(LocalDate.now()));
		
		
		//insertamos el objeto y commit para fijar la operación
		
		try {
			sesion.save(emp);
			tx.commit();
			
			System.out.println("Empleado insertado");
		}catch(ConstraintViolationException cve){
			System.out.println("Problemas al guardar: Registro duplicado");
		}catch(TransientPropertyValueException tpve) {
			System.out.println("Problemas al guardar: El departamento indicado no existe");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problemas al guardar: " + e.getMessage());
		}
		//cerramos la sesión
		sesion.close();
		System.exit(0);
	}

}
