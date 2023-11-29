package net.zoofantastique.view;

public interface ConsoleTricks {
    default void clearConsole() {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch(
                final Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

}
