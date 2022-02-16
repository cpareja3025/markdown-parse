import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;



public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile() throws IOException{
        Path filename = Path.of("test-file.md");
        String contents = Files.readString(filename);
        assertEquals(List.of("https://something.com", "some-page.html"),MarkdownParse.getLinks(contents));
    }

    @Test
    public void break1() throws IOException{
        Path filename = Path.of("break1.md");
        String contents = Files.readString(filename);
        assertEquals(List.of("https://something.com", "some-page.html"),MarkdownParse.getLinks(contents));
    }

    @Test
    public void break2() throws IOException{
        Path filename = Path.of("break2.md");
        String contents = Files.readString(filename);
        assertEquals(List.of("https://something().com"),MarkdownParse.getLinks(contents));
    }
    @Test
    public void break3() throws IOException{
        Path filename = Path.of("break3.md");
        String contents = Files.readString(filename);
        assertEquals(List.of(),MarkdownParse.getLinks(contents));
    }

    
}