package com.ratpack.downloadhound.data.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "HISTORY")
public class History {
    @Id
    @Column(name = "ENTRY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long entry_id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEARCH_DATE")
    private Date searchDate;
    @Column(name = "TYPE")
    private String Type;

    public Long getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(Long entry_id) {
        this.entry_id = entry_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
