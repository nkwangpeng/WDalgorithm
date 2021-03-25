public class Main {
    public static void main(String[] args) {
        for(int a = 0; a <= 9; a++){
            for(int b = 0; b <= 9; b++){
                for(int c = 0; c <= 9; c++){
                    if(a * 100 + b * 110 + c * 12 == 532)
                        System.out.println(a + " " + b + " " + c);
                }
            }
        }
    }
}