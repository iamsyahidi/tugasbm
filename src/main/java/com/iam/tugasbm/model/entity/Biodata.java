package com.iam.tugasbm.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.iam.tugasbm.model.entity.DetailBiodata;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = Biodata.TABLE_NAME)
@Data
public class Biodata {
	public static final String TABLE_NAME = "dat_customer";
	
	@Id
	@GeneratedValue(generator = "sequence_bio", strategy = GenerationType.AUTO)
	@Column(name = "id_bio", nullable = false)
    private Integer id;
	
	@NotBlank(message = "Name is mandatory!")
	@Column(name="full_name",length = 512, nullable = false)
    private String fullName;
	
	@NotBlank(message = "Email is mandatory!")
    @Column(name = "email_address",length=128, nullable = false)
    private String emailAddress;
	
	@NotBlank(message = "Address is mandatory!")
    @Column(name = "address",length=256, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="kd_dati2", nullable = false, columnDefinition = "varchar(4)")
    private DetailBiodata detailBiodata;
	

}
