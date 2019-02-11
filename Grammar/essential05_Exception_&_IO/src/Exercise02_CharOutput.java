import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Exercise02_CharOutput {
	public static void main(String[] args) {
		int[] ar = new int[7];
		boolean[] br = new boolean[5];
		
		
		try {
		//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("exam.log")));
			BufferedWriter bw = new BufferedWriter(new FileWriter("exam.log"));
			bw.write("# int 배열의 데이터");
			bw.newLine();
			bw.write("-> ");
			for(int i = 0; i<ar.length; i++) {
				ar[i] = (int)Math.pow(2, i);
				bw.write(ar[i] + " ");
			}
			bw.newLine();
			bw.write("# boolean 배열의 데이터");
			bw.newLine();
			bw.write("-> ");
			for(int i = 0; i<br.length; i++) {
				br[i] = i%2==0 ? true : false;
				bw.write(br[i] + " ");
			}
			bw.close();
		}catch(IOException e) {
			System.out.println(e.toString());
		}
	}
}
