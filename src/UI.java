import java.sql.Connection;
import java.util.Scanner;

public class UI {
    public static void Menu(Connection con){
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
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                default:
            }

        }while(menu == true);
    }
}
