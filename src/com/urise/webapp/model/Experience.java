package com.urise.webapp.model;

import java.time.YearMonth;

public class Experience {
    private String organization;
    private YearMonth dateFrom;
    private YearMonth dateTo;
    private String position;
    private String duties;

    public Experience(String organization, YearMonth dateFrom, YearMonth dateTo, String position, String duties) {
        this.organization = organization;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.position = position;
        this.duties = duties;
    }

    @Override
    public String toString() {
        return '\n' + organization + '\n' +
                dateFrom + "          " +
                position + '\n' +
                dateTo + "          " +
                (duties == null ? "" : (duties)) + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (!organization.equals(that.organization)) return false;
        if (!dateFrom.equals(that.dateFrom)) return false;
        if (!dateTo.equals(that.dateTo)) return false;
        if (!position.equals(that.position)) return false;
        return duties.equals(that.duties);
    }

    @Override
    public int hashCode() {
        int result = organization.hashCode();
        result = 31 * result + dateFrom.hashCode();
        result = 31 * result + dateTo.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + duties.hashCode();
        return result;
    }
}
