package Divide_and_Conquer;

public class Main {
    public static void main(String[] args) {
        int[] test_array={1,0,9,4,5,7,6};
        int largest=find_largest(test_array,0,test_array.length-1);
        int smallest=find_smallest(test_array,0,test_array.length-1);

        System.out.println("min value: "+test_array[smallest]);
        System.out.println("max index: " + largest);
        System.out.println("max value: "+ test_array[largest]);
    }
    public static int find_largest(int[] default_array, int start_index, int end_index){
        //System.out.println("entering with" + start_index + " " + end_index);

        if (start_index == end_index) {
            return start_index;
        }
        int mid_index=(start_index + end_index)/2;
        int left_largest = find_largest(default_array, start_index, mid_index);
        int right_largest = find_largest(default_array, mid_index+1, end_index);

        if(default_array[left_largest]>= default_array[right_largest]){
            return left_largest;
        } else {
            return right_largest;
        }
    }

    public static int find_smallest(int[] default_array, int start_index, int end_index){

        if (start_index == end_index) {
            return start_index;
        }
        int mid_index=(start_index + end_index)/2;
        int left_smallest = find_smallest(default_array, start_index, mid_index);
        int right_smallest = find_smallest(default_array, mid_index+1, end_index);

        if(default_array[left_smallest]<= default_array[right_smallest]){
            return left_smallest;
        } else {
            return right_smallest;
        }
    }
}
