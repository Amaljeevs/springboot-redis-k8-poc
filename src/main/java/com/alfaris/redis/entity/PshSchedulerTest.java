package com.alfaris.redis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PSH_SCHEDULER_TEST")
public class PshSchedulerTest {

	@Id
	@Column(name = "SERIAL_NO")
	private String serialNo;

	@Column(name = "PAYMENT_REFERENCE")
	private String paymentReference;

	@Column(name = "STATUS")
	private String status;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PshSchedulerTest [serialNo=" + serialNo + ", paymentReference=" + paymentReference + ", status="
				+ status + "]";
	}

}
