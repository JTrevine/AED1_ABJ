public class executaEP2{
  public static void main(String[] args){

    //EXERCICIO 1
      String saidasDir = "./saidas_PilhaIngenua2";
      String dadosArqv = "./dados_PilhaIngenua2.csv";
      String entradasDir = "./entradas";

      //cria o diretório onde ficarão os arquivos de saida
      operaArquivos.createDirectory(saidasDir);
      //cria o arquivo para centralizar os dados de tamanho e tempo
      operaArquivos.createFile(dadosArqv);
      //inicializa ex1
      ex1.stack(entradasDir, saidasDir, dadosArqv);

    //EXERCICIO 2
      saidasDir = "./saidas_PilhaMalandra";
      dadosArqv = "./dados_PilhaMalandra.csv";
      entradasDir = "./entradas";

      //cria o diretório onde ficarão os arquivos de saida
      operaArquivos.createDirectory(saidasDir);
      //cria o arquivo para centralizar os dados de tamanho e tempo
      operaArquivos.createFile(dadosArqv);
      //inicializa ex1
      ex2.stack(entradasDir, saidasDir, dadosArqv);

  }
}
