import java.io.*;

public class Ejercicio04 {
    public static void main(String[] args) {

        String archivo = "src\\user_data.txt";
        String encabezado = "id,first_name,last_name,email,gender,ip_address\n";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));

            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            lector.close();

            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));
            escritor.write(encabezado);
            escritor.write(contenido.toString());
            escritor.close();

            System.out.println("El encabezado fue agregado con exito.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
