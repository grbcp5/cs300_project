package edu.mst.grbcp5.procedure;

import java.util.Map;

public class Server extends Thread {

  private Map< String, String > options;

  public Server( Map< String, String > options ) {
    super();

    this.options = options;

  }

  @Override
  public void run() {

    System.out.println( "Server thread running" );

    while ( !currentThread().isInterrupted() ) {

    }

  } /* run */


}
