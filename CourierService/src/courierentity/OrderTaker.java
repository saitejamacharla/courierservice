package courierentity;

import javax.persistence.Column;
import javax.persistence.Id;


public class OrderTaker {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phno")
	private String phno;
	
	@Column(name="position")
	private String position;
	
	
	

}
