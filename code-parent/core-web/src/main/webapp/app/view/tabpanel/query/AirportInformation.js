Ext.define('LunaTechCode.view.tabpanel.query.AirportInformation',	{
	extend: 'Ext.container.Container',
	alias: 'widget.airport_information',
	initComponent: function()	{
		var me = this;
		me.items = [
//			{
//				xtype: 'container',
//				items: [
				{
					title: 'Airport',
					xtype: 'grid',
					columns: [
						{text: 'ident', dataIndex: 'ident'},
						{text: 'type', dataIndex: 'type'},
						{text: 'name', dataIndex: 'name'},
						{text: 'latitude_deg', dataIndex: 'latitude_deg'},
						{text: 'longitude_deg', dataIndex: 'longitude_deg'},
						{text: 'elevation_ft', dataIndex: 'elevation_ft'},
						{text: 'continent', dataIndex: 'continent'},
						{text: 'iso_country', dataIndex: 'iso_country'},
						{text: 'iso_region', dataIndex: 'iso_region'},
						{text: 'municipality', dataIndex: 'municipality'},
						{text: 'scheduled_service', dataIndex: 'scheduled_service'},
						{text: 'gps_code', dataIndex: 'gps_code'},
						{text: 'iata_code', dataIndex: 'iata_code'},
						{text: 'local_code', dataIndex: 'local_code'},
						{text: 'home_link', dataIndex: 'home_link'},
						{text: 'wikipedia_link', dataIndex: 'wikipedia_link'},
						{text: 'keywords', dataIndex: 'keywords'}

					]
				},
				{
					title: 'Runways',
					xtype: 'grid',	
					columns: [
						{text: 'airport_ref', dataIndex: 'airport_ref'},
						{text: 'airport_ident', dataIndex: 'airport_ident'},
						{text: 'length_ft', dataIndex: 'length_ft'},
						{text: 'width_ft', dataIndex: 'width_ft'},
						{text: 'surface', dataIndex: 'surface'},
						{text: 'lighted', dataIndex: 'lighted'},
						{text: 'closed', dataIndex: 'closed'},
						{text: 'le_ident', dataIndex: 'le_ident'},
						{text: 'le_latitude_deg', dataIndex: 'le_latitude_deg'},
						{text: 'le_longitude_deg', dataIndex: 'le_longitude_deg'},
						{text: 'le_elevation_ft', dataIndex: 'le_elevation_ft'},
						{text: 'le_heading_degT', dataIndex: 'le_heading_degT'},
						{text: 'le_displaced_threshold_ft', dataIndex: 'le_displaced_threshold_ft'},
						{text: 'he_ident', dataIndex: 'he_ident'},
						{text: 'he_latitude_deg', dataIndex: 'he_latitude_deg'},
						{text: 'he_longitude_deg', dataIndex: 'he_longitude_deg'},
						{text: 'he_elevation_ft', dataIndex: 'he_elevation_ft'},
						{text: 'he_heading_degT', dataIndex: 'he_heading_degT'},
						{text: 'he_displaced_threshold_ft', dataIndex: 'he_displaced_threshold_ft'}
					]
				},
				{
					xtype: 'panel',
					layout:	{
						type: 'hbox'
					},
					items: [
						{
							xtype: 'button',
							text: 'Previous Airport',
							handler: function()	{
								Ext.getBody().mask('Loading...');
								this.fireEvent('goToPreviousAirport');								
							}
						},
						{
							xtype: 'button',
							text: 'Next Airport',
							handler: function()	{
								Ext.getBody().mask('Loading...');
								this.fireEvent('goToNextAirport');								
							}
						}
					]
				}
		];
		
		me.callParent(arguments);
	}
});