package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
        System.out.println("Хранилище очищено");
    }

    @Override
    public void update(Resume r) {
        int index = Arrays.binarySearch(storage, 0, size, r);

        if (index >= 0) {
            storage[index] = r;
            System.out.println("Резюме обновлено: " + r.getUuid());
        } else {
            System.out.println("Ошибка: Резюме с данным UUID не найдено: " + r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        int index = Arrays.binarySearch(storage, 0, size, r);

        if (index >= 0) {
            System.out.println("Ошибка: Резюме с данным UUID уже существует: " + r.getUuid());
            return;
        }

        int insertIndex = -index - 1;

        if (size >= storage.length) {
            System.out.println("Ошибка: Хранилище заполнено. Невозможно сохранить резюме.");
            return;
        }
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = r;
        size++;
        System.out.println("Резюме сохранено: " + r.getUuid());
    }

    @Override
    public void delete(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        int index = Arrays.binarySearch(storage, 0, size, searchKey);

        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println("Резюме удалено: " + searchKey);
        } else {
            System.out.println("Ошибка. Резюме с данным UUID не найдено " + searchKey);
        }
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
