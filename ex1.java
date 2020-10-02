import java.util.Scanner; // Import the Scanner class
import java.io.File; // Import the File class
import java.io.FileWriter; // Import the FileWriter class
import java.io.FileNotFoundException; // Import to handle errors
import java.io.IOException;  // Import to handle errors
import java.lang.*;


public class ex1{
  protected static PilhaIngenua pile;
  protected static int pileCounter = 0;

  static void pile_control(String line, String saidaArqv){
    if(line.isEmpty()){
      if(pileCounter > 1){
      String aux = Integer.toString(pile.remove()) + "\n";
      writeToFile(aux, saidaArqv);
      pileCounter--; }}
    else{
      if(pileCounter < pile.MAX){
        int aux = Integer.parseInt(line);
        pile.add(aux);
        pileCounter++; }}
  }

  static void writeToFile(String conteudo, String file){
    try {
        FileWriter myWriter = new FileWriter(file, true);
        myWriter.write(conteudo);
        myWriter.close();}
    catch (IOException e) {
        e.printStackTrace();}
  }

  static void readFile(File entradaArqv, String saidaArqv){
    String aux;
    try {
      Scanner myReader = new Scanner(entradaArqv);
      while(myReader.hasNext()) {
        aux = myReader.nextLine();
        pile_control(aux, saidaArqv);}
      myReader.close();}
    catch(FileNotFoundException e) {
      e.printStackTrace();}
  }

  static void readDirectory(String entradasDir, String dadosArqv, String saidasDir){
    long inicio; long fim; long diferenca; String dados; String saidaArqv;

    File[] fileArray = new File(entradasDir).listFiles();
    for(File entradaArqv: fileArray){
      //cria arquivo de saida
      saidaArqv = saidasDir + "/" + "saida_" + entradaArqv.getName();
      createFile(saidaArqv);

      //comeca a contar o tempo
      inicio = System.currentTimeMillis();

      //zera a PilhaIngenua
      pile = new PilhaIngenua();
      pileCounter = 0;

      //itera no arquivo de entradas
      readFile(entradaArqv, saidaArqv);

      //finaliza contagem do tempo
      fim = System.currentTimeMillis();

      //calcula e imprime dados no arquivo de dados
      diferenca = fim - inicio;
      dados = pegaTamanho(entradaArqv.getName()) + "," + diferenca + "\n";
      writeToFile(dados, dadosArqv);}
  }

  static String pegaTamanho(String texto){
    int fim = texto.indexOf(".");
    return texto.substring(7,fim);
  }

  static void createFile(String path_name){
    try {
      File obj = new File(path_name);
      obj.createNewFile();}
    catch (IOException e) {
      e.printStackTrace();}
  }

  static void createDirectory(String name){
    File direct = new File(name);
    direct.mkdir();
  }
}
