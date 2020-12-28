package model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity(name="guest")
@SequenceGenerator(name="GUEST_SEQ_GEN",sequenceName="MEMBER_SEQ",
initialValue=1)
public class GuestDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="GUEST_SEQ_GEN")
	@Column(name="guest_id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="phone")
	private String phone;
	@Column(name="people")
	private String people;
	@Column(name="data")
	private String data;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuestDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", number=");
		builder.append(people);
		builder.append(", date=");
		builder.append(data);
		builder.append(", phone=");
		builder.append(phone);
		builder.append("]");
		return builder.toString();
	}
}
