package com.ecommerce.om.models;

public enum Origin {
    TURKEY("Türkiye", "Turkey", "+90",90),
    UNITED_KINGDOM("Birleşik Krallık", "United Kingdom", "+44",44),
    CHINA("Çin", "China","+86",86);

    private String readingTurkish;
    private String readingEnglish;
    private String phoneCode;
    private Integer sort;

    Origin(String readingTurkish, String readingEnglish, String phoneCode, Integer sort) {
        this.readingTurkish = readingTurkish;
        this.readingEnglish = readingEnglish;
        this.phoneCode = phoneCode;
        this.sort = sort;
    }

    public Integer getSort() {
        return sort;
    }

}