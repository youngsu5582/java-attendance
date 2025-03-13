import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {

    public static List<String> readLines(final String path, final int skipCount) throws IOException {
        final BufferedReader br = new BufferedReader(new FileReader(path));
        for (int i = 0; i < skipCount; i++) br.readLine();
        return readLines(br);
    }

    private static List<String> readLines(final BufferedReader br) throws IOException {
        final List<String> lines = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            lines.add(str);
        }
        return lines;
    }
}
