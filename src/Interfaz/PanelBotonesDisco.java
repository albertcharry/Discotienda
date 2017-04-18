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
 * @author Albert charry,Jorge Duran
 * Es el panel con los botones para agregar un nuevo disco
 */
public class PanelBotonesDisco extends JPanel implements ActionListener{
    private static final String CREAR_DISCO = "CrearDisco";
    private static final String CANCELAR = "Cancelar";
    private DCrearDisco ventana;
    private JButton botonAgregarDisco;
    private JButton botonCancelar;

    public PanelBotonesDisco( DCrearDisco dcd ){

        ventana = dcd;

        botonAgregarDisco = new JButton( "Crear" );
        botonAgregarDisco.setActionCommand( CREAR_DISCO );
        botonAgregarDisco.addActionListener( this );
        add( botonAgregarDisco );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );

    }

    public void actionPerformed( ActionEvent evento ){
        String comando = evento.getActionCommand( );

        if( CREAR_DISCO.equals( comando ) ) {
            ventana.crearDisco( );
        }else if( CANCELAR.equals( comando ) ){
            ventana.dispose( );
        }

    }
}
