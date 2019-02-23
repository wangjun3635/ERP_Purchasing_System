package com.team.purchasing.sort;

/**
 * @Auther:ynhuang
 * @Date:21/2/19 下午10:01
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arrs = new int[]{5,3,2,7,10,4};
        int[] sort = sort(arrs, 0, arrs.length - 1);
        for(int i : sort){
            System.out.print(i + ",");
        }
    }

    public static int[] sort(int[] arrs, int point, int length){

        int start = point;
        int end = length;
        int pointValue = arrs[point];

        while (start < end){
            //从后往前做比较
            if(start < end && arrs[end] > pointValue){
                end --;
            }

            int temp = arrs[end];
            arrs[end] = arrs[start];
            arrs[start] = temp;

            //从前往后比较
            if(start < end && arrs[start] < pointValue){
                start ++;
            }

            temp = arrs[start];
            arrs[start] = arrs[end];
            arrs[end] = temp;

        }

        if(start > point){
            sort(arrs, point, start-1);
        }
        if(end < length){
            sort(arrs, end + 1, length);
        }


        return arrs;
    }

}
