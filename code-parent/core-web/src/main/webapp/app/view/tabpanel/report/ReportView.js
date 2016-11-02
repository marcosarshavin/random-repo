Ext.define('LunaTechCode.view.tabpanel.report.ReportView',	{
	extend: 'Ext.Panel',
	alias: 'widget.report',
	itemId: 'reportview',
	requires: ['LunaTechCode.store.report.AirportCountryBiggest', 'LunaTechCode.store.report.AirportCountryLowest'],
	initComponent: function()	{
		var me = this;
		
		me.items = [
			{
				title: 'Countries with the Biggest Number of Airports',
				xtype: 'grid',	
				columns: [
					{text: 'Country Code', dataIndex: 'countryCode'},
					{text: 'Country Name', dataIndex: 'countryName'},
					{text: 'Number of Airports', dataIndex: 'numberOfAirports'}
				]
			},
			{
				title: 'Countries with the Lowest Number of Airports',
				xtype: 'grid',
				columns: [
					{text: 'Country Code', dataIndex: 'countryCode'},
					{text: 'Country Name', dataIndex: 'countryName'},
					{text: 'Number of Airports', dataIndex: 'numberOfAirports'}
				]
			}
		];
		
		me.callParent(arguments);
	}
})