package com.hack.hck.meili.Index.Party;

import com.hack.hck.meili.Index.Genre;
import com.hack.hck.meili.Index.PartyStatus;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class Party implements Serializable {
    private String id;
    private PartyStatus status;
    private Genre genre;
    private String title;
    private String cotent;
    private long limit_member;
    private long current_member;
    private List<Option> options;
    private long create_dt;
    private long deadline_dt;
    private long party_dt;

    public Party() {
    }

    public Party(String id, PartyStatus status, String title, String cotent, long limit_member, long current_member, List<Option> options, long create_dt, long deadline_dt, long party_dt) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.cotent = cotent;
        this.limit_member = limit_member;
        this.current_member = current_member;
        this.options = options;
        this.create_dt = create_dt;
        this.deadline_dt = deadline_dt;
        this.party_dt = party_dt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public PartyStatus getStatus() {
        return status;
    }

    public void setStatus(PartyStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCotent() {
        return cotent;
    }

    public void setCotent(String cotent) {
        this.cotent = cotent;
    }

    public long getLimit_member() {
        return limit_member;
    }

    public void setLimit_member(long limit_member) {
        this.limit_member = limit_member;
    }

    public long getCurrent_member() {
        return current_member;
    }

    public void setCurrent_member(long current_member) {
        this.current_member = current_member;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public long getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(long create_dt) {
        this.create_dt = create_dt;
    }

    public long getDeadline_dt() {
        return deadline_dt;
    }

    public void setDeadline_dt(long deadline_dt) {
        this.deadline_dt = deadline_dt;
    }

    public long getParty_dt() {
        return party_dt;
    }

    public void setParty_dt(long party_dt) {
        this.party_dt = party_dt;
    }
}
