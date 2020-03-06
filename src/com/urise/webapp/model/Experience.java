package com.urise.webapp.model;

import com.urise.webapp.util.YearMonthAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Experience implements Serializable {
    private Link organization;
    private List<Position> positions = new ArrayList<>();

    public Experience(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Experience(Link organization, List<Position> positions) {
        this.organization = organization;
        this.positions = positions;
    }

    public Experience() {
    }

    public Link getOrganization() {
        return organization;
    }

    public List<Position> getPositions() {
        return positions;
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

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable{
        private static final long serialVersionUID = 1L;

        @XmlJavaTypeAdapter(YearMonthAdapter.class)
        private  YearMonth dateFrom;
        @XmlJavaTypeAdapter(YearMonthAdapter.class)
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
            this.duties = duties == null ? "" : duties;
        }

        public Position() {
        }

        public YearMonth getDateFrom() {
            return dateFrom;
        }

        public YearMonth getDateTo() {
            return dateTo;
        }

        public String getPosition() {
            return position;
        }

        public String getDuties() {
            return duties;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position1 = (Position) o;

            if (!dateFrom.equals(position1.dateFrom)) return false;
            if (!dateTo.equals(position1.dateTo)) return false;
            if (!position.equals(position1.position)) return false;
            return duties != null ? duties.equals(position1.duties) : position1.duties == null;
        }

        @Override
        public int hashCode() {
            int result = dateFrom.hashCode();
            result = 31 * result + dateTo.hashCode();
            result = 31 * result + position.hashCode();
            result = 31 * result + (duties != null ? duties.hashCode() : 0);
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