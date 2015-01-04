import java.util.*;
 
public class testListArrary {
    public static void main(String args[]){
        List list = new ArrayList();
        int j = 1;
        for (int i = 0; i < 10 ; i ++)
            list.add(i);
        list.add(5,j);
         
        System.out.println(list);
    }
}