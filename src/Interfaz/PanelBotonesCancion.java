/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author Albert charry,Jorge Duran
 */
public class PanelBotonesCancion extends JPanel implements ActionListener {

    private static final String CREAR_CANCION = "CrearCancion";
    private static final String CANCELAR = "Cancelar";
    private DCrearCancion ventana;
    private JButton botonAgregarCancion;
    private JButton botonCancelar;
     
    
    public PanelBotonesCancion( DCrearCancion dcc ){

        ventana = dcc;

        botonAgregarCancion = new JButton( "Crear" );
        botonAgregarCancion.setActionCommand( CREAR_CANCION );
        botonAgregarCancion.addActionListener( this );
        add( botonAgregarCancion );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );

    }

    public void actionPerformed( ActionEvent evento ){
        String comando = evento.getActionCommand( );

        if( CREAR_CANCION.equals( comando ) )
        {
            ventana.crearCancion( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            ventana.dispose( );
        }

    }

}

