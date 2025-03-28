package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    private Long id;
    private String name;
    private String password;
    @JsonProperty("isTeacher")
    private boolean isTeacher;

    public UserDTO(Long id,String name, String password, boolean isTeacher) {
        setId(id);
        setName(name);
        setPassword(password);
        setTeacher(isTeacher);
    }

    public UserDTO() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

}
