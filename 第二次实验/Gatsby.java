package Exercise2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.io.BufferedReader;

public class Gatsby {
    static Map<String,Integer> map = new HashMap<String,Integer>();
    static List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>();
	
    private static void arrayToMap(String[] array) {
    	for(String item: array) {
			if(!map.containsKey(item)) {
				map.put(item, 1);
			} else {
				map.put(item,map.get(item) + 1);
			}
		}
    }
    
    private static void sort() {
    	list = new ArrayList<Entry<String,Integer>>(map.entrySet());
    	Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
    		public int compare(Map.Entry<String, Integer> o1,
    				Map.Entry<String, Integer> o2) {
    			if (o1.getValue().equals(o2.getValue())) {
    				return (o2.getKey().hashCode() - o1.getKey().hashCode());
    			} 
    			return (o2.getValue() - o1.getValue());
    		}
    	});
  

    }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			File file = new File(File.separator + "Users"+ File.separator + "scarelette" +File.separator + "Desktop" +File.separator + "the great gatsby.txt");
			//bufferedReader
			BufferedReader buf = new BufferedReader(new FileReader(file));
			String str = null;
			String[] array ;
			while((str = buf.readLine()) != null) {
				array = str.split("\\s+");
				arrayToMap(array);
			}
			
//			InputStream is = new FileInputStream(file);
//			byte barray[] = new byte[1024];
//			int length = is.read(barray);
//            str = new String(barray,0,length);
//            array = str.split("\\s+");
//			arrayToMap(array);
			buf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sort();
		
		File outFile = new File(File.separator + "Users"+ File.separator + "scarelette" +File.separator + "Desktop" +File.separator + "output3.txt");
		if(!outFile.getParentFile().exists()) {
			outFile.getParentFile().mkdirs();
		}
		
//		Writer writer = new FileWriter(outFile);
//		OutputStream ops = new FileOutputStream(outFile);
		PrintStream ps = new PrintStream(new FileOutputStream(outFile));
		for(Entry<String, Integer> item: list) {
    		String string = item.getKey() + " " + item.getValue() + "\n";
//    		char[] arr = string.toCharArray();
//    		writer.write(string);
    		//outputstream
//    		byte[] ba = string.getBytes();
//    		ops.write(ba);
    		ps.print(string);
    	}
//		writer.flush();
//		writer.close();
//		ops.close();
	}

}
