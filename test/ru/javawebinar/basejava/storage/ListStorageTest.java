package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.jupiter.api.Assertions.*;

public abstract class ListStorageTest {
    private final Storage storage;

    protected ListStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();

        Resume resume1 = new Resume();
        Resume resume2 = new Resume();
        Resume resume3 = new Resume();

        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void update() {
    }

    @Test
    public void save() {

        Resume newResume = new Resume();
        storage.save(newResume);
        assertEquals(4, storage.size(), "Размер хранилища должен составлять 4 (четыре) после добавления нового резюме.");
    }

    @Test
    public void get() {
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 (три) резюме.");

    }

    @Test
    public void delete() {

        Resume resume4 = new Resume();
        storage.save(resume4);

        String uuidToDelete = resume4.getUuid();
        storage.delete(uuidToDelete);

        assertEquals(3, storage.size(), "Размер хранилища должен уменьшиться на 1 после удаления");

    }

}
