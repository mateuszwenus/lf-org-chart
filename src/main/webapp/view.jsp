<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<liferay-util:html-top>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jstree.js"></script>
    <script type="text/javascript">
    $(document).ready(function($) {

    	var nodeType = function(icon, validChildren) {
    		return {
    			valid_children : validChildren,
    			icon : {
    				image : iconPath(icon)
    			}
    		};
    	};
    	
    	var iconPath = function(icon) {
    		return "/lf-org-chart/img/16/" + icon;
    	};
    	
    	var showNodeDetails = function(node) {
    		var req = {
    			id : node.attr("id"),
    			type : node.attr("rel")
    		};
    		$.post("<portlet:resourceURL id='nodeDetails' />", req, function(data) {
    			$("#<portlet:namespace />nodeDetails").html(data);
    		});
    	};

    	var treeData = {
    		json_data : {
    			data : {
    				"data" : "ROOT_COMMUNITIES",
    				"attr" : { id : "root", rel : "ROOT_COMMUNITIES"},
    				"state" : "closed"
    			},
    			ajax : {
    				data : function(data) {
    					return {
    						"<portlet:namespace />id" : data.attr("id"),
    						"<portlet:namespace />type" : data.attr("rel")
    					};
    				},
    				url : function(data) {
    					return "<portlet:resourceURL id='loadChildren' />";
    				}, 
    				success : function(data) {
    					return $.map(data, function(item) {
    						return {
    							data : item.name,
    							attr : {
    								id : item.pk,
    								rel : item.type
    							},
    							state : "closed"
    						};
    					});
    				}
    			}
    		},
    		ui : {
    			select_limit : 1,
    			initially_select : []
    		},
    		types : {
    			types : {
    				ROOT_COMMUNITIES : nodeType("database.png", [ "COMMUNITY" ]), 
    				COMMUNITY : nodeType("home.png", [ "ORGANISATION", "USER_GROUP", "TEAM", "USER" ]),
    				ORGANISATION : nodeType("sitemap.png", [ "ORGANISATION", "TEAM", "USER" ]),
    				USER_GROUP : nodeType("customers.png", [ "USER" ]),
    				TEAM : nodeType("customers.png", [ "USER" ]),
    				USER : nodeType("user.png", [])
    			}
    		},
    		plugins : [ "themes", "json_data", "ui", "types" ]
    	};
    	$("#<portlet:namespace />tree").jstree(treeData).bind("select_node.jstree", function(e, data) {
    		showNodeDetails(data.rslt.obj);
    	});
    });
    $.noConflict(true);
    </script>
</liferay-util:html-top>

<table>
	<tr>
	<td style="width: 45%"><div id="<portlet:namespace />tree" style="min-height:100px;"></div></td>
	<td style="width: 5%"></td>
	<td style="width: 50%"><div id="<portlet:namespace />nodeDetails"></div></td>
	</tr>
</table>
