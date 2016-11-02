Ext.define('LunaTechCode.controller.query.QueryController', {
	extend: 'Ext.app.Controller',
	views: ['LunaTechCode.view.tabpanel.query.QueryView'],
	stores: ['LunaTechCode.store.query.AirportInformation', 'LunaTechCode.view.tabpanel.query.AirportInformation'],
	models: ['LunaTechCode.model.query.grid.AirportGridInformation', 'LunaTechCode.model.query.grid.RunwayGridInformation'],
	airports: [],
	init : function() {
		var me = this;
		console.log('Initializing ' + me.self.getName() + ' listeners');
        me.control({
        	'query form button' : {
        		getCountryAirportsAndRunways: me.manageEvent
            },
            'country_airports airport_information panel button'	:	{
            	goToPreviousAirport: me.goToPreviousAirport,
            	goToNextAirport: me.goToNextAirport
            }
        });
	},
	manageEvent: function(form)	{
		console.log("Getting Airport and Runway information", form.getFieldValues());
		var me = this;
		var store = me.getLunaTechCodeStoreQueryAirportInformationStore();	
		Ext.getBody().mask('Loading...');

		store.read(
				{
					params: {
						country: form.getFieldValues().country,
						countryCode: form.getFieldValues().countryCode
					},
					callback: function (records, operation, success) {
						Ext.getBody().unmask();
						if (success)	{							
							Ext.ComponentQuery.query('#AirportView')[0].removeAll();
							
							//	Put Airport and Runways Info 
							me.putAiportInfo(records[0].data, 0);
							Ext.ComponentQuery.query('#AirportView')[0].getLayout().setActiveItem(0);
							me.airports = records;
								
						} else {
							console.log('Error try again');
						}
					}
				}
		);
	},
	
	putAiportInfo: function (airport, index)	{
		
		var airportAndRunwayInformation = Ext.create('LunaTechCode.view.tabpanel.query.AirportInformation');
		airportAndRunwayInformation.index = index;
		
		//Put Airport Info
		var airportStore = Ext.create('Ext.data.Store',	{
			model: 'LunaTechCode.model.query.grid.AirportGridInformation'
		});
		
		airportAndRunwayInformation.down('grid[title=Airport]').reconfigure(airportStore);
			
		var model = Ext.create('LunaTechCode.model.query.grid.AirportGridInformation');
		
		model.data.ident = airport.ident;
		model.data.type = airport.type;
		model.data.name = airport.name;
		model.data.latitude_deg = airport.latitude_deg;
		model.data.longitude_deg = airport.longitude_deg; 
		model.data.elevation_ft = airport.elevation_ft; 
		model.data.continent = airport.continent; 
		model.data.iso_country = airport.iso_country; 
		model.data.iso_region = airport.iso_region; 
		model.data.municipality = airport.municipality; 
		model.data.scheduled_service = airport.scheduled_service; 
		model.data.gps_code = airport.gps_code; 
		model.data.iata_code = airport.iata_code; 
		model.data.local_code = airport.local_code; 
		model.data.home_link = airport.home_link; 
		model.data.wikipedia_link = airport.wikipedia_link; 
		model.data.keywords = airport.keywords; 
		
		airportStore.add(model);

		//Put Runways Info
		var runwaysStore = Ext.create('Ext.data.Store',	{
			model: 'LunaTechCode.model.query.grid.RunwayGridInformation'
		});
		
		airportAndRunwayInformation.down('grid[title=Runways]').reconfigure(runwaysStore);
		
		for (var runwayIndex = 0; runwayIndex < airport.runwayInformation.length; runwayIndex++)	{
			var runway = airport.runwayInformation[runwayIndex];	
			var model = Ext.create('LunaTechCode.model.query.grid.RunwayGridInformation');
		
			model.data.airport_ref = runway.airport_ref;
			model.data.airport_ident = runway.airport_ident;
			model.data.length_ft = runway.length_ft; 
			model.data.width_ft = runway.width_ft; 
			model.data.surface = runway.surface; 
			model.data.lighted = runway.lighted; 
			model.data.closed = runway.closed; 
			model.data.le_ident = runway.le_ident; 
			model.data.le_latitude_deg = runway.le_latitude_deg; 
			model.data.le_longitude_deg = runway.le_longitude_deg; 
			model.data.le_elevation_ft = runway.le_elevation_ft; 
			model.data.le_heading_degT = runway.le_heading_degT; 
			model.data.le_displaced_threshold_ft = runway.le_displaced_threshold_ft; 
			model.data.he_ident = runway.he_ident; 
			model.data.he_latitude_deg = runway.he_latitude_deg; 
			model.data.he_longitude_deg = runway.he_longitude_deg; 
			model.data.he_elevation_ft = runway.he_elevation_ft; 
			model.data.he_heading_degT = runway.he_heading_degT; 
			model.data.he_displaced_threshold_ft = runway.he_displaced_threshold_ft; 
			
			runwaysStore.add(model);
		}
		
		//Add item to view
		Ext.ComponentQuery.query('#AirportView')[0].items.add(airportAndRunwayInformation);
	},
	
	goToPreviousAirport: function ()	{
		var me = this;

		var airportViewLayout = Ext.ComponentQuery.query('#AirportView')[0].getLayout();
		var numberOfCards = me.airports.length;
		var activeCard = airportViewLayout.getActiveItem().index;
		var nextCard = activeCard - 1 == -1 ? numberOfCards - 1: activeCard -1;
		
		me.changeLayout(nextCard);
		Ext.getBody().unmask();
	},
	
	goToNextAirport: function()	{
		var me = this;
		
		var airportViewLayout = Ext.ComponentQuery.query('#AirportView')[0].getLayout();
		var numberOfCards = me.airports.length;
		var activeCard = airportViewLayout.getActiveItem().index;
		var nextCard = activeCard + 1 == numberOfCards ? 0 : activeCard + 1;
		
		me.changeLayout(nextCard);
		Ext.getBody().unmask();
	},
	
	changeLayout: function(nextCard)	{
		var me = this;
		
		var airport = me.airports[nextCard];
		me.putAiportInfo(airport.data, nextCard);
		Ext.ComponentQuery.query('#AirportView')[0].getLayout().setActiveItem(nextCard);
	}
	
});