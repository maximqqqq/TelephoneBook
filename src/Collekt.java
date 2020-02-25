import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collekt {
    public static HashMap<String, String> pb = new HashMap<>();

    public static void addPB(String phone, String name) {

        pb.put(phone, name);
    }

    //Save in BD
    public static void seveBd() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Temp.txt")));
        for (Map.Entry<String, String> k : pb.entrySet()) {
            writer.write(k.getKey() + " " + k.getValue() + System.lineSeparator());
        }
        writer.close();
    }

    //loadPB - загружает БД из текстового файла phone.txt
    //производит проверку на наличие файла
    public static void loadPB() throws IOException {
        File file = new File("Temp.txt");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(new File("Temp.txt")));
            String act;
            while ((act = reader.readLine()) != null) {
                String[] dat = act.split(" ");
                pb.put(dat[0], dat[1]);
            }
            reader.close();
        }
    }

    //FindNumberPhone - производит поиск списка номеров по фамилии заданой в качестве аргумента
    //возвращает массив строк
    public static String[] FindNumberPhone(String surname) {
        List<String> result = new ArrayList<>();
        for (Map.Entry entry : pb.entrySet()) {
            if (surname.equalsIgnoreCase((String) entry.getKey())) {//Если поставитьentry.getValue() то поиск будет по номеру
                result.add("[" + (String) entry.getKey() + "]" + " " + (String) entry.getValue());
            }
        }
        if (result.size() == 0) result.add("абонент с такой фамилией не найден");
        return result.toArray(new String[0]);
    }

}
