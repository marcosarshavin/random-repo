Ext.define('LunaTechCode.view.tabpanel.query.AirportView',	{
	extend: 'Ext.container.Container',
	alias: 'widget.country_airports',
	requires: ['LunaTechCode.view.tabpanel.query.AirportInformation'],
	itemId: 'AirportView',
	initComponent: function()	{
		var me = this;
		me.layout = 'card';
		me.items = [
			
		];
		
		me.callParent(arguments);
	}
});