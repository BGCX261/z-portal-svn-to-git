package iglabs.zportal.util;

public final class Strings {

    private Strings() {
    }
    
    public static boolean isEmpty(String value) {
        return (value == null || value.length() == 0);
    }

    public static boolean isNotEmpty(String value) {
        return (value != null && value.length() != 0);
    }
    
    public static boolean equals(String x, String y) {
        if (x == null ? y == null : x.equals(y)) {
            return true;
        }
        
        return false;
    }
    
}
