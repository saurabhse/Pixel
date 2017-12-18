package hackovationselproj

import org.springframework.dao.DataIntegrityViolationException

class VehicleController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [vehicleInstanceList: Vehicle.list(params), vehicleInstanceTotal: Vehicle.count()]
    }

    def create() {
        [vehicleInstance: new Vehicle(params)]
    }

    def save() {
        def vehicleInstance = new Vehicle(params)
        if (!vehicleInstance.save(flush: true)) {
            render(view: "create", model: [vehicleInstance: vehicleInstance])
            return
        }
		def registration = new Registration()
		registration.regNumber = randomAlphaNumeric(8)
		registration.vehicle = vehicleInstance
		registration.regStatus = "Active"
		registration.regDate = new Date()
        flash.message = "Your Vehicle registered with Registration Number : " + registration.regNumber
        redirect(action: "show", id: vehicleInstance.id)
    }

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
    def show(Long id) {
        def vehicleInstance = Vehicle.get(id)
        if (!vehicleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicle.label', default: 'Vehicle'), id])
            redirect(action: "list")
            return
        }

        [vehicleInstance: vehicleInstance]
    }

    def edit(Long id) {
        def vehicleInstance = Vehicle.get(id)
        if (!vehicleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicle.label', default: 'Vehicle'), id])
            redirect(action: "list")
            return
        }

        [vehicleInstance: vehicleInstance]
    }

    def update(Long id, Long version) {
        def vehicleInstance = Vehicle.get(id)
        if (!vehicleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicle.label', default: 'Vehicle'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (vehicleInstance.version > version) {
                vehicleInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'vehicle.label', default: 'Vehicle')] as Object[],
                          "Another user has updated this Vehicle while you were editing")
                render(view: "edit", model: [vehicleInstance: vehicleInstance])
                return
            }
        }

        vehicleInstance.properties = params

        if (!vehicleInstance.save(flush: true)) {
            render(view: "edit", model: [vehicleInstance: vehicleInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'vehicle.label', default: 'Vehicle'), vehicleInstance.id])
        redirect(action: "show", id: vehicleInstance.id)
    }

    def delete(Long id) {
        def vehicleInstance = Vehicle.get(id)
        if (!vehicleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicle.label', default: 'Vehicle'), id])
            redirect(action: "list")
            return
        }

        try {
            vehicleInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'vehicle.label', default: 'Vehicle'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'vehicle.label', default: 'Vehicle'), id])
            redirect(action: "show", id: id)
        }
    }
}
