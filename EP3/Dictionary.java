public interface Dictionary<K,V> {
  // a quantidade de entradas
  int size();

  // verifica se o dicionário está vazio
  boolean isEmpty();

  // devolve uma entrada cuja chave é key
  Entry<K,V> find(K key);

  // insere um par chave/valor
  Entry<K,V> insert(K key, V value);
}
