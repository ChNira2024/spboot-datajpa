package com.eidiko.niranjana.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="STUDENTS")
public class Students2  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer sno;		
	private  String sname;		
	private  String saddrs;		
	private  Float ssal;

	@Override
	public String toString() {
		return "Students [sno=" + sno + ", sname=" + sname + ", saddrs=" + saddrs + ", ssal=" + ssal + "]";
	}
}
