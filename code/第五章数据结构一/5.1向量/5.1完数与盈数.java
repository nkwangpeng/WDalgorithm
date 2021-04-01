public class Main {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
 
        for (int i = 2; i <= 60; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                sb1.append(i).append(" ");
            }
            if (sum > i) {
                sb2.append(i).append(" ");
            }
        }
        sb1.deleteCharAt(sb1.length() - 1);
        sb2.deleteCharAt(sb2.length() - 1);
        System.out.println("E: " + sb1);
        System.out.println("G: " + sb2);
    }
}