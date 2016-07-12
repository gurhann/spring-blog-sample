package com.gurhan.blogsample.persistence.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "verification_token")
@NamedQueries({
		@NamedQuery(name = VerificationToken.FIND_BY_TOKEN, query = "select vt from VerificationToken vt where vt.token=:token"),
		@NamedQuery(name = VerificationToken.FIND_BY_USER, query = "select vt from VerificationToken vt where vt.user.id=:userId"),
		@NamedQuery(name = VerificationToken.FIND_ALL_BY_EXPIRY_DATE_LESS_THAN, query = "select vt from VerificationToken vt where vt.expiryDate>:expiryDate"),
		@NamedQuery(name = VerificationToken.DELETE_BY_EXPIRY_DATE_LESS_THAN, query = "delete from VerificationToken vt where vt.expiryDate>:expiryDate"),
		@NamedQuery(name = VerificationToken.DELETE_ALL_EXPIRED_SINCE, query = "delete from VerificationToken vt where vt.expiryDate=:expiryDate") })
public class VerificationToken {
	public final static String FIND_BY_TOKEN = "VerificationToken.findByToken";
	public final static String FIND_BY_USER = "VerificationToken.findByUser";
	public final static String FIND_ALL_BY_EXPIRY_DATE_LESS_THAN = "VerificationToken.findAllByExpiryDateLessThan";
	public final static String DELETE_BY_EXPIRY_DATE_LESS_THAN = "VerificationToken.deleteByExpiryDateLessThan";
	public final static String DELETE_ALL_EXPIRED_SINCE = "VerificationToken.deleteAllExpiredSince";

	private static final int EXPIRATION = 60 * 24;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "token")
	private String token;

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	@Column(name = "expiry_date")
	private Date expiryDate;

	public VerificationToken() {
		super();
	}

	public VerificationToken(String token, User user) {
		super();
		this.token = token;
		this.user = user;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
