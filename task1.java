import java.util.Scanner;
import java.util.math;


public class task1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Введте размер исходных цен: ");
        int size = input.nextInt();
        int[] price = new int[size];
        System.out.print("Заполните исходные цены: ");
        for (int i = 0; i < size; ++i) {
            price[i] = input.nextInt();  // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print("Введите % скидки, от 1 до 99: ");
        int discount = input.nextInt();
        if(discount > 99){
            System.out.println("Некоректно введены данные");
            System.exit(discount);
        } else if(discount < 0){
            System.out.println("Некоректно введены данные");
            System.exit(discount);
        }
        System.out.print("Введите номер позиции, с которой нужно применить скидку: ");
        int offset = input.nextInt();
        if (offset > size){
            System.out.println("Некоректно введены данные");
            System.exit(offset);
        } else if(offset < 0){
            System.out.println("Некоректно введены данные");
            System.exit(offset);
        }
        System.out.print("Введите количество позиций, к которым нужно применить скидку: ");
        int readLength = input.nextInt();
        if (readLength > size){
            System.out.println("Некоректно введены данные");
            System.exit(readLength);
        } else if (readLength < 1){
            System.out.println("Некоректно введены данные");
            System.exit(readLength);
        }
        int[]price1 = new int[readLength];
        decryptData(price1, price, discount, offset, readLength);
        for (int i = 0; i < readLength; i++){
            if(price1[i] == 0){
                System.out.println("Некоректно введены данные");
                System.exit(i);
            }
            System.out.print(price1[i] + " ");
        }
        System.out.println();
        
    }
    public static
    int[] decryptData(int[] price1, int[] price, int discount,
     int offset,
     int readLength) {
        double ddiscount = (double) discount;
        double b;
        int count = 0;
        for (; offset < readLength; offset++){
            b = (double)price[offset];
            price1[count] = (int)Math.floor(b - (b * (ddiscount / 100)));
            count++;
            
        }
        return price1;
    }
}