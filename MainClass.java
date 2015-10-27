package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Даша on 10.10.2015.
 */
public class MainClass

{
    public static void main(String[] args) {
        do {
            try {
                int z = instructionMenu();куку

                switch (t z) {
                    case 1: {
                        Set words = new Set();
                        words.openFile();
                        words.printWords();
                    }
                    break;

                    case 2:
                        return;

                    default:
                        System.out.println("Вы выбрали несуществующий пункт меню, повторите попытку.");

                }
            } catch (IOException ex) {

                System.out.println("\n Общая ошибка");
            } catch (Exception ex) {

                System.out.println("\n Файл оказался пустым.");
            }
        } while (true);
    }


    public static int instructionMenu() {
        System.out.println("1. Выбрать файл.\n" +
                "2. Выйти. \n");
        return getMenuPoint(1, 2);
    }

    /**
     * Ввод пунктов меню
     *0
     * Позволяет пользователю вводить цифры в определённом параметрами интервале
     *
     * @param minPoint
     * минимальное значение пункта меню (первый пункт)
     * @param maxPoint
     * максимальное значение пункта меню (последний пункт)
     *1
     * @return
     * выход из функции
     */
    public static int getMenuPoint(int minPoint, int maxPoint) {
        while (true) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String entered = bufferedReader.readLine();
                int point = Integer.parseInt(entered);
                if (point >= minPoint && point <= maxPoint) {
                    return point;
                }
                System.out.println("Введите число от " + minPoint + " до " + maxPoint + ".");
            } catch (IOException exception) {
                System.out.println("Ошибка чтения. Попытайтесь ещё раз.");
            } catch (NumberFormatException exception) {
                System.out.println("Введите число. Попытайтесь еще раз.");
            }
        }
    }

    /**
     * Функция для чтения потока ввода
     *
     * Создаёт и читает поток ввода. Если поток не открыт, срабатывает исключение.
     *
     * @return
     * выход из функции
     *
     * @throws IOException
     * исключение для открытия потока ввода
     */
    public static String readLine() {
        while (true) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                return bufferedReader.readLine();
            } catch (IOException exception) {
                System.out.println("Ошибка чтения. Попытайтесь ещё раз.");
            }
        }
    }
}
