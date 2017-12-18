package hackovationselproj

import grails.converters.JSON;
import groovy.json.JsonOutput

class ReportController {
	def reportGraph(){
		//render 'graph'
	}

	def reportGraph_1(){
	//render 'graph'
}
	def reportGraphData(){
		def vehs = Vehicle.list()
		def json = [:]

		json['Data_title'] = 'Vehicle sell details'
		json['highlight'] = ['columns':'Quantity']

		def data = [:]



		vehs.each{
			def makerCode = it.vehMaker.makerCode
			def val = data."$makerCode"
			println makerCode
			println val
			if(val){
				data."$makerCode" = ++val
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

		def jsonTxt = JsonOutput.toJson(json)
		println jsonTxt
		
		render json as JSON
	}
	
	def reportGrid(){
	//render 'graph'
	}
	
	def reportExtGridData(){
		def contacts = Contact.list()
		
		render contacts as JSON
	}
}
