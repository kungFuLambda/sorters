package sorters;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {
	ArrayList<Integer> a = new ArrayList<>();
	int lines = 0;
	
	
	public Integer[] readFile(String path){
		String fileName = path;
		File file = new File(fileName);
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while((line = br.readLine()) != null){
				a.add(Integer.decode(line));
				lines++;
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Integer [] stockArr = a.toArray(new Integer[a.size()]);
		return stockArr;
	}


	@Override
	public String toString() {
		return "FileReader [a=" + a + "]";
	}
}
