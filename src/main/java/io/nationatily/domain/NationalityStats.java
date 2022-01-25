package io.nationatily.domain;

public class NationalityStats {

    private String nationality;

    private Long no;

    public NationalityStats(String nationality, Long no) {
        this.nationality = nationality;
        this.no = no;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }
}

