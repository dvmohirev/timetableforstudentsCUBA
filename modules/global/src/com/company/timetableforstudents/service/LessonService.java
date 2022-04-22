package com.company.timetableforstudents.service;

import com.company.timetableforstudents.entity.Lesson;

import java.time.LocalDateTime;

public interface LessonService {
    String NAME = "timetableforstudents_LessonService";

    Lesson rescheduleLesson(Lesson lesson, LocalDateTime newStartDate);

}