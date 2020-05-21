package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MarkedTextSection extends Section {
    private static final long serialVersionUID = 1L;
    public static final MarkedTextSection EMPTY = new MarkedTextSection("");

    private List<String> organizations = new ArrayList<>();

    public MarkedTextSection(String... organizations) {
        this(Arrays.asList(organizations));
    }

    public MarkedTextSection(List<String> organizations) {
        Objects.requireNonNull(organizations, "organizations must not be null");
        this.organizations = organizations;
    }

    public MarkedTextSection() {
    }

    public List<String> getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String text : organizations) {
            builder.append(text);
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkedTextSection that = (MarkedTextSection) o;
        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizations);
    }
}