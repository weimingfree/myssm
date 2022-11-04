package cn.xj.pojo;

public class TeacherPw {
    private String tid;

    private String tpw;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getTpw() {
        return tpw;
    }

    public void setTpw(String tpw) {
        this.tpw = tpw == null ? null : tpw.trim();
    }
}