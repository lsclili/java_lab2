import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LabWork3 {
    public static void main(String[] args) {
        int studentNumber = 4;
        int C3 = studentNumber % 3;
        int C13 = studentNumber % 17;

        System.out.println("C3: " + C3);
        System.out.println("C13: " + C13);

        try {
            Object textVariable;
            switch (C3) {
                case 0:
                    textVariable = new StringBuilder();
                    break;
                case 1:
                    textVariable = new StringBuffer();
                    break;
                case 2:
                    textVariable = "";
                    break;
                default:
                    throw new UnsupportedOperationException("Невідомий тип для C3 = " + C3);
            }
            System.out.println("Тип текстових змінних: " + textVariable.getClass().getSimpleName());

            String text = "Це перше речення. А це друге речення! Чи це третє речення? Що буде з четвертим реченням?";
            System.out.println("Заданий текст:");
            System.out.println(text);

            String processedText = processText(text, C13);
            System.out.println("Оброблений текст:");
            System.out.println(processedText);

        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String processText(String text, int C13) throws UnsupportedOperationException {
        switch (C13) {
            case 4:
                String[] sentences = text.split("(?<=[.!?])\\s*");
                StringBuilder result = new StringBuilder();
                for (String sentence : sentences) {
                    String processedSentence = swapFirstLastWord(sentence);
                    result.append(processedSentence).append(" ");
                }
                return result.toString().trim();
            default:
                throw new UnsupportedOperationException("Невідома дія для C13 = " + C13);
        }
    }

    private static String swapFirstLastWord(String sentence) {
        String endingPunctuation = "";
        if (sentence.endsWith(".") || sentence.endsWith("!") || sentence.endsWith("?")) {
            endingPunctuation = sentence.substring(sentence.length() - 1);
            sentence = sentence.substring(0, sentence.length() - 1);
        }
        String[] words = sentence.trim().split("\\s+");
        if (words.length < 2) {
            return sentence + endingPunctuation;
        }
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        words[0] = lastWord;
        words[words.length - 1] = firstWord;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        sb.append(endingPunctuation);
        return sb.toString();
    }
}
