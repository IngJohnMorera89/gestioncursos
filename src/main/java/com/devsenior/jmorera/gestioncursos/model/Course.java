package com.devsenior.jmorera.gestioncursos.model;

import java.time.LocalDate;

//Pjp
// java Bean
//DTO -Data transfer Object

public class Course {

    private Long id;
    private String name;
    private String code;
    private String descrition;
    private LocalDate initalDate;
    private LocalDate finalDate;
    private Integer credits;

    public Course() {
    }

    public Course(Long id, String name, String code, String descrition, LocalDate initalDate, LocalDate finalDate,
            Integer credits) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.descrition = descrition;
        this.initalDate = initalDate;
        this.finalDate = finalDate;
        this.credits = credits;

                

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public LocalDate getInitalDate() {
        return initalDate;
    }

    public void setInitalDate(LocalDate initalDate) {
        this.initalDate = initalDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((descrition == null) ? 0 : descrition.hashCode());
        result = prime * result + ((initalDate == null) ? 0 : initalDate.hashCode());
        result = prime * result + ((finalDate == null) ? 0 : finalDate.hashCode());
        result = prime * result + ((credits == null) ? 0 : credits.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (descrition == null) {
            if (other.descrition != null)
                return false;
        } else if (!descrition.equals(other.descrition))
            return false;
        if (initalDate == null) {
            if (other.initalDate != null)
                return false;
        } else if (!initalDate.equals(other.initalDate))
            return false;
        if (finalDate == null) {
            if (other.finalDate != null)
                return false;
        } else if (!finalDate.equals(other.finalDate))
            return false;
        if (credits == null) {
            if (other.credits != null)
                return false;
        } else if (!credits.equals(other.credits))
            return false;
        return true;
    }

    

    

    
}
