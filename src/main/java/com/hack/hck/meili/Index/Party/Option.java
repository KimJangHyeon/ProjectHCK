package com.hack.hck.meili.Index.Party;

import java.io.Serializable;

public class Option implements Serializable {
    private String view;
    private String search;
    private long current_member;
    private long limit_member;

    public Option() {
    }

    public Option(String view, String search, long current_member, long limit_member) {
        this.view = view;
        this.search = search;
        this.current_member = current_member;
        this.limit_member = limit_member;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public long getCurrent_member() {
        return current_member;
    }

    public void setCurrent_member(long current_member) {
        this.current_member = current_member;
    }

    public long getLimit_member() {
        return limit_member;
    }

    public void setLimit_member(long limit_member) {
        this.limit_member = limit_member;
    }
}
