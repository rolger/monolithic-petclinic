package org.springframework.samples.petclinic.management;

import java.util.Objects;

public class YearlyRevenue {

    private Integer year;
    private Long total;

    private YearlyRevenue() {
    }

    public YearlyRevenue(Integer year, Long total) {
        this.year = year;
        this.total = total;
    }

    public Integer getYear() {
        return year;
    }

    public Long getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof YearlyRevenue)) return false;
        YearlyRevenue that = (YearlyRevenue) o;
        return Objects.equals(year, that.year) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, total);
    }

    @Override
    public String toString() {
        return "YearlyRevenue{" + "year=" + year + ", total=" + total + '}';
    }
}