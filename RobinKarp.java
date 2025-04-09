public class RobinKarp {

    public static void search(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        int patternHash = pattern.hashCode();

        for (int i = 0; i <= n - m; i++) {
            String window = text.substring(i, i + m);
            if (window.hashCode() == patternHash && window.equals(pattern)) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String text = "hellohelloworld";
        String pattern = "hello";

        search(pattern, text);
    }
}

