-- begin TIMETABLEFORSTUDENTS_LESSON
create table TIMETABLEFORSTUDENTS_LESSON (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    START_DATE timestamp not null,
    DURATION integer not null,
    TEACHER_ID varchar(36) not null,
    ROOM integer not null,
    --
    primary key (ID)
)^
-- end TIMETABLEFORSTUDENTS_LESSON
-- begin TIMETABLEFORSTUDENTS_TEACHER
create table TIMETABLEFORSTUDENTS_TEACHER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255),
    EMAIL varchar(255) not null,
    --
    primary key (ID)
)^
-- end TIMETABLEFORSTUDENTS_TEACHER
