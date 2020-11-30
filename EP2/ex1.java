import java.io.File; // Import the File class

public class ex1{
  protected static PilhaIngenua2 mainstack;
  protected static Integer[] respostas;
  protected static int i;
  protected static long t_inicial;
  protected static long t_final;
  protected static long tempo;
  protected static long tamanho;


  static void stack(String entradasDir, String saidasDir, String dadosArqv){
    //recebe lista de arquivos
    File[] fileArray = operaArquivos.readDirectory(entradasDir);

    for(File entradaArqv: fileArray){
      //zera
      mainstack = new PilhaIngenua2();
      respostas = new Integer[999999];
      i=0;
      tamanho = 0;
      //comeca a contar o tempo
      t_inicial = System.currentTimeMillis();

      //le arquivo
      operaArquivos.readFile(entradaArqv, true);

      //finaliza contagem do tempo
      t_final = System.currentTimeMillis();

      //imprime arquivo de saida
      imprimeSaida(saidasDir, entradaArqv);

      //imprime dados
      imprimeDados(dadosArqv);
    }
  }

  static void control(String line){
    if(line.isEmpty()) {
      if(mainstack.size > 0) {
        respostas[i] = mainstack.remove();
        //System.out.println("Tirou "+respostas[i]);
        i++;
      }
    }
    else {
      Integer aux = Integer.parseInt(line);
      mainstack.add(aux);
    }
    tamanho++;
  }

  static void imprimeSaida(String saidasDir, File entradaArqv){
    String aux;

    //cria arquivo de saida
    String saidaArqv = saidasDir + "/" + "saida_" + entradaArqv.getName();
    operaArquivos.createFile(saidaArqv);

    for(int j=0; j<i; j++){
        aux = Integer.toString(respostas[j]) + "\n";
        operaArquivos.writeToFile(aux, saidaArqv);
    }
  }

  static void imprimeDados(String dadosArqv){
    tempo = t_final - t_inicial;
    String dados = String.valueOf(tamanho) + "," + tempo + "\n";
    operaArquivos.writeToFile(dados, dadosArqv);
  }
}
