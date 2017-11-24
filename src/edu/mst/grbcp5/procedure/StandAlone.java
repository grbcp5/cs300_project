package edu.mst.grbcp5.procedure;

import java.util.Map;

public class StandAlone extends Thread {

  private Map< String, String > options;

  public StandAlone( Map< String, String > options ) {
    super();

    this.options = options;

  }

  @Override
  public void run() {

    System.out.println( "Stand Alone thread running" );

    while ( !currentThread().isInterrupted() ) {

    }

  } /* run */

}
