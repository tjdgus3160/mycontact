package com.fastcampus.javaallinone.project3.mycontact.domain;

import com.fastcampus.javaallinone.project3.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

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

    @NonNull
    @Min(1)
    private int age;

    private String hobby;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String bloodType;

    private String address;

    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block;

    @ColumnDefault("0")
    private boolean deleted;

    public void set(PersonDto personDto){
        if(personDto.getAge()!=0){
            this.setAge(personDto.getAge());
        }
        if(!personDto.getHobby().trim().isEmpty()){
            this.setHobby(personDto.getHobby());
        }
        if(!personDto.getBloodType().trim().isEmpty()){
            this.setBloodType(personDto.getBloodType());
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
    }
}
