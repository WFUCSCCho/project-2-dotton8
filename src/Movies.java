/***
 * @file: Movies.java
 * @description: This code creates a Movies class with get and set methods for each variable
 * @author: Douglas Otton
 * @date: September 26, 2024
 ***/

/*
Edits to the Movies csv:
    Removed description, date released (kept year released), and genres columns from original CSV
 */

public class Movies implements Comparable<Movies> {
    private String title;
    private Integer year;
    private String distributor;
    private Long budget;
    private Long domOpen;
    private Long domSales;
    private Long intSales;
    private Long wwSales;
    private String runtime;
    private String license;

    // Default constructor
    public Movies() {
        title = "";
        year = 0;
        distributor = "";
        budget = 0L;
        domOpen = 0L;
        domSales = 0L;
        intSales = 0L;
        wwSales = 0L;
        runtime = "";
        license = "";
    }

    // Constructor
    public Movies(String title, Integer year, String distributor, Long budget, Long domOpen, Long domSales,
                  Long intSales, Long wwSales, String runtime, String license) {
        this.title = title;
        this.year = year;
        this.distributor = distributor;
        this.budget = budget;
        this.domOpen = domOpen;
        this.domSales = domSales;
        this.intSales = intSales;
        this.wwSales = wwSales;
        this.runtime = runtime;
        this.license = license;
    }

    // toString method
    public String toString() {
        return "Title: " + title + ", Year: " + year + ", Distributor: " + distributor + ", Budget: " + budget +
                ", Domestic Opening: " + domOpen + ", Domestic Sales: " + domSales + ", International Sales: " +
                intSales + ", Worldwide Sales: " + wwSales + ", Runtime: " + runtime + ", License: " + license + "\n";
    }

    // compareTo method
    @Override
    public int compareTo(Movies obj) {
        return obj.wwSales.compareTo(this.wwSales);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // get/set title methods
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // get/set year methods
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    // get/set distributor methods
    public String getDistributor() {
        return distributor;
    }
    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    // get/set budget methods
    public Long getBudget() {
        return budget;
    }
    public void setBudget(Long budget) {
        this.budget = budget;
    }

    // get/set domOpen methods
    public Long getDomOpen() {
        return domOpen;
    }
    public void setDomOpen(Long domOpen) {
        this.domOpen = domOpen;
    }

    // get/set getDomSales methods
    public Long getDomSales() {
        return domSales;
    }
    public void setDomSales(Long domSales) {
        this.domSales = domSales;
    }

    // get/set getIntSales methods
    public Long getIntSales() {
        return intSales;
    }
    public void setIntSales(Long intSales) {
        this.intSales = intSales;
    }

    // get/set wwSales methods
    public Long getWwSales() {
        return wwSales;
    }
    public void setWwSales(Long wwSales) {
        this.wwSales = wwSales;
    }

    // get/set runtime methods
    public String getRuntime() {
        return runtime;
    }
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    // get/set license methods
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
}
