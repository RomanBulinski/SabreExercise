import java.util.*;
import java.util.stream.Collectors;

public class App {

    public String indexing(String input) {

        if (input == null) {
            return "Wrong input!!!";
        }
        if (input.length() == 0) {
            return "Empty input!!!";
        }

        String cleanedInput = input.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        String[] words = cleanedInput.split(" ");
        TreeMap<String, List<String>> indexes = new TreeMap<>();
        Set<String> lettersSet = new HashSet<>(Arrays.asList(cleanedInput.replaceAll(" ", "").split("")));
        lettersSet.forEach(n -> indexes.put(n, new ArrayList<String>()));

        for (String word : words) {
            String[] letters = word.split("");
            for (String s : letters) {
                List<String> tempWords = indexes.get(s);
                if (!tempWords.contains(word)) {
                    tempWords.add(word);
                }
                Collections.sort(tempWords);
                indexes.put(s, tempWords);
            }
        }

        String result = indexes.keySet().stream()
                .map(m -> m + ": " + indexes.get(m).toString()
                        .replaceAll("\\[", "")
                        .replaceAll("]", "") + "\n")
                .collect(Collectors.joining());

        return result.substring(0, result.length() - 1);
    }


}
