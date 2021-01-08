package com.fastcampus.javaallinone.project3.mycontact.domain;

import com.fastcampus.javaallinone.project3.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Where(clause = "deleted = false")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    private String hobby;

    private String address;

    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    private String phoneNumber;

    @ColumnDefault("0")
    private boolean deleted;

    public void set(PersonDto personDto){
        if(!personDto.getHobby().trim().isEmpty()){
            this.setHobby(personDto.getHobby());
        }
        if(!personDto.getAddress().trim().isEmpty()){
            this.setAddress(personDto.getAddress());
        }
        if(!personDto.getJob().trim().isEmpty()){
            this.setJob(personDto.getJob());
        }
        if(!personDto.getPhoneNumber().trim().isEmpty()){
            this.setPhoneNumber(personDto.getPhoneNumber());
        }
        if(personDto.getBirthday()!=null){
            this.setBirthday(Birthday.of(personDto.getBirthday()));
        }

    }
    public Integer getAge(){
        if(birthday!=null) {
            return LocalDate.now().getYear() - birthday.getYearOfBirthday() + 1;
        }else{
            return null;
        }
    }

    public boolean isBirthdayToday(){
        return LocalDate.now().equals(LocalDate.of(birthday.getYearOfBirthday(),birthday.getMonthOfBirthday(),birthday.getDayOfBirthday()));
    }
}
