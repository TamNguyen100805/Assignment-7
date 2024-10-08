package BaiTapVeNha;

import java.util.Scanner;

public class Assignment_7 {

    public static float[] importData(float[] arrays) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            arrays[i] = scanner.nextFloat();
        }
        return arrays;
    }

    public static Float findMax2(float[] arrays) {
        if (arrays.length < 2) {
            System.out.println("Mang phai co it nhat 2 phan tu.");
            return null;
        }

        float max1 = Math.max(arrays[0], arrays[1]);
        float max2 = Math.min(arrays[0], arrays[1]);

        for (int i = 2; i < arrays.length; i++) {
            if (arrays[i] > max1) {
                max2 = max1;
                max1 = arrays[i];
            } else if (arrays[i] > max2 && arrays[i] != max1) {
                max2 = arrays[i];
            }
        }

        if (max1 == max2) {
            System.out.println("Mang khong co phan tu lon thu 2.");
            return null;
        }

        return max2;
    }

    public static float[] deleteOddNumber(float[] arrays) {
        int countEven = 0;
        for (float number : arrays) {
            if (number % 2 == 0) {
                countEven++;
            }
        }

        float[] newArray = new float[countEven];
        int index = 0;
        for (float number : arrays) {
            if (number % 2 == 0) {
                newArray[index++] = number;
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap kich thuoc mang: ");
        int size = scanner.nextInt();

        float[] arrays = new float[size];
        
        arrays = importData(arrays);
        
        System.out.println();

        System.out.print("Mang vua nhap: ");
        for (float number : arrays) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println();

        Float max2 = findMax2(arrays);
        if (max2 != null) {
            System.out.println("Phan tu lon thu 2 trong mang: " + max2);
        }
        System.out.println();

        arrays = deleteOddNumber(arrays);

        System.out.print("Mang sau khi xoa cac phan tu le: ");
        for (float number : arrays) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
