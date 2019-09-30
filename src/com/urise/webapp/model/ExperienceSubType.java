package com.urise.webapp.model;

import java.time.YearMonth;

public class ExperienceSubType {
    private String organization;
    private YearMonth dateFrom;
    private YearMonth dateTo;
    private String position;
    private String duties;

    public ExperienceSubType(String organization, YearMonth dateFrom, YearMonth dateTo, String position, String duties) {
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
}
