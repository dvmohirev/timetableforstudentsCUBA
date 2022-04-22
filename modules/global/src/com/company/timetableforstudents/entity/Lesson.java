package com.company.timetableforstudents.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Table(name = "TIMETABLEFORSTUDENTS_LESSON")
@Entity(name = "timetableforstudents_Lesson")
@NamePattern("%s|name")
public class Lesson extends StandardEntity {
    private static final long serialVersionUID = -6317534172042469411L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "DURATION", nullable = false)
    @Positive
    private Integer duration;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @NotNull
    @Column(name = "ROOM", nullable = false)
    @Positive
    private Integer room;

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MetaProperty(related = {"startDate", "duration"})
    public LocalDateTime getEndDate(){
        return (startDate != null && duration != null) ? startDate.plusHours(duration) : null;
    }
}