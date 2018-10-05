

public class Multiplication{

    public static void main(String [] args){
		
		System.out.println("\n Multiplication table \n");
	
	    for(int i = 0; i < 10; i++){
		   for(int j = 0;j < 10; j++){
		       
			   if(i == 0 && j == 0){
			       System.out.print(" X ");
				   
			   }
			   
			   else if(i == 0 || j == 0){
				   
				   if(i==0){
				   System.out.print("| "+j+" ");
				  
				   }

                   if(j==0){
				   System.out.print(" "+i+" ");
				
				   }				   
			   }
			   
			   else{
				   
				   if(i*j < 10){
					      System.out.print("| "+(i*j)+" ");
				   }else{
				          System.out.print("| "+(i*j));
				   }
				   
			       
			   }
		   }
		   System.out.println("\n");
		}
	
	}

}