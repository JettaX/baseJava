package com.urise.webapp.model;

public class Resume implements Comparable<Resume> {
    private String uuid;

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public int compareTo(Resume o) {
        int result = this.uuid.compareTo(o.uuid);

        if (result < 0) {
            if (this.uuid.length() < o.uuid.length()) {
                result = -1;
            } else if (this.uuid.length() > o.uuid.length()) {
                result = 1;
            }
        } else if (result > 0) {
            if (this.uuid.length() > o.uuid.length()) {
                result = 1;
            } else if (this.uuid.length() < o.uuid.length()) {
                result = -1;
            }
        }
        return result;
    }
}
