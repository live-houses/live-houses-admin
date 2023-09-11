package livehouses.pretty;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
    Map.entry("a", {"▄▀█"  , "█▀█"  }),
    Map.entry("b", {"█▄▄"  , "█▄█"  }),
    Map.entry("c", {"█▀▀"  , "█▄▄"  }),
    Map.entry("d", {"█▀▄"  , "█▄▀"  }),
    Map.entry("e", {"█▀▀"  , "██▄"  }),
    Map.entry("f", {"█▀▀"  , "█▀░"  }),
    Map.entry("g", {"█▀▀"  ,"█▄█"  }),
    Map.entry("h", {"█░█"  , "█▀█"  }),
    Map.entry("i", {"█"    , "█"    }),
    Map.entry("j", {"░░█"  , "█▄█"  }),
    Map.entry("k", {"█▄▀"  , "█░█"  }),
    Map.entry("l", {"█░░"  , "█▄▄"  }),
    Map.entry("m", {"█▀▄▀█", "█░▀░█"}),
    Map.entry("n", {"█▄░█" , "█░▀█" }),
    Map.entry("o", {"█▀█"  , "█▄█"  }),
    Map.entry("p", {"█▀█"  , "█▀▀"  }),
    Map.entry("q", {"█▀█"  , "▀▀█"  }),
    Map.entry("r", {"█▀█"  , "█▀▄"  }),
    Map.entry("s", {"█▀"   , "▄█"   }),
    Map.entry("t", {"▀█▀"  , "░█░"  }),
    Map.entry("u", {"█░█"  , "█▄█"  }),
    Map.entry("v", {"█░█"  , "▀▄▀"  }),
    Map.entry("w", {"█░█░█", "▀▄▀▄▀"}),
    Map.entry("x", { "▀▄▀" , "█░█" }),
    Map.entry("y", {"█▄█"  , "░█░"  }),
    Map.entry("z", {"▀█"   , "█▄"   }),
    Map.entry(":", {"▀"    , "▄"    }),
    Map.entry("-", {"▄▄"   , "░░"   }),
    Map.entry(",", {"░"    , "█"    }),
    Map.entry(".", {"░"    , "▄"    }),
    Map.entry("?", {"▀█"   , "░▄"   }),
    Map.entry("!", {"█"    , "▄"    }),
    Map.entry("¿", {"▀░"   , "█▄"   }),
    Map.entry("¡", {"▀"    , "█"    }),
    Map.entry("1", {"▄█"   , "░█"   }),
    Map.entry("2", {"▀█"   , "█▄"   }),
    Map.entry("3", {"▀█▀"   , "▄▄█"  }),
    Map.entry("4", {"█░█"  , "▀▀█"  }),
    Map.entry("5", {"█▀"   , "▄█"   }),
    Map.entry("6", {"█▄▄"  , "█▄█"  }),
    Map.entry("7", {"▀▀█"   , "░░█"   }),
    Map.entry("8", {"█▀█"   , "███"   }),
    Map.entry("9", {"█▀█"   , "▀▀█"   }),
    Map.entry("0", {"█▀█"  , "█▄█"  }),
    Map.entry("/", {"░█", "█░"})
*/

public class Printer {
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

    public static void PrintSymbol(String symbol) {
        System.out.print(
            letters.get(symbol)[0] + "\n" +
            letters.get(symbol)[1]
        );
    }

    public static void PrintSymbol(String symbol, int row) {
        System.out.print(letters.get(symbol)[row]);
    }

    public static void Print(String str) {
        for (int i = 0; i < str.length(); i++) {
             PrintSymbol(String.valueOf(str.charAt(i)), 0);
        }
        System.out.print("\n");
        for (int i = 0; i < str.length(); i++) {
             PrintSymbol(String.valueOf(str.charAt(i)), 1);
        }
    }

    public static void Print(String str, int spacing) {
        for (int i = 0; i < str.length(); i++) {
             PrintSymbol(String.valueOf(str.charAt(i)), 0);
             for (int j = spacing; j != 0; j--) {
                 System.out.print(" ");
             }
        }
        System.out.print("\n");
        for (int i = 0; i < str.length(); i++) {
             PrintSymbol(String.valueOf(str.charAt(i)), 1);
             for (int j = spacing; j != 0; j--) {
                 System.out.print(" ");
             }
        }
    }
}






