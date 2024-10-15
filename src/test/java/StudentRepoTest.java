import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {

    @org.junit.jupiter.api.Test
    void findStudentById_StudentDoesNotExist() {
        //Given
        StudentRepo studentRepo = new StudentRepo();
        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();
        studentRepo.save(newStudent);


        //when
        Student actual = studentRepo.findStudentById(newStudent.id()).get();

        //then
        assertEquals(newStudent.id(), actual.id());
    }
    @org.junit.jupiter.api.Test
    void findStudentById_StudentDoesExist() {

        // given
        StudentRepo studentRepo = new StudentRepo();
        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();
        studentRepo.save(newStudent);
        //when

        //then
        assertThrows(StudentNotFound.class,()->studentRepo.findStudentById("123"));

    }
}