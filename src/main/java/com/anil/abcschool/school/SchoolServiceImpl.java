package com.anil.abcschool.school;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{

    private final SchoolRepository schoolRepository;
    private final Logger log = LoggerFactory.getLogger(SchoolServiceImpl.class);

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School findSchoolDetailsById(Integer schoolId) {
        return schoolRepository.findById(schoolId)
                .orElseThrow(
                        () -> new SchoolDetailsNotFoundException("School Details not exists for given id: " + schoolId)
                );
    }

    @Override
    public Boolean deleteSchoolById(Integer schoolId) {
        boolean isExists = schoolRepository.existsById(schoolId);
        if(isExists){
            schoolRepository.deleteById(schoolId);
            return true;
        }
        return false;
    }

    @Override
    public School addNewSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School updateSchoolDetails(School school) {
        log.info("Inside SchoolServiceImpl.updateSchoolDetails");
        School updatedDetails = schoolRepository.saveAndFlush(school);
        if(updatedDetails == null){
            log.error("unable to update the record");
        }
        log.info("school details updated successfully");
        return updatedDetails;
    }
}
