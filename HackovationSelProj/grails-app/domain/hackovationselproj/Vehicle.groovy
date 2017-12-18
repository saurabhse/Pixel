package hackovationselproj

class Vehicle {

    static constraints = {
		registrants (nullable:true)
    }
    static mapping = {
		table 'vehicle'
		columns {
			vehMaker					column: 'maker_id'
			vehModel				   column:  'model_id'
			owner						column : 'owner_id'
		}	
    }
	
	
	
	String vehType
	String vehEngineSize
	String yearOfManufacture
	Long vehSeatingCapacity
	String vehColor
	String vehBody
	Double vehWeight
	String vehFuelType
	VehicleMaker vehMaker
	VehicleModel vehModel
	String VIN
	Contact owner
	
	static hasMany = [
		registrants					: 	 Registrant
	]
	
}
