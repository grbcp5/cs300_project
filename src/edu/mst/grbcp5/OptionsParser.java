package edu.mst.grbcp5;

import java.util.HashMap;
import java.util.Map;

public class OptionsParser {

  public static Map<String, String> parseOptions( String[] args ) {

    if( args.length % 2 == 1 ) {
      throw new IllegalArgumentException();
    }

    String key;
    String value;
    Map<String, String> result = new HashMap<>( args.length / 2 );

    for ( int i = 0; i < args.length; i += 2 ) {

      if( args[ i ].charAt( 0 ) != '-' ) {
        throw new IllegalArgumentException();
      }

      key = args[ i ].toLowerCase().substring( 1 ); // remove '-' char
      value = args[ i + 1 ].toLowerCase();

      result.put( key, value );
    }

    return result;
  }


}
