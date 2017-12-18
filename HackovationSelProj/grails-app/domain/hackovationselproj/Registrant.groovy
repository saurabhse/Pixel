package hackovationselproj

class Registrant {

    static mapping = {
		table 'Registrants'
		columns {
			registrantCon					column: 'contact_id'
		}
		 
    }
	
	Contact registrantCon
	Date registrationStart
	Date registrationEnd
	
}
