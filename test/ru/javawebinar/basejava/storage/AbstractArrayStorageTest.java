package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractArrayStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
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
    public void size() {
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 после добавления 3 резюме.");
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size(), "Размер хранилища должен составлять 0 после очистки.");
    }

    @Test
    void update() {

        Resume newResume = new Resume();
        assertNotNull(newResume.uuid, "UUID не должен быть null.");
        assertFalse(newResume.uuid.isEmpty(), "UUID не должен быть пустой строкой.");

    }

    @Test
    void getAll() {

        Resume newResume = new Resume();
        assertNotNull(newResume.uuid, "UUID не должен быть null.");
        assertFalse(newResume.uuid.isEmpty(), "UUID не должен быть пустой строкой.");

    }

    @Test
    void save() {

        Resume newResume = new Resume();
        storage.save(newResume);
        assertEquals(4, storage.size(), "Размер хранилища должен составлять 4 после добавления нового резюме.");
    }

    @Test
    void delete() {
        Resume newResume = new Resume();
        assertNotNull(newResume.uuid, "UUID не должен быть null.");
        assertFalse(newResume.uuid.isEmpty(), "UUID не должен быть пустой строкой.");

    }

    @Test
    void get() {

        Resume newResume = new Resume();
        assertNotNull(newResume.uuid, "UUID не должен быть null.");
        assertFalse(newResume.uuid.isEmpty(), "UUID не должен быть пустой строкой.");

    }
}

