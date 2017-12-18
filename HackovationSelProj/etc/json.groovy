import hackovationselproj.*
import groovy.json.JsonOutput

//println Registration.list()
def vehs = Vehicle.list()
def json = [:]

json['Data_title'] = 'Vehicle sell details'
json['highlight'] = ['columns':'Quantity']

def data = [:]



vehs.each{
    def makerCode = it.vehMaker.makerCode 
    println makerCode
    def val = data."$makerCode"
    if(val){
        data."$makerCode" = val++
    }else{
        data."$makerCode" = 1
    }
}
def dataForJson = []
data.each{
    dataForJson.add(['BrandName':it.key,'Quantity':it.value])
}
json['totalCount'] = vehs.size()
json['data'] = dataForJson 

println json
def jsonTxt = JsonOutput.toJson(json)
println jsonTxt