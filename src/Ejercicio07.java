import java.io.*;

public class Ejercicio07 {
    public static void main(String[] args) {
        String archivo = "src\\user_data.txt";
        String archivoMasculino = "src\\file.male.txt";
        String archivoFemenino = "src\\file.female.txt";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            BufferedWriter Masculino = new BufferedWriter(new FileWriter(archivoMasculino));
            BufferedWriter Femenino = new BufferedWriter(new FileWriter(archivoFemenino));
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                String genero = campos[4].trim();

                if (genero.equalsIgnoreCase("Male")) {
                    Masculino.write(linea + "," + genero);
                    Masculino.newLine();
                } else if (genero.equalsIgnoreCase("Female")) {
                    Femenino.write(linea + "," + genero);
                    Femenino.newLine();
                }
            }
            lector.close();
            Masculino.close();
            Femenino.close();

            System.out.println("Registros filtrados por género (Maculino y Femenino).");

        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
