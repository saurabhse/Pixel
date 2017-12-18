package hackovationselproj

class Registration {

    static constraints = {
    }
	
	Date regDate
	String RegStatus
	Vehicle vehicle
	String regNumber
	
	
	static mapping = {
		table 'registration'
		columns {
			vehicle					column: 'vehicle_id'
		}
	}
}
