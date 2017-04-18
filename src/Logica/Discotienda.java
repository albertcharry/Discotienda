/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.*;
import java.text.*;
import java.util.*;
/**
 *
 * @author Albert charry,Jorge Duran
 */



//discotienda en general
public class Discotienda {
    
    private static final String LOG_FILE = "./data/error.log";
    private ArrayList discos;
    private String archivoDiscotienda;
    
    
    public Discotienda( String nombreArchivoDiscotienda ) throws Persistencia{
        archivoDiscotienda = nombreArchivoDiscotienda;
        File archivo = new File( archivoDiscotienda );
        if( archivo.exists()){
            
            try {
                ObjectInputStream ois = new ObjectInputStream( new FileInputStream( archivo ) );
                discos = ( ArrayList )ois.readObject( );
                ois.close( );
            }
            catch( Exception e ) {
                
                registrarError( e );
                throw new Persistencia( "Error fatal: imposible restaurar el estado del programa (" + e.getMessage( ) + ")" );
            }
        }
        else{
            discos = new ArrayList( );
        }
        verificarInvariante( );
    }
    
    public Disco darDisco( String nombreDisco ){
        for( int i = 0; i < discos.size( ); i++ )
        {
            Disco d = ( Disco )discos.get( i );
            if( d.equals( nombreDisco ) )
                return d;
        }
        return null;
    }
     
    private Disco darDisco( String nombreDisco, String nombreArtista, String nombreCancion ){
        Disco discoBuscado = darDisco( nombreDisco );
        if( discoBuscado != null && discoBuscado.darArtista( ).equalsIgnoreCase( nombreArtista ) )
            return ( discoBuscado.darCancion( nombreCancion ) != null ) ? discoBuscado : null;
        else
            return null;
    }
    
    public void agregarDisco( String nombreDiscoD, String artistaD, String generoD, String imagenD ) throws ElementoExiste {
        if( darDisco( nombreDiscoD ) != null )
            throw new ElementoExiste( "El disco " + nombreDiscoD + " ya existe en miDiscoTienda" );

        discos.add( new Disco( nombreDiscoD, artistaD, generoD, imagenD ) );
        verificarInvariante( );
    }
    
    public void agregarCancionADisco( String nombreDisco, String nombreC, int minutosC, int segundosC, double precioC, double tamanoC, int calidadC ) throws ElementoExiste {
        Disco d = darDisco( nombreDisco );
        d.agregarCancion( new Cancion( nombreC, minutosC, segundosC, precioC, tamanoC, calidadC, 0 ) );
        verificarInvariante( );
    }
    
    public ArrayList darDiscos() {
        ArrayList nombresDiscos = new ArrayList( );
        for( int i = 0; i < discos.size( ); i++ )
        {
            Disco d = ( Disco )discos.get( i );
            nombresDiscos.add( d.darNombreDisco( ) );
        }
        return nombresDiscos;
    }
    
    
    
     
     public void registrarError( Exception excepcion ) {
        try{
            
            FileWriter out = new FileWriter( LOG_FILE, true );
            PrintWriter log = new PrintWriter( out );
            log.println( "---------------------------------------" );
            log.println( "Discotienda.java :" + new Date( ).toString( ) );
            log.println( "---------------------------------------" );
            excepcion.printStackTrace( log );
            log.close( );
            out.close( );
        }
        catch( IOException e ){
            
            excepcion.printStackTrace( );
            e.printStackTrace( );
        }
    }
     
     private void verificarInvariante( ) {
        assert discos != null : "La lista de discos es null";
        assert !buscarDiscosConElMismoNombre( ) : "Hay dos discos con el mismo nombre";
    }
     
     

private boolean buscarDiscosConElMismoNombre( ) {
        for( int i = 0; i < discos.size( ); i++ )
        {
            Disco d1 = ( Disco )discos.get( i );
            for( int j = i + 1; j < discos.size( ); j++ )
            {
                Disco d2 = ( Disco )discos.get( j );
                if( d1.equals( d2.darNombreDisco( ) ) )
                    return true;
            }
        }
        return false;
    }


}
