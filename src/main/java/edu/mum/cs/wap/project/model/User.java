package edu.mum.cs.wap.project.model;

import com.sun.istack.Nullable;
import sun.security.util.Password;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String state;
    private String city;
    private String country;
    private String gender;
    private String role;
    private String profilePic;
    private String description;
    private boolean status;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name="follower_user",
            joinColumns={@JoinColumn(name="userId")},
            inverseJoinColumns={@JoinColumn(name="friendId")})
    private List<User> friends = new ArrayList<User>();
//
//    @ManyToMany(mappedBy="friends",  fetch = FetchType.EAGER)
//    private List<User> friendOf = new ArrayList<User>();



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> postList;

    public User(String firstName, String lastName, String email, String username, String password, String state, String city, String country, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.state = state;
        this.city = city;
        this.country = country;
        this.gender = gender;
    }
    public User(){}


    public List<User> getFriends() {
        return friends;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof User)
        {
            sameSame = this.userId == ((User) object).userId;
        }

        return sameSame;
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, username, password);
    }
}
