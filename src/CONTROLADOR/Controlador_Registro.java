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
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
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
        DAO_Registro.restaurarDatos();
        
        
        //funcionalidad de los botones
        this.Vista_Registro.btnNuevo.addActionListener(this);
        this.Vista_Registro.btnGrabar.addActionListener(this);
        this.Vista_Registro.btnCancelar.addActionListener(this);
        this.Vista_Registro.btnModificar.addActionListener(this);
        this.Vista_Registro.btnEliminar.addActionListener(this);

    }
    public void iniciar(){
        Vista_Registro.setTitle("Registro de Competencia");
        Vista_Registro.setLocationRelativeTo(null);
        cargarDeportes();
        ActualizarJlist();
    }
    public void ActualizarJlist(){
        File archivo=null;
        Object FileReaderfileR = null;
        BufferedReader BuferedR= null;
//        try{
//            archivo= new File ("src\\Persistencia\\Registro_Persistencia.txt");
//            FileR
//        }catch(exception e){}
//        
        
    }
    public void LimpiarCampos(){
        Vista_Registro.txtApellidos.setText("");
        Vista_Registro.txtIdentificacion.setText("");
        Vista_Registro.txtNombres.setText("");
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
            
            int Identificacion = Integer.parseInt(Vista_Registro.txtIdentificacion.getText());
            String Apellidos=Vista_Registro.txtApellidos.getText();
            String Nombres= Vista_Registro.txtNombres.getText();
            String Deporte= (String) Vista_Registro.cmbDeportes.getSelectedItem();
            
            Modelo_Registro Modelo_Registro = DAO_Registro.getProducto(Identificacion);
            Map<Integer, Modelo_Registro> ListaParticipantes = DAO_Registro.getListaParticipantes();
            if (Identificacion != 0) {
    if (ListaParticipantes.containsKey(Identificacion)) {
        JOptionPane.showMessageDialog(null, "El ID " + Identificacion + " YA ESTA REGISTRADO EN UNA COMPETENCIA");
    } else {
        DAO_Registro.registrar(Identificacion, Nombres, Apellidos, Deporte);
        JOptionPane.showMessageDialog(null, "PERSONA REGISTRADA exitosamente");
        DAO_Registro.generarCSV();
    }
} else {
    JOptionPane.showMessageDialog(null, "Por favor ingrese datos válidos");
}

            
            Vista_Registro.btnGrabar.setEnabled(false);
            Vista_Registro.btnCancelar.setEnabled(false);
            Vista_Registro.txtIdentificacion.setEnabled(false);
            Vista_Registro.txtApellidos.setEnabled(false);
            Vista_Registro.txtNombres.setEnabled(false);
            Vista_Registro.cmbDeportes.setEnabled(false);
            Vista_Registro.btnNuevo.setEnabled(true);
            LimpiarCampos();

        }
        if (e.getSource() == Vista_Registro.btnCancelar) {
            Vista_Registro.btnGrabar.setEnabled(false);
            Vista_Registro.btnCancelar.setEnabled(false);
            Vista_Registro.txtIdentificacion.setEnabled(false);
            Vista_Registro.txtApellidos.setEnabled(false);
            Vista_Registro.txtNombres.setEnabled(false);
            Vista_Registro.cmbDeportes.setEnabled(false);
            Vista_Registro.btnNuevo.setEnabled(true);
            LimpiarCampos();

        }
        
        if (e.getSource() == Vista_Registro.btnEliminar) {
    String identificacionStr = JOptionPane.showInputDialog(null, "Ingrese la identificación del registro a eliminar:");
    if (identificacionStr != null && !identificacionStr.isEmpty()) {
        int identificacion = Integer.parseInt(identificacionStr);
        Modelo_Registro registro = DAO_Registro.getProducto(identificacion);
        if (registro != null) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                DAO_Registro.eliminarRegistro(identificacion);
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");

            }
        } else {
            JOptionPane.showMessageDialog(null, "El registro con identificación " + identificacion + " no existe");
        }
    }
}

    }
}
