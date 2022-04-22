package com.company.timetableforstudents.web.screens.teacher;

import com.haulmont.cuba.gui.screen.*;
import com.company.timetableforstudents.entity.Teacher;

@UiController("timetableforstudents_Teacher.edit")
@UiDescriptor("teacher-edit.xml")
@EditedEntityContainer("teacherDc")
@LoadDataBeforeShow
public class TeacherEdit extends StandardEditor<Teacher> {
}