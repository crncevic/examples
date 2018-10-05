import java.io.*;
public class Read{
    public static void main(String [] args) throws IOException{
	   
	   System.out.println("Unesite tekst:");
	   
	   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	   String text = reader.readLine();
	   
	   System.out.println("Uneli ste: \n"+text);
	   
	}		
}