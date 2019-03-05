package com.machi.uc;

import com.machi.model.User;

import java.util.Objects;

public class UserDto {

    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String passwordTwo;

    public UserDto() {
    }

    public UserDto(final User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(final String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDto)) {
            return false;
        }
        final UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(email, userDto.email) && Objects.equals(firstname, userDto.firstname) && Objects.equals(lastname, userDto.lastname) && Objects.equals(password, userDto.password) && Objects.equals(passwordTwo, userDto.passwordTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstname, lastname, password, passwordTwo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", password2='").append(passwordTwo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
