//Два нечетных простых числа, отличающиеся на 2, называются близнецами.
// Например, числа 5 и 7. Напишите программу, которая будет находить все числа-близнецы на заданном отрезке

import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите начало отрезка: ");
            int start = scanner.nextInt();
            System.out.print("Введите конец отрезка: ");
            int end = scanner.nextInt();
            System.out.println("Числа-близнецы на отрезке от " + start + " до " + end + ":");
            for (int i = start; i < end ; i++) {
                if (Twinkel.sr(i) && Twinkel.sr(i + 2)) {
                    System.out.println(i + " и " + (i + 2));
                }
            }
        }

        class Twinkel {
            public static boolean sr(int num) {
                if (num <= 1) {
                    return false;
                }
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
