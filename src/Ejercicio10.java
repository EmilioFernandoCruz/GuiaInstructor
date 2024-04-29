import java.io.*;

public class Ejercicio10 {
    public static void main(String[] args) {
        String archivo1 = "src\\user_data.txt";
        String archivo2 = "src\\user_names.txt";
        String archivo3 = "src\\user_data_NuevaColumna.txt";

        try {
            BufferedReader lector1 = new BufferedReader(new FileReader(archivo1));
            BufferedReader lector2 = new BufferedReader(new FileReader(archivo2));
            BufferedWriter temp = new BufferedWriter(new FileWriter(archivo3));
            String lineaOriginal;
            String lineaUserNames;
            while ((lineaOriginal = lector1.readLine()) != null &&
                    (lineaUserNames = lector2.readLine()) != null) {
                String lineaActualizada = lineaOriginal + "," + lineaUserNames;

                temp.write(lineaActualizada);
                temp.newLine();
            }
            lector1.close();
            lector2.close();
            temp.close();

            File archivo1File = new File(archivo1);
            File archivo2File = new File(archivo3);
            archivo2File.renameTo(archivo1File);

            System.out.println("Se agregó la columna de nombre de usuario al registro original exitosamente.");

        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
