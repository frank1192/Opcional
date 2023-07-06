/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;
import MODELO.Modelo_Registro;
import COLECCIONES.DAO_Registro;
import VISTA.Vista_Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Franklin Aguirre
 */
public class Controlador_Registro implements ActionListener{
    private Modelo_Registro Modelo_Registro;
    private DAO_Registro DAO_Registro;
    private Vista_Registro Vista_Registro;
    
    
    public Controlador_Registro(Vista_Registro Vista_Registro, Modelo_Registro Modelo_Registro, DAO_Registro DAO_Registro){
        this.Vista_Registro = Vista_Registro;
        this.Modelo_Registro = Modelo_Registro;
        this.DAO_Registro = new DAO_Registro();
        
        //funcionalidad de los botones
        
        this.Vista_Registro.btnGrabar.addActionListener(this);
        this.Vista_Registro.btnCancelar.addActionListener(this);

    }
    public void iniciar(){
        Vista_Registro.setTitle("Registro de Competencia");
        Vista_Registro.setLocationRelativeTo(null);
    }

   @Override
    public void actionPerformed(ActionEvent e) {

    }
}
