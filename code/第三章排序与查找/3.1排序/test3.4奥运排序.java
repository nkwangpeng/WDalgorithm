import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.math.*;
class Country{
    public int goldMedal;
    public int allMedal;
    public int population;
    public double goldDivPop;
    public double medalDivPop;
}
class goldMedalComparator implements Comparator{
    @Override
    public int compare(Object a, Object b){
        Country c1 = (Country) a;
        Country c2 = (Country) b;
        return c1.goldMedal < c2.goldMedal ? 1 : -1;
    }
} 
class allMedalComparator implements Comparator{
    @Override
    public int compare(Object a, Object b){
        Country c1 = (Country) a;
        Country c2 = (Country) b;
        return c1.allMedal < c2.allMedal ? 1 : -1;
    }
}
class goldDivComparator implements Comparator{
    @Override
    public int compare(Object a, Object b){
        Country c1 = (Country) a;
        Country c2 = (Country) b;
        return c1.goldDivPop < c2.goldDivPop ? 1 : -1;
    }
}
class medalDivComparator implements Comparator{
    @Override
    public int compare(Object a, Object b){
        Country c1 = (Country) a;
        Country c2 = (Country) b;
        return c1.medalDivPop < c2.medalDivPop ? 1 : -1;
    }
} 
public class Main {
    public static int getRank(Country[] allCtrs, Country ctr, Comparator cmp, int type){
        Arrays.sort(allCtrs, cmp);
        if(allCtrs[0] == ctr)
            return 1;
        int ctrOrder = 1;
        int sameOrder = 0;
        for(int i = 1; i < allCtrs.length; i++){
            if(type == 0 && allCtrs[i].goldMedal < allCtrs[i - 1].goldMedal){
                ctrOrder += sameOrder + 1;
                sameOrder = 0;
            }
            else if(type == 1 && allCtrs[i].allMedal < allCtrs[i - 1].allMedal){
                ctrOrder += sameOrder + 1;
                sameOrder = 0;
            }
            else if(type == 2 && allCtrs[i].goldDivPop < allCtrs[i - 1].goldDivPop){
                ctrOrder += (sameOrder + 1);
                sameOrder = 0;
            }
            else if(type == 3 && allCtrs[i].medalDivPop < allCtrs[i - 1].medalDivPop){
                ctrOrder += sameOrder + 1;
                sameOrder = 0;
            }
            else
                sameOrder++;
            if(allCtrs[i] == ctr)
                break;
        }
        return ctrOrder;
    }
    public static int[] getBestRank(Country[] allCtrs, Country ctr){
        int[] res = new int[2];
        int rank1 = getRank(allCtrs, ctr, new goldMedalComparator(), 0);
        int rank2 = getRank(allCtrs, ctr, new allMedalComparator(), 1);
        int rank3 = getRank(allCtrs, ctr, new goldDivComparator(), 2);
        int rank4 = getRank(allCtrs, ctr, new medalDivComparator(), 3);
        res[0] = Math.min(rank1, Math.min(rank2, Math.min(rank3, rank4)));
        int[] tmpArr = new int[4];
        tmpArr[0] = (rank1 == res[0]) ? 1 : 0;
        tmpArr[1] = (rank2 == res[0]) ? 1 : 0;
        tmpArr[2] = (rank3 == res[0]) ? 1 : 0;
        tmpArr[3] = (rank4 == res[0]) ? 1 : 0;
        for(int i = 0; i < 4; i++)
            if(tmpArr[i] == 1){
                res[1] = i + 1;
                break;
            }
        return res;
    }
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
            ctryAllInfo[i].goldDivPop = ctryAllInfo[i].population != 0 ? (double)ctryAllInfo[i].goldMedal / ctryAllInfo[i].population : ctryAllInfo[i].goldMedal == 0 ? 1 : Double.MAX_VALUE;
            ctryAllInfo[i].medalDivPop = ctryAllInfo[i].population != 0 ? (double)ctryAllInfo[i].allMedal / ctryAllInfo[i].population : ctryAllInfo[i].allMedal == 0 ? 1 : Double.MAX_VALUE;
        }
        String[] orderCountry = in.nextLine().split(" ");
        for(int i = 0; i < orderCtryCount; i++){
            orderCtryInfo[i] = new Country();
            orderCtryInfo[i] = ctryAllInfo[Integer.parseInt(orderCountry[i])];
        }
        for(int i = 0; i < orderCtryCount; i++){
            int[] res = getBestRank(ctryAllInfo, orderCtryInfo[i]);
            System.out.println(res[0] + ":" + res[1]);
        }
    }
}