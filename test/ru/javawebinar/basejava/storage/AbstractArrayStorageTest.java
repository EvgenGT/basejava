package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Test
    void size() {
        Storage storage = new ArrayStorage(); // Используем конкретный класс, реализующий AbstractArrayStorage
        Resume resume1 = new Resume();
        Resume resume2 = new Resume();
        Resume resume3 = new Resume();

        // Установим UUID через сеттер, если он существует
        resume1.setUuid(UUID_1);
        resume2.setUuid(UUID_2);
        resume3.setUuid(UUID_3);

        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);

        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 после добавления 3 резюме.");

    }

    @Test
    void clear() {
    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }
}
