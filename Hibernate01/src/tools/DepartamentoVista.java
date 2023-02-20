package tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Departamentos;
import modelo.Empleados;

public class DepartamentoVista {

	public void verDepartamento() {

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

	}

	public ArrayList<ArrayList> verDptoInterfaz(int dpto) {

		SessionFactory sesFactory = HibernateUtil.getSessionFactory();

		Session sesion = sesFactory.openSession();

		ArrayList<ArrayList> dptoEmpList = new ArrayList<ArrayList>();
		ArrayList<String> dptoList = new ArrayList<>();
		ArrayList<String> empList = new ArrayList<>();
		// Inicializamos a null

		Departamentos depart = null;

		int dpno = dpto;

		depart = (Departamentos) sesion.get(Departamentos.class, (int) dpno);

		if (depart != null) {

			dptoList.add(depart.getDnombre());
			dptoList.add(depart.getLoc());
			dptoEmpList.add(dptoList);
			//System.out.println("Nombre del dpto " + depart.getDnombre());
			//System.out.println("Localización " + depart.getLoc());

			Set<Empleados> empleados = depart.getEmpleadoses();
			Iterator<Empleados> it = empleados.iterator();

			//System.out.println("Nº de empeados: " + empleados.size());

			while (it.hasNext()) {
				Empleados emp = it.next();
				empList.add(emp.getApellido());
				empList.add(String.valueOf(emp.getSalario()));
				//System.out.print("Apellido: " + emp.getApellido());
				//System.out.println(" \tSalario: " + emp.getSalario());

			}
			dptoEmpList.add(empList);
		} else {
			//System.out.println("No existe el departamento");
		}

		sesion.close();
		return dptoEmpList;
	}
}
