import java.util.Scanner;
import java.util.Arrays;
class Country{
    public int goldMedal;
    public int allMedal;
    public int population;
    public double goldDivPop;
    public double medalDivPop;
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] countryNums = in.nextLine().split(" ");
        int allCtryCount = Integer.parseInt(countryNums[0]);
        int orderCtryCount = Integer.parseInt(countryNums[1]);
        Country[] ctryAllInfo = new Country[allCtryCount];
        Country[] orderCtryInfo = new Country[orderCtryCount];
        for(int i = 0; i < allCtryCount; i++){
            String[] ctryInfos = in.nextLine().split(" ");
            ctryAllInfo[i] = new Country();
            ctryAllInfo[i].goldMedal = Integer.parseInt(ctryInfos[0]);
            ctryAllInfo[i].allMedal = Integer.parseInt(ctryInfos[1]);
            ctryAllInfo[i].population = Integer.parseInt(ctryInfos[2]);
        }
        String[] orderCountry = in.nextLine().split(" ");
        for(int i = 0; i < orderCtryCount; i++){
            orderCtryInfo[i] = new Country();
            orderCtryInfo[i] = ctryAllInfo[Integer.parseInt(orderCountry[i])];
        }
    }
}