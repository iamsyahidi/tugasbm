package com.iam.tugasbm.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DetailBiodata.TABLE_NAME)
@Data
public class DetailBiodata{
	
	public static final String TABLE_NAME = "ref_dati2";
	
	@Id
	@GeneratedValue(generator = "sequence_detail")
    @GenericGenerator(name = "sequence_detail", parameters = @Parameter(name = "prefix", value = "A"), strategy="com.iam.tugasbm.generator.IdGenerator")
	@Column(name = "kd_dati2",length = 4, nullable = false)
    private String kdDati2;
	
	@NotBlank(message = "City is Mandatory!")
	@Column(name = "nm_dati2",length = 128, nullable = false)
    private String nmDati2;
}
