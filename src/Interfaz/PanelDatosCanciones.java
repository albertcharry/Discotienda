/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Logica.Cancion;
import Logica.Disco;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
/**
 *
 * @author Albert charry,Jorge Duran
 */


//panel para los datos de las canciones 
public class PanelDatosCanciones extends JPanel implements ActionListener{

    private static final String CAMBIAR_CANCION = "CambiarCancion";
    private static final String AGREGAR_CANCION = "AgregarCancion";
    private InterfazDiscotienda principal;
    private Disco disco;
    private Cancion cancion;
    private JComboBox comboCanciones;
    private JLabel etiquetaTituloPrecio;
    private JTextField txtPrecio;
    private JLabel etiquetaTituloTamano;
    private JTextField txtTamano;
    private JLabel etiquetaTituloDuracion;
    private JTextField txtDuracion;
    private JLabel etiquetaTituloCalidad;
    private JTextField txtCalidad;
    private JLabel etiquetaTituloUnidades;
    private JTextField txtUnidades;
    private JButton botonAgregarCancion;

    
    public PanelDatosCanciones( InterfazDiscotienda ventanaPrincipal ){
        principal = ventanaPrincipal;

        setLayout( new BorderLayout( ) );

        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Canciones" ) ) );

        comboCanciones = new JComboBox( );
        comboCanciones.setEditable( false );
        comboCanciones.addActionListener( this );
        comboCanciones.setActionCommand( CAMBIAR_CANCION );
        add( comboCanciones, BorderLayout.NORTH );

        JPanel panelDatos = new JPanel( new GridLayout( 5, 2 ) );

        etiquetaTituloPrecio = new JLabel( "Precio: " );
        txtPrecio = new JTextField( 7 );
        txtPrecio.setEditable( false );
        txtPrecio.setFont( txtPrecio.getFont( ).deriveFont( Font.PLAIN ) );
        Border borde = txtPrecio.getBorder( );
        txtPrecio.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaTituloPrecio );
        panelDatos.add( txtPrecio );

        etiquetaTituloTamano = new JLabel( "Tamaño: " );
        txtTamano = new JTextField( 7 );
        txtTamano.setEditable( false );
        txtTamano.setFont( txtTamano.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtTamano.getBorder( );
        txtTamano.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaTituloTamano );
        panelDatos.add( txtTamano );

        etiquetaTituloDuracion = new JLabel( "Duración: " );
        txtDuracion = new JTextField( 7 );
        txtDuracion.setEditable( false );
        txtDuracion.setFont( txtDuracion.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtDuracion.getBorder( );
        txtDuracion.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaTituloDuracion );
        panelDatos.add( txtDuracion );

        etiquetaTituloCalidad = new JLabel( "Calidad: " );
        txtCalidad = new JTextField( 7 );
        txtCalidad.setEditable( false );
        txtCalidad.setFont( txtCalidad.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtCalidad.getBorder( );
        txtCalidad.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaTituloCalidad );
        panelDatos.add( txtCalidad );

        
        add( panelDatos, BorderLayout.CENTER );

        JPanel panelBotones = new JPanel( new BorderLayout( ) );

        botonAgregarCancion = new JButton( "Agregar Canción" );
        botonAgregarCancion.setActionCommand( AGREGAR_CANCION );
        botonAgregarCancion.addActionListener( this );
        botonAgregarCancion.setEnabled( false );
        panelBotones.add( botonAgregarCancion, BorderLayout.NORTH );


        add( panelBotones, BorderLayout.SOUTH );
    }
    
    public void cambiarDisco( Disco d ){
        if( d != null )
        {
            disco = d;
            botonAgregarCancion.setEnabled( true );

            comboCanciones.removeAllItems( );
            ArrayList canciones = disco.darNombresCanciones( );
            for( int i = 0; i < canciones.size( ); i++ )
            {
                comboCanciones.addItem( canciones.get( i ) );
            }
        }
    }
    private void refrescarCanciones( ){
        comboCanciones.removeAllItems( );
        ArrayList canciones = disco.darNombresCanciones( );
        for( int i = 0; i < canciones.size( ); i++ )
        {
            comboCanciones.addItem( canciones.get( i ) );
        }

    }

    
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( CAMBIAR_CANCION.equals( comando ) )
        {
            String nombreCancion = ( String )comboCanciones.getSelectedItem( );
            if( nombreCancion != null )
            {
                cancion = disco.darCancion( nombreCancion );
                DecimalFormat df = new DecimalFormat( "0.##" );
                txtPrecio.setText( "$" + Double.toString( cancion.darPrecio( ) ) );
                txtTamano.setText( df.format( cancion.darTamano( ) ) + " Mb" );
                txtCalidad.setText( Integer.toString( cancion.darCalidad( ) ) + " Kbps" );
                txtDuracion.setText( Integer.toString( cancion.darMinutos( ) ) + ":" + Integer.toString( cancion.darSegundos( ) ) );
                txtUnidades.setText( Integer.toString( cancion.darUnidadesVendidas( ) ) );
            }
            else
            {
                txtPrecio.setText( "" );
                txtTamano.setText( "" );
                txtCalidad.setText( "" );
                txtDuracion.setText( "" );
                txtUnidades.setText( "" );
            }
        }
        else if( AGREGAR_CANCION.equals( comando ) )
        {
            principal.mostrarDialogoAgregarCancion( );
            refrescarCanciones( );
        }
        
    }
    
     
}
