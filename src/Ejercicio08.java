import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio08 {
    public static void main(String[] args) {
        String archivo1 = "src\\user_data.txt";
        String archivo2 = "src\\user_data_sinDuplicados.txt";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo1));
            BufferedWriter temp = new BufferedWriter(new FileWriter(archivo2));
            List<String> direccionesIPVistas = new ArrayList<>();
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                String direccionIP = campos[5].trim();
                if (!direccionesIPVistas.contains(direccionIP)) {
                    direccionesIPVistas.add(direccionIP);
                    temp.write(linea);
                    temp.newLine();
                }
            }
            lector.close();
            temp.close();
            File archivo1File = new File(archivo1);
            File archivo2File = new File(archivo2);
            archivo2File.renameTo(archivo1File);

            System.out.println("Duplicados eliminados.");

        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
