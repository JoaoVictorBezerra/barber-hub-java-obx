package tech.projects.barberhub.helpers;

import java.text.Normalizer;

public final class StringHelpers {
    private StringHelpers() {
        throw new IllegalArgumentException("This is an utility class!");
    }

    public static String createSlug(String name) {
        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD);
        return normalized
                .replaceAll("\\p{InCOMBINING_DIACRITICAL_MARKS}","")
                .replaceAll("[^\\w\\s]", "")
                .replaceAll("\\s+", "-")
                .toLowerCase();
    }
}
