import java.util.List;

public class Recursion {
     public int factorialR(int n){
        if(n == 0) {
            return 1;
        }
        return n * factorialR(n-1);
    }

    public int fibonacci(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public void reverseR(List list){
        if(list.size() == 1){
            return;
        }
        Object firstEleemnt = list.remove(0);
        reverseR(list);
        list.add(firstEleemnt);
    }
    public void sortR(List list){
        if(list.size() == 1){
            return;
        }
        int minElement = removeMinElement(list);
        sortR(list);
        list.add(0, minElement);
    }
    public int removeMinElement(List list){
        int temp;
        if(list.size() == 0){
            throw new IndexOutOfBoundsException();
        }else if(list.size() == 1){
            temp = (int)list.get(0);
            list.remove(0);
            return temp;
        }
        temp = (int)list.get(0);
        for(int i  = 1; i < list.size(); i++){
            if((int)list.get(i) < temp){
                temp = (int)list.get(i);
            }
        }
        return temp;
    }
    public int powerXR(int x, int n){
        if(n == 0){
            return 1;
        }else{
            return x*powerXR(x, n-1);
        }
    }
    public static int powerXR2(int x, int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }else{
            int temp = powerXR2(x, n/2);
            if(n%2 == 0){
                System.out.println(2);
                return temp*temp;
            }else{
                System.out.println(3);
                return temp*temp*x;
            }
        }
    }
    public int powerX2(int x, int n){
        int result = 1;
        int pow = x;
        if(n%2 == 1){
            result = x;
        }
        n = n/2;
        while(n != 0){
            pow = pow*pow;
            if(n%2 == 1){
                result = result*pow;
            }
            n = n/2;
        }
        return result;
    }
    public int binarySearchR(List list, int key, int left, int right){
        if(left <= right){
            int mid = (left + right)/2;
            if((int)list.get(mid) == key){
                return mid;
            }else{
                if(key < (int)list.get(mid)){
                    return binarySearchR(list, key, left, mid-1);
                }else{
                    return binarySearchR(list, key, mid+1, right);
                }
            }
        }
        return -1;
    }
    public static int[] merge(int[] list1, int[] list2){
        int[] newList = new int[list1.length + list2.length];
        int counter = 0;
        int counter1 = 0;
        int counter2 = 0;
        while(counter1 < list1.length && counter2 < list2.length){
            if(list1[counter1] < list2[counter2]){
                newList[counter] = list1[counter1];
                counter++;
                counter1++;
            }else{
                newList[counter] = list2[counter2];
                counter++;
                counter2++;
            }
        }
        while(counter1 < list1.length){
            newList[counter] = list1[counter1];
            counter++;
            counter1++;
        }
        while(counter2 < list2.length){
            newList[counter] = list2[counter2];
            counter++;
            counter2++;
        }
        return newList;
    }
    public static int[] mergeSort(int[] list){
        if(list.length <= 1){
            return list;
        }else{
            int mid = (list.length - 1)/2;
            int[] list1 = getElements(list, 0, mid);
            int[] list2 = getElements(list, mid+1, list.length-1);

            list1 = mergeSort(list1);
            list2 = mergeSort(list2);
            /**
            System.out.println("list1");
            for (Integer value : list1){

                System.out.println(value);
            }
            System.out.println("list2");
            for (Integer value : list2){
                System.out.println(value);
            }
             */
            return merge(list1, list2);
        }
    }
    public static int[] getElements(int[] list, int start, int end){
        int[] returnList = new int[(end-start)+1];
        for(int i = 0; i <= end-start; i++){
            returnList[i] = list[start+i];
        }
        return returnList;
    }
    public static void quickSort(int[] list, int left, int right){
        if(left >= right){
            System.out.println("FINAL");
            for(Integer value : list){
                System.out.println(value);
            }
            return;
        }else{
            int i = placeAndDivide(list, left, right);
            quickSort(list, left, i-1);
            quickSort(list, i+1, right);
        }
    }
    public static int placeAndDivide(int[] list, int left, int right){
        int pivot = list[right];
        int wall = left - 1;
        for(int i = left; i < right; i++){
            if(list[i] < pivot){
                wall++;
                swap(list, i, wall);
            }
        }
        list = swap(list, right, wall+1);
        System.out.println("PLACE AND DIVIDE");
        for(Integer value : list){
            System.out.println(value);
        }
        return wall+1;
    }
    public static int[] swap(int[] list, int index1, int  index2){
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
        return list;
    }
    public static boolean isEven(int x){
         int y = Math.abs(x);
         if(y==0){
             return true;
         }else{
             return y != 1 && isEven(y-2);
         }
     }

    public static void main(String[] args) {
        System.out.println(isEven(4));
        //powerXR2(1,116);
        /**
        int[] arr = {9, 6, 3, 13, 2, 58, 32, 8, 12, 1};
        arr = mergeSort(arr);
        for(Integer value : arr){
            System.out.println(value);
        }
         */
        int[] arr = {2,6,1,7,3,5,4};
        quickSort(arr, 0, arr.length-1);
    }
}

