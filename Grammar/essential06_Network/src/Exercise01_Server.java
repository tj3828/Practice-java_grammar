import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise01_Server {
	public static void main(String[] args) {
		try(DatagramSocket ds = new DatagramSocket(54321);){
			for(int c=0;c<=10;c++) {
				DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
				ds.receive(dp);
				byte[] b = dp.getData();
				String data = new String(b, 0, dp.getLength());
				
				String[] i = data.split(" ",2);
				String[] a = i[1].split(" ");
				double num = 0;
				if(i[0].equals("sum")) {
					for(String s : a) {
					
						int n = Integer.valueOf(s);
						num += n;
					}
					System.out.println(num);
				} else if(i[0].equals("avg")) {
					for(String s : a) {
						int n = Integer.valueOf(s);
						num += n;
					}
					num /= a.length;
				} else if(i[0].equals("max")) {
					List<Integer> li = new ArrayList<>();
					for(String s : a) {
						int n = Integer.valueOf(s);
						li.add(n);
					}
					li.sort(new Comparator<Integer>(){
						@Override
						public int compare(Integer o1, Integer o2) {
							return o1 > o2 ? 1 : o1 == o2 ? 0 : -1;
						}		
					});;
					num = li.get(li.size()-1);
				}
				String sendData = String.valueOf(num);
				byte[] sendDataByte = sendData.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendDataByte, sendDataByte.length, dp.getSocketAddress());
				ds.send(sendPacket);
				System.out.println("send");
			}
		}catch(IOException e) {
			System.out.println("failed..");
		}
	}
}
