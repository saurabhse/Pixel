package hackovationselproj

class VehicleModel {

    static constraints = {
    }
	
	static mapping = {
		table 'model'
		
	}
	
	static belongsTo = [maker: VehicleMaker]
	
	String modelName
	String modelCode
	
	public String toString()
	{
		return  modelName
	}
}
