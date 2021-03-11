package study.eatgo.domain.user.domain;

import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import study.eatgo.domain.user.model.Email;
import study.eatgo.domain.user.model.Name;

@EqualsAndHashCode(of = {"id"})
@ToString(of = {"email", "name"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false)
    private Integer id;

    //name -> Email 객체 안의 column, Column은 주테이블에 어떻게 매핑될지.
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email", length = 50, nullable = false, unique = true, updatable = false))
    private Email email;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "first", column = @Column(name = "first_name", length = 50, nullable = false, updatable = false)),
        @AttributeOverride(name = "last", column = @Column(name = "last_name", length = 50, nullable = false, updatable = false))
    })
    private Name name;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "create_at", updatable = false, nullable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @Builder
    public User(Email email, Name name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

}
