package eg_buffer_builder;

public class TitleCase {

	public static void main(String[] args) {
		String s="hello hi how are you doing today";
		StringBuilder sb=new StringBuilder();
		String ar[]=s.split(" ");
		for (int i = 0; i < ar.length; i++) {
			sb.append(Character.toUpperCase(ar[i].charAt(0))).append(ar[i].substring(1)).append(" ");
		}
		System.out.println(sb.toString().trim());//gets rid of white space but only works for strings so tostring converts
	
	
	
	}

}
//1 try converting last letter of every word to uppercase and print
//2 if length of word is odd then convert middle letter of word as uppercase else print as it is