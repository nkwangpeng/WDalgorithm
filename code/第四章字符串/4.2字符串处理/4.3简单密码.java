import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] mapping = {
                'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'
        };
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("ENDOFINPUT")) break;
            line = br.readLine();
            String res = "";
            for (int i = 0; i < line.length(); i++) {
                char tmpCh = line.charAt(i);
                if (tmpCh >= 'A' && tmpCh <= 'Z') {
                    res += mapping[tmpCh - 'A'];
                } else {
                    res += tmpCh;
                }
            }
            br.readLine();
            System.out.println(res);

        }
    }
}