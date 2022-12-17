import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.io.*;
import java.util.NoSuchElementException;

class FileIterator implements Iterator<String> , AutoCloseable{
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
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public String next() {
        try {
            var str = reader.readLine();
            if (str == null) {
                throw new NoSuchElementException();
            }
            return str;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}