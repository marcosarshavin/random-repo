Ext.define('LunaTechCode.store.query.AirportInformation', {
    extend : 'Ext.data.Store',
    requires: 'LunaTechCode.model.query.AirportInformation',
    model: 'LunaTechCode.model.query.AirportInformation',
    proxy : {
        type : 'ajax',
        timeout: '180000',
        url: 'airports',
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