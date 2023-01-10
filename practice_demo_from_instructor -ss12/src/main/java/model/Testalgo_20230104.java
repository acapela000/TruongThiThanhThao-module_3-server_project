package model;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Testalgo_20230104 {
    //parent =[1,4,5,2,1],child=[1,2,3] =>return 0 // không xuất hiện => OK
    //parent =[1,2,1] ,child=[1] => return 2;//xuất hiện 2 lần => OK
    //parent =[1,4,5,2,3] child=[1,2,3] => return 1; // xuất hiện 1 lần => OK
    //parent =[1,4,5,2,3,2,3,1] child=[1,2,3] => return 2;//xuất hiện 2 lần => chưa OK
    //parent =[1,4,5,2,3,2,3,8] ,child=[1,2,3] => return 1;//xuất hiện 1 lần => chưa OK
    private static int[] parentArr = {1,4,5,2,3};
    private static int[] childArr = {1,2,3};
    private static List<Integer> listParent = new ArrayList<>();
    private static List<Integer> listChild = new ArrayList<>();

    private static int findOccurence(int[] parentArr) {
        int count = 0;

        for (int els : parentArr) {
            listParent.add(els);
        }
        System.out.println(listParent);

        for (int els : childArr) {
            listChild.add(els);
        }
        System.out.println(listChild);

        List<Integer> subList = new ArrayList<>();

        for (int i = 0; i < listParent.size(); i++) {
            for (int j = 0; j < listChild.size(); j++) {
                if (listParent.get(i).equals(listChild.get(j))) {
                    subList.add(listParent.get(i));
                    listParent.remove(listParent.get(i));
                }
                System.out.println(subList);
                if (subList.equals(listChild)) {
                    count++;
                }
            }
        }

//        for (int i = 0; i < parentArr.length; i++) {
//            for (int j = 0; j < childArr.length; j++) {
//                if (parentArr[i] == childArr[j]) {
//                    count++;
//                }
//            }
//        }
        System.out.print("occurence: " + count);

        return count;
    }

    public static void main(String[] args) {
        findOccurence(parentArr);
    }

}
