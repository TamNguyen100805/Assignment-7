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

    public static void printData(float[] arrays) {
        for (float number : arrays) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static float findMax2(float[] arrays) {
        if (arrays.length < 2) {
            throw new IllegalArgumentException("Mang phai co it nhat 2 phan tu.");
        }

        float max1 = Float.NEGATIVE_INFINITY;
        float max2 = Float.NEGATIVE_INFINITY;

        for (float number : arrays) {
            if (number > max1) {
                max2 = max1;
                max1 = number;
            } else if (number > max2 && number != max1) {
                max2 = number;
            }
        }

        if (max2 == Float.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Mang khong co phan tu lon thu 2.");
        }

        return max2;
    }

    public static float[] deleteOddNumber(float[] arrays) {
        int countEven = 0;
        for (float number : arrays) {
            if ((int) number % 2 == 0) {
                countEven++;
            }
        }

        float[] newArray = new float[countEven];
        int index = 0;
        for (float number : arrays) {
            if ((int) number % 2 == 0) {
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

        System.out.print("Mảng vừa nhập: ");
        printData(arrays);

        try {
            float max2 = findMax2(arrays);
            System.out.println("Gia tri phan tu lon thu 2 trong mang: " + max2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        arrays = deleteOddNumber(arrays);
        System.out.print("Mang sau khi xoa cac phan tu le: ");
        printData(arrays);
    }
}
