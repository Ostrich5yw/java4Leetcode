package util;

public class print {
    public static void printArray1D(int[] array){
        for(int i = 0;i < array.length;i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    public static void printArray1D1(int[] array){
        for(int i = 0;i <= array[0];i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    public static void printArray2D(int[][] array){
        for(int i = 0;i < array.length;i++) {
            for (int j = 0; j < array[i].length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }
}
