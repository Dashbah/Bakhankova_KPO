import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {

        FileIterator fileIterator;
        try {
            fileIterator = new FileIterator("input.txt");
            while (fileIterator.hasNext()) {
                System.out.println(fileIterator.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file ;( ");
        }
        catch (Exception e) {
            System.out.println("Ex message: " + e.getMessage());
        }
    }
}