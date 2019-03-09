package project.register;

public class RegistrationData {
	 private String txtEmail1;
	 private String txtPassword1;
	 private String txtrePassword1;
	 private String txtfName1;
	 private String txtlName1;
	 private String country1;
	 private String state1;
	 private String txtzip1;
	 private String txtCity1;
	 private String txtAddrl11;
	 private String txtAddrl21;
	 private String txtContactno1;
	 
	 public RegistrationData() {
		 
		 this.txtEmail1="abc7@gmail.com";
		 this.txtPassword1="test7@123";
		 this.txtrePassword1="test7@123";
		 this.txtfName1="sheetal7";
		 this.txtlName1="karande7";
		 this.country1="India";
		 this.state1="Maharashtra";
		 this.txtzip1="411014";
		 this.txtCity1="Pune";
		 this.txtAddrl11="MG Road";
		 this.txtAddrl21="Flat no15";
		 this.txtContactno1="1234567895";		 
		
	 }
	 
	 public String getEmail() {
		return this.txtEmail1;
	}
	 
	 public void setEmail(String txtEmail1) {
		 this.txtEmail1=txtEmail1;
	 }
	 
	 	public String getPassword() {
			return this.txtPassword1; 
		 }
		 
		 public void setPassword(String txtPassword1) {
			 this.txtPassword1=txtPassword1;
		 }
		 
		 public String getRePassword() {
				return this.txtrePassword1;
			}
			 
			 public void setRePassword(String txtrePassword1) {
				 this.txtrePassword1=txtrePassword1;
			 }
			 
			 public String getFname() {
					return this.txtfName1; 
				 }
				 
				 public void setFname(String txtfName1) {
					 this.txtfName1=txtfName1;
				 }
				 
				 public String getLname() {
						return this.txtlName1; 
					 }
					 
					 public void setLname(String txtlName1) {
						 this.txtlName1=txtlName1;
					 }
					 
					 public String getCountry() {
							return this.country1; 
						 }
						 
						 public void setCountry(String country1) {
							 this.country1=country1;
						 }
						 
						 public String getState() {
								return this.state1; 
							 }
							 
							 public void setState(String state1) {
								 this.state1=state1;
							 }
							 
							 public String getZip() {
									return this.txtzip1; 
								 }
								 
								 public void setZip(String txtzip1) {
									 this.txtzip1=txtzip1;
								 }
								 
								 public String getCity() {
										return this.txtCity1; 
									 }
									 
									 public void setCity(String txtCity1) {
										 this.txtCity1=txtCity1;
									 }
									 
									 public String getAddl1() {
											return this.txtAddrl11; 
										 }
										 
										 public void setAddl1(String txtAddrl11) {
											 this.txtAddrl11=txtAddrl11;
										 }
										 
										 public String getAddl2() {
												return this.txtAddrl21; 
											 }
											 
											 public void setAddl2(String txtAddrl21) {
												 this.txtAddrl21=txtAddrl21;
											 }
											 
											 public String getContact() {
													return this.txtContactno1; 
												 }
												 
												 public void setContact(String txtContactno1) {
													 this.txtContactno1=txtContactno1;
												 }


}
