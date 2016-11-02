Ext.define('LunaTechCode.model.query.grid.RunwayGridInformation', {
    extend : 'Ext.data.Model',
    fields: [
    	{ name: 'airport_ref'},
    	{ name: 'airport_ident'},
    	{ name: 'length_ft'},
    	{ name: 'width_ft'},
    	{ name: 'surface'},
    	{ name: 'lighted'},
    	{ name: 'closed'},
    	{ name: 'le_ident'},
    	{ name: 'le_latitude_deg'},
    	{ name: 'le_longitude_deg'},
    	{ name: 'le_elevation_ft'},
    	{ name: 'le_heading_degT'},
    	{ name: 'le_displaced_threshold_ft'},
    	{ name: 'he_ident'},
    	{ name: 'he_latitude_deg'},
    	{ name: 'he_longitude_deg'},
    	{ name: 'he_elevation_ft'},
    	{ name: 'he_heading_degT'},
    	{ name: 'he_displaced_threshold_ft'}
    ]
});