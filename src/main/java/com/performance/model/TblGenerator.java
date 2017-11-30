package com.performance.model;

public class TblGenerator {
    private Integer gid;

    private Integer moduleid;

    private String modulename;

    private Integer startorg;

    private Integer endorg;

    private Integer filenum;

    private Integer filesize;

    private String filebasepath;

    private String updatetime;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public Integer getStartorg() {
        return startorg;
    }

    public void setStartorg(Integer startorg) {
        this.startorg = startorg;
    }

    public Integer getEndorg() {
        return endorg;
    }

    public void setEndorg(Integer endorg) {
        this.endorg = endorg;
    }

    public Integer getFilenum() {
        return filenum;
    }

    public void setFilenum(Integer filenum) {
        this.filenum = filenum;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getFilebasepath() {
        return filebasepath;
    }

    public void setFilebasepath(String filebasepath) {
        this.filebasepath = filebasepath == null ? null : filebasepath.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}