package edu.mst.grbcp5;

import edu.mst.grbcp5.procedure.Client;
import edu.mst.grbcp5.procedure.Server;
import edu.mst.grbcp5.procedure.StandAlone;
import jdk.nashorn.internal.runtime.options.Options;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main( String[] args ) throws Exception {

    ExecutionType executionType;
    Map<String, String> options;
    Thread executionProcedure;
    Scanner input;
    String inputToken;

    input = new Scanner( System.in );

    /* Filter out incorrect command line args */
    if( !filterIncorrectUsage( args ) ) {
      return;
    }

    /* Get execution type */
    executionType = getExecutionType( args[ 0 ].toLowerCase() );

    /* Get command line options */
    options = OptionsParser.parseOptions(
      Arrays.copyOfRange(
        args,
        1,
        args.length
      )
    );

    /* Set execution procedure */
    switch ( executionType ) {

      case SERVER_ONLY:
        executionProcedure = new Server( options );
        break;
      case CLIENT_ONLY:
        executionProcedure = new Client( options );
        break;
      case STAND_ALONE:
        executionProcedure = new StandAlone( options );
        break;

      default:
        throw new IllegalArgumentException();
    }

    executionProcedure.start();

    while ( executionProcedure.isAlive() ) {

      System.out.println( "Process executing" );
      System.out.println( "Type Quit (q) to cancel" );

      inputToken = input.next();

      if ( inputToken.toLowerCase().contains( "q" ) ) {
        executionProcedure.interrupt();
        Thread.sleep( 10 );
      }

    }

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

  private static ExecutionType getExecutionType( String type ) {

    if ( type.contains( "sa" ) || type.contains( "standAlone" ) ) {
      return ExecutionType.STAND_ALONE;
    }

    if ( type.contains( "m" ) ) { // m for master
      return ExecutionType.CLIENT_ONLY;
    }

    if ( type.contains( "s" ) ) {
      return ExecutionType.SERVER_ONLY;
    }

    throw new IllegalArgumentException();
  }

}

enum ExecutionType {
  SERVER_ONLY,
  CLIENT_ONLY,
  STAND_ALONE
}
