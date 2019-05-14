package de.light668.ecomdashboard.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class KeyEntity {

    @Id
    @Column(name = "PK", unique = true)
    private long pk;

    public long getPk() {
        return pk;
    }


    public void setPk(long pk) {
        this.pk = pk;
    }
}
