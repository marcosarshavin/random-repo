Ext.define('LunaTechCode.view.tabpanel.EntityViewport', {
	extend: 'Ext.tab.Panel',
	alias: 'widget.mainview_tabpanel',
	requires: ['LunaTechCode.view.tabpanel.query.QueryView', 'LunaTechCode.view.tabpanel.report.ReportView'],
	initComponent: function()	{
		var me = this;

		me.height = '100%';
        me.activeTab = 0;
		me.items =	[
			{
				title: 'Query',
                xtype: 'query'
            },
            {
            	title: 'Report',
            	xtype: 'report'            	
           	}
    	];
		
		me.callParent(arguments);
	}
});