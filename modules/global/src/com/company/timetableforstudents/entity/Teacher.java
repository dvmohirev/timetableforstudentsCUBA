package com.company.timetableforstudents.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "TIMETABLEFORSTUDENTS_TEACHER", indexes = {
        @Index(name = "IDX_TIMETABLEFORSTUDENTS_TEACHER_FIRST_NAME", columnList = "FIRST_NAME")
})
@Entity(name = "timetableforstudents_Teacher")
@NamePattern("%s|firstName")
public class Teacher extends StandardEntity {
    private static final long serialVersionUID = 1374481743598930769L;

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "EMAIL", nullable = false, unique = true)
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}