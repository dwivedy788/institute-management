package com.abroad.ims.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    @NotBlank(message = "Name is required")
    @Size(max = 10,message = "must have only 10 character")
    private String name;
    @NotBlank(message = "location is needed")
    private String location;
    @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
    private long contact;



}
