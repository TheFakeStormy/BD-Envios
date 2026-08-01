import java.sql.Connection;

void main() {

    try(Connection con = Conexion.getConnection()){
        System.out.println("La conexion funciona");
        UI.Menu(con);
    }catch(Exception e){
        System.out.println("Algo salio mal con la conexion ["+e.getMessage()+"]");
    }
}
