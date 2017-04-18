/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Albert charry,Jorge Duran
 */
public class DCrearDisco extends JDialog {
    
    private InterfazDiscotienda principal;
    private PanelCrearDisco panelDatos;
    private PanelBotonesDisco panelBotones;
    
    public DCrearDisco( InterfazDiscotienda id ){
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearDisco( );
        panelBotones = new PanelBotonesDisco( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Disco" );
        pack( );

    }
    
    public void crearDisco( ){
        boolean parametersOk = true;
        String artista = panelDatos.darArtista( );
        String titulo = panelDatos.darTitulo( );
        String genero = panelDatos.darGenero( );
        String imagen = panelDatos.darImagen( );

        if( ( artista.equals( "" ) || titulo.equals( "" ) ) || ( genero.equals( "" ) || imagen.equals( "" ) ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
        }
        if( parametersOk )
        {
            boolean ok = principal.crearDisco( titulo, artista, genero, imagen );
            if( ok )
                dispose( );
        }
    }


}
