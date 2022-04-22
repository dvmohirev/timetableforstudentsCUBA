package com.company.timetableforstudents.service;

import com.company.timetableforstudents.entity.Lesson;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service(LessonService.NAME)
public class LessonServiceBean implements LessonService {
    @Inject
    private DataManager dataManager;

    @Override
    public Lesson rescheduleLesson(Lesson lesson, LocalDateTime newStartDate) {
        LocalDateTime dayStart = newStartDate.truncatedTo(ChronoUnit.DAYS).withHour(8);
        LocalDateTime dayEnd = newStartDate.truncatedTo(ChronoUnit.DAYS).withHour(19);
        Long lessonsSameTime = dataManager.loadValue("select count(s) from timetableforstudents_Lesson s where " +
                "(s.startDate between :dayStart and :dayEnd) " +
                "and s.teacher = :teacher " +
                "and s.id <> :lessonId", Long.class)
                .parameter("dayStart", dayStart)
                .parameter("dayEnd", dayEnd)
                .parameter("teacher", lesson.getTeacher())
                .parameter("lessonId", lesson.getId())
                .one();
        if (lessonsSameTime >= 2){
            return lesson;
        }
            lesson.setStartDate(newStartDate);
            return dataManager.commit(lesson);
    }
}