import java.util.Scanner;


public class task1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Введте размер исходных цен: ");
        int size = input.nextInt();
        int[] price = new int[size];
        System.out.println("Заполните исходные цены:");
        for (int i = 0; i < size; i++) {
            price[i] = input.nextInt();  // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.println("Введите % скидки, от 1 до 99: ");
        int discount = input.nextInt();
        System.out.println("Введите номер позиции, с которой нужно применить скидку: ");
        int offset = input.nextInt();
        System.out.println("Введите количество позиций, к которым нужно применить скидку: ");
        int readLength = input.nextInt();
        int[]price1 = new int[readLength];
        decryptData(price1, price, discount, offset, readLength);
        for (int i = 0; i < readLength; i++){
            System.out.print(price1[i] + " ");
        }
        System.out.println();
        
    }
    public static
    int[] decryptData(int[] price1, int[] price,
     int discount,
     int offset,
     int readLength) {
        double ddiscount = (double) discount;
        double b;
        int count = 0;
        for (;offset <= readLength; offset++){
            b = (double)price[offset];
            price1[count] = price[offset] - (int) (b * (ddiscount / 100));
            count++;
        }
        return price1;
    }
}