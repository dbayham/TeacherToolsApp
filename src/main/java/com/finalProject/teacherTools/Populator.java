package com.finalProject.teacherTools;

import com.finalProject.teacherTools.Models.Assignment;
import com.finalProject.teacherTools.Models.Classroom;
import com.finalProject.teacherTools.Models.Grade;
import com.finalProject.teacherTools.Models.Note;
import com.finalProject.teacherTools.Models.Student;
import com.finalProject.teacherTools.Repos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private AssignmentRepo assignmentRepo;

    @Resource
    private ClassroomRepo classroomRepo;

    @Resource
    private GradeRepo gradeRepo;

    @Resource
    private NoteRepo noteRepo;

    @Resource
    private StudentRepo studentRepo;

    @Override
    public void run(String... args) throws Exception {

        Classroom apHistoryOne = new Classroom("AP History One", 11, "402A", "8:30", 2021, "Fall");
        classroomRepo.save(apHistoryOne);
        Classroom civilWarHistory = new Classroom("Civil War History", 10, "Zoom Id: 12354-78", "10:00", 2021, "Fall");
        classroomRepo.save(civilWarHistory);
        Classroom apCalculus = new Classroom("AP Calculus", 12, "410", "11:30", 2021, "Winter");
        classroomRepo.save(apCalculus);
        Classroom earthScience = new Classroom("Earth Science", 9, "312", "1:30", 2021, "Summer");
        classroomRepo.save(earthScience);
        Classroom apIntroComputerScience = new Classroom("AP Intro to Computer Science", 9, "110", "2:30", 2021, "Summer");
        classroomRepo.save(apIntroComputerScience);

        Student jonesBobby = new Student("Bobby Jones",
                "..//images/student-bobby-jones.jpg",
                "Shari Jones", "sharijones123@gmail.com", "614-867-5309", 19, 5, 2006, apHistoryOne);
        studentRepo.save(jonesBobby);

        Student fongGary = new Student("Gary Fong",
                "..//images/student-gary-fong.jfif",
                "Ben Fong", "ben_fong@nomail.com", "614-555-1212", 1, 3, 2006, apHistoryOne, civilWarHistory);
        studentRepo.save(fongGary);

        Student williamsAbbey = new Student("Abbey Williams",
                "..//images/student-abbey-williams.jfif",
                "Trent Williams", "trentman123@nomail.com", "780-555-1212", 6, 10, 2006, apHistoryOne, civilWarHistory, apCalculus);
        studentRepo.save(williamsAbbey);

        Student stevensWendy = new Student("Wendy Stevens",
                "..//images/student-wendy-stevens.jfif",
                "Martha Stevens", "marthas123@nomail.com", "580-555-6985", 9, 12, 2005, apHistoryOne, civilWarHistory, apCalculus, earthScience);
        studentRepo.save(stevensWendy);

        Student jamesLester = new Student("Lester James", "..//images/student-lester-james.jfif",
                "Agatha James", "agathajames@nomail.com", "614-532-8965", 6, 7, 2006, apHistoryOne, civilWarHistory, apCalculus, earthScience, apIntroComputerScience);
        studentRepo.save(jamesLester);

        Student sanghaAdi = new Student("Adi Sangha",
                "..//images/adi-sangha.png",
                "Addhira Sangha", "misssangha@gmail.com", "740-455-2555", 12, 6, 2007, apCalculus);
        studentRepo.save(sanghaAdi);

        Student bahramAlliyah = new Student("Alliyah Bahram",
                "..//images/alliyah-bahram.png",
                "Hfaf Bahram", "hbahram5@gmail.com", "614-525-2115", 20, 8, 2006, apCalculus, apIntroComputerScience);
        studentRepo.save(bahramAlliyah);

        Student williamsMarcus = new Student("Marcus Williams",
                "..//images/marcus-williams.png",
                "Mark Williams", "mlwilliams1@gmail.com", "614-558-5654", 29, 2, 2005, apCalculus);
        studentRepo.save(williamsMarcus);

        Student pattersonBecky = new Student("Becky Patterson",
                "..//images/becky-patterson.png",
                "Janet Patterson", "janet_patterson@gmail.com", "614-325-2125", 1, 8, 2005, earthScience, apHistoryOne);
        studentRepo.save(pattersonBecky);

        Student petersonBrian = new Student("Brian Peterson",
                "..//images/brian-peterson.png",
                "Dustin Peterson", "peterson1529@gmail.com", "740-825-1222", 17, 1, 2006, earthScience);
        studentRepo.save(petersonBrian);

        Student wongMichael = new Student("Michael Wong",
                "..//images/michael-wong.png",
                "Sue Wong", "sw86_d@gmail.com", "614-852-9678", 05, 12, 2007, earthScience);
        studentRepo.save(wongMichael);

        Student mccoyDamien = new Student("Damien McCoy",
                "..//images/damien-mccoy.png",
                "Sara McCoy", "smccoy98@gmail.com", "740-533-8574", 1, 8, 2007, apIntroComputerScience);
        studentRepo.save(mccoyDamien);

        Student askerJennifer = new Student("Jennifer Asker",
                "..//images/jennifer-asker.png",
                "Thomas Asker", "tasker_12@gmail.com", "614-857-5563", 10, 4, 2006, apIntroComputerScience);
        studentRepo.save(askerJennifer);

        Student novikJoey = new Student("Joey Novik",
                "..//images/joey-novik.png",
                "Joseph Novik", "novikj_098@gmail.com", "614-565-4893", 16, 4, 2005, apIntroComputerScience);
        studentRepo.save(novikJoey);

        Student changSarah = new Student("Sarah Chang",
                "..//images/sarah_chang.png",
                "Tom Chang", "tc1979@gmail.com", "614-562-8379", 27, 3, 2006, apIntroComputerScience, earthScience);
        studentRepo.save(changSarah);

        apHistoryOne.addStudent(jonesBobby);
        apHistoryOne.addStudent(williamsAbbey);
        apHistoryOne.addStudent(jamesLester);
        apHistoryOne.addStudent(pattersonBecky);
        apHistoryOne.addStudent(stevensWendy);
        classroomRepo.save(apHistoryOne);

        civilWarHistory.addStudent(fongGary);
        civilWarHistory.addStudent(stevensWendy);
        civilWarHistory.addStudent(jamesLester);
        civilWarHistory.addStudent(williamsAbbey);
        classroomRepo.save(civilWarHistory);

        apCalculus.addStudent(sanghaAdi);
        apCalculus.addStudent(bahramAlliyah);
        apCalculus.addStudent(jamesLester);
        apCalculus.addStudent(stevensWendy);
        apCalculus.addStudent(williamsMarcus);
        apCalculus.addStudent(williamsAbbey);
        classroomRepo.save(apCalculus);

        earthScience.addStudent(pattersonBecky);
        earthScience.addStudent(petersonBrian);
        earthScience.addStudent(wongMichael);
        earthScience.addStudent(changSarah);
        earthScience.addStudent(stevensWendy);
        earthScience.addStudent(jamesLester);
        classroomRepo.save(earthScience);

        apIntroComputerScience.addStudent(mccoyDamien);
        apIntroComputerScience.addStudent(askerJennifer);
        apIntroComputerScience.addStudent(novikJoey);
        apIntroComputerScience.addStudent(changSarah);
        apIntroComputerScience.addStudent(sanghaAdi);
        apIntroComputerScience.addStudent(jamesLester);
        classroomRepo.save(apIntroComputerScience);


        Assignment apHistoryOneFirstAssignment = new Assignment(apHistoryOne, "Favorite Ancient Civilization", "Write a one page paper detailing your favorite ancient civilization, where it was located, " +
                "what tools they used, what languages they spoke, and any interesting achievements or conflicts they were involved in.", "08/28/2021", "09/02/2021", "100");
        assignmentRepo.save(apHistoryOneFirstAssignment);
        Assignment apHistoryOneSecondAssignment = new Assignment(apHistoryOne, "Least-Liked Ancient Civilization", "Write a five paragraph essay discussing why the ancient civilization that you chose is " +
        "your least favorite.", "09/05/2021", "09/10/2021", "100");
        assignmentRepo.save(apHistoryOneSecondAssignment);

        Assignment civilWarHistoryFirstAssignment = new Assignment(civilWarHistory, "Summarize the accomplishment of a famous Civil War general", "Choose any Civil War general and summarize the accomplishments of that general, " +
                "including major victories and areas he fought in.", "08/28/2021", "09/03/2021", "50");
        assignmentRepo.save(civilWarHistoryFirstAssignment);
        Assignment civilWarHistorySecondAssignment = new Assignment(civilWarHistory, "Name all the soldiers in the Civil War", "Name them all. Go!", "09/06/2021", "09/06/2021", "500");
        assignmentRepo.save(civilWarHistorySecondAssignment);
        Assignment civilWarHistoryThirdAssignment = new Assignment(civilWarHistory, "How many buttons were on a Union General's coat?", "In efficitur molestie porta. Nullam quis sollicitudin orci, a tempus neque. Ut.",
        "09/28/2021", "10/03/2021", "100");
        assignmentRepo.save(civilWarHistoryThirdAssignment);

 
        Assignment apCalculusFirstAssignment = new Assignment(apCalculus, "Calculus Quiz 1", "This quiz consists of 25 problems. Click on “Begin Quiz”, then read each problem carefully. " +
                "Then work the problem on a separate sheet of paper and click on the box next to the correct choice.", "08/30/2021", "08/31/2021", "100");
        assignmentRepo.save(apCalculusFirstAssignment);
        Assignment apCalculusSecondAssignment = new Assignment(apCalculus, "Calculus Quiz 2", "This quiz consists of 50 problems. Click on “Begin Quiz”, then read each problem carefully. " +
                "Then work the problem on a separate sheet of paper and click on the box next to the correct choice.", "09/01/2021", "09/02/2021", "100");
        assignmentRepo.save(apCalculusSecondAssignment);
        Assignment apCalculusThirdAssignment = new Assignment(apCalculus, "Calculus Quiz 3", "This quiz consists of 75 problems. Click on “Begin Quiz”, then read each problem carefully. " +
                "Then work the problem on a separate sheet of paper and click on the box next to the correct choice.", "09/03/2021", "09/04/2021", "100");
        assignmentRepo.save(apCalculusThirdAssignment);
        Assignment apCalculusFourthAssignment = new Assignment(apCalculus, "Calculus Quiz 4", "This quiz consists of 100 problems. Click on “Begin Quiz”, then read each problem carefully. " +
                "Then work the problem on a separate sheet of paper and click on the box next to the correct choice.", "09/05/2021", "09/06/2021", "100");
        assignmentRepo.save(apCalculusFourthAssignment);


        Assignment earthScienceFirstAssignment = new Assignment(earthScience, "Theory of Plate Tectonics", "You will complete a written analysis (about 5-6 pages) investigating the " +
        "development of the Theory of Plate Tectonics as it relates to the scientific disciplines of geology, oceanography, meteorology and astronomy.", "08/16/2021", "08/20/2021", "100");
        assignmentRepo.save(earthScienceFirstAssignment);
        Assignment earthScienceSecondAssignment = new Assignment(earthScience, "The Joy of Geology", "Talk about rocks until you are stoned.", "08/23/2021", "08/27/2021", "100");
        assignmentRepo.save(earthScienceSecondAssignment);
        Assignment earthScienceThirdAssignment = new Assignment(earthScience, "Dig Up Some Dirt", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In non odio sed ante.", "08/30/2021", "09/03/2021", "100");
        assignmentRepo.save(earthScienceThirdAssignment);
        Assignment earthScienceFourthAssignment = new Assignment(earthScience, "Climate Change: Fact or Fiction?", "Praesent velit neque, pellentesque eget consequat ac, fermentum sed.", "09/06/2021", "09/10/2021", "100");
        assignmentRepo.save(earthScienceFourthAssignment);
        Assignment earthScienceFifthAssignment = new Assignment(earthScience, "Sky High Pie", "Praesent eleifend tempor rhoncus. Quisque et purus sagittis, gravida neque rutrum, " +
        "luctus lorem. Integer hendrerit, nibh at egestas bibendum, orci orci rhoncus magna, ut.", "09/13/2021", "09/17/2021", "100");
        assignmentRepo.save(earthScienceFifthAssignment);


        Assignment apIntroComputerScienceFirstAssignment = new Assignment(apIntroComputerScience, "Hello World!", "Write \"Hello World!\" in Java", "08/28/2021", "08/28/2021", "10");
        assignmentRepo.save(apIntroComputerScienceFirstAssignment);


        apHistoryOneFirstAssignment.addStudent(jonesBobby);
        apHistoryOneFirstAssignment.addStudent(williamsAbbey);
        apHistoryOneFirstAssignment.addStudent(jamesLester);
        apHistoryOneFirstAssignment.addStudent(pattersonBecky);
        apHistoryOneFirstAssignment.addStudent(stevensWendy);
        assignmentRepo.save(apHistoryOneFirstAssignment);

        apHistoryOneSecondAssignment.addStudent(jonesBobby);
        apHistoryOneSecondAssignment.addStudent(williamsAbbey);
        apHistoryOneSecondAssignment.addStudent(jamesLester);
        apHistoryOneSecondAssignment.addStudent(pattersonBecky);
        apHistoryOneSecondAssignment.addStudent(stevensWendy);
        assignmentRepo.save(apHistoryOneSecondAssignment);

        civilWarHistoryFirstAssignment.addStudent(fongGary);
        civilWarHistoryFirstAssignment.addStudent(stevensWendy);
        civilWarHistoryFirstAssignment.addStudent(jamesLester);
        civilWarHistoryFirstAssignment.addStudent(williamsAbbey);
        assignmentRepo.save(civilWarHistoryFirstAssignment);

        civilWarHistorySecondAssignment.addStudent(fongGary);
        civilWarHistorySecondAssignment.addStudent(stevensWendy);
        civilWarHistorySecondAssignment.addStudent(jamesLester);
        civilWarHistorySecondAssignment.addStudent(williamsAbbey);
        assignmentRepo.save(civilWarHistorySecondAssignment);

        civilWarHistoryThirdAssignment.addStudent(fongGary);
        civilWarHistoryThirdAssignment.addStudent(stevensWendy);
        civilWarHistoryThirdAssignment.addStudent(jamesLester);
        civilWarHistoryThirdAssignment.addStudent(williamsAbbey);
        assignmentRepo.save(civilWarHistoryThirdAssignment);

        apCalculusFirstAssignment.addStudent(sanghaAdi);
        apCalculusFirstAssignment.addStudent(bahramAlliyah);
        apCalculusFirstAssignment.addStudent(williamsMarcus);
        apCalculusFirstAssignment.addStudent(jamesLester);
        apCalculusFirstAssignment.addStudent(stevensWendy);
        apCalculusFirstAssignment.addStudent(williamsAbbey);
        assignmentRepo.save(apCalculusFirstAssignment);

        apCalculusSecondAssignment.addStudent(sanghaAdi);
        apCalculusSecondAssignment.addStudent(bahramAlliyah);
        apCalculusSecondAssignment.addStudent(williamsMarcus);
        apCalculusSecondAssignment.addStudent(jamesLester);
        apCalculusSecondAssignment.addStudent(stevensWendy);
        apCalculusSecondAssignment.addStudent(williamsAbbey);
        assignmentRepo.save(apCalculusSecondAssignment);

        apCalculusThirdAssignment.addStudent(sanghaAdi);
        apCalculusThirdAssignment.addStudent(bahramAlliyah);
        apCalculusThirdAssignment.addStudent(williamsMarcus);
        apCalculusThirdAssignment.addStudent(jamesLester);
        apCalculusThirdAssignment.addStudent(stevensWendy);
        apCalculusThirdAssignment.addStudent(williamsAbbey);
        assignmentRepo.save(apCalculusThirdAssignment);

        apCalculusFourthAssignment.addStudent(sanghaAdi);
        apCalculusFourthAssignment.addStudent(bahramAlliyah);
        apCalculusFourthAssignment.addStudent(williamsMarcus);
        apCalculusFourthAssignment.addStudent(jamesLester);
        apCalculusFourthAssignment.addStudent(stevensWendy);
        apCalculusFourthAssignment.addStudent(williamsAbbey);
        assignmentRepo.save(apCalculusFourthAssignment);

        earthScienceFirstAssignment.addStudent(pattersonBecky);
        earthScienceFirstAssignment.addStudent(petersonBrian);
        earthScienceFirstAssignment.addStudent(wongMichael);
        earthScienceFirstAssignment.addStudent(changSarah);
        earthScienceFirstAssignment.addStudent(stevensWendy);
        earthScienceFirstAssignment.addStudent(jamesLester);
        assignmentRepo.save(earthScienceFirstAssignment);

        earthScienceSecondAssignment.addStudent(pattersonBecky);
        earthScienceSecondAssignment.addStudent(petersonBrian);
        earthScienceSecondAssignment.addStudent(wongMichael);
        earthScienceSecondAssignment.addStudent(changSarah);
        earthScienceSecondAssignment.addStudent(stevensWendy);
        earthScienceSecondAssignment.addStudent(jamesLester);
        assignmentRepo.save(earthScienceSecondAssignment);

        earthScienceThirdAssignment.addStudent(pattersonBecky);
        earthScienceThirdAssignment.addStudent(petersonBrian);
        earthScienceThirdAssignment.addStudent(wongMichael);
        earthScienceThirdAssignment.addStudent(changSarah);
        earthScienceThirdAssignment.addStudent(stevensWendy);
        earthScienceThirdAssignment.addStudent(jamesLester);
        assignmentRepo.save(earthScienceThirdAssignment);

        earthScienceFourthAssignment.addStudent(pattersonBecky);
        earthScienceFourthAssignment.addStudent(petersonBrian);
        earthScienceFourthAssignment.addStudent(wongMichael);
        earthScienceFourthAssignment.addStudent(changSarah);
        earthScienceFourthAssignment.addStudent(stevensWendy);
        earthScienceFourthAssignment.addStudent(jamesLester);
        assignmentRepo.save(earthScienceFourthAssignment);

        earthScienceFifthAssignment.addStudent(pattersonBecky);
        earthScienceFifthAssignment.addStudent(petersonBrian);
        earthScienceFifthAssignment.addStudent(wongMichael);
        earthScienceFifthAssignment.addStudent(changSarah);
        earthScienceFifthAssignment.addStudent(stevensWendy);
        earthScienceFifthAssignment.addStudent(jamesLester);
        assignmentRepo.save(earthScienceFifthAssignment);

        apIntroComputerScienceFirstAssignment.addStudent(bahramAlliyah);
        apIntroComputerScienceFirstAssignment.addStudent(mccoyDamien);
        apIntroComputerScienceFirstAssignment.addStudent(askerJennifer);
        apIntroComputerScienceFirstAssignment.addStudent(novikJoey);
        apIntroComputerScienceFirstAssignment.addStudent(changSarah);
        apIntroComputerScienceFirstAssignment.addStudent(sanghaAdi);
        apIntroComputerScienceFirstAssignment.addStudent(jamesLester);
        assignmentRepo.save(apIntroComputerScienceFirstAssignment);



        Grade bobbyJonesApHistoryGrade = new Grade(apHistoryOneFirstAssignment, 97, 100);
        gradeRepo.save(bobbyJonesApHistoryGrade);
        bobbyJonesApHistoryGrade.addStudentToGrade(jonesBobby);
        gradeRepo.save(bobbyJonesApHistoryGrade);
        
        Grade abbeyWilliamsApHistoryGrade = new Grade(apHistoryOneFirstAssignment, 95, 100);
        gradeRepo.save(abbeyWilliamsApHistoryGrade);
        abbeyWilliamsApHistoryGrade.addStudentToGrade(williamsAbbey);
        gradeRepo.save(abbeyWilliamsApHistoryGrade);
        
        Grade lesterJamesApHistoryGrade = new Grade(apHistoryOneFirstAssignment, 89, 100);
        gradeRepo.save(lesterJamesApHistoryGrade);
        lesterJamesApHistoryGrade.addStudentToGrade(jamesLester);
        gradeRepo.save(lesterJamesApHistoryGrade);
        
        Grade beckyPattersonApHistoryGrade = new Grade(apHistoryOneFirstAssignment, 91, 100);
        gradeRepo.save(beckyPattersonApHistoryGrade);
        beckyPattersonApHistoryGrade.addStudentToGrade(pattersonBecky);
        gradeRepo.save(beckyPattersonApHistoryGrade);


        Grade pattersonBeckyEarthScienceGrade1 = new Grade(earthScienceFirstAssignment, 97, 100);
        gradeRepo.save(pattersonBeckyEarthScienceGrade1);
        pattersonBeckyEarthScienceGrade1.addStudentToGrade(pattersonBecky);
        gradeRepo.save(pattersonBeckyEarthScienceGrade1);

        Grade pattersonBeckyEarthScienceGrade2 = new Grade(earthScienceSecondAssignment, 93, 100);
        gradeRepo.save(pattersonBeckyEarthScienceGrade2);
        pattersonBeckyEarthScienceGrade2.addStudentToGrade(pattersonBecky);
        gradeRepo.save(pattersonBeckyEarthScienceGrade2);

        Grade pattersonBeckyEarthScienceGrade3 = new Grade(earthScienceThirdAssignment, 67, 100);
        gradeRepo.save(pattersonBeckyEarthScienceGrade3);
        pattersonBeckyEarthScienceGrade3.addStudentToGrade(pattersonBecky);
        gradeRepo.save(pattersonBeckyEarthScienceGrade3);

        Grade pattersonBeckyEarthScienceGrade4 = new Grade(earthScienceFourthAssignment, 78, 100);
        gradeRepo.save(pattersonBeckyEarthScienceGrade4);
        pattersonBeckyEarthScienceGrade4.addStudentToGrade(pattersonBecky);
        gradeRepo.save(pattersonBeckyEarthScienceGrade4);

        Grade pattersonBeckyEarthScienceGrade5 = new Grade(earthScienceFifthAssignment, 56, 100);
        gradeRepo.save(pattersonBeckyEarthScienceGrade5);
        pattersonBeckyEarthScienceGrade5.addStudentToGrade(pattersonBecky);
        gradeRepo.save(pattersonBeckyEarthScienceGrade5);


        Grade petersonBrianEarthScienceGrade1 = new Grade(earthScienceFirstAssignment, 90, 100);
        gradeRepo.save(petersonBrianEarthScienceGrade1);
        petersonBrianEarthScienceGrade1.addStudentToGrade(petersonBrian);
        gradeRepo.save(petersonBrianEarthScienceGrade1);
        
        Grade petersonBrianEarthScienceGrade2 = new Grade(earthScienceSecondAssignment, 87, 100);
        gradeRepo.save(petersonBrianEarthScienceGrade2);
        petersonBrianEarthScienceGrade2.addStudentToGrade(petersonBrian);
        gradeRepo.save(petersonBrianEarthScienceGrade2);
        
        Grade petersonBrianEarthScienceGrade3 = new Grade(earthScienceThirdAssignment, 85, 100);
        gradeRepo.save(petersonBrianEarthScienceGrade3);
        petersonBrianEarthScienceGrade3.addStudentToGrade(petersonBrian);
        gradeRepo.save(petersonBrianEarthScienceGrade3);
        
        Grade petersonBrianEarthScienceGrade4 = new Grade(earthScienceFourthAssignment, 78, 100);
        gradeRepo.save(petersonBrianEarthScienceGrade4);
        petersonBrianEarthScienceGrade4.addStudentToGrade(petersonBrian);
        gradeRepo.save(petersonBrianEarthScienceGrade4);
        
        Grade petersonBrianEarthScienceGrade5 = new Grade(earthScienceFifthAssignment, 87, 100);
        gradeRepo.save(petersonBrianEarthScienceGrade5);
        petersonBrianEarthScienceGrade5.addStudentToGrade(petersonBrian);
        gradeRepo.save(petersonBrianEarthScienceGrade5);
        

        Grade wongMichaelEarthScienceGrade1 = new Grade(earthScienceFirstAssignment, 65, 100);
        gradeRepo.save(wongMichaelEarthScienceGrade1);
        wongMichaelEarthScienceGrade1.addStudentToGrade(wongMichael);
        gradeRepo.save(wongMichaelEarthScienceGrade1);

        Grade wongMichaelEarthScienceGrade2 = new Grade(earthScienceSecondAssignment, 95, 100);
        gradeRepo.save(wongMichaelEarthScienceGrade2);
        wongMichaelEarthScienceGrade2.addStudentToGrade(wongMichael);
        gradeRepo.save(wongMichaelEarthScienceGrade2);
        
        Grade wongMichaelEarthScienceGrade3 = new Grade(earthScienceThirdAssignment, 85, 100);
        gradeRepo.save(wongMichaelEarthScienceGrade3);
        wongMichaelEarthScienceGrade3.addStudentToGrade(wongMichael);
        gradeRepo.save(wongMichaelEarthScienceGrade3);
        
        Grade wongMichaelEarthScienceGrade4 = new Grade(earthScienceFourthAssignment, 58, 100);
        gradeRepo.save(wongMichaelEarthScienceGrade4);
        wongMichaelEarthScienceGrade4.addStudentToGrade(wongMichael);
        gradeRepo.save(wongMichaelEarthScienceGrade4);
        
        Grade wongMichaelEarthScienceGrade5 = new Grade(earthScienceFifthAssignment, 77, 100);
        gradeRepo.save(wongMichaelEarthScienceGrade5);
        wongMichaelEarthScienceGrade5.addStudentToGrade(wongMichael);
        gradeRepo.save(wongMichaelEarthScienceGrade5);
        

        Grade changSarahEarthScienceGrade1 = new Grade(earthScienceFirstAssignment, 88, 100);
        gradeRepo.save(changSarahEarthScienceGrade1);
        changSarahEarthScienceGrade1.addStudentToGrade(changSarah);
        gradeRepo.save(changSarahEarthScienceGrade1);
        
        Grade changSarahEarthScienceGrade2 = new Grade(earthScienceSecondAssignment, 99, 100);
        gradeRepo.save(changSarahEarthScienceGrade2);
        changSarahEarthScienceGrade2.addStudentToGrade(changSarah);
        gradeRepo.save(changSarahEarthScienceGrade2);
        
        Grade changSarahEarthScienceGrade3 = new Grade(earthScienceThirdAssignment, 100, 100);
        gradeRepo.save(changSarahEarthScienceGrade3);
        changSarahEarthScienceGrade3.addStudentToGrade(changSarah);
        gradeRepo.save(changSarahEarthScienceGrade3);
        
        Grade changSarahEarthScienceGrade4 = new Grade(earthScienceFourthAssignment, 0, 100);
        gradeRepo.save(changSarahEarthScienceGrade4);
        changSarahEarthScienceGrade4.addStudentToGrade(changSarah);
        gradeRepo.save(changSarahEarthScienceGrade4);
        
        Grade changSarahEarthScienceGrade5 = new Grade(earthScienceFifthAssignment, 67, 100);
        gradeRepo.save(changSarahEarthScienceGrade5);
        changSarahEarthScienceGrade5.addStudentToGrade(changSarah);
        gradeRepo.save(changSarahEarthScienceGrade5);
        



        Grade stevensWendyEarthScienceGrade1 = new Grade(earthScienceFirstAssignment, 87, 100);
        gradeRepo.save(stevensWendyEarthScienceGrade1);
        stevensWendyEarthScienceGrade1.addStudentToGrade(stevensWendy);
        gradeRepo.save(stevensWendyEarthScienceGrade1);
        
        Grade stevensWendyEarthScienceGrade2 = new Grade(earthScienceSecondAssignment, 98, 100);
        gradeRepo.save(stevensWendyEarthScienceGrade2);
        stevensWendyEarthScienceGrade2.addStudentToGrade(stevensWendy);
        gradeRepo.save(stevensWendyEarthScienceGrade2);
        
        Grade stevensWendyEarthScienceGrade3 = new Grade(earthScienceThirdAssignment, 99, 100);
        gradeRepo.save(stevensWendyEarthScienceGrade3);
        stevensWendyEarthScienceGrade3.addStudentToGrade(stevensWendy);
        gradeRepo.save(stevensWendyEarthScienceGrade3);
        
        Grade stevensWendyEarthScienceGrade4 = new Grade(earthScienceFourthAssignment, 100, 100);
        gradeRepo.save(stevensWendyEarthScienceGrade4);
        stevensWendyEarthScienceGrade4.addStudentToGrade(stevensWendy);
        gradeRepo.save(stevensWendyEarthScienceGrade4);
        
        Grade stevensWendyEarthScienceGrade5 = new Grade(earthScienceFifthAssignment, 87, 100);
        gradeRepo.save(stevensWendyEarthScienceGrade5);
        stevensWendyEarthScienceGrade5.addStudentToGrade(stevensWendy);
        gradeRepo.save(stevensWendyEarthScienceGrade5);
        

        
        Grade jamesLesterEarthScienceGrade1 = new Grade(earthScienceFirstAssignment, 78, 100);
        gradeRepo.save(jamesLesterEarthScienceGrade1);
        jamesLesterEarthScienceGrade1.addStudentToGrade(jamesLester);
        gradeRepo.save(jamesLesterEarthScienceGrade1);
        
        Grade jamesLesterEarthScienceGrade2 = new Grade(earthScienceSecondAssignment, 79, 100);
        gradeRepo.save(jamesLesterEarthScienceGrade2);
        jamesLesterEarthScienceGrade2.addStudentToGrade(jamesLester);
        gradeRepo.save(jamesLesterEarthScienceGrade2);
        
        Grade jamesLesterEarthScienceGrade3 = new Grade(earthScienceThirdAssignment, 80, 100);
        gradeRepo.save(jamesLesterEarthScienceGrade3);
        jamesLesterEarthScienceGrade3.addStudentToGrade(jamesLester);
        gradeRepo.save(jamesLesterEarthScienceGrade3);
        
        Grade jamesLesterEarthScienceGrade4 = new Grade(earthScienceFourthAssignment, 90, 100);
        gradeRepo.save(jamesLesterEarthScienceGrade4);
        jamesLesterEarthScienceGrade4.addStudentToGrade(jamesLester);
        gradeRepo.save(jamesLesterEarthScienceGrade4);
        
        Grade jamesLesterEarthScienceGrade5 = new Grade(earthScienceFifthAssignment, 100, 100);
        gradeRepo.save(jamesLesterEarthScienceGrade5);
        jamesLesterEarthScienceGrade5.addStudentToGrade(jamesLester);
        gradeRepo.save(jamesLesterEarthScienceGrade5);
        

        Note bobbyJonesNote = new Note("Reminder for Bobby", "Remind Bobby to cover his text book by next week.", "8/30/2021");
        jonesBobby.addNoteToStudent(bobbyJonesNote);
        studentRepo.save(jonesBobby);

        Note fongGaryNote = new Note("Reminder for Gary", "Praesent eleifend tempor rhoncus. Quisque et purus sagittis, " + 
        "gravida neque rutrum, luctus lorem. Integer hendrerit, nibh at egestas bibendum, orci orci rhoncus magna, ut.", "8/30/2021");
        fongGary.addNoteToStudent(fongGaryNote);
        studentRepo.save(fongGary);

        Note williamsAbbeyNote = new Note("Reminder for Abbey", "Integer hendrerit, nibh at egestas bibendum, orci orci rhoncus magna, ut.", "8/30/2021");
        williamsAbbey.addNoteToStudent(williamsAbbeyNote);
        studentRepo.save(williamsAbbey);

        Note stevensWendyNote = new Note("Reminder for Wendy", "Nibh at egestas bibendum", "8/30/2021");
        stevensWendy.addNoteToStudent(stevensWendyNote);
        studentRepo.save(stevensWendy);

        Note jamesLesterNote = new Note("Reminder for Lester", "Remind Lester to take out the trash.", "8/30/2021");
        jamesLester.addNoteToStudent(jamesLesterNote);
        studentRepo.save(jamesLester);


    }
}
