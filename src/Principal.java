import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

public static void main(String[] args) throws SQLException {
		 
		Scanner op = new Scanner(System.in);
		boolean salidaMenu=false;
		int opcion;
		
	while(!salidaMenu) {
		 System.out.println("        ------------Bienvenidos a CINEMAR------------------\n");
		 System.out.println("Que desea hacer?");
		 System.out.println("1_Registrarse \n2_Iniciar Sesion \n3_Ver Salas\n4_Salir");
		try {
				 opcion=op.nextInt();
		switch (opcion) {
	 case 1:
	
		 System.out.println("*******Registro******");
		 System.out.println("registrar nuevo usuario");
		 System.out.println("Ingrese email: ");
		  Scanner e1 = new Scanner(System.in);
		  String email=e1.nextLine();
		  System.out.println("Ingrese clave: ");
		  String clave=e1.nextLine();
		  System.out.println("Ingrese nombre: ");
		  String nombre= e1.nextLine();
		  System.out.println("Ingrese apellido: ");
		  String apellido=e1.nextLine();

		   CreaUser usuario = new CreaUser(email,clave,nombre,apellido,2);
		   ConsultasUser RegistrarUser = new ConsultasUser();
		   RegistrarUser.RegistrarUser(usuario);
		 
		 break;
	 case 2:
		 System.out.println("*******Inicio de sesion******");
		 
		 System.out.println("Seleccione su ingreso : \n");
		 System.out.println("1_administrador \t2_Usuario Registrado\n");
		 int opcion2=op.nextInt();
		 if (opcion2==1) {
			  System.out.println("ingreso como Admin");
		      System.out.println("Ingrese su email: ");
		      Scanner entrada = new Scanner(System.in);
		      String  mail=entrada.nextLine();
		      System.out.println("Ingrese su contra: ");
		      Scanner entrada2 = new Scanner(System.in);  //es necesario 2 scanner?
		      String contra=entrada2.nextLine();
		      ConsultasUser IngresarAdmin = new ConsultasUser();
			    if(  IngresarAdmin.ingresar(mail, contra, 1) != null) {
		    	  System.out.println("que desea hacer? \n");
		    		 System.out.println("1_Ver reservas de todos los clientes \t2_ver reserva especifica \t3_Crear nueva sala \t4_Modificar una sala \t5_eliminar una sala \t6_modificar descuentos \n");
		    	  int opAdmin = op.nextInt();
		    	  switch (opAdmin) { 
		    	    case 1:
		    	     
		    	     break;
		    	    case 2:
		    	    
		    	     break;
		    	 
		    	    case 3 :
		    	     
		    	     break;
		    	     
		    	    case 4:
		    	    	
		    	    break;
		    	    case 5:
		    	    	break;
		    	    case 6:
		    	    	break;
		    	    
		    	    default:
		    	    
		    	  }
		      }else{
		    	  System.out.println("estas aqui");
		      }
		      
		 }else if(opcion2 == 2){
			  System.out.println("ingreso como usuario Registrado");
		      System.out.println("Ingrese su email: ");
		      Scanner entrada = new Scanner(System.in);
		      String  mail=entrada.nextLine();
		      System.out.println("Ingrese su contra: ");
		      Scanner entrada2 = new Scanner(System.in);  //es necesario 2 scanner?
		      String contra=entrada2.nextLine();
		      ConsultasUser IngresarUsRe = new ConsultasUser();
		      IngresarUsRe.ingresar(mail, contra, 2);
		    	  System.out.println("Que desea hacer? \n");
		    		 System.out.println("1_Crear una reserva \t2_Modificar una reserva \t3_Observar mis reservas \t4_ver el historico de mis entradas.\n");
		    	  int opUser = op.nextInt();
		    	  switch (opUser) { 
		    	    case 1:
		    	    Reserv reserva= new Reserv(2);
		    	     ConsultaReser NuevaReser = new ConsultaReser();
		    	     NuevaReser.insertar(reserva);
		    	     break;
		    	    case 2:
		    	    
		    	     break;
		    	 
		    	    case 3 :
		    	     
		    	     break;
		    	     
		    	    case 4:
		    	    	
		    	    break;
		    	    
		    	    default:
		    	    
		    	  }
		    	
		    	
		    	
		    
		      
		 }
	 break;
	 case 3:
		 System.out.println("*******Cartelera******");
		ConsultaFunc funcion = new ConsultaFunc();
		funcion.mostrar(); 
		
		 break;
	 case 4:
		 System.out.println("Gracias por usar el sistema CINEMAR");
		 salidaMenu=true;
		 break;
		 default:
		    System.out.println("*******OPCION INCORRECTA INTENTE DE NUEVO******");
			System.out.println("Que desea hacer?");
			System.out.println("1_Registrarse \n2_Iniciar Sesion\n3_Ver Salas");
			opcion=op.nextInt();
	 }
	}catch(InputMismatchException e) {
		System.out.println("Debes ingresar un numero");
		op.next();
	}
		
	}
op.close();
	}

}
		
	

