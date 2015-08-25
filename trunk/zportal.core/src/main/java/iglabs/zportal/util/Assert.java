package iglabs.zportal.util;

public final class Assert {
	
    private Assert() {}


    public static void isNotNull(Object obj) {
        Assert.isNotNull(obj, "Object reference cannot be null.");
    }

    public static void isNotNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNull(Object obj) {
        Assert.isNull(obj, "Object reference must be null.");
    }

    public static void isNull(Object obj, String message) {
        if (obj != null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean predicate) {
        Assert.isTrue(predicate, "Predicate must be true.");
    }

    public static void isTrue(boolean predicate, String message) {
        if (!predicate) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isFalse(boolean predicate) {
        Assert.isFalse(predicate, "Predicate must be false.");
    }

    public static void isFalse(boolean predicate, String message) {
        if (predicate) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(String s) {
        Assert.isNotEmpty(s, "String cannot be null or empty.");
    }

    public static void isNotEmpty(String s, String message) {
        if (!Strings.isNotEmpty(s)) {
            throw new IllegalArgumentException(message);
        }
    }
    
    public static void isEmpty(String s) {
        Assert.isEmpty(s, "String must be null or empty");
    }
    
    public static void isEmpty(String s, String message) {
        if (!Strings.isEmpty(s)) {
            throw new IllegalArgumentException(message);
        }
    }
}