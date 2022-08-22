package com.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="member")
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="membership_length")
	private String membership_length;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Tours> tours = new HashSet<Tours>();	
	
	
	
	
	
//	// method to add a role to a user
//		public void addTours(Tours tour) {
//			Tours.add(tour);
//			tour.getMembers().add(this);
//		}
//
//		// method to remove a role from a user
//		public void removeCustomerRoles(Tours tour) {
//			Tours.remove(tour);
//			tour.getMembers().remove(this);
//		}
		

		public Member(String email) {
			this.email = email;
		}
	
	
	public Member() {
		
	}
	
	

	public Set<Tours> getTour() {
		return tours;
	}

	public void setTour(Set<Tours> tours) {
		this.tours = tours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getMembership_length() {
		return membership_length;
	}

	public void setMembership_length(String membership_length) {
		this.membership_length = membership_length;
	}
	
	


	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", membership_length=" + membership_length + "]";
	}


	
		
}






