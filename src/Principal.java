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
		 System.out.println("1_Registrarse \n2_Iniciar Sesion \n3_Ver Salas\n4_Ver Funciones\n5_Salir");
		
		 
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
		      Scanner entrada2 = new Scanner(System.in);  
		      String contra=entrada2.nextLine();
		      ConsultasUser IngresarAdmin = new ConsultasUser();
			    if( IngresarAdmin.ingresar(mail, contra, 1) != null) {
		    	  System.out.println("que desea hacer? \n");
		    		 System.out.println("1_Ver reservas de todos los clientes \t2_ver reserva especifica \t3_Crear nueva sala \t4_Crear nueva funcion \t5_Modificar una sala \t6_eliminar una sala \t7_modificar descuentos  \n");
		    	  int opAdmin = op.nextInt();
		    	  switch (opAdmin) { 
		    	    case 1:
		    	     //ver reservas de clientes
		    	     break;
		    	    case 2:
		    	 //ver reserva de algun cliente
		    	     break;
		    	 
		    	    case 3 :
		    	    	   //crear sala y funcion 
		    	    	ConsultaSala Sala=new ConsultaSala();
		    	    	Sala.CrearSala();
		    	    	ConsultasPeli peli=new ConsultasPeli();
		    	    	Scanner Ingrpel = new Scanner(System.in);
				   	  System.out.println("INGRESE DURACION \n");
		    	    	int duracion=Ingrpel.nextInt();
				   	  System.out.println("Ingrese descripcion \n");
		    	    	String Descripcion=Ingrpel.next();
				   	  System.out.println("ingrese titulo \n");
		    	    	String titulo=Ingrpel.next();
			    	  System.out.println("ingrese si es estreno \n");
		    	    	Boolean Estreno=Ingrpel.nextBoolean();
				   	  System.out.println("ingrese idioma \n");
		    	    	String Idioma=Ingrpel.next();
				      System.out.println("ingrese precio\n");
		    	    	float PrecioxPers=Ingrpel.nextFloat();
		    	    	pelicula Peli = new pelicula(duracion,Descripcion,titulo,Estreno,Idioma,PrecioxPers);
		    	    	peli.insertar(Peli);
		    	    break;
		    	    case 4:
		    	    	//Crear Funcion
		    	    ConsultasPeli  Cpeli = new ConsultasPeli();
		    	    	Cpeli.mostrar();
		    	    	System.out.println("Seleccione la pelicula para la funcion");
		    	    	Scanner opC =new Scanner(System.in);
		    	    	int id_pelicula=opC.nextInt();
		    	    	
		    	    	ConsultaFunc funcion =new ConsultaFunc();
		    	    	ConsultaSala Sala4 = new ConsultaSala();
		    	    	Sala4.mostrar();
		    	    	System.out.println("Seleccione sala Disp para la funcion");
		    	    	int sala=opC.nextInt();
		    	    	
		    	    
		    	    	System.out.println("Seleccione fecha para la funcion YYYY-MM-DD");
		    	    	String fecha=opC.next();
		    	    	
		    	    	funcion.crearUnaFuncion(id_pelicula,sala,fecha);
		 
		    	 
		    	    	funcion.mostrar();
		    	     break;
		    	     
		    	    case 5:
		    	    	//modificar sala
		    	    	ConsultaSala Sala2 = new ConsultaSala();
		    	    	Sala2.mostrar();
		    	    	Sala2.ModifSala();
		    	    	Sala2.mostrar();
		    	    break;
		    	    case 6:
		    	    	//eliminar una sala
		    	    	ConsultaSala Sala3 = new ConsultaSala();
		    	    	Sala3.EliminSala();
		    	    	Sala3.mostrar();
		    	    	break;
		    	    case 7:
		    	    	//modificar descuentos 
		    	    /*Lunes y  Miércoles: 20%
		    	    	Martes y  Jueves: 15%
		    	    	Viernes, Sábados y Domingos: 10% */
		    	    	Scanner opD = new Scanner(System.in);
		    	    	String dia=opD.nextLine();
		    	    	float porcentaje;
		    	    	if (dia=="lunes"){
		    	    		
		    	    	}
		    	   ConsultaDesc descuento = new ConsultaDesc();
		           descuento.Creadescuento(dia,20,800);
		
                   
		    	    	break;
		    	    
		    	    default:
		    	    
		    	  }
		      }else{
		    	  System.out.println("admin no encontrado");
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
		    
		      
		     CreaUser cliente = new CreaUser();
		     cliente =  IngresarUsRe.ingresar(mail, contra, 2);
		    
		     
		    	  System.out.println("Que desea hacer? \n");
		    		 System.out.println("1_Crear una reserva \t2_Modificar una reserva \t3_Observar mis reservas \t4_ver el historico de mis entradas.\n");
		    	  int opUser = op.nextInt();
		    	  switch (opUser) { 
		    	  
		    	 //crear reserva
		    	  case 1:
		    	    	cliente.getId_usuario();
			    	 System.out.println(cliente.getId_usuario());
			    	  
			    	    Reserv reserva= new Reserv(5,"2022-07-16",500,cliente.getId_usuario(),2,"13:47:00",1);
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
		ConsultaSala sala = new ConsultaSala();
		sala.mostrar(); 
		
		
		 break;
	 case 4:
		 System.out.println("*******Funciones Actuales******");
		 ConsultaFunc funcion =new ConsultaFunc();
	    	funcion.mostrar();
	 case 5:
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
		
	

