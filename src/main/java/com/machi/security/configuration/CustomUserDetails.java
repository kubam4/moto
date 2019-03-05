package com.machi.security.configuration;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Objects;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

    private final Long id;

    public CustomUserDetails(final String username, final String password, final Collection<? extends GrantedAuthority> authorities, final Long id) {
        super(username, password, authorities);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomUserDetails)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CustomUserDetails that = (CustomUserDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomUserDetails{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }

}
