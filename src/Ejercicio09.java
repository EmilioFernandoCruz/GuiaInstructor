import java.io.*;

public class Ejercicio09 {
    public static void main(String[] args) {
        String archivo = "src\\user_data.txt";
        String num = "170.";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            int cantidadRegistros = 0;
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                String IP = campos[5].trim();
                if (IP.startsWith(num)) {
                    cantidadRegistros++;
                }
            }
            lector.close();
            System.out.println("La Cantidad mostrada de registros de su dirección IP pertenece al rango \"" + num + "\": " + cantidadRegistros);

        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}

