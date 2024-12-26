package com.techpixe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // Username: String, Not Blank, with length between 3 and 20 characters
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain alphabets only")
    private String username;

    // Email: Valid email format, must contain "@" and end with ".com"
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$", message = "Email must end with .com")
    private String email;

    // Mobile number: Exactly 10 digits// we should use @NotNull annotataion for long and Integer datatypes
//    @NotNull(message = "Mobile number cannot be null")
//    private Long mobilenumber;
    
    
    @NotBlank(message = "Mobile number cannot be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
    private String mobilenumber;


    // Password: Contains at least one uppercase letter, one lowercase letter, one digit, and one special character
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}$", 
             message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String password;
    
    private String role;
    

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
//	public Long getMobilenumber() {
//		return mobilenumber;
//	}
//
//    
// //   //2nd approach for validating mobile number
//    public void setMobilenumber(Long mobilenumber)
//    {
//        if (mobilenumber == null || mobilenumber.toString().length() != 10)
//        {
//            throw new IllegalArgumentException("Mobile number must be exactly 10 digits");
//        }
//        this.mobilenumber = mobilenumber;
//    }
	
	
    /*
     * In industry standards, it is generally not recommended to declare a mobile number as a Long data type.
     * 1. Leading Zeros
			Mobile numbers can sometimes have leading zeros (e.g., 0123456789). A Long data type would remove the leading zeros, which could cause data loss and incorrect formatting.
			Example: If you declare the mobile number as Long and pass 0123456789, it would be stored as 123456789 (leading zero is lost).
			
	   3. Mobile Numbers Are Not Numeric Values
			Mobile numbers are not used for mathematical operations. Although they consist of digits, they are used purely as identifiers (i.e., strings of characters), and storing them as a string gives you more flexibility.
			Example: You wouldn’t perform arithmetic operations on a mobile number, so treating it as a string is a better approach for validation, formatting, and comparison.
			
	  4. International Mobile Numbers
			Many mobile numbers are formatted with a country code (e.g., +1, +44, +91). A Long type would not allow for the inclusion of special characters like the + sign, which is often part of the phone number.
			Declaring it as a string allows for proper storage and validation of international numbers.
			
	  5. String Format for Validation and Formatting
			By declaring the mobile number as a string (String), you can easily perform validation (length checks, regex for digits) and format the number without any issues related to numerical representation.
			You can validate the number with regular expressions or check for length as required.*/
	
	 /*
	  * When to Use Long for Mobile Numbers
		Rare cases: 
					If you need to work with numeric operations, like calculating the length of the mobile number or interacting with databases that expect the number to be stored as a numeric type, you might consider using a Long.
					
		They may include leading zeros and special characters (e.g., country code +).
		String-based validation and formatting are easier and more flexible.
		Storing mobile numbers as String is the industry standard, ensuring you avoid issues with data loss, validation, and formatting.
		
		*/
	
	/*@NotBlank(message = "Mobile number cannot be blank")
	  @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
	  private String mobilenumber;
*/
    

}
