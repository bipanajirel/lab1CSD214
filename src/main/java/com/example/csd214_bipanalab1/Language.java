package com.example.csd214_bipanalab1;

public class Language {

        private int id;
        private String Instructor;
        private String Language;
        private int Session;
        public Language(int id, String Instructor, String Language, int Session) {
            this.id = id;
            this.Instructor = Instructor;
            this.Language = Language;
            this.Session= Session;
        }
        public int getId() {
            return id;
        }
        public String getInstructor() {
            return Instructor;
        }
        public String getLanguage() {
            return Language;
        }
        public int getSession() {
            return Session;
        }

    public void setId(int id) {
        this.id = id;
    }

    public void setInstructor(String Instructor) {
        this.Instructor = Instructor;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public void setSession(int Session) {
        this.Session = Session;
    }
}


