public class executaEP{
  public static void main(String[] args){

    //EXERCICIO 1
      String saidasDir = "./saidas_PilhaIngenua";
      String dadosArqv = "./dados_PilhaIngenua.csv";
      String entradasDir = "./entradas";

      //cria o diretório onde ficarão os arquivos de saida
      ex1.createDirectory(saidasDir);
      //cria o arquivo para centralizar os dados de tamanho e tempo
      ex1.createFile(dadosArqv);
      //le o diretorio de arquivos de entrada
      ex1.readDirectory(entradasDir, dadosArqv, saidasDir);

    //EXERCICIO 2
      saidasDir = "./saidas_ListaSLigada";
      dadosArqv = "./dados_ListaSLigada.csv";

      //cria o diretório onde ficarão os arquivos de saida
      ex2.createDirectory(saidasDir);
      //cria o arquivo para centralizar os dados de tamanho e tempo
      ex2.createFile(dadosArqv);
      //le o diretorio de arquivos de entrada
      ex2.readDirectory(entradasDir, dadosArqv, saidasDir);

    //EXERCICIO EXTRA
      saidasDir = "./saidas_PilhaArranjo";
      dadosArqv = "./dados_PilhaArranjo.csv";

      //cria o diretório onde ficarão os arquivos de saida
      exExtra.createDirectory(saidasDir);
      //cria o arquivo para centralizar os dados de tamanho e tempo
      exExtra.createFile(dadosArqv);
      //le o diretorio de arquivos de entrada
      exExtra.readDirectory(entradasDir, dadosArqv, saidasDir);
  }
}
