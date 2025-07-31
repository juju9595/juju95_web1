package example.day02.과제;

public class BoardDto {
    private int bno;
    private String btitle;

    public BoardDto(){}

    public BoardDto(int bno, String btitle) {
        this.bno = bno;
        this.btitle = btitle;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }
}
