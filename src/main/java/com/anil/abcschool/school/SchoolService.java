package com.anil.abcschool.school;

import java.util.List;

public interface SchoolService {
    List<School> getAllSchools();

    School findSchoolDetailsById(Integer schoolId);

    Boolean deleteSchoolById(Integer schoolId);

    School addNewSchool(School school);


    School updateSchoolDetails(School school);
}
