import java.io.*;

public class FileMove {

     public static void main(String[] args) throws IOException {
         File file = new File(File.separator + "Users"+ File.separator + "scarelette" +File.separator + "Desktop" +File.separator + "1.txt");
         //bufferedReader
         BufferedReader buf = new BufferedReader(new FileReader(file));
        File outFile = new File(File.separator + "Users"+ File.separator + "scarelette" + File.separator + "Desktop" + File.separator + "output.txt ");
        Writer writer = new FileWriter(outFile);
        String str;
        while ((str = buf.readLine()) != null) {
            writer.write(str + "\n");
        }
        writer.close();
    }
}
