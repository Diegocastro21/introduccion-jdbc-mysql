import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("Id Persona: "+resultado.getInt("idpersona"));
                System.out.print(" |Nombre: "+resultado.getString("nombre"));
                System.out.print(" |Apellido: "+resultado.getString("apellido"));
                System.out.print(" |Email: "+resultado.getString("email"));
                System.out.println(" |Telefono: "+resultado.getString("telefono"));

            }
            resultado.close();
            instruccion.close();
            conexion.close();
        }  catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
