Ext.define('LunaTechCode.view.header.EntityViewport',	{
    extend: 'Ext.container.Container',
	alias: 'widget.mainview_header',
	initComponent: function()	{
		var me = this;
		me.items =	[
			{
				xtype: 'image',
   				width: 200,
   				heigth: 100,
   				src: 'resources/images/airplane.png'
    		},
    		{
    			xtype: 'panel',
   				html: '<h1>Airport and Runway Information</h1>'
    		}
    	];
		
		me.callParent(arguments);
	}
});