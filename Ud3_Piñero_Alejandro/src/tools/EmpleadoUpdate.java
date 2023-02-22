package tools;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Departamentos;
import modelo.Empleados;

public class EmpleadoUpdate {

	public void updateEmp() {
		SessionFactory sesFactory = HibernateUtil.getSessionFactory();

		Session sesion = sesFactory.openSession();

		Transaction tx = sesion.beginTransaction();

		// definimos el objeto y le asignamos el valor de la busqueda

		System.out.println("Introduce el número de empleado a modificar");
		Scanner s = new Scanner(System.in);
		int numEmp = s.nextInt();
		Empleados emp = (Empleados) sesion.get(Empleados.class, (int) numEmp);
		int numDep;
		String apellido;
		if (emp != null) {
			System.out.println("Introduce el nuevo departamento al empleado");
			numDep = s.nextInt();
			Departamentos dep = (Departamentos) sesion.get(Departamentos.class, (int) numDep);
			if (dep != null) {
				emp.setDepartamentos(dep);
				System.out.println("Introduce el apellido");
				s.nextLine();
				apellido = s.nextLine();
				emp.setApellido(apellido);

				// modificamos el empleado con los nuevos valores

				sesion.update(emp);

				tx.commit();
				System.out.println("Empleado modificado.");
				
			}else {
				System.out.println("No existe el departamento asginado.");
				updateEmp();
			}

		}else {
			System.out.println("No existe el empleado.");
			updateEmp();
		}
		s.close();
		sesion.close();		
	}
}
