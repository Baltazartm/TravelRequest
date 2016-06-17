package com.company.travelrequest.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tour")
public class Tour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	private String status;
	
	private Long userId;
	
	@Column(name = "mode_travel")
	private String modeTravel;
	
	@Column(name = "ticket_cost")
	private Long ticketCost;
	
	@Column(name = "cab_h")
	private Long cabH;
	
	@Column(name = "cab_d")
	private Long cabD;
	
	@Column(name = "hotel_cost")
	private Long hotelCost;
	
	private Long description;
	
	private Date startDate;
	
	private Date endDate;
	
	private Long tobeApprovedby;
	
	private Timestamp approvedat;
	
	private Timestamp rejectedat;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getModeTravel() {
		return modeTravel;
	}

	public void setModeTravel(String modeTravel) {
		this.modeTravel = modeTravel;
	}

	public Long getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Long ticketCost) {
		this.ticketCost = ticketCost;
	}

	public Long getCabH() {
		return cabH;
	}

	public void setCabH(Long cabH) {
		this.cabH = cabH;
	}

	public Long getCabD() {
		return cabD;
	}

	public void setCabD(Long cabD) {
		this.cabD = cabD;
	}

	public Long getHotelCost() {
		return hotelCost;
	}

	public void setHotelCost(Long hotelCost) {
		this.hotelCost = hotelCost;
	}

	public Long getDescription() {
		return description;
	}

	public void setDescription(Long description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getTobeApprovedby() {
		return tobeApprovedby;
	}

	public void setTobeApprovedby(Long tobeApprovedby) {
		this.tobeApprovedby = tobeApprovedby;
	}

	public Timestamp getApprovedat() {
		return approvedat;
	}

	public void setApprovedat(Timestamp approvedat) {
		this.approvedat = approvedat;
	}

	public Timestamp getRejectedat() {
		return rejectedat;
	}

	public void setRejectedat(Timestamp rejectedat) {
		this.rejectedat = rejectedat;
	}
	
}
