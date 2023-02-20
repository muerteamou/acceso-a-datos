package tools;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import modelo.Departamentos;

public class Main {
	public static void main(String[] args) {
		menu();
	}
	public static void menu() {
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; // Guardaremos la opcion del usuario
		
		
		
		while (!salir) {
			System.out.println("1. Ver departamento");
			System.out.println("2. Insertar un nuevo departamento");
			System.out.println("3. Actualizar datos empleado");
			System.out.println("4. Eliminar empleado");
			System.out.println("5. Mostrar empleados");
			System.out.println("9. Salir");
			try {
				System.out.println("Escribe una de las opciones");
				opcion = sn.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Has seleccionado ver los departamentos");
					DepartamentoVista dl = new DepartamentoVista();
					dl.verDepartamento();
					;
					break;
				case 2:
					System.out.println("Has seleccionado insertar un nuevo departamento");
					DepInsert di = new DepInsert();
					di.insertarDepartamento();
					break;
				case 3:
					System.out.println("Has seleccionado actualizar los datos de un empleado");
					EmpleadoUpdate empUp = new EmpleadoUpdate();
					empUp.updateEmp();
					break;
				case 4:
					System.out.println("Ha seleccionado eliminar empleado");
					EmpleadoDelete ed = new EmpleadoDelete();
					ed.borrarEmp();
					break;
				case 5:
					System.out.println("Ha seleccionado ver los empleados");
					EmpleadoVistaQuery empV  = new EmpleadoVistaQuery();
					empV.mostrarEmp();
					break;
				case 6 : 
					System.out.println("Ha seleccionado insertar empleados");
					
				case 9:
					salir = true;
					break;
				default:
					System.out.println("Solo números entre 1 y 9");
					
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}
		}
		}
	}

