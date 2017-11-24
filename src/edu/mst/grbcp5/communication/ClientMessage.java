package edu.mst.grbcp5.communication;

public enum ClientMessage {

  WAITING_ON_DATA( 0 ),

  REQUEST_TO_CONNECT( 1 ),

  REQUEST_RESULT( 10 ),
  REQUEST_WORK( 11 ),

  ABORT( -1 );

  private int key;

  ClientMessage( int key ) {
    this.key = key;
  }

  public int getKey() {
    return this.key;
  }

  public static ClientMessage getMessage( int key ) {

    for ( ClientMessage possibleMessage : ClientMessage.values() ) {

      if ( possibleMessage.getKey() == key ) {
        return possibleMessage;
      }

    }

    throw new IllegalArgumentException();
  }

}
