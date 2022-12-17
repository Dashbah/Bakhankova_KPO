import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.io.*;

class FileIterator implements Iterator<String> {
    private final BufferedReader reader;

    /**
     *
     * @param path path to the file to read
     * @throws NullPointerException if path == null
     * @throws FileNotFoundException if there is no such file
     */
    public FileIterator(String path) throws NullPointerException,
            FileNotFoundException {
        this.reader = getBufferedReader(path);
    }

    private BufferedReader getBufferedReader(String path) throws NullPointerException,
            FileNotFoundException {
        var file = new File(path);
        return new BufferedReader(new InputStreamReader(
                new FileInputStream(new File(path)), StandardCharsets.UTF_8));
    }

    @Override
    public boolean hasNext() {
        try {
            return reader.ready();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String next() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }
}
