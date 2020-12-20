import java.util.Arrays;
import java.io.File;
import java.util.Comparator;

public class executaEP3{
  //Nomeia os diretórios das tarefas
  static  String TADir = "./entradas";
  static  String TTDir = "./verificar";
  static  String BI_saidasDir = "./BuscaIngenua_saidas";
  static  String BB_saidasDir = "./BuscaBinaria_saidas";

  //Nomeia os arquivos de saidas de dados
  static  String dadosArqv_Ingenua = BI_saidasDir + "/dados_BuscaIngenua.csv";
  static  String dadosArqv_Binaria = BB_saidasDir + "/dados_BuscaBinaria.csv";

  //Arrays de arquivos e referencia aos arquivos
  static  File[] filesAnteriores;
  static  File[] filesTotais;
  static  File arquivoTA;
  static  File arquivoTT;

  //Reserva os conteudos lidos pelos arquivos
  static  String[] tarefasAnteriores;
  static  int num_linhasTA;
  static  String[] tarefasTotais;
  static  int num_linhasTT;

  //Objetos de busca
  static  BuscaIngenua buscaingenua;
  static  BinarySearchTree buscabinaria;

  //variaveis auxiliares
  static  String[] tarefasEncontradas;
  static  boolean encontrou;
  static  int contadorEncontradas;
  static  long tempo_inicial;
  static  long tempo_final;
  static  String conteudo;  //a ser escrito no arquivo de dados
  static  String saida_path;
  static  String tam_txt;  //tamanho, em texto, do arquivo
  static  int tam_num;    //tamanho do arquivo



  public static void main(String[] args){
    preparaArquivos();

    //Percorre a lista de arquivos
    for(int i=0; i<filesAnteriores.length; i++){

      //separa arquivo do momento
      arquivoTA = filesAnteriores[i];
      arquivoTT = filesTotais[i];

      //pega tamanho
      tam_txt = operaArquivos.pegaTamanho(arquivoTA.getName());
      tam_num = Integer.parseInt(tam_txt);

      //inicializa variaveis
      tarefasAnteriores = new String[tam_num];
      tarefasTotais = new String[tam_num];

      //pega lista de tarefas do arquivo de tarefas da impressora antiga e totais
      num_linhasTA = operaArquivos.FileToArray(arquivoTA, tarefasAnteriores);
      num_linhasTT = operaArquivos.FileToArray(arquivoTT, tarefasTotais);

      // SECAO::: BUSCAS INGENUAS NO ARQUVO
      ex1();

      // SECAO::: BUSCAS BINARIAS NOS ARQUVOS
      ex2();
    }
  }

  static void ex1(){
    //zera variaveis
    contadorEncontradas = 0;
    tarefasEncontradas = new String[tam_num];
    buscaingenua = new BuscaIngenua();

    //inicia contador de tempo da busca ingenua
    tempo_inicial = System.currentTimeMillis();

    //percorre array tarefasAnteriores preenchendo buscaingenua
    for(int i = 0; i < num_linhasTA; i++) buscaingenua.insert(tarefasAnteriores[i]);

    //percorre array de tarefasTotais buscando se existe em tarefasAnteriores. Armazena tarefa caso sim.
    for(int i = 0; i < num_linhasTT; i++)
      if(buscaingenua.find(tarefasTotais[i])) tarefasEncontradas[contadorEncontradas++] = tarefasTotais[i];

    //encerra contador de tempo da busca
    tempo_final = System.currentTimeMillis();

    //escreve os dados de processamento no arquivo de dados
    conteudo = tam_txt + "," + (tempo_final - tempo_inicial);
    operaArquivos.writeToFile(conteudo, dadosArqv_Ingenua);

    //cria e escreve as tarefas encontradas no arquivo de saida
    saida_path = BI_saidasDir + "/saida_tarefas" + tam_txt + ".txt";
    operaArquivos.createFile(saida_path);
    for(int i=0; i<contadorEncontradas; i++) operaArquivos.writeToFile(tarefasEncontradas[i], saida_path);
  }

  static void ex2(){
    //zera variaveis
    contadorEncontradas = 0;
    tarefasEncontradas = new String[tam_num];
    buscabinaria = new BinarySearchTree<String,String>(new StringComparator());

    //inicia contador de tempo da busca binaria
    tempo_inicial = System.currentTimeMillis();

    //percorre array tarefasAnteriores preenchendo buscaingenua
    for(int i = 0; i < num_linhasTA; i++) buscabinaria.insert(tarefasAnteriores[i],'0');

    //percorre array de tarefasTotais buscando se existe em tarefasAnteriores. Armazena tarefa caso sim.
    for(int i = 0; i < num_linhasTT; i++){
      Entry<String,String> result = buscabinaria.find(tarefasTotais[i]);
      if(result!=null) tarefasEncontradas[contadorEncontradas++] = tarefasTotais[i];
    }

    //encerra contador de tempo da busca
    tempo_final = System.currentTimeMillis();

    //escreve os dados de processamento no arquivo de dados
    conteudo = tam_txt + "," + (tempo_final - tempo_inicial);
    operaArquivos.writeToFile(conteudo, dadosArqv_Binaria);

    //cria e escreve as tarefas encontradas no arquivo de saida
    saida_path = BB_saidasDir + "/saida_tarefas" + tam_txt + ".txt";
    operaArquivos.createFile(saida_path);
    for(int i=0; i<contadorEncontradas; i++) operaArquivos.writeToFile(tarefasEncontradas[i], saida_path);
  }

  static void preparaArquivos(){
    //Cria diretórios de Saida
    operaArquivos.createDirectory(BI_saidasDir);
    operaArquivos.createDirectory(BB_saidasDir);

    //Cria arquivos de saida dos dados das buscas
    operaArquivos.createFile(dadosArqv_Ingenua);
    operaArquivos.createFile(dadosArqv_Binaria);

    //Le os diretórios de entradas
    filesAnteriores = operaArquivos.readDirectory(TADir);
    filesTotais = operaArquivos.readDirectory(TTDir);

    //ordena os diretórios por conveniencia para os arquivos de tarefas ficarem correspondentes
    Arrays.sort(filesAnteriores);
    Arrays.sort(filesTotais);
  }

  static void Imprime(String[] arr, int linhas){
    for(int i=0; i<linhas; i++) System.out.print(arr[i] + " ");
    System.out.println();
  }

  protected static class StringComparator implements Comparator<String> {
      public int compare(String v1, String v2) {
        return v1.compareTo(v2);
      }
  }
}
