package com.company.timetableforstudents.web.screens.lesson;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.company.timetableforstudents.entity.Lesson;

@UiController("timetableforstudents_Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
@LoadDataBeforeShow
public class LessonEdit extends StandardEditor<Lesson> {
    @Subscribe
    public void onInitEntity(InitEntityEvent<Lesson> event) {
        event.getEntity().setDuration(1);
    }
}