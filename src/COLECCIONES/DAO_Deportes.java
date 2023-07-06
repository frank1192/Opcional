/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COLECCIONES;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Franklin Aguirre
 */
public class DAO_Deportes {
    private List<String> Deportes;

    public DAO_Deportes(){
        Deportes = new ArrayList<>();

        Deportes.add("Baloncesto");
        Deportes.add("Voleibol");
        Deportes.add("futbol");
        Deportes.add("tenis de mesa");
        Deportes.add("Atletismo");
        Deportes.add("Natacion");
        Deportes.add("Rugby");
    }

    public List<String> GetDeportes(){
        return Deportes;
    }
}
