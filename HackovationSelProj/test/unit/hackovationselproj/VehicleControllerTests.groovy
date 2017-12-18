package hackovationselproj



import org.junit.*
import grails.test.mixin.*

@TestFor(VehicleController)
@Mock(Vehicle)
class VehicleControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/vehicle/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.vehicleInstanceList.size() == 0
        assert model.vehicleInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.vehicleInstance != null
    }

    void testSave() {
        controller.save()

        assert model.vehicleInstance != null
        assert view == '/vehicle/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/vehicle/show/1'
        assert controller.flash.message != null
        assert Vehicle.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/vehicle/list'

        populateValidParams(params)
        def vehicle = new Vehicle(params)

        assert vehicle.save() != null

        params.id = vehicle.id

        def model = controller.show()

        assert model.vehicleInstance == vehicle
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/vehicle/list'

        populateValidParams(params)
        def vehicle = new Vehicle(params)

        assert vehicle.save() != null

        params.id = vehicle.id

        def model = controller.edit()

        assert model.vehicleInstance == vehicle
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/vehicle/list'

        response.reset()

        populateValidParams(params)
        def vehicle = new Vehicle(params)

        assert vehicle.save() != null

        // test invalid parameters in update
        params.id = vehicle.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/vehicle/edit"
        assert model.vehicleInstance != null

        vehicle.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/vehicle/show/$vehicle.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        vehicle.clearErrors()

        populateValidParams(params)
        params.id = vehicle.id
        params.version = -1
        controller.update()

        assert view == "/vehicle/edit"
        assert model.vehicleInstance != null
        assert model.vehicleInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/vehicle/list'

        response.reset()

        populateValidParams(params)
        def vehicle = new Vehicle(params)

        assert vehicle.save() != null
        assert Vehicle.count() == 1

        params.id = vehicle.id

        controller.delete()

        assert Vehicle.count() == 0
        assert Vehicle.get(vehicle.id) == null
        assert response.redirectedUrl == '/vehicle/list'
    }
}
