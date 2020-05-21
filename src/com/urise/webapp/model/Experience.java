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
    private static final long serialVersionUID = 1L;
    private Link homePage;
    private List<Position> positions = new ArrayList<>();

    public static final Experience EMPTY = new Experience("", "", Position.EMPTY);

    public Experience(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Experience(Link homePage, List<Position> positions) {
        this.homePage = homePage;
        this.positions = positions;
    }

    public Experience() {
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (!homePage.equals(that.homePage)) return false;
        return positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + positions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "organization=" + homePage +
                ", positions=" + positions +
                '}';
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable{
        private static final long serialVersionUID = 1L;
        public static final Position EMPTY = new Position();

        @XmlJavaTypeAdapter(YearMonthAdapter.class)
        private  YearMonth dateFrom;
        @XmlJavaTypeAdapter(YearMonthAdapter.class)
        private YearMonth dateTo;
        private String title;
        private String description;

        public Position(int startYear, int startMonth, String title, String description) {
            this(YearMonth.of(startYear, startMonth), YearMonth.now(), title, description);
        }

        public Position(int startYear, int startMonth, int endYear, int endMonth, String title, String description) {
            this(YearMonth.of(startYear, startMonth), YearMonth.of(endYear, endMonth), title, description);
        }

        public Position(YearMonth dateFrom, YearMonth dateTo, String title, String description) {
            this.dateFrom = dateFrom;
            this.dateTo = dateTo;
            this.title = title;
            this.description = description == null ? "" : description;
        }

        public Position() {
        }

        public YearMonth getDateFrom() {
            return dateFrom;
        }

        public YearMonth getDateTo() {
            return dateTo;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position1 = (Position) o;

            if (!dateFrom.equals(position1.dateFrom)) return false;
            if (!dateTo.equals(position1.dateTo)) return false;
            if (!title.equals(position1.title)) return false;
            return description != null ? description.equals(position1.description) : position1.description == null;
        }

        @Override
        public int hashCode() {
            int result = dateFrom.hashCode();
            result = 31 * result + dateTo.hashCode();
            result = 31 * result + title.hashCode();
            result = 31 * result + (description != null ? description.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "dateFrom=" + dateFrom +
                    ", dateTo=" + dateTo +
                    ", position='" + title + '\'' +
                    ", duties='" + description + '\'' +
                    '}';
        }
    }
}