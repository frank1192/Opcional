
package opcional;

import MODELO.Modelo_Registro;
import COLECCIONES.DAO_Registro;
import COLECCIONES.DAO_Deportes;
import VISTA.Vista_Registro;
import CONTROLADOR.Controlador_Registro;
/**
 *
 * @author Franklin Aguirre
 */
public class Opcional {


    public static void main(String[] args) {
        // TODO code application logic here
        
        Vista_Registro Vista_Registro = new Vista_Registro();
        DAO_Deportes DAO_Deportes = new DAO_Deportes();
        Modelo_Registro Modelo_Registro= new Modelo_Registro(0,"","","");
        DAO_Registro DAO_Registro= new DAO_Registro();
        DAO_Registro.restaurarDatos();
        Controlador_Registro Controlador_Registro =new Controlador_Registro( Vista_Registro,Modelo_Registro ,DAO_Registro,DAO_Deportes);
        
        Controlador_Registro.iniciar();
        Vista_Registro.setVisible(true);
    }
    
}
