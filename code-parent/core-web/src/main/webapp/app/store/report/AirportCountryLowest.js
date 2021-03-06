Ext.define('LunaTechCode.store.report.AirportCountryLowest', {
    extend : 'Ext.data.Store',
    requires: 'LunaTechCode.model.report.AirportCountry',
    model: 'LunaTechCode.model.report.AirportCountry',
    autoload: true,
    proxy : {
        type : 'ajax',
        timeout: '180000',
        url: 'airports/lowestNumberOfAirports',
        actionMethods: {
	        create: 'POST',
	        criteria: 'POST',
	        destroy: 'DELETE',
	        read: 'GET',
	        update: 'PUT'
	    },
	    reader: {
	        messageProperty: 'info',
	        root: 'data',
	        successProperty: 'success',
	        totalProperty: 'totalCount',
	        type: 'json'
	    }
    }
});