package com.company.timetableforstudents.web.screens.teacher;

import com.haulmont.cuba.gui.screen.*;
import com.company.timetableforstudents.entity.Teacher;

@UiController("timetableforstudents_Teacher.browse")
@UiDescriptor("teacher-browse.xml")
@LookupComponent("teachersTable")
@LoadDataBeforeShow
public class TeacherBrowse extends StandardLookup<Teacher> {
}