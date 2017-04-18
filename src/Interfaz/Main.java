/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.Discotienda;
import Logica.Persistencia;

/**
 *
 * @author Albert charry,Jorge Duran
 */
public class Main {
    public static void main( String[] args )
    {
        Discotienda discotienda = null;
        try
        {
            discotienda = new Discotienda( "./data/discotienda.discos" );
        }
        catch( Persistencia e )
        {
            e.printStackTrace( );
            System.exit( 1 );
        }
        InterfazDiscotienda id = new InterfazDiscotienda( discotienda );
        id.setVisible( true );
    }
}
