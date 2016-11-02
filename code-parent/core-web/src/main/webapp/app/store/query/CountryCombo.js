Ext.define('LunaTechCode.store.query.CountryCombo', {
    extend : 'Ext.data.Store',
    requires: 'LunaTechCode.model.query.CountryCombo',
    model: 'LunaTechCode.model.query.CountryCombo',
    autoload: true,
    proxy : {
        type : 'ajax',
        url: 'countries',
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