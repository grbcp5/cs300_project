package edu.mst.grbcp5.communication;

public enum ServerMessage {

  DENY( 0 ),
  APPROVE( 1 ),

  COMPLETED( 10 ),
  WORK_IN_PROGRESS( 11 ),

  ABORT( -1 );

  private int key;

  ServerMessage( int key ) {
    this.key = key;
  }

  public int getKey() {
    return this.key;
  }

  public static ServerMessage getMessage( int key ) {

    for ( ServerMessage possibleMessage : ServerMessage.values() ) {

      if ( possibleMessage.getKey() == key ) {
        return possibleMessage;
      }

    }

    throw new IllegalArgumentException();
  }

}
