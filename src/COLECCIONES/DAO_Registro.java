/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COLECCIONES;
import MODELO.Modelo_Registro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franklin Aguirre
 */
public class DAO_Registro {
    private static Map <Integer, Modelo_Registro> ListaParticipantes;
    
    public DAO_Registro(){
        ListaParticipantes = new HashMap<>();
    }
    
    public void registrar(Integer Identificacion, String Nombres,String Apellidos,String Deporte) {
        Modelo_Registro Modelo_Registro = new Modelo_Registro(Identificacion, Nombres, Apellidos, Deporte );
        ListaParticipantes.put(Identificacion, Modelo_Registro);
    }

    public void generarCSV() {
        String archivoPersistencia = "";
        for(int Identificacion : ListaParticipantes.keySet()){
            archivoPersistencia += ListaParticipantes.get(Identificacion) + "\n";
        }
        try {
            FileOutputStream os = new FileOutputStream(new File("src\\PERSISTENCIA\\Registro_Persistencia.txt"));
            
            os.write(archivoPersistencia.getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void restaurarDatos() {
    File archivo = new File("src\\Persistencia\\Registro_Persistencia.txt");
    StringTokenizer stringTokenizer;

    String cadena1;
    String cadena2;

    Integer identificacion;
    String nombres;
    String apellidos;
    String deporte;

    try {
        FileReader fileReader = new FileReader(archivo);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((cadena1 = bufferedReader.readLine()) != null) {
                cadena2 = cadena1.replace("{Identificacion: ", "");
                cadena1 = cadena2.replace(" Nombres: ", "");
                cadena2 = cadena1.replace(" Apellidos: ", "");
                cadena1 = cadena2.replace(" Deporte: ", "");
                cadena2 = cadena1.replace("}", "");

                stringTokenizer = new StringTokenizer(cadena2, ",");

                if (stringTokenizer.countTokens() == 4) {
                    identificacion = Integer.valueOf(stringTokenizer.nextToken());
                    nombres = stringTokenizer.nextToken();
                    apellidos = stringTokenizer.nextToken();
                    deporte = stringTokenizer.nextToken();

                    Modelo_Registro modeloRegistro = new Modelo_Registro(identificacion, nombres, apellidos, deporte);
                    ListaParticipantes.put(identificacion, modeloRegistro);
                }
            }
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

     public Modelo_Registro getProducto(Integer Identificacion) {
        return ListaParticipantes.get(Identificacion);
    }
    
    public static Map<Integer, Modelo_Registro> getListaParticipantes() {
        return ListaParticipantes;
    }
    
}
