/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Logica.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;


/**
 *
 * @author Albert charry,Jorge Duran
 */
public class InterfazDiscotienda extends JFrame{
    
    private Discotienda discotienda;
    private Disco discoSeleccionado;
    private PanelDiscos panelDiscos;
    private PanelDatosCanciones panelDatosCanciones;
    private PanelImagen panelImagen;
    
    
    public InterfazDiscotienda( Discotienda d ){
        discotienda = d;

        // Panel con la Imagen
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        // Panel central con los datos del disco, de las canciones y el botón para cargar un pedido
        JPanel panelCentral = new JPanel( new BorderLayout( ) );
        add( panelCentral, BorderLayout.CENTER );

        panelDiscos = new PanelDiscos( this, discotienda.darDiscos( ) );
        panelCentral.add( panelDiscos, BorderLayout.CENTER );

        panelDatosCanciones = new PanelDatosCanciones( this );
        panelCentral.add( panelDatosCanciones, BorderLayout.EAST );

        ArrayList discos = discotienda.darDiscos( );
        if( discos.size( ) > 0 )
        {
            cambiarDiscoSeleccionado( ( ( String )discos.get( 0 ) ) );
        }

        setTitle( "miDiscoTienda" );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        pack( );
    }
    
    public void cambiarDiscoSeleccionado( String nombreDisco ){
        discoSeleccionado = discotienda.darDisco( nombreDisco );
        panelDiscos.cambiarDisco( discoSeleccionado );
        panelDatosCanciones.cambiarDisco( discoSeleccionado );
    }
    
    public void mostrarDialogoAgregarDisco( ){
        DCrearDisco dialogo = new DCrearDisco( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }
    
    public void mostrarDialogoAgregarCancion( ){
        DCrearCancion dialogo = new DCrearCancion( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }
    
    public boolean crearDisco( String nombreDisco, String artista, String genero, String imagen ){
        boolean ok = false;
        try{
            discotienda.agregarDisco( nombreDisco, artista, genero, imagen );
            panelDiscos.refrescarDiscos( discotienda.darDiscos( ) );
            ok = true;
        }catch( ElementoExiste e ){
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }
        return ok;
    }
    
    public boolean crearCancion( String nombre, int minutos, int segundos, double precio, double tamano, int calidad ){
        boolean ok = false;
        if( discoSeleccionado != null ){
            try{
                discotienda.agregarCancionADisco( discoSeleccionado.darNombreDisco( ), nombre, minutos, segundos, precio, tamano, calidad );
                discoSeleccionado = discotienda.darDisco( discoSeleccionado.darNombreDisco( ) );
                panelDiscos.cambiarDisco( discoSeleccionado );
                ok = true;
            }catch( ElementoExiste e ){
                JOptionPane.showMessageDialog( this, e.getMessage( ) );
            }
        }
        return ok;
    }
    
    
}
    

     
     

    
    
