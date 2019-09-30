package com.urise.webapp.model;

public class Text extends Section{
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
}
