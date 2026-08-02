import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UI {
    public static void Menu(Connection con) throws SQLException {
        Scanner teclado = new Scanner (System.in);
        boolean menu = true;
        int opc = 0;
        do{
            System.out.println("----- Menu de Opciones -----");
            System.out.println("[1] Nuevo Envio");
            System.out.println("[2] Ver Lista de Envios");
            System.out.println("[3] Modificar Envio");
            System.out.println("[4] Eliminar Envio");
            System.out.println("[5] Envios por tipo");
            System.out.println("[6] Salir de Programa");
            opc = teclado.nextInt();
            switch (opc){
                case 1:
                    System.out.println("Nuevo envio");
                    System.out.println("Ingresar el tipo de Envío");
                    System.out.println("[1] Normal");
                    System.out.println("[2] Internacional");
                    System.out.println("[3] Frágil");
                    System.out.println("[4] Express");
                    System.out.println("[5] Estándar");
                    int tipoEnvioOp = teclado.nextInt();
                    teclado.nextLine();

                    TipoEnvio envioObj = null;
                    switch (tipoEnvioOp) {
                        case 1: envioObj = new EnvioNormal();
                        break;
                        case 2: envioObj = new EnvioInternacional();
                        break;
                        case 3: envioObj = new EnvioFragil();
                        break;
                        case 4: envioObj = new EnvioExpress();
                        break;
                        case 5: envioObj = new EnvioEstandar();
                        break;
                        default:
                            System.out.println("Opción no válida. Se asignará Envío Normal por defecto.");
                            envioObj = new EnvioNormal();
                            break;
                    }
                    System.out.println("Ingresar el tipo de Paquete");
                    System.out.println("[1] Normal");
                    System.out.println("[2] Internacional");
                    System.out.println("[3] Frágil");
                    System.out.println("[4] Express");
                    System.out.println("[5] Estándar");
                    int tipoPaqOp = teclado.nextInt();
                    teclado.nextLine();

                    TipoPaquete paqueteObj = null;
                    switch (tipoPaqOp) {
                        case 1: paqueteObj = new PaqueteNormal();
                        break;
                        case 2: paqueteObj = new PaqueteInternacional();
                        break;
                        case 3: paqueteObj = new PaqueteFragil();
                        break;
                        case 4: paqueteObj = new PaqueteExpress();
                        break;
                        case 5: paqueteObj = new PaqueteEstandar();
                        break;
                        default:
                            System.out.println("Opción no válida. Se asignará Paquete Normal por defecto.");
                            paqueteObj = new PaqueteNormal();
                            break;
                    }
                    System.out.println("Ingresar Dirección");
                    String Direccion = teclado.nextLine();

                    System.out.println("Ingresar Destinatario");
                    String Destinatario = teclado.nextLine();

                    System.out.println("Ingresar Peso");
                    double Peso = teclado.nextDouble();
                    teclado.nextLine();
                    double Coste = paqueteObj.CalcularCosto(Peso);

                    try {
                        Methods.AgregarEnvio(con, envioObj.Tipo(), paqueteObj.TipoPaquete(), Direccion, Destinatario, Peso, Coste);
                    } catch (Exception e) {
                        System.out.println("Error al registrar el envío: " + e.getMessage());
                    }
                    break;
                case 2:
                    Methods.ListaEnvios(con);
                    break;
                case 3:
                    System.out.println("Ingrese el ID del envío a modificar: ");
                    int idMod = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nueva Dirección: ");
                    String nuevaDir = teclado.nextLine();
                    System.out.print("Nuevo Destinatario: ");
                    String nuevoDest = teclado.nextLine();
                    System.out.print("Nuevo Peso: ");
                    double nuevoPeso = teclado.nextDouble();
                    double nuevoCoste = nuevoPeso * 12.0;

                    Methods.ModEnvio(con, idMod, nuevaDir, nuevoDest, nuevoPeso, nuevoCoste);
                    break;
                case 4:
                    System.out.println("Ingrese el ID del envío que desea eliminar: ");
                    int idElim = teclado.nextInt();
                    Methods.ElimPaq(con, idElim);
                    break;
                case 5:
                    System.out.println("--- Buscar Envíos por Tipo ---");
                    System.out.println("[1] Normal");
                    System.out.println("[2] Internacional");
                    System.out.println("[3] Fragil");
                    System.out.println("[4] Express");
                    System.out.println("[5] Estandar");
                    System.out.print("Seleccione una opción: ");
                    int tipoBusqueda = teclado.nextInt();
                    teclado.nextLine();

                    String tipoTexto = "";
                    switch (tipoBusqueda) {
                        case 1: tipoTexto = "Normal";
                        break;
                        case 2: tipoTexto = "Internacional";
                        break;
                        case 3: tipoTexto = "Fragil";
                        break;
                        case 4: tipoTexto = "Express";
                        break;
                        case 5: tipoTexto = "Estandar";
                        break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    if (!tipoTexto.isEmpty()) {
                        Methods.BuscarEnvio(con, tipoTexto);
                    }
                    break;
                case 6:
                    break;
                default:
            }

        }while(menu == true);
    }
}
