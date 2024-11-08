package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import ru.javawebinar.basejava.model.Resume;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AbstractArrayStorageTest {
    protected Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @BeforeEach
    void setUp() {
        storage.clear();

        Resume resume1 = new Resume();
        Resume resume2 = new Resume();
        Resume resume3 = new Resume();

        resume1.setUuid(UUID_1);
        resume2.setUuid(UUID_2);
        resume3.setUuid(UUID_3);

        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    void size() {
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 после добавления 3 резюме.");
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size(), "Размер хранилища должен составлять 0 после очистки.");
    }

    @Test
    void update() {

        Resume newResume = new Resume();
        newResume.setUuid(UUID_1);
        storage.update(newResume);
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 после обновления резюме.");
    }

    @Test
    void getAll() {

        Resume[] resumes = storage.getAll();
        assertEquals(3, resumes.length, "Длина массива должна быть равна 3.");
        assertEquals(UUID_1, resumes[0].getUuid(), "Резюме должно иметь UUID = uuid1.");
        assertEquals(UUID_2, resumes[1].getUuid(), "Резюме должно иметь UUID = uuid2.");
        assertEquals(UUID_3, resumes[2].getUuid(), "Резюме должно иметь UUID = uuid3.");

    }

    @Test
    void save() {

        Resume newResume = new Resume();
        newResume.setUuid("uuid4");
        storage.save(newResume);
        assertEquals(4, storage.size(), "Размер хранилища должен составлять 4 после добавления нового резюме.");
    }

    @Test
    void delete() {

        storage.delete(UUID_1);
        assertEquals(2, storage.size(), "Размер хранилища должен составлять 2 после удаления резюме.");
    }

    @Test
    void get() {

        Resume resume = storage.get(UUID_1);
        assertEquals(UUID_1, resume.getUuid(), "Резюме должно иметь UUID = uuid1.");
    }
}

