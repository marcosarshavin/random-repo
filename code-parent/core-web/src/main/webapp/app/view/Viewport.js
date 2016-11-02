Ext.define('LunaTechCode.view.Viewport', {

    extend: 'Ext.container.Viewport',

    uses:	[
    	'LunaTechCode.view.header.EntityViewport',
    	'LunaTechCode.view.tabpanel.EntityViewport'
    ],
    
    initComponent: function(){

        Ext.apply(this, {
            id: 'app-viewport',
            items: [
            	{
 	               	region: 'north',
 	               	xtype: 'mainview_header'
             	},
            	{
	               region: 'center',
	               xtype: 'mainview_tabpanel'
            	}
            ]
        });
        
        this.callParent(arguments);
    }
});