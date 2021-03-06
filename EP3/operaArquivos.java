import java.util.Scanner; // Import the Scanner class
import java.io.File; // Import the File class
import java.io.FileWriter; // Import the FileWriter class
import java.io.FileNotFoundException; // Import to handle errors
import java.io.IOException;  // Import to handle errors
import java.lang.*;

public class operaArquivos{


  static void createDirectory(String name){
    File direct = new File(name);
    direct.mkdir();
  }


  static void createFile(String path_name){
    try {
      File obj = new File(path_name);
      obj.createNewFile();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  static File[] readDirectory(String entradasDir){
    File[] fileArray = new File(entradasDir).listFiles();
    return fileArray;
  }

  static int FileToArray(File entradaArqv, String[] lista){
    String line;
    int i = 0;

    try {
        Scanner myReader = new Scanner(entradaArqv);
        while(myReader.hasNext()) {
          line = myReader.nextLine();
          if(!line.isEmpty()) lista[i++] = line;
        }
        myReader.close();
    }
    catch(FileNotFoundException e) {
        e.printStackTrace();
    }
    return i;
  }

  static void writeToFile(String conteudo, String file){
    try {
      FileWriter myWriter = new FileWriter(file, true);
      myWriter.write(conteudo + "\n");
      myWriter.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  static String pegaTamanho(String texto){
    int fim = texto.indexOf(".");
    return texto.substring(7,fim);
  }

}
