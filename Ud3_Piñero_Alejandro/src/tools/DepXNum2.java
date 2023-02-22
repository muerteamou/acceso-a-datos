package tools;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import modelo.Departamentos;
import modelo.Empleados;

public class DepXNum2 {

	public void verDepXNum() {

		// Crea un ejemplar de SessionFactory
		SessionFactory sesFactory = HibernateUtil.getSessionFactory();

		Session sesion = sesFactory.openSession();

		// Inicializamos a null

		Departamentos depart = null;

		System.out.println("Introduce el número de departamento, pulsa 0 para salir");

		Scanner s = new Scanner(System.in);

		int dpno = s.nextInt();

		while (dpno != 0) {

			depart = (Departamentos) sesion.get(Departamentos.class, (int) dpno);

			if (depart != null) {
				System.out.println("Nombre del dpto " + depart.getDnombre());
				System.out.println("Localización " + depart.getLoc());
				Set<Empleados> empleados = depart.getEmpleadoses();
				Iterator<Empleados> it = empleados.iterator();
				System.out.println("Nº de empeados: " + empleados.size());

				while (it.hasNext()) {
					Empleados emp = it.next();
					System.out.print("Apellido: " + emp.getApellido());
					System.out.println(" \tSalario: " + emp.getSalario());
				}
			} else {
				System.out.println("No existe el departamento");
			}

			System.out.println("Introduce el número de departamento, pulsa 0 para salir");
			dpno = s.nextInt();
		}
		sesion.close();
		s.close();
		System.exit(0);
	}
}
