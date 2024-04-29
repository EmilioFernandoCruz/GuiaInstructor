import java.io.*;

public class Ejercicio001 {
    public static void main(String[] args) {
        String ruta = "src\\Biblia_Completa.txt";
        createFile(ruta);
        contar(ruta, "Dios");
    }

    public static void createFile(String path) {
        File file = new File(path);

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                System.out.println("Absolute path: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists");
            }

        } catch (IOException e) {
            System.out.println("ERROR, el archivo no existe.");
            e.printStackTrace();
        }
    }

    public static void contar(String path, String buscarPalabra) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            int calcular = 0;
            while ((linea = br.readLine()) != null) {
                linea = linea.toLowerCase();

                String[] palabras = linea.split("\\s+");
                for (String palabra : palabras) {
                    if (palabra.equals(buscarPalabra.toLowerCase())) {
                        calcular++;
                    }
                }
            }
            System.out.println("La palabra '" + buscarPalabra + "' se encuentra " + calcular + " veces en la Biblia.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer el archivo.");
            e.printStackTrace();
        }
    }
}
