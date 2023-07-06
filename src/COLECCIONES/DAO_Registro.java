/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COLECCIONES;
import MODELO.Modelo_Registro;
import java.util.HashMap;
import java.util.Map;

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
    
    
}
