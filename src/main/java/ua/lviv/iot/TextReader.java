package ua.lviv.iot;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TextReader {
    public void prepositionRemover() throws IOException {
        StringBuffer rawBuffer = new StringBuffer();
        FileReader reader = new FileReader("EminemLyrics.txt");
        int i;
        while ((i = reader.read()) != -1) {
            rawBuffer.append((char) i);
        }
        String pattern = "\\b(?:a|the|or|are|on|in|out)\\b";
        Pattern prepositionPattern = Pattern.compile(pattern);
        Matcher m = prepositionPattern.matcher(rawBuffer);
        StringBuffer filteredBuffer = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(filteredBuffer, " ");
        }
        m.appendTail(filteredBuffer);
        FileWriter writer = new FileWriter("EminemLyricsFiltered.txt");
        writer.write(filteredBuffer.toString());
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        TextReader myReader = new TextReader();
        myReader.prepositionRemover();
    }
}
