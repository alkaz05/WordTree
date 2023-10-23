import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        example1();
        example2();
        example3();

    }

    private static void example3() throws IOException {
        TreeMap< String, Character> nametToChar = new TreeMap<>();
        List<String> list = Files.readAllLines(Path.of("words.txt"));
        for (String elem : list)
        {
            Character c = elem.charAt(0);   //берем начальную букву имени
            nametToChar.put(elem, c);
        }

        System.out.println(nametToChar);
    }

    private static void example2() throws FileNotFoundException {
        String fname = "dictionary";
        TreeMap<String, String> namesMap = new TreeMap<>();
        Scanner scanner = new Scanner(new File(fname));
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            namesMap.put(s1, s2);
        }
        System.out.println(namesMap);

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("введите имя");
        String name = scanner1.next();
        System.out.println("этому имени в словаре соответствует "+namesMap.get(name));
    }

    private static void example1() throws IOException {
        String fname = "words.txt";
        /*ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fname));
        while (scanner.hasNext()) {
            String s = scanner.next();
            list.add(s);
        }*/
        List<String> list = Files.readAllLines(Path.of(fname)); //краткий способ вместо использования сканнера
        System.out.println("размер list "+ list.size());

        TreeSet<String> treeSet = new TreeSet<>(list);
        System.out.println(treeSet);
        System.out.println("размер treeset "+treeSet.size());

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String elem: list) {
            if(treeMap.containsKey(elem))
                treeMap.put(elem, 1+treeMap.get(elem));
            else
                treeMap.put(elem, 1);
        }
        System.out.println(treeMap);
    }
}