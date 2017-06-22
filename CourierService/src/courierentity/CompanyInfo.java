package courierentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companyinfo")
public class CompanyInfo {

	@Id
	@Column(name = "companyid")
	private int companyId;

	@Column(name = "billrate")
	private int billRate;

	@Column(name = "bonus")
	private int bonus;

	@Column(name = "basebillamount")
	private int baseBillAmount;

	@Column(name = "address")
	private String address;
	
	@Column(name = "phoneno")
	private String phoneno;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getBillRate() {
		return billRate;
	}

	public void setBillRate(int billRate) {
		this.billRate = billRate;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getBaseBillAmount() {
		return baseBillAmount;
	}

	public void setBaseBillAmount(int baseBillAmount) {
		this.baseBillAmount = baseBillAmount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	

}
