import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

public static void main(String[] args) throws SQLException {
		 
		Scanner op = new Scanner(System.in);
		boolean salidaMenu=false;
		int opcion;
		
		
	while(!salidaMenu) {
		
		 System.out.println("\n\t------------Bienvenidos a CINEMAR------------------\n");
		
		 System.out.println("Que desea hacer?\n");
		 System.out.println("1_Registrarse \n2_Iniciar Sesion \n3_Ver Salas\n4_Ver Funciones\n5_Salir\n");
		
		 
		 try {
			 System.out.print("Ingrese su opcion : ");
			
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
		 System.out.println("\n*******Inicio de sesion******\n");
		 
		 System.out.println("Seleccione su ingreso : \n");
		 System.out.println("1_administrador \t2_Usuario Registrado\n");
		 int opcion2=op.nextInt();
		 if (opcion2==1) {
			  System.out.println("\n-------ingreso como Admin-----\n");
		      System.out.print("Ingrese su email: ");
		      Scanner entrada = new Scanner(System.in);
		      String  mail=entrada.nextLine();
		      System.out.print("Ingrese su contra: ");
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
		    	    	ConsultaReser reserva =new ConsultaReser();
		    	    	reserva.mostrar();
		    	     break;
		    	    case 2:
		    	    	 //ver reserva de algun cliente
		    	    	System.out.print("ingresar dni de usuario a buscar: ");
		    	    	Scanner ingreso = new Scanner(System.in);
		    	    	int buscar=ingreso.nextInt();
		    	    	
		    	    	ConsultaReser reserva2= new ConsultaReser();
		    	    	reserva2.mostrar(buscar);
		    	 
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
		    	    	
		    	    	System.out.println("Seleccione la hora para la funcion HH:MM");
		    	    	String hora=opC.next();
		    	    	
		    	    	System.out.println("Seleccione El precio de la funcion");
		    	    	int precio=opC.nextInt();
		    	    	
		    	    	funcion.crearUnaFuncion(id_pelicula, sala, fecha, hora ,precio);
		    	    
		    	   
		    	    	
		    	 
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
		    	    System.out.println("Lunes  y  Miércoles: 20%  \n Martes y  Jueves: 15% \n Viernes, Sábados y Domingos: 10%" );
		    	    	
		           
		
                   
		    	    	break;
		    	    
		    	    default:
		    	    
		    	  }
		      }else{
		    	  System.out.println("admin no encontrado");
		      }
		      
		 }else if(opcion2 == 2){
			  System.out.println("\nIngreso como usuario Registrado");
		      System.out.print("\nIngrese su email: ");
		      Scanner entrada = new Scanner(System.in);
		      String  mail=entrada.nextLine();
		      System.out.print("Ingrese su contra: ");
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
		    	    	int Cliente= cliente.getId_usuario();
			    	
			  System.out.println("--------------------CARTELERA CINEMAR--------------------------------");
			    	 ConsultaFunc funciones=new ConsultaFunc();
			    	 funciones.mostrar();
			  System.out.println("---------------------------------------------------------------------\n");
			  System.out.println("---------------------------------------------------------------------");  
			  ConsultaSala Salas = new ConsultaSala();
                      Salas.mostrar();
                      //stop para pruebas
			    	/*Scanner stop = new Scanner(System.in);
			    	System.out.println("STOOOP");
			    	int a=stop.nextInt();
			    	*/
			    	System.out.println("seleccione funcion");
			    	Scanner Seleccion = new Scanner(System.in);
			    	int Selec=Seleccion.nextInt();
			    	ConsultaFunc FechaF= new ConsultaFunc();
			    	String FechaReser=FechaF.ConsultaFecha(Selec);
			    	String FechaHora=FechaF.ConsultaHora(Selec);
			    	
			    	ConsultaButaca butaca = new ConsultaButaca();
			    	butaca.mostrar();
			    	
			    	ConsultaFunc precioF = new ConsultaFunc();
                    int precio=precioF.ConsultarPrecio(Selec);	
			    	Boolean salida=false;
			    	
			    	Scanner eleccion = new Scanner(System.in);
			    int numeroBut=1;
			    	
			    	while(!salida) {
			    		System.out.println("seleccione BUTACA NRO");
			    	numeroBut = eleccion.nextInt();
			    	ConsultaButaca validaButac = new ConsultaButaca();
			    	if(validaButac.comprobarDisp(numeroBut)==0) {
			    	System.out.println("butaca elegida correctamente");
			    	salida=true;
			    	}else {
			    		System.out.println("butaca incorrecta vuelva a elegir");
			    	 salida=false;
			    	}
			    	//SELECCIONA BUTACA DISPONIBLE 
			    	}
			    	ConsulTarjCredito Pago = new ConsulTarjCredito();
			    	System.out.println("PROCEDIENDO AL PAGO ");
			    	System.out.println("INSERTE Numero de TARJETA");
			        Scanner Atributos = new Scanner(System.in);
			        String numero = Atributos.nextLine();
			        System.out.println("INSERTE SU BALANCE");
			        double balance =Atributos.nextDouble();
			        System.out.println("INSERTE limite de tarjeta");
			        double limite = Atributos.nextDouble();
			        System.out.println("INSERTE NOMBRE del banco");
			        String banco = Atributos.nextLine();
			        
			    	Pago.inserta_TarjetaCredito(numero,balance, limite, banco);
			    	int idTARJ= Pago.consultar(numero);
			        if (precio < limite && balance>0) {
			        	System.out.println("pago realizado xd");
			        }
			    	
		// sí acudieron al menos 6 veces en 3 meses, en caso contrario el precio de la entrada no tendrá descuento alguno.

			    	  //1,2,2021-03-02-,500,1,13:00,127,3,1
			   // TARJETA DE CREDITO DE UN USUARIO Y DESCUENTO :(
			        System.out.println("Ingrese el dia de hoy");
			        Scanner dia = new Scanner(System.in);
			    	Scanner opD = new Scanner(System.in);
	    	    	String dia1=opD.nextLine();
	    	    	float porcentaje = 0;
	    	    	if (dia1=="lunes" || dia1=="miercoles"){
	    	    		porcentaje=20;
	    	    	}else if(dia1=="martes" || dia1 =="jueves"){
	    	    		porcentaje=15;
	    	    	}else if(dia1 == "viernes"|| dia1=="sabado" || dia1 =="domingo") {
	    	    		porcentaje=10;	
	    	    	}else { 
	                System.out.println("ingreso incorrecto");
	    	    	}
	    	    	float precioFinal = (precio*porcentaje/100);
	    	   ConsultaDesc descuento = new ConsultaDesc();
	           descuento.Creadescuento(dia1,porcentaje,precioFinal);
	

			        
			       Reserv reserva= new Reserv(Selec,FechaReser,precio,Cliente,FechaHora,numeroBut,precioFinal,idTARJ);
		    	     ConsultaReser NuevaReser = new ConsultaReser();
		    	     NuevaReser.insertar(reserva);
		    	  
		   
		    	     break;
		    	    case 2:
		    	    	//modific reserva
		    	     break;
		    	 
		    	    case 3 :
		    	    	//observar reservas
		    	     ConsultaReser  reserv = new ConsultaReser();
		    	     reserv.mostrar();
		    	     break;
		    	     
		    	    case 4:
		    	    	//ver historico de reservas
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
			System.out.println("1_Registrarse \n2_Iniciar Sesion \n3_Ver Salas\n4_Ver Funciones\n5_Salir");
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
		
	

