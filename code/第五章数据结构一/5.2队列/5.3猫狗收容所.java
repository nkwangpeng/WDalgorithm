import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ArrayList<Integer> dog = new ArrayList<>();
        ArrayList<Integer> cat = new ArrayList<>();
        ArrayList<Integer> animal = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < count; i++){
            int type =  in.nextInt();
            int option = in.nextInt();
            if(type == 1){
                if(option > 0 )
                    dog.add(option);    
                else
                    cat.add(option);
                animal.add(option);
            }
            else{
                if(option == 0){
                    int animalType = animal.remove(0);
                    if(animalType > 0)
                        sb.append(dog.remove(0) + " ");
                    else
                        sb.append(cat.remove(0) + " ");
                }
                else if(option == -1){
                    sb.append(cat.remove(0) + " ");
                    for(int j = 0; j < animal.size(); j++)
                        if(animal.get(j) < 0){
                            animal.remove(j);
                            break;
                        }
                }
                else{
                    sb.append(dog.remove(0) + " ");
                    for(int j = 0; j < animal.size(); j++)
                        if(animal.get(j) > 0){
                            animal.remove(j);
                            break;
                        }
                }
            }   
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}