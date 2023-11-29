import java.util.Scanner;

/*
Задание:

str = "<текст1>: <число1> р, <число2> шт"
Арбуз: 10 р, 3 шт
Проверки:
1) текст не соответствует шаблону //TODO: сделал
2) число1 это число с плавающей точкой
3) число2 это целочисленное число
4) длина <текст1> должна быть >0 //TODO: сделал
5) число1 < 0 //TODO: сделал
6) число2 < 0//TODO: сделал
*/


public class Main {

    public static void main(String[] args) {

        System.out.println("Введи информацию по продукту согласно шаблона - \"<текст1>: <число1> р, <число2> шт/кг\"");
        Scanner scanner = new Scanner(System.in);
        try {
            String str = scanner.nextLine(); //TODO: как зациклить код с ввода с клавиатуры и прервать его только при вводе слова Stop?
            String[] parts = str.split(" ");
            String product = parts[0];
            exceptionEmptyProduct(product); //TODO: проверка на исключение ввода пустого продукта
            String cost = parts[1];
            String rubles = parts[2];
            exceptionRublesChars(rubles); //TODO: проверка на исключение ввода некорректной размерности цены
            String quantity = parts[3];
            String measureOfQuantity = parts[4];
            exceptionMeasureOfQuantityChars(measureOfQuantity); //TODO: проверка на исключение ввода некорректной размерности количества товара

            //ToDo:мне кажется что я некорректно с точки чистоты кода определил переменные costDouble и quantityDouble (использовал их для NumberFormatException)
            int costDouble = Integer.parseInt(cost);
            double quantityDouble = Float.parseFloat(quantity);

            exceptionСostZero(costDouble); //TODO: для проверки NumberFormatException
            exceptionQuantityZero(quantityDouble); //TODO: для проверки NumberFormatException


            System.out.println("Введенная строка: " + str);
            System.out.println("Продукт: " + product);
            System.out.println("Цена: " + cost);
            System.out.println("Размерность цены: " + rubles);
            System.out.println("Количество: " + quantity);
            System.out.println("Размерность количества товара: " + measureOfQuantity);

        }
        //ToDo: вначале проверяем вообще ли соответвует шаблону введенная строка, затем в поле для цифр вводим ли цифры, а затем частные моменты по полям через собственные исключения

        catch (ArrayIndexOutOfBoundsException e) { //TODO: не понимаю как выбросить исключение, если мы стали вводить больше текста с разделением через пробел, а не меньше
            System.out.println("Вы вводили данные не согласно шаблона!");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("В поле для цены или для количества товара вы ввели не числовые значения!");
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void exceptionEmptyProduct(String input) throws MyException {
        if (input.isEmpty()) {
            throw new MyException("В поле наименовании продукта вы ничего не ввели!");
        }
    }

    public static void exceptionСostZero(int input) throws MyException {
        if (input < 0) {
            throw new MyException("Цена товара не может быть меньше нуля!");
        }
    }

    public static void exceptionRublesChars(String input) throws MyException {
        boolean contains2 = input.contains("р,");
        if (!contains2) {
            throw new MyException("В поле размерности цены вы не указали - \"р,\"!");
        }
    }

    public static void exceptionQuantityZero(double input) throws MyException {
        if (input < 0) {
            throw new MyException("Количество товара не может быть меньше нуля!");
        }
    }

    public static void exceptionMeasureOfQuantityChars(String input) throws MyException {
        boolean contains41 = input.contains("шт");
        boolean contains42 = input.contains("кг");
        if (contains41 == contains42) {
            throw new MyException("В поле размерности количества товара вы некорректно указали - \"шт\" или \"кг\"!");
        }
    }

}