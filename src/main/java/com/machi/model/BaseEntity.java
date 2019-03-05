package com.machi.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@Access(AccessType.FIELD)
public class BaseEntity {

    private static final int UUID_LENGTH = 36;

    @Column(name = "uuid", length = UUID_LENGTH, unique = true, updatable = false, nullable = false)
    private String uuid;

    @Version
    private long version;

    public BaseEntity() {
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String newIuid) {
        this.uuid = newIuid;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(final long version) {
        this.version = version;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseEntity)) {
            return false;
        }
        final BaseEntity that = (BaseEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

}
