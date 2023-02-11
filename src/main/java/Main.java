import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger atomic = new AtomicInteger(100);

        public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
        }

        new Thread(() -> {
            for (int i = 0; i < texts.length; i++) {
                texts[i] = generateText("abc", 3 + random.nextInt(3));
            }
            System.out.println("Красивых слов с длиной 3: " + atomic.getAndAdd(3) + " шт");
        }).start();

        new Thread(() -> {
            for (int i = 0; i < texts.length; i++) {
                texts[i] = generateText("abba", 4 + random.nextInt(3));
            }
            System.out.println("Красивых слов с длиной 4: " + atomic.getAndAdd(4) + " шт");

        }).start();

        new Thread(() -> {
            for (int i = 0; i < texts.length; i++) {
                texts[i] = generateText("aabbb", 5 + random.nextInt(3));
            }
            System.out.println("Красивых слов с длиной 5: " + atomic.getAndAdd(5) + " шт");

        }).start();

        Thread.sleep(3000);
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}

