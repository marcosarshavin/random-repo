Ext.define('LunaTechCode.model.query.grid.AirportGridInformation', {
    extend : 'Ext.data.Model',
    fields: [
    	{ name: 'ident'},
    	{ name: 'type'},
    	{ name: 'name'},
    	{ name: 'latitude_deg'},
    	{ name: 'longitude_deg'},
    	{ name: 'elevation_ft'},
    	{ name: 'continent'},
    	{ name: 'iso_country'},
    	{ name: 'iso_region'},
    	{ name: 'municipality'},
    	{ name: 'scheduled_service'},
    	{ name: 'gps_code'},
    	{ name: 'iata_code'},
    	{ name: 'local_code'},
    	{ name: 'home_link'},
    	{ name: 'wikipedia_link'},
    	{ name: 'keywords'}
    ]
});