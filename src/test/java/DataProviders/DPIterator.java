package DataProviders;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by RXC8414 on 2/14/2017.
 */
public class DPIterator {

    private static List<Object[]> data = null;

    private static void getData() {
        File file = new File(".");
        try {
            data = new ArrayList<Object[]>();
            String line = null;
            FileReader file_reader = new FileReader(file.getAbsolutePath()+"\\src\\test\\resources\\Team.txt");
            BufferedReader bufferedReader = new BufferedReader(file_reader);

            while ((line = bufferedReader.readLine()) != null) {
                data.add(new Object[]{line});
            }

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            file + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + file + "'");
        }
    }

    public static Iterator<Object[]> getFileData(){
        getData();
        return data.iterator();
    }

}
