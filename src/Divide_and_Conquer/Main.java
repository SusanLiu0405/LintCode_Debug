package Divide_and_Conquer;

public class Main {
    public static void main(String[] args) {
        int[] test_array={1,0,1,4,5,6};
        int result=find_largest(test_array,0,test_array.length);
        System.out.println(result);
    }
    public static int find_largest(int[] default_array, int start_index, int end_index){
        int mid_index=(start_index + end_index)/2;
        int left_largest = find_largest(default_array, start_index, mid_index);
        int right_largest = find_largest(default_array, mid_index+1, end_index);

        if(default_array[left_largest]>= default_array[right_largest]){
            return left_largest;
        } else {
            return right_largest;
        }
    }
}