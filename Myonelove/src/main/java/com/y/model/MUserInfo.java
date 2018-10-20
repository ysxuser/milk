package com.y.model;

import java.util.Date;

public class MUserInfo {
    private Integer id;

    private String usernumber;

    private String mobilephone;

    private String idCard;

    private String creationTime;

    private String status;



	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	private String password;
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }



	@Override
	public String toString() {
		return "MUserInfo [id=" + id + ", userNumber=" + usernumber + ", mobilephone=" + mobilephone + ", idCard="
				+ idCard + ", creationTime=" + creationTime + ", status=" + status + "]";
	}
    
    
}