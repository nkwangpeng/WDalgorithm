public class Main {
    public static int Reverse(int x){
        int revX = 0;
        while(x != 0){
            revX *= 10;
            revX += x % 10;
            x /= 10;
        }
        return revX;
    }
    public static void main(String[] args) {
        for(int i = 0; i <= 256; i++){
            if(i * i == Reverse(i * i))
                System.out.println(i);
        }
    }
}