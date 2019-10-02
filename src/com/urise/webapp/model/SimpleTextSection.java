package com.urise.webapp.model;

public class SimpleTextSection extends AbstractSection {
        private java.lang.String field;

        public java.lang.String getField() {
            return field;
        }

        public void setField(java.lang.String field) {
            this.field = field;
        }

        @Override
        public java.lang.String toString() {
            return field;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleTextSection that = (SimpleTextSection) o;

        return field.equals(that.field);
    }

    @Override
    public int hashCode() {
        return field.hashCode();
    }
}
