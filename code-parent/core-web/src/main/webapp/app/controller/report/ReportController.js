Ext.define('LunaTechCode.controller.report.ReportController', {
	extend: 'Ext.app.Controller',
	views: ['LunaTechCode.view.tabpanel.report.ReportView'],
	stores: ['LunaTechCode.store.report.AirportCountryBiggest'],
	models: ['LunaTechCode.model.report.AirportCountry'],
	init : function() {
		var me = this;
		console.log('Initializing ' + me.self.getName() + ' listeners');
        me.control({
        	'report' : {
        		afterrender: me.loadReportData
            }
        });
	},
	loadReportData: function()	{
		var me = this;
		
		Ext.getBody().mask('Loading...');
		
		var store = me.getLunaTechCodeStoreReportAirportCountryBiggestStore();
		
		store.load({
			callback: function (records, operation, success) {
				Ext.getBody().unmask();
				if (success)	{
					var biggestNumberOfAirportsGrid = Ext.ComponentQuery.query('#reportview')[0]
						.down('grid[title=Countries with the Biggest Number of Airports]');
					var lowestNumberOfAirportsGrid = Ext.ComponentQuery.query('#reportview')[0]
						.down('grid[title=Countries with the Lowest Number of Airports]');
					
					var biggestNumberOfAirportsStore = Ext.create('Ext.data.Store',	{
						model: 'LunaTechCode.model.report.AirportCountry'
					});
					
					var lowestNumberOfAirportsStore = Ext.create('Ext.data.Store',	{
						model: 'LunaTechCode.model.report.AirportCountry'
					});
					
					var maximum = records.length > 10 ? 10 : records.length;
					
					for (var index = 0; index < maximum; index++)	{
						biggestNumberOfAirportsStore.add(records[records.length - 1 - index]);
						lowestNumberOfAirportsStore.add(records[0 + index]);
					}
					
					biggestNumberOfAirportsGrid.reconfigure(biggestNumberOfAirportsStore);
					lowestNumberOfAirportsGrid.reconfigure(lowestNumberOfAirportsStore);
					
				} else {
					console.log('Error try again');
				}
			}
		});
		
	}
	
});