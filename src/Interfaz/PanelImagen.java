/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 *
 * @author Albert charry,Jorge Duran
 */

//panel para las imagenes de los discos
public class PanelImagen extends JPanel{
    
     private JLabel imagen;
     
     public PanelImagen(){
        FlowLayout layout = new FlowLayout( );
        layout.setHgap( 0 );
        layout.setVgap( 0);
        setLayout( layout );

        
        ImageIcon icono = new ImageIcon( "imagenes/udec.JPG" );

        
        imagen = new JLabel( "                                                                                 Albert charry,Jorge andres duran  " );
        imagen.setIcon(icono );
        layout.setHgap(3004);
        add( imagen );

        
        setBackground( Color.WHITE );
        setBorder( new LineBorder( Color.GRAY ) );
    }
}
