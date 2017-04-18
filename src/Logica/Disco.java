/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.*;
import java.util.*;


public class Disco{
    
    private ArrayList canciones;
    private String nombreDisco;
    private String artista;
    private String genero;
    private String imagen;
    private double precioTotal;

    public Disco( String nombreDiscoD, String artistaD, String generoD, String imagenD ){
        canciones = new ArrayList( );
        nombreDisco = nombreDiscoD;
        artista = artistaD;
        genero = generoD;
        imagen = imagenD;
        precioTotal = 0;

        verificar();
    }

    public Cancion darCancion( String nombreC ){
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            if( c.equals( nombreC ) )
                return c;
        }
        return null;
    }
    
    public void agregarCancion( Cancion c ) throws ElementoExiste{
        if( darCancion( c.darNombre( ) ) != null )
            throw new ElementoExiste( "La canción " + c.darNombre( ) + " ya existe en el disco" );

        canciones.add( c );
        precioTotal += c.darPrecio( );

        verificar();
    }
    
    public String darArtista(){
        return artista;
    }

    public ArrayList darNombresCanciones(){
        ArrayList nombresCanciones = new ArrayList( );
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            nombresCanciones.add( c.darNombre( ) );
        }
        return nombresCanciones;
    }

    public String darGenero(){
        return genero;
    }

    public String darNombreDisco(){
        return nombreDisco;
    }

    public String darImagen(){
        return imagen;
    }

    public double darPrecioDisco(){
        return precioTotal;
    }

    public boolean equals( String nombre ){
        return nombreDisco.equalsIgnoreCase( nombre );
    }

    
    private void verificar(){
        assert canciones != null : "La lista de canciones es nula";
        assert nombreDisco != null && !nombreDisco.equals( "" ) : "El nombre del disco es inválido";
        assert artista != null && !artista.equals( "" ) : "El nombre del artista es inválido";
        assert genero != null && !genero.equals( "" ) : "El nombre del género es inválido";
        assert imagen != null && !imagen.equals( "" ) : "El nombre del archivo con la imagen es inválido";

        assert !buscarCancionesConElMismoNombre( ) : "Hay dos canciones con el mismo nombre";
        assert precioTotal == recalcularPrecioDisco( ) : "Hay un error en el cálculo del precio total del disco";
    }

    private double recalcularPrecioDisco(){
        double acumPrecioTotal = 0;
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            acumPrecioTotal = acumPrecioTotal + c.darPrecio( );
        }
        return acumPrecioTotal;
    }

    private boolean buscarCancionesConElMismoNombre(){
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c1 = ( Cancion )canciones.get( i );
            for( int j = i + 1; j < canciones.size( ); j++ )
            {
                Cancion c2 = ( Cancion )canciones.get( j );
                if( c1.equals( c2.darNombre( ) ) )
                    return true;
            }
        }
        return false;
    }
}