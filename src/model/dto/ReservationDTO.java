package model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@NamedQuery(name="getAllReservations", query="SELECT r FROM reservation r")
@Entity(name="reservation")
@SequenceGenerator(name="RESERVATION_SEQ_GEN",sequenceName="RESERVATION_SEQ",
initialValue=1)
public class ReservationDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="RESERVATION_SEQ_GEN")
	private int reservationNum;
	private String menuName;
	private String foodNum;
	private int id;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReservationDTO [reservationNum=");
		builder.append(reservationNum);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", foodNum=");
		builder.append(foodNum);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
	
}
