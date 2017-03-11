
import java.util.Arrays;
public class Answer {   
	public static void main(String args[]){
		
		int[] c={2,6,5,1,8,9};
		int[] d={9,8,1,5,6,3,2};
		int m=Answer.answer(c, d);
		System.out.println(m);
	}
	
    public static int answer(int[] x, int[] y) { 

        Arrays.sort(x);
        Arrays.sort(y);
        int a=x.length;
        int b=y.length;
        if(a>b){
            for(int i=0;i<b;i++){
                if(x[i]!=y[i]){
                    return x[i];
                }
            }
            return x[b];
        }
        if(a<b){
            for(int i=0;i<a;i++){
                if(x[i]!=y[i]){
                    return y[i];
                }
            }
            return y[a];
        }
		return 0;
    } 
}