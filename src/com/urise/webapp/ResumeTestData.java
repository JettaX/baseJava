package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.YearMonth;

public class ResumeTestData {
    public static void main(java.lang.String[] args) {

        Resume resume = new Resume("Grigory Kislin");
        resume.setContactsFields(ContactType.PHONE, "+7(921) 855-0482");
        resume.setContactsFields(ContactType.SKYPE, "grigory.kislin");
        resume.setContactsFields(ContactType.MAIL, "gkislin@yandex.ru");
        resume.setContactsFields(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.setContactsFields(ContactType.GITHUB, "https://github.com/gkislin");
        resume.setContactsFields(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.setContactsFields(ContactType.HOMEPAGE, "http://gkislin.ru/");

        System.out.println(resume.getFullName());
        System.out.println(resume.getContactsFields());

        Text objective = new Text();
        objective.setField("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.setSectionsFields(SectionType.OBJECTIVE, objective);

        List<java.lang.String> personal = new List<>();
        personal.add("Аналитический склад ума, сильная логика, креативность, инициативность.");
        personal.add("Пурист кода и архитектуры.");
        resume.setSectionsFields(SectionType.PERSONAL, personal);

        List<java.lang.String> achievment = new List<>();
        achievment.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"." +
                " Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.\n");
        achievment.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, " +
                "DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievment.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, " +
                "интеграция CIFS/SMB java сервера.");
        achievment.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, " +
                "HTML5, Highstock для алгоритмического трейдинга.");
        achievment.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов " +
                "(SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievment.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        resume.setSectionsFields(SectionType.ACHIEVEMENT, achievment);

        List<java.lang.String> qualifications = new List<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        qualifications.add("MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        qualifications.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), " +
                "JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium " +
                "(htmlelements).");
        qualifications.add("Python: Django");
        qualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, " +
                "JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT");
        qualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        qualifications.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования.");
        qualifications.add("Родной русский, английский \"upper intermediate\".");
        resume.setSectionsFields(SectionType.QUALIFICATION, qualifications);

        List<ExperienceSubType> experience = new List<>();
        experience.add(new ExperienceSubType("Wrike", YearMonth.of(2014, 10), YearMonth.of(2016, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        resume.setSectionsFields(SectionType.EXPERIENCE, experience);

        List<ExperienceSubType> education = new List<>();
        education.add(new ExperienceSubType("Coursera", YearMonth.of(2013, 3), YearMonth.of(2013, 5), "\"Functional Programming Principles in Scala\" by Martin Odersky", null));
        resume.setSectionsFields(SectionType.EDUCATION, education);

        System.out.println(resume.getSectionsFields());
    }
}
