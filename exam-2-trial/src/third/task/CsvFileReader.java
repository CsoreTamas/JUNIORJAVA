package third.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record CsvFileReader(String filePath) {

    public Set<Person> reader() throws IOException {
        return fileReader();
    }

    private Set<Person> fileReader() throws IOException {
        List<String> text = Files.readAllLines(Path.of(this.filePath));
        Set<Person> personList = new HashSet<>();
        for (String line : text) {
            String[] lines = line.split(",");
            if (lines.length == 2) {
                Person person = Person.builder()
                        .name(lines[0])
                        .age(Integer.parseInt(lines[1]))
                        .build();
                personList.add(person);
            }
        }
        return personList;
    }
}
