import java.io.*;

public class Ejercicio06 {
    public static void main(String[] args) {
        // Ruta del archivo
        String archivo = "src\\user_data.txt";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            File archivo2 = new File("src\\user_data_actualizado.txt");
            BufferedWriter temp = new BufferedWriter(new FileWriter(archivo2));
            String encabezado = lector.readLine();
            temp.write(encabezado);
            temp.newLine();
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                String primerLetraNombre = campos[1].substring(0, 1);
                String primerLetraApellido = campos[2].substring(0, 1);
                String tresDigitos = String.format("%03d", campos[2].length());
                String ID = primerLetraNombre.toUpperCase() + primerLetraApellido.toUpperCase() + tresDigitos;

                campos[0] = ID;

                String lineaActualizada = String.join(",", campos);
                temp.write(lineaActualizada);
                temp.newLine();
            }
            lector.close();
            temp.close();

            File archivo1 = new File(archivo);
            archivo2.renameTo(archivo1);

            System.out.println(" ID actualizado.");
            System.out.println("COMPARAR CON EL OTRO ARCHIVO DE TEXTO (user_data)");

        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
