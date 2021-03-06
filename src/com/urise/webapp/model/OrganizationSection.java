package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationSection extends Section {
    private static final long serialVersionUID = 1L;

    private List<Experience> organizations = new ArrayList<>();

    public OrganizationSection(Experience... organizations) {
        this(Arrays.asList(organizations));
    }

    public OrganizationSection(List<Experience> organizations) {
        Objects.requireNonNull(organizations, "organizations must not be null");
        this.organizations = organizations;
    }

    public OrganizationSection() {
    }

    public List<Experience> getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Experience text : organizations) {
            builder.append(text);
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizations);
    }
}