/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;
import MODELO.Modelo_Registro;
import COLECCIONES.DAO_Registro;
import COLECCIONES.DAO_Deportes;
import VISTA.Vista_Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Franklin Aguirre
 */
public class Controlador_Registro implements ActionListener{
    private Modelo_Registro Modelo_Registro;
    private DAO_Registro DAO_Registro;
    private Vista_Registro Vista_Registro;
    private DAO_Deportes DAO_Deportes;
    
    
    public Controlador_Registro(Vista_Registro Vista_Registro, Modelo_Registro Modelo_Registro, DAO_Registro DAO_Registro,DAO_Deportes DAO_Deportes){
        this.Vista_Registro = Vista_Registro;
        this.Modelo_Registro = Modelo_Registro;
        this.DAO_Deportes = DAO_Deportes;
        this.DAO_Registro = new DAO_Registro();
        
        //funcionalidad de los botones
        this.Vista_Registro.btnNuevo.addActionListener(this);
        this.Vista_Registro.btnGrabar.addActionListener(this);
        this.Vista_Registro.btnCancelar.addActionListener(this);

    }
    public void iniciar(){
        Vista_Registro.setTitle("Registro de Competencia");
        Vista_Registro.setLocationRelativeTo(null);
        cargarDeportes();
    }
    private void cargarDeportes() {
        List<String> Deportes = DAO_Deportes.GetDeportes();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(Deportes.toArray(String[]::new));
        Vista_Registro.cmbDeportes.setModel(comboBoxModel);
    }

   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista_Registro.btnNuevo) {
        Vista_Registro.btnGrabar.setEnabled(true);
        Vista_Registro.btnCancelar.setEnabled(true);
        Vista_Registro.txtIdentificacion.setEnabled(true);
        Vista_Registro.txtApellidos.setEnabled(true);
        Vista_Registro.txtNombres.setEnabled(true);
        Vista_Registro.cmbDeportes.setEnabled(true);
        Vista_Registro.btnNuevo.setEnabled(false);

        }
        if (e.getSource() == Vista_Registro.btnGrabar) {
        Vista_Registro.btnGrabar.setEnabled(false);
        Vista_Registro.btnCancelar.setEnabled(false);
        Vista_Registro.txtIdentificacion.setEnabled(false);
        Vista_Registro.txtApellidos.setEnabled(false);
        Vista_Registro.txtNombres.setEnabled(false);
        Vista_Registro.cmbDeportes.setEnabled(false);
        Vista_Registro.btnNuevo.setEnabled(true);

        }
        if (e.getSource() == Vista_Registro.btnCancelar) {
        Vista_Registro.btnGrabar.setEnabled(false);
        Vista_Registro.btnCancelar.setEnabled(false);
        Vista_Registro.txtIdentificacion.setEnabled(false);
        Vista_Registro.txtApellidos.setEnabled(false);
        Vista_Registro.txtNombres.setEnabled(false);
        Vista_Registro.cmbDeportes.setEnabled(false);
        Vista_Registro.btnNuevo.setEnabled(true);

        }
        
    }
}
