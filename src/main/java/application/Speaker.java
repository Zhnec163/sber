package application;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;

public class Speaker {
    private List<String> answers;
    private String hello;
    private String goodbye;
    private Random rand = new Random();
    private Logger logger = Logger.getLogger(Speaker.class);

    public Speaker(List<String> answers) {
        hello = answers.get(0);
        goodbye = answers.get(answers.size() - 1);
        answers.remove(0);
        answers.remove(answers.size() - 1);
        this.answers = answers;
    }

    public void sayHello(){
        logger.info(hello);
        System.out.println(hello);
    }

    public void sayGoodbye(){
        logger.info(goodbye);
        System.out.println(goodbye);
    }

    public void sayRandomAnswer(){
        String answer = answers.get(rand.nextInt(answers.size()));
        logger.info(answer);
        System.out.println(answer);
    }
}
