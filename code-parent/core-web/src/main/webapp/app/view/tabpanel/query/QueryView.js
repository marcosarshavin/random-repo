Ext.define('LunaTechCode.view.tabpanel.query.QueryView',	{
	extend: 'Ext.Panel',
	alias: 'widget.query',
	itemId: 'queryview',
	requires: ['LunaTechCode.view.tabpanel.query.AirportView', 'LunaTechCode.store.query.CountryCombo'],
	initComponent: function()	{
		var me = this;
		
		me.items = [
			{
				xtype: 'form',
				border:	false,
				items:[
					{
						xtype: 'combo',
						fieldLabel: 'Country Code',		
						name: 'countryCode',
						store: Ext.create('LunaTechCode.store.query.CountryCombo'),
						valueField: 'countryCode',
						displayField: 'countryCode',
					}, 
					{
						xtype: 'textfield',
						fieldLabel: 'Country',
						name: 'country'
					}, 
					{
						xtype: 'button',	
						text: 'Reset',
						handler: function ()	{
							this.up('form').getForm().reset();
						}
					},
					{
						xtype: 'button',
						text: 'Save',
						handler: function ()	{
							this.fireEvent('getCountryAirportsAndRunways', this.up('form').getForm());
						}
					}	
				]
			},
			{
				xtype: 'country_airports'
			}
		];
		
		me.callParent(arguments);
	}
})