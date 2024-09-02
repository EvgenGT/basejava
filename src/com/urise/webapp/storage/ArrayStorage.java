package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    public void clear() {
        int i;
        for (i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    public void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                System.out.println("Резюме с uuid " + r.getUuid() + "добавлено");
                return;
            }
        }
        System.out.println("ERROR. Резюме с uuid " + r.getUuid() + "не найдено. ОБновление не выполнено");
    }

    public void save(Resume r) {
        if (size < storage.length) {
            storage[size++] = r;
            System.out.println("Резюме сохранено. Новый размер хранилища: " + size);
        } else {
            System.out.println("Хранилище полно");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid != null && uuid.equals(storage[i].getUuid())) {
                System.out.println("найден совпадающий uuid на индексе: " + i);
                return storage[i];
            }

        }
        System.out.println("Совпадающий uuid не найден");
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.out.println("Найден совпадающий uuid на индексе: " + i);
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                System.out.println("Резюме удалено. Новый размер хранилища: " + size);
                break;
            }
        }
        System.out.println("Совпадающий uuid не найден");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}


