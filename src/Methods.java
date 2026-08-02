import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Methods {
    public static void AgregarEnvio(Connection con, String Envio, String Paquete, String Direccion, String Destinatario, double Peso, double Coste) throws SQLException{
        String sql = "INSERT INTO [Tabla 1] (Envio, Paquete, Direccion, Destinatario, Peso, Coste) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, Envio);
            statement.setString(2, Paquete);
            statement.setString(3, Direccion);
            statement.setString(4, Destinatario);
            statement.setDouble(5, Peso);
            statement.setDouble(6, Coste);

            int FilasAF = statement.executeUpdate();
            if(FilasAF > 0){
                System.out.println("Paquete registrado con exito!");
            }else{
                System.out.println("ERROR, el paquete no ha sido registrado");
            }
        }catch(SQLException e){
            System.out.println("Error al ejecutar el codigo "+e.getMessage());
        }
    }

    public static void ListaEnvios(Connection con) throws SQLException{
        String sql = "SELECT ID, Envio, Paquete, Direccion, Destinatario, Peso, Coste FROM [Tabla 1]";
        try(PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery()){
            System.out.println("Lista de Envios:");
            while(rs.next()){
                imprimirFila(rs);
            }
        }catch (SQLException e){
            System.out.println("Error al ejecutar el codigo "+e.getMessage());
        }
    }

    public static void ModEnvio(Connection con, int ID, String Direccion, String Destinatario, double Peso, double Coste) throws SQLException{
        String sql = "UPDATE [Tabla 1] SET Direccion = ?, Destinatario = ?, Peso = ?, Coste = ? WHERE ID = ?";
        try(PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, Direccion);
            statement.setString(2, Destinatario);
            statement.setDouble(3, Peso);
            statement.setDouble(4, Coste);
            statement.setInt(5, ID);

            int FilasAF = statement.executeUpdate();
            if(FilasAF > 0){
                System.out.println("Paquete registrado con exito!");
            }else{
                System.out.println("ERROR, el paquete no ha sido registrado");
            }
        }catch (SQLException e){
            System.out.println("Error al ejecutar el codigo "+e.getMessage());
        }
    }

    public static void ElimPaq(Connection con, int ID) throws SQLException{
        String sql = "DELETE FROM [Tabla 1] WHERE ID = ?";
        try(PreparedStatement statement = con.prepareStatement(sql)){
            statement.setInt(1, ID);

            int FilasAF = statement.executeUpdate();
            if(FilasAF > 0){
                System.out.println("Paquete registrado con exito!");
            }else{
                System.out.println("ERROR, el paquete no ha sido registrado");
            }
        }catch (SQLException e){
            System.out.println("Error al ejecutar el codigo "+e.getMessage());
        }
    }

    public static void BuscarEnvio(Connection con, String TipoEnvio) throws SQLException{
        String sql = "SELECT ID, Envio, Paquete, Direccion, Destinatario, Peso, Coste FROM [Tabla 1] WHERE Envio = ?";
        try(PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, TipoEnvio);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                imprimirFila(rs);
            }
        }catch (SQLException e){
            System.out.println("Error al ejecutar el codigo "+e.getMessage());
        }

    }

    private static void imprimirFila(ResultSet rs) throws SQLException {
        System.out.printf("ID: %d | Envio: %s | Paquete: %s | Dir: %s | Destinatario: %s | Peso: %.2f kg | Coste: $%.2f%n",
                rs.getInt("ID"),
                rs.getString("Envio").trim(),
                rs.getString("Paquete").trim(),
                rs.getString("Direccion").trim(),
                rs.getString("Destinatario").trim(),
                rs.getDouble("Peso"),
                rs.getDouble("Coste"));
    }


}

