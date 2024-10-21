package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;


    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            System.out.println("Резюме " + r.getUuid() + " уже существует");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Хранилище заполнено");
        } else {
            storage[size++] = r;
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid != null && uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }


    public int size() {
        return size;
    }
}


