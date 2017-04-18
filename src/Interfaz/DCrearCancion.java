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

//Clase creacion de cancion
public class DCrearCancion extends JDialog{
    private InterfazDiscotienda principal;
    private PanelCrearCancion panelDatos;
    private PanelBotonesCancion panelBotones;
     
    
    public DCrearCancion( InterfazDiscotienda id ){
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearCancion( );
        panelBotones = new PanelBotonesCancion( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Canción" );
        pack( );
    }
    
    public void crearCancion(){
        boolean parametersOk = true;
        double precio = 0;
        int calidad = 0;
        double tamano = 0;
        int minutos = 0;
        int segundos = 0;
        String nombre = panelDatos.darNombre( );
        //Ingresa datos al programa y con sus respectivas validaciones
        if( nombre.equals( "" ) ){
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el nombre de la canción " );
        }try{
            precio = Double.parseDouble( panelDatos.darPrecio( ) );
            if( precio < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "El precio ingresado no es un valor válido" );
            }
        }catch( Exception e ){
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "El precio ingresado no es un valor válido" );
        }try{
            calidad = Integer.parseInt( panelDatos.darCalidad( ) );
            if( calidad < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "La calidad ingresada no es un valor válido" );
            }
        }catch( Exception e ){
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "La calidad ingresada no es un valor válido" );
        }try{
            tamano = Double.parseDouble( panelDatos.darTamano( ) );
            if( tamano < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "El tamaño ingresado no es un valor válido" );
            }
        }catch( Exception e ){
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "El tamaño ingresado no es un valor válido" );
        }try{
            minutos = Integer.parseInt( panelDatos.darMinutos( ) );
            if( minutos < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "Los minutos ingresados no son un valor válido" );
            }
        }catch( Exception e ){
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Los minutos ingresados nos son un valor válido" );
        }try{
            segundos = Integer.parseInt( panelDatos.darSegundos( ) );
            if( segundos < 0 || segundos >= 60 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "Los segundos ingresados no son un valor válido" );
            }
        }catch( Exception e ){
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Los segundos ingresados nos son un valor válido" );
        }if( parametersOk ){
            boolean ok = principal.crearCancion( nombre, minutos, segundos, precio, tamano, calidad );
            if( ok )
                dispose( );
        }
    }
}
