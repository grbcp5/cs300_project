package edu.mst.grbcp5.procedure;

import java.util.Map;

public class Client extends Thread {

  private Map< String, String > options;

  public Client( Map< String, String > options ) {
    super();

    this.options = options;

  }

  @Override
  public void run() {

    System.out.println( "Client process running" );

    while ( !currentThread().isInterrupted() ) {

    }

  } /* run */


}
