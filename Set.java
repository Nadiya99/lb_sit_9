package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.*;
/**
 * Created by Даша on 10.10.2015.
 */
public class Set
{

    private HashSet <String> hashSet;

    public Set(){
        hashSet = new HashSet<String>();
    }

    /**
     *Добавление слов в коллекцию
     *
     * Функция с помощью итератора получает указатель на первую позицию и сравнивает с полученной в параметрах строкой.
     * Далее с помощью итератора двигаемся в цикле по коллекции, сравнивая каждый последующий элемент с данной строкой.
     * Если элементы при сравнении одинаковые, то происходит выход из функции без добавления строки в коллекцию. Иначе - добавление.
     * Выход из цикла происходит, когда итератор указывает на конец коллекции.
     *
     * @param str
     * объект класса String, полученный с массива строк
     *
     * @return void
     * выход из функции
     */
    public void addWord(String str)
    {
        Iterator<String> it = hashSet.iterator();

        while (it.hasNext())
        {
            boolean compare = (it.next()).equalsIgnoreCase(str);
            if (compare == true) return;

        }
        hashSet.add(str);
    }

    /**
     * Вывод коллекции на экран
     *
     * С помощью итератора проходим по коллекции, разбивая её на отдельные компоненты-строки. Выводим слова
     * на экран форматированным выводом.
     *
     */
    public void printWords()
    {
        Iterator<String> it = hashSet.iterator();
        System.out.print("Слова: \n" );
        while (it.hasNext())
        {
            System.out.print(it.next() + ", ");
        }
        System.out.print("(" + hashSet.size() + " слов) \n");
    }


    /**
     * Считывание информации с файла
     *
     * Изначально пользователь вводит в консоль название требуемого для считывания файла. Если файла с таким название не
     * существует, то срабатывает исключение.
     * Найденный файл открывается, считывается в буфер построчно. Затем строка разбивается на слова с помощью регулярного выражения.
     * Слова записываются в строковый массив, после чего каждый элемент массива с помощью вызова соответствующей функции добавляется
     * коллекцию. Цикл продолжается, пока не достигнет конца файла.
     *
     * @throws IOException
     * исключение на невозможность открытия файла
     *
     * @throws Exception
     * исключение на достижение конца файла
     */
    public  void openFile() throws IOException, Exception {

        System.out.print("Введите название файла:   ");
        String path = MainClass.readLine();

        String str= new String();
        BufferedReader reader = null;
        try {
            FileReader readFile = new FileReader(path);
            reader = new BufferedReader(readFile);
            while ((str = reader.readLine()) != null) {
                String[] df = str.split("[^0-9a-zA-Zа-яА-Я]+");
                for (int i = 0; i < df.length; i++) {
                    addWord(df[i]);
                }

            }



        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            throw ex;
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            throw ex;
        } finally {
            try {
                if (str != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                System.out.println("Невозможно открыть файл.");
            }


        }

    }
}
