package utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class FileHelper {
    private static final String DIRECTORY = System.getProperty("user.dir");
    private static final String ANSWERS_TXT = "\\answers.txt";

    private FileHelper(){
    }

    public static List<String> readAnswers(){
        return read(DIRECTORY.concat(ANSWERS_TXT));
    }

    public static List<String> readAnswers(String path){
        Path file = Paths.get(path);
        if (file.isAbsolute()){
            return read(file.toString().concat(ANSWERS_TXT));
        } else {
            return read(DIRECTORY.concat(file.toString().concat(ANSWERS_TXT)));
        }
    }

    public static String getPath(String value){
        String path = null;
        Pattern pattern = Pattern.compile(": (.*)\"");
        Matcher matcher = pattern.matcher(value);
        try {
            if (matcher.find()) {
                path = matcher.group(1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return path;
    }

    private static List<String> read(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path), UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}