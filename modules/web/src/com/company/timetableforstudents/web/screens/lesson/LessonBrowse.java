package com.company.timetableforstudents.web.screens.lesson;

import com.company.timetableforstudents.service.LessonService;
import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.components.EditorScreenFacet;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.timetableforstudents.entity.Lesson;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("timetableforstudents_Lesson.browse")
@UiDescriptor("lesson-browse.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowse extends StandardLookup<Lesson> {
    @Inject
    private EditorScreenFacet<Lesson, LessonEdit> lessonEditDialog;
    @Inject
    private LessonService lessonService;
    @Inject
    private CollectionContainer<Lesson> lessonsDc;

    @Subscribe("lessonsCalendar")
    public void onLessonsCalendarCalendarEventClick(Calendar.CalendarEventClickEvent<LocalDateTime> event) {
        lessonEditDialog.setEntityProvider(() -> (Lesson) event.getEntity());
        lessonEditDialog.show();
    }

    @Subscribe("lessonsCalendar")
    public void onLessonsCalendarCalendarEventMove(Calendar.CalendarEventMoveEvent<LocalDateTime> event) {
        Lesson lesson = lessonService.rescheduleLesson((Lesson) event.getEntity(), event.getNewStart());
        lessonsDc.replaceItem(lesson);
    }
}