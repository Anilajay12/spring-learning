package com.anil.abcschool.school;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;
    private final Logger Log = LoggerFactory.getLogger(SchoolController.class);

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools(){
        Log.info("Inside SchoolController.getAllSchools");
        Log.info("Fetching school details");
        var schools = schoolService.getAllSchools();
        Log.info("Details Retrieved Successfully. current result {}", schools.size());
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> findSchoolById(@PathVariable("id") Integer schoolId){
        Log.info("Inside SchoolController.findSchoolById");
        Log.info("finding school details for given id: {}", schoolId);
        var school = schoolService.findSchoolDetailsById(schoolId);
        Log.info("Details Retrieved successfully.");
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchoolById(@PathVariable("id") Integer schoolId){
        Log.info("Inside SchoolController.deleteSchoolById");
        Log.info("Deleting school details for id: {}", schoolId);
        var result = schoolService.deleteSchoolById(schoolId);
        if(result) {
            Log.info("school details deleted successfully");
            return new ResponseEntity<>("school with given id: " + schoolId + " deleted successfully", HttpStatus.OK);
        }
        Log.error("Unable to perform the delete on school id: {}", schoolId);
        return new ResponseEntity<>("unable to delete the school details for id: " + schoolId, HttpStatus.CONFLICT);
    }

    @PostMapping
    public ResponseEntity<School> addNewSchool(@RequestBody School school){
        Log.info("Inside SchoolController.addNewSchool");
        Log.info("Trying to add new school record: {} -> {}", school, school.toString());
        var response = schoolService.addNewSchool(school);
        Log.info("details added successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<School> updateSchoolDetails(@RequestBody School school){
        Log.info("Inside SchoolController.updateSchoolDetails");
        Log.info("updating school details {} -> {}", school, school.toString());
        var response = schoolService.updateSchoolDetails(school);
        Log.info("details updated successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
