package courierentity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CreateDeliveryTicket {

	@Id
	@Column
	private String packageId;

	@Column
	private int fromAddress;

	@Column
	private String createdCutomerNo;

	@Column
	private int assignedCourierNo;

	@Column
	private String deliveryStatus;

	@Column
	private Date createdDate;

	@Column
	private String createdTime;

	@Column
	private Date pickUpTime;

	@Column
	private String deliveryPath;

	@Column
	private int toAddress;

	@Column
	private String deliveryCustName;

	@Column
	private String deliveryCustPhone;
	
	private int estimatedBlocks;
	
	@Column 
	private double billToPickUP;
	
	@Column
	private double billToDelivery;
	
	@Column
	private double quotedPrice;
	
	@Column
	private Date estimatedDeliveryDate;
	
	@Column
	private String instructions;
	
	@Column
	private Date actualDeliveredDate;

	public double getBillToPickUP() {
		return billToPickUP;
	}

	public void setBillToPickUP(double billToPickUP) {
		this.billToPickUP = billToPickUP;
	}

	public double getBillToDelivery() {
		return billToDelivery;
	}

	public void setBillToDelivery(double billToDelivery) {
		this.billToDelivery = billToDelivery;
	}

	public double getQuotedPrice() {
		return quotedPrice;
	}

	public void setQuotedPrice(double quotedPrice) {
		this.quotedPrice = quotedPrice;
	}

	public Date getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}

	public int getEstimatedBlocks() {
		return estimatedBlocks;
	}

	public void setEstimatedBlocks(int estimatedBlocks) {
		this.estimatedBlocks = estimatedBlocks;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public int getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(int fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getCreatedCutomerNo() {
		return createdCutomerNo;
	}

	public void setCreatedCutomerNo(String createdCutomerNo) {
		this.createdCutomerNo = createdCutomerNo;
	}

	public int getAssignedCourierNo() {
		return assignedCourierNo;
	}

	public void setAssignedCourierNo(int assignedCourierNo) {
		this.assignedCourierNo = assignedCourierNo;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public Date getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public String getDeliveryPath() {
		return deliveryPath;
	}

	public void setDeliveryPath(String deliveryPath) {
		this.deliveryPath = deliveryPath;
	}

	public int getToAddress() {
		return toAddress;
	}

	public void setToAddress(int toAddress) {
		this.toAddress = toAddress;
	}

	public String getDeliveryCustName() {
		return deliveryCustName;
	}

	public void setDeliveryCustName(String deliveryCustName) {
		this.deliveryCustName = deliveryCustName;
	}

	public String getDeliveryCustPhone() {
		return deliveryCustPhone;
	}

	public void setDeliveryCustPhone(String deliveryCustPhone) {
		this.deliveryCustPhone = deliveryCustPhone;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Date getActualDeliveredDate() {
		return actualDeliveredDate;
	}

	public void setActualDeliveredDate(Date actualDeliveredDate) {
		this.actualDeliveredDate = actualDeliveredDate;
	}

}
