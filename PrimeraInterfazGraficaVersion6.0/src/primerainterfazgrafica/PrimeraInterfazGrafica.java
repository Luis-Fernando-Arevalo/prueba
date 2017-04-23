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

//import javax.swing.JOptionPane;

/**
 * @version 07 Abril 2017
 * @author Alejandro Machaca Luna
 */
public class PrimeraInterfazGrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instanciado la clase Ventana
       Ventana v1 = new Ventana();
       v1.setVisible(true);
       
       //Viendo la funcionalidad de JOptioPane.showIputDialog
//       String accion = JOptionPane.showInputDialog("Coloca tu apellido");
//       JOptionPane.showMessageDialog(null, "Tu apellido es "+ accion);
    }
    
}
