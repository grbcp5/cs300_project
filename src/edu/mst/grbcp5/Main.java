package edu.mst.grbcp5;

import java.util.Scanner;

public class Main {

  public static void main( String[] args ) {

    /* Filter out incorrect command line args */
    if( !filterIncorrectUsage( args ) ) {
      return;
    }

    System.out.println( "Main" );

  }

  private static boolean filterIncorrectUsage( String[] args ) {

    if ( args.length < 1 ) {
      displayUsage();

      return false;
    }

    if ( args[ 0 ].toLowerCase().contains( "help" ) ) {

      if ( args.length < 2 ) {
        displayUsage();

        return false;
      } else {

        if( !displayHelp( args[ 1 ] ) ) {
          return false;
        } else {
          return true;
        }

      }

    }

    if( !"server_master_standalone_sa".contains( args[ 0 ].toLowerCase() ) ) {
      displayUsage();
      return false;
    }

    return true;
  }

  private static void displayUsage() {
    System.out.println( "Usage: command [type] <options>\n" );

    System.out.println( "Types:" );
    System.out.println( "\tserver \t\t( s  )" );
    System.out.println( "\tmaster \t\t( m  )" );
    System.out.println( "\tstandAlone \t( sa )\n" );

    System.out.println( "Use \"command help [type]\" to view options help" );
  }

  private static boolean displayHelp( String type ) {

    Scanner input = new Scanner( System.in );

    System.out.println( "help" );

    System.out.print( "Would you like to continue with default values: " );

    return input.next().toLowerCase().contains( "y" );
  }

}
