package livehouses.utils.pretty;

import java.util.Map;

public class Printer {
    private static int DEFAULT_PADDING = 5;

    public static final Map<String, String[]> letters = Map.ofEntries(
        Map.entry("a", new String[] {"▄▀█"   , "█▀█"  }),
        Map.entry("b", new String[] {"█▄▄"   , "█▄█"  }),
        Map.entry("c", new String[] {"█▀▀"   , "█▄▄"  }),
        Map.entry("d", new String[] {"█▀▄"   , "█▄▀"  }),
        Map.entry("e", new String[] {"█▀▀"   , "██▄"  }),
        Map.entry("f", new String[] {"█▀▀"   , "█▀░"  }),
        Map.entry("g", new String[] {"█▀▀"   , "█▄█"  }),
        Map.entry("h", new String[] {"█░█"   , "█▀█"  }),
        Map.entry("i", new String[] {"█"     , "█"    }),
        Map.entry("j", new String[] {"░░█"   , "█▄█"  }),
        Map.entry("k", new String[] {"█▄▀"   , "█░█"  }),
        Map.entry("l", new String[] {"█░░"   , "█▄▄"  }),
        Map.entry("m", new String[] {"█▀▄▀█" , "█░▀░█"}),
        Map.entry("n", new String[] {"█▄░█"  , "█░▀█" }),
        Map.entry("o", new String[] {"█▀█"   , "█▄█"  }),
        Map.entry("p", new String[] {"█▀█"   , "█▀▀"  }),
        Map.entry("q", new String[] {"█▀█"   , "▀▀█"  }),
        Map.entry("r", new String[] {"█▀█"   , "█▀▄"  }),
        Map.entry("s", new String[] {"█▀"    , "▄█"   }),
        Map.entry("t", new String[] {"▀█▀"   , "░█░"  }),
        Map.entry("u", new String[] {"█░█"   , "█▄█"  }),
        Map.entry("v", new String[] {"█░█"   , "▀▄▀"  }),
        Map.entry("w", new String[] {"█░█░█" , "▀▄▀▄▀"}),
        Map.entry("x", new String[] { "▀▄▀"  , "█░█"  }),
        Map.entry("y", new String[] {"█▄█"   , "░█░"  }),
        Map.entry("z", new String[] {"▀█"    , "█▄"   }),
        Map.entry(":", new String[] {"▀"     , "▄"    }),
        Map.entry("-", new String[] {"▄▄"    , "░░"   }),
        Map.entry(",", new String[] {"░"     , "█"    }),
        Map.entry(".", new String[] {"░"     , "▄"    }),
        Map.entry("?", new String[] {"▀█"    , "░▄"   }),
        Map.entry("!", new String[] {"█"     , "▄"    }),
        Map.entry("¿", new String[] {"▀░"    , "█▄"   }),
        Map.entry("¡", new String[] {"▀"     , "█"    }),
        Map.entry("1", new String[] {"▄█"    , "░█"   }),
        Map.entry("2", new String[] {"▀█"    , "█▄"   }),
        Map.entry("3", new String[] {"▀█▀"   , "▄▄█"  }),
        Map.entry("4", new String[] {"█░█"   , "▀▀█"  }),
        Map.entry("5", new String[] {"█▀"    , "▄█"   }),
        Map.entry("6", new String[] {"█▄▄"   , "█▄█"  }),
        Map.entry("7", new String[] {"▀▀█"   , "░░█"  }),
        Map.entry("8", new String[] {"█▀█"   , "███"  }),
        Map.entry("9", new String[] {"█▀█"   , "▀▀█"  }),
        Map.entry("0", new String[] {"█▀█"   , "█▄█"  }),
        Map.entry("/", new String[] {"░█"    , "█░"   }),
        Map.entry(" ", new String[] {" "    , " "   })
    );

    public static void printPadding(int padding) {
        for (int j = padding; j != 0; j--) {
            System.out.print(" ");
        }
    }

    public static void printSymbol(String symbol) {
        System.out.print(
            letters.get(symbol)[0] + "\n" +
            letters.get(symbol)[1]
        );
    }

    public static void printSymbol(String symbol, int row) {
        System.out.print(letters.get(symbol)[row]);
    }

    public static void prettyPrint(String str) {
        for (int i = 0; i < str.length(); i++) {
             printSymbol(String.valueOf(str.charAt(i)), 0);
        }
        System.out.print("\n");
        for (int i = 0; i < str.length(); i++) {
             printSymbol(String.valueOf(str.charAt(i)), 1);
        }
    }

    public static void prettyPrint(String str, int spacing) {
        for (int i = 0; i < str.length(); i++) {
             printSymbol(String.valueOf(str.charAt(i)), 0);
             for (int j = spacing; j != 0; j--) {
                 System.out.print(" ");
             }
        }
        System.out.print("\n");
        for (int i = 0; i < str.length(); i++) {
             printSymbol(String.valueOf(str.charAt(i)), 1);
             for (int j = spacing; j != 0; j--) {
                 System.out.print(" ");
             }
        }
    }

    public static void prettyPrint(String str, int spacing, int padding) {
        printPadding(padding);
        for (int i = 0; i < str.length(); i++) {
             printSymbol(String.valueOf(str.charAt(i)), 0);
             for (int j = spacing; j != 0; j--) {
                 System.out.print(" ");
             }
        }
        System.out.print("\n");
        printPadding(padding);
        for (int i = 0; i < str.length(); i++) {
             printSymbol(String.valueOf(str.charAt(i)), 1);
             for (int j = spacing; j != 0; j--) {
                 System.out.print(" ");
             }
        }
    }

    public static void newLine() {
        System.out.print("\n");
    }

    public static void print(Object toPrint) {
        printPadding(DEFAULT_PADDING);
        System.out.print(toPrint);
    }
}
