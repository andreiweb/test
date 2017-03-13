import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution11 {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String s = scan.nextLine();
		
		int idx = 0;
		String group="", name="", data="";
		
		HashMap<String, HashMap<String, String>> gnd = new HashMap<String, HashMap<String, String>>();
		for (String value : s.split("\t")) {
			
			if (idx%3==0) {
				group = value;
			}
			if (idx%3==1) {
				name = value;
			}
			if (idx%3==2) {
				data = value;
				
				if (gnd.containsKey(group)){
					
					HashMap<String, String> nd = gnd.get(group);
					nd.put(name, data);
					
				}
				else {
					HashMap<String, String> nd = new HashMap<String, String>();
					nd.put(name, data);
				}
			}
			
			idx++;
		}
		
		
		SortedSet<String> sortedGroup =  new TreeSet<String>(gnd.keySet());
		
		StringBuilder sb = new StringBuilder();
		for (String g : sortedGroup) {
			
			
			SortedSet<String> sortedName =  new TreeSet<String>(gnd.get(g).keySet());
			
			for (String n : sortedName) {
				
				String d = gnd.get(g).get(n);
				
				
				sb.append(g+"\t");
				sb.append(n+"\t");
				sb.append(d+"\t");
			}
			
		}
		
		System.out.println(sb);
		
		
		
	}
}
