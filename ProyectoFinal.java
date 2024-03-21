import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProyectoFinal {
	
	public static final int TIPO_DOCUMENTO_IDENTIFICACION = 0;
    public static final int DOCUMENTO_IDENTIFICACION = 1;
    public static final int NOMBRES = 2;
    public static final int APELLIDOS = 3;
    public static final int CORREO_ELECTRONICO = 4;
    public static final int DIRECCION_RESIDENCIA = 5;
    public static final int CIUDAD_RESIDENCIA = 6;
    public static final int TELEFONO_CONTACTO = 7;
    public static final int CONTRASENA = 8;
    public static final int CONFIRMAR_CONTRASENA = 9;
	
	public static List<String[]> usuarios = new ArrayList<>() ;
	public static Scanner leerDatoTeclado = new Scanner(System.in);
	
	public static void mostrarMenuLoginRegistro () {
		System.out.println("Bienvenido a MyHotel...");
		System.out.println("Mas que un lugar para descansar.");
		System.out.println("-------------------------------------");
		System.out.println("Ingrese una opcion deseada.");
		System.out.println("1. Registrarse como cliente.");
		System.out.println("2. Iniciar sesion.");
		System.out.println("3. Salir.");
	}
	
	public static void registrarUsuario(String tipoDocumentoIdentificacion, String documentoIdentificacion, String nombres, String apellidos,
										String correoElectronico, String direccionResidencia, String ciudadResidencia, String telefonoContacto,
										String contrasena, String confirmarContrasena) {
		
		String [] usuario = new String[10];
		usuario [TIPO_DOCUMENTO_IDENTIFICACION] = tipoDocumentoIdentificacion;
		usuario [DOCUMENTO_IDENTIFICACION] = documentoIdentificacion;
		usuario [NOMBRES] = nombres;
		usuario [APELLIDOS] = apellidos;
		usuario [CORREO_ELECTRONICO] = correoElectronico;
		usuario [DIRECCION_RESIDENCIA] = direccionResidencia;
		usuario [CIUDAD_RESIDENCIA] = ciudadResidencia;
		usuario [TELEFONO_CONTACTO] = telefonoContacto;
		usuario [CONTRASENA] = contrasena;
		usuario [CONFIRMAR_CONTRASENA] = confirmarContrasena;
		
		usuarios.add(usuario);
	}
	
	public static void solicitarDatosRegistro() {
		System.out.println("\nFormulario de registro\nPara completar el registro, por favor facilitar la siguiente información.\n");
		System.out.println("Ingrese el tipo de documento de identificacion: ");
		String tipoDocumentoIdentificacion = leerDatoTeclado.nextLine();
		System.out.println("Ingrese el numero de documento de identificacion: ");
		String documentoIdentificacion = leerDatoTeclado.nextLine();
		System.out.println("Ingrese el nombre: ");
		String nombres = leerDatoTeclado.nextLine();
		System.out.println("Ingrese el apellido: ");
		String apellidos  = leerDatoTeclado.nextLine();
		System.out.println("Ingrese el correo electronico: ");
		String correoElectronico = leerDatoTeclado.nextLine();
		System.out.println("Ingrese la direccion de Residencia: ");
		String direccionResidencia = leerDatoTeclado.nextLine();
		System.out.println("Ingrese la ciudad de residencia: ");
		String ciudadResidencia = leerDatoTeclado.nextLine();
		System.out.println("Ingrese el telefono de contacto: ");
		String telefonoContacto = leerDatoTeclado.nextLine();
		System.out.println("Ingrese la contraseña: ");
		String contrasena = leerDatoTeclado.nextLine();
		System.out.println("Confirme la contraseña: ");
		String confirmarContrasena = leerDatoTeclado.nextLine();
		
		while(!contrasena.equals(confirmarContrasena)){
			System.out.println("La confirmación de la contraseña es incorrecta, intentelo nuevamente.");
			System.out.println("Ingrese la contraseña: ");
			contrasena = leerDatoTeclado.nextLine();
			System.out.println("Confirme la contraseña: ");
			confirmarContrasena = leerDatoTeclado.nextLine();
		}
		
		registrarUsuario(tipoDocumentoIdentificacion, documentoIdentificacion, nombres, apellidos, correoElectronico, direccionResidencia, 
						 ciudadResidencia, telefonoContacto, contrasena, confirmarContrasena);
		System.out.println("Usuario agregado correctamente, pulse la tecla enter para continuar.");
        leerDatoTeclado.nextLine();
	}
	
	public static boolean iniciarParametros(String correoElectronico, String contrasena) {
		for(String[] usuario :usuarios) {
			if(usuario[CORREO_ELECTRONICO].equals(correoElectronico) && usuario[CONTRASENA].equals(contrasena)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Boolean ingresoMenu = true;
		int intentos = 0;
		while(ingresoMenu) {
			mostrarMenuLoginRegistro();
			int valor = leerDatoTeclado.nextInt();
			leerDatoTeclado.nextLine();
			
			switch(valor) {
			case 1:
				solicitarDatosRegistro();
				break;
			
			case 2:
				
				boolean acceso;
				System.out.println("\nPara iniciar sesion, ingrese los siguientes datos:\n");
				System.out.println("Ingrese el correo electronico: ");
				String correoElectronico = leerDatoTeclado.nextLine();
				System.out.println("Ingrese la contraseña: ");
				String contrasena = leerDatoTeclado.nextLine();
				acceso = iniciarParametros(correoElectronico, contrasena);
				
				if(acceso==true) {
						System.out.println("Usuario logueado correctamente, pulse la tecla enter para continuar.");
				        leerDatoTeclado.nextLine();
					}else {
						System.out.println("Usuario incorrecto, intente una vez más, pulse la tecla enter para continuar.");
						leerDatoTeclado.nextLine();
						intentos++;
					}
				
				if(intentos == 3) {
					System.out.println("Intentos maximos permitidos, cerrando el programa.");
					ingresoMenu = false;
				}
				
				break;
				
			case 3:
				System.out.println("¡Hasta pronto!");	
				ingresoMenu = false;
				break;
				
			default:
				System.out.println("OPCION INCORRECTA, INTENTELO DE NUEVO.");
				break;
			}
		}
		leerDatoTeclado.close();
	}
}
