public class MyScanner {
    public MyScanner() {
    }

    public int handleInput(String string) {

        String[] strings = string.trim().split(" +");
        if (strings[0].equals("14")) {
            return Integer.parseInt(strings[2]);
        } else {
            return 0;
        }
    }
}
