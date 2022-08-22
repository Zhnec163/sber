package application;

import org.apache.log4j.Logger;
import utils.FileHelper;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Application.class);
        Speaker speaker = new Speaker(FileHelper.readAnswers());
        speaker.sayHello();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String line = in.nextLine();
                if (line.equals("\"Goodbye\"")) {
                    break;
                }
                else if (line.equals("\"Stop talking\"")) {
                    while (true){
                        line = in.nextLine();
                        if (line.equals("\"Start talking\"")){
                            break;
                        }
                    }
                } else if (line.contains("\"Use another file:")) {
                    String path = FileHelper.getPath(line);
                    speaker = new Speaker(FileHelper.readAnswers(path));
                } else if (!line.isEmpty()){
                    logger.info(line);
                    speaker.sayRandomAnswer();
                }
            }
        }
        speaker.sayGoodbye();
    }
}
