package cn.xj.pojo;

public class StudentPw {
    private String sid;

    private String spw;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSpw() {
        return spw;
    }

    public void setSpw(String spw) {
        this.spw = spw == null ? null : spw.trim();
    }
}