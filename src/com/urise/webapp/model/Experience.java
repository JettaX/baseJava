package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Experience {
    private Link organization;
    private List<Position> positions = new ArrayList<>();

    public Experience(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Experience(Link organization, List<Position> positions) {
        this.organization = organization;
        this.positions = positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (!organization.equals(that.organization)) return false;
        return positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        int result = organization.hashCode();
        result = 31 * result + positions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "organization=" + organization +
                ", positions=" + positions +
                '}';
    }

    public static class Position {
        private  YearMonth dateFrom;
        private YearMonth dateTo;
        private String position;
        private String duties;

        public Position(int startYear, int startMonth, String position, String duties) {
            this(YearMonth.of(startYear, startMonth), YearMonth.now(), position, duties);
        }

        public Position(int startYear, int startMonth, int endYear, int endMonth, String position, String duties) {
            this(YearMonth.of(startYear, startMonth), YearMonth.of(endYear, endMonth), position, duties);
        }

        public Position(YearMonth dateFrom, YearMonth dateTo, String position, String duties) {
            this.dateFrom = dateFrom;
            this.dateTo = dateTo;
            this.position = position;
            this.duties = duties;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position1 = (Position) o;

            if (!dateFrom.equals(position1.dateFrom)) return false;
            if (!dateTo.equals(position1.dateTo)) return false;
            if (!position.equals(position1.position)) return false;
            return duties.equals(position1.duties);
        }

        @Override
        public int hashCode() {
            int result = dateFrom.hashCode();
            result = 31 * result + dateTo.hashCode();
            result = 31 * result + position.hashCode();
            result = 31 * result + duties.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "dateFrom=" + dateFrom +
                    ", dateTo=" + dateTo +
                    ", position='" + position + '\'' +
                    ", duties='" + duties + '\'' +
                    '}';
        }
    }
}
