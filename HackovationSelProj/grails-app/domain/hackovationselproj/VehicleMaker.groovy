package hackovationselproj

class VehicleMaker {

    static constraints = {
    }
	
	static mapping = {
		table 'maker'
		
	}
	
	static hasMany = [
		models					: 	 VehicleModel
	]
	
	String makerName
	String makerCode
	
   public String toString()
   {
	   return  makerName
   }
	
}
