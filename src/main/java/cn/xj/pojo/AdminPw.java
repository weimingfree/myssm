package cn.xj.pojo;

public class AdminPw {
    private String aname;

    private String apw;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getApw() {
        return apw;
    }

    public void setApw(String apw) {
        this.apw = apw == null ? null : apw.trim();
    }
}