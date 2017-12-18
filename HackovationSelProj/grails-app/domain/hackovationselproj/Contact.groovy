package hackovationselproj

class Contact {

    static constraints = {
		firstName maxSize:10//, matches:  "[a-zA-Z]+"
    }
	
	String firstName
	String lastName
	Long contactNum
	String occupation
	String address
	String dob
	String sex
	String contactId
	
	
	public String toString()
	{
		return  firstName + " ," + lastName
	}
}
