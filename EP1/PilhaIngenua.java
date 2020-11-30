public class PilhaIngenua{
  protected final int MAX = 1000000;
  protected Integer[] pilha;

  PilhaIngenua(){
    pilha = new Integer[MAX];}

  void add(int newElement){
    int i;
    for(i=0; pilha[i] != null; i++);
    pilha[i] = newElement;}

  int remove(){
    int i;
    for(i=0; pilha[i] != null; i++);
    int tmp = pilha[i-1];
    pilha[i-1] = null;
    return tmp;}

  /*
  void imprime(){
    String s = "[";
    for(int i=0; pilha[i] != null; i++) s += pilha[i].toString();
    s += "]";
    System.out.println(s);}

  public static void main(String[] args){
    PilhaIngenua pilha = new PilhaIngenua();
    pilha.imprime();
    pilha.add(2); pilha.imprime();
    pilha.remove(); pilha.imprime();
    pilha.add(3); pilha.imprime();
    pilha.remove(); pilha.imprime();
    pilha.remove(); pilha.imprime();
    pilha.add(4); pilha.imprime();
    pilha.add(5); pilha.imprime();
  */
}
