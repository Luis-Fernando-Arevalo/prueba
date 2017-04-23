/*
 * Copyright (c) 2017 Alejandro Machaca Luna y VirtualEntertainmentCompany. Todos los derechos reservados.
 * ESTE SOFTWARE ES PROPORCIONADO POR LOS TITULARES DE COPYRIGHT Y CONTRIBUYENTES "COMO
 * ES "Y CUALQUIER GARANTÍA EXPRESA O IMPLÍCITA, INCLUYENDO, PERO SIN LIMITARSE A,
 * LAS GARANTÍAS IMPLÍCITAS DE COMERCIABILIDAD Y ADECUACIÓN PARA UN
 * EL PROPÓSITO SE RENUNCIA. EN NINGÚN CASO EL PROPIETARIO O
 * CONTRIBUYENTES SERÁN RESPONSABLES POR CUALQUIER DAÑO DIRECTO, INDIRECTO, INCIDENTAL, ESPECIAL,
 * DAÑOS EJEMPLARES O CONSECUENTES (INCLUYENDO, PERO SIN LIMITARSE A,
 * ADQUISICIÓN DE BIENES O SERVICIOS SUSTITUTOS; PÉRDIDA DE USO, DATOS O
 * BENEFICIOS; O INTERRUPCIÓN DEL NEGOCIO) SIN EMBARGO CAUSADO Y SOBRE CUALQUIER TEORÍA DE
 * RESPONSABILIDAD, YA SEA POR CONTRATO, RESPONSABILIDAD ESTRICTA, O AGRAVIO (INCLUYENDO
 * NEGLIGENCIA O DE OTRA MANERA) QUE SURJA EN CUALQUIER FORMA EL USO DE ESTE
 * SOFTWARE, INCLUSO SI SE ADVIERTE DE LA POSIBILIDAD DE DICHO DAÑO.
 */
package primerainterfazgrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Clase Ventana
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing
 */
public class Ventana extends JFrame implements ActionListener {

    private JLabel texto1;
    private JTextField caja;
    private JButton btnGuardar;
    private JButton btnMostrar;              //Nuevo boton
    private JLabel lblTemporal;              //nuevo Label
    private Timer time;
    private JTextArea pantalla;              // Nuevo elemento
    private JScrollPane ampliar;
    private JPanel  contenedor;
    private final File informacion;
    private FileWriter escribir;
    private PrintWriter linea;
    private FileReader leer;
    private BufferedReader leerLinea;

    public Ventana() {
        super();
        configurarVentana();
        inicializarComponentes();
        informacion = new File("Lista.txt");
    }

    private void configurarVentana() {
        this.setTitle("Lista De Nombres");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        texto1 = new JLabel();
        caja = new JTextField();
        btnGuardar = new JButton();
        lblTemporal = new JLabel();
        btnMostrar = new JButton();  //Agregando nuevo boton
        contenedor = new JPanel();   //Agregando un JPanel,para usarlo como contenedor
        pantalla = new JTextArea(5,25);  // creando un nuevo textArea
        ampliar = new JScrollPane(pantalla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                                  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        
        texto1.setText("Insertar Nombre");
        texto1.setBounds(90, 70, 100, 25);
        caja.setBounds(230, 70, 100, 25);
        btnGuardar.setText("Guardar Datos");
        btnGuardar.setBounds(30, 150, 150, 30);
        btnGuardar.addActionListener(this);
        lblTemporal.setText("Datos guardados con exito!");
        lblTemporal.setBounds(30, 175,180, 30);
        lblTemporal.setVisible(false);
        btnMostrar.setText("Mostrar Datos");
        btnMostrar.setBounds(215, 150, 150, 30);
        btnMostrar.addActionListener(this);
        pantalla.setEditable(false);
        contenedor.setBounds(30, 220, 335, 90);
        contenedor.add(ampliar);

        this.add(texto1);
        this.add(caja);
        this.add(btnGuardar);
        this.add(lblTemporal);
        this.add(btnMostrar);
        this.add(contenedor);

    }
    //Metodo guardarInformacion guardara los datos capturados de la caja de texto
    public void guardarInformacion(String nombre){
        try {
            // Crear un objeto de tipo FileWriter, para escribir en el documento.
            escribir = new FileWriter(informacion, true);
            // crear un objeto de tipo PrintWriter, para escribir una linea.
            linea = new PrintWriter(escribir);
            if (!informacion.exists()) {    
                informacion.createNewFile();
            } 
            linea.println(nombre);      //escribir el nombre ingresado
                linea.close();              // cerrar el objeto linea
                escribir.close();           //cerrar el objeto escribir
                lblTemporal.setVisible(true);      
                caja.setText("");
                time.start();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }
    //Metodo mostrarInfomacion, mostrara todo el contenido del documento creado
    public void mostrarInformacion(){
        
        try {
            leer = new FileReader(informacion);
            leerLinea = new BufferedReader(leer);
            String datos = leerLinea.readLine();
            pantalla.setText(datos);
            
            while ((datos=leerLinea.readLine())!=null){
                pantalla.setText(pantalla.getText()+"\n"+datos);
            }
            leer.close();
            leerLinea.close();
            
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }
    // el Override realizara la accion de cada boton una vez presionados
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()== btnGuardar){
        String nombre = caja.getText();     //Obtener el texto1 que exista en la caja
        guardarInformacion(nombre);
        time = new Timer(3000, (ActionEvent ae1) -> {
            lblTemporal.setVisible(false);
            time.stop();
        });                
        }
        
        if (ae.getSource()==btnMostrar){
            mostrarInformacion();
        }
    }
}
