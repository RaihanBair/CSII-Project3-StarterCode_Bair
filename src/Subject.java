public enum Subject {
    MATH("Mathematics"),
    LANGUAGE("Language"),
    HISTORY("History"),
    ENGLISH("English"),
    PHYSICS("Physics"),
    CHEMISTRY("Chemistry"),
    LATIN("Latin"),
    PROGRAMMING("Programming");

    private final String name;

    Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Subject fromName(String displayName) {
        for (Subject s : Subject.values()) {
            if (s.getName().equalsIgnoreCase(displayName)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown subject: " + displayName);
    }

    public String toString() {
        return name;
    }
}
