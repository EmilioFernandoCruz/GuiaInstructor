import java.io.*;

public class Ejercicio05 {
    public static void main(String[] args) {
        // Ruta del archivo
        String archivo = "src\\user_data.txt";
        String id = "73";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            boolean hallado = false;

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length > 0 && campos[0].equals(id)) {
                    System.out.println("Registro hallado:");
                    System.out.println(linea);
                    hallado = true;
                    break;
                }
            }
            lector.close();
            if (!hallado) {
                System.out.println("El registro con ID " + id + " no fue hallado.");
                System.out.println("Intenta con otro número.");
            }
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}

