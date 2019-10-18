package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Experience {
    private Link organization;
    private YearMonth dateFrom;
    private YearMonth dateTo;
    private String position;
    private String duties;

    public Experience(String nameOrganization, String urlOrganization, YearMonth dateFrom, YearMonth dateTo, String position, String duties) {
        Objects.requireNonNull(dateFrom, "dateFrom must not be null");
        Objects.requireNonNull(position, "position must not be null");
        if (nameOrganization != null) {
            this.organization = new Link(nameOrganization, urlOrganization);
        }
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.position = position;
        this.duties = duties;
    }

    @Override
    public String toString() {
        return  (organization == null ? "" : ('\n' + organization.toString()) + '\n') +
                dateFrom + "          " +
                position +
                (dateTo == null ? "" : ('\n' + "" + dateTo + "          "))  +
                (duties == null ? "" : (duties)) + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        if (!dateFrom.equals(that.dateFrom)) return false;
        if (!dateTo.equals(that.dateTo)) return false;
        if (!position.equals(that.position)) return false;
        return duties.equals(that.duties);
    }

    @Override
    public int hashCode() {
        int result = organization != null ? organization.hashCode() : 0;
        result = 31 * result + dateFrom.hashCode();
        result = 31 * result + dateTo.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + duties.hashCode();
        return result;
    }
}
