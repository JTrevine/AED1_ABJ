import java.util.Arrays;

public class BuscaIngenua {
  protected final int MAX = 1000000 ;
  protected String[] arranjo ;
  int size = 0;

  BuscaIngenua() { arranjo = new String[MAX]; }

  void insert ( String s ) {
    arranjo [ size ] = s;
    size ++;
  }
  boolean find ( String a ) {
    for ( int i = 0 ; i < size ; i ++) {
      if ( arranjo[ i ].equals(a)) return true;
    }
    return false;
  }
}
