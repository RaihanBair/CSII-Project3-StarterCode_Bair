import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface CsvSerializable<T extends CsvSerializable<T>> {
    String DELIM = ",";
    String NEWLINE = System.lineSeparator();

    String toLine();

    T fromLine(String line);

    default void writeAll(Collection<T> items, Path path) throws IOException {
        List<String> lines = items.stream()
                .map(CsvSerializable::toLine)
                .toList();
    }

    default List<T> readAll(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<T> result = new ArrayList<>(lines.size());
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                result.add(fromLine(line));
            }
        }
        return result;
    }

    // string overload
    default void writeAll(Collection<T> items, String pathStr) throws IOException {
        writeAll(items, Paths.get(pathStr));
    }

    default List<T> readAll(String pathStr) throws IOException {
        return readAll(Paths.get(pathStr));
    }
}
