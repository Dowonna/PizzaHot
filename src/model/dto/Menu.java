package model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Menu {
	
	@Id
	private String name;
	private String config;
	private String status;
	private String category;
	private double price;
	
}
