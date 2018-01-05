package cn.sheep3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Created by sheep3 on 16-9-14.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_users")
@NoArgsConstructor
public class User extends BaseEntity{

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();*/

    /**
     * user login name
     */
    @Column(name = "c_user_login", nullable = false)
    private String userLogin;

    /**
     * user password
     * this password= md5 (real_password + salt)
     */
    @Column(name = "c_user_pass", nullable = false)
    @JsonIgnore
    private String userPass;

    /**
     * user password salt
     */
    @Column(name = "c_user_salt", nullable = false)
    @JsonIgnore
    private String userSalt;

    /**
     * user nice name
     */
    @Column(name = "c_user_nice_name")
    private String userNiceName;

    /**
     * user email
     */
    @Column(name = "c_user_email")
    private String userEmail;

    @Column(name = "c_user_url")
    private String userUrl;

    @Column(name = "c_user_status")
    @Enumerated
    private UserStatus userStatus = UserStatus.UN_LOCK;

    public enum UserStatus{
        LOCK("LOCK"),
        UN_LOCK("UN_LOCK");

        @Getter@Setter
        private String value;

        UserStatus(String value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userLogin='" + userLogin + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userSalt='" + userSalt + '\'' +
                ", userNiceName='" + userNiceName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }

}
