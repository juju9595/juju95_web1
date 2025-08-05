package 종합.과제11.model.dto;

public class WaitingDto {
    private int wno;
    private String wphone;
    private String wcount;

    public WaitingDto() {
    }

    public WaitingDto(int wno, String wphone, String wcount) {
        this.wno = wno;
        this.wphone = wphone;
        this.wcount = wcount;
    }

    public int getWno() {
        return wno;
    }

    public void setWno(int wno) {
        this.wno = wno;
    }

    public String getWphone() {
        return wphone;
    }

    public void setWphone(String wphone) {
        this.wphone = wphone;
    }

    public String getWcount() {
        return wcount;
    }

    public void setWcount(String wcount) {
        this.wcount = wcount;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "wno=" + wno +
                ", wphone='" + wphone + '\'' +
                ", wcount='" + wcount + '\'' +
                '}';
    }
}
