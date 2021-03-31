import java.io.IOException;
import java.util.Scanner;
public class Main{
    private static  int lena;
    private static  int lenb;
    private static int []a=new int [1000005];
    private static int []b=new int [10005];
    private static int []next=new int [200000];
    public static void getNext() 
    {  
        int i=0,j=-1;  
        next[0]=-1;  
        while(i<lenb)  
        {  
            if(j==-1||b[i]==b[j])  
            {  
                i++; j++;  
                next[i]=j;  
            }  
            else  
            j=next[j];  
        }  
    }  
    
    public static int KMP()  
    {  
        int i=0,j=0;  
        getNext();  
        while(i<lena)  
        {  
            if(j==-1||a[i]==b[j])  
            {  
                i++;
                j++;  
            }  
            else 
            {
                j=next[j];  
            }
            if(j==lenb)  
            return i-j+1;  
        }  
        return -1;  
    }  
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for(int i = 0; i < count; i++){
            lena=in.nextInt();
            lenb=in.nextInt();
            for(int j=0;j<lena;j++)  
                {a[j]=in.nextInt();}
            for(int j=0;j<lenb;j++)  
                {b[j]=in.nextInt();}
            System.out.println(KMP());
        }
    }
}