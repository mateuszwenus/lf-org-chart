<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<liferay-util:html-top>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.hotkeys.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jstree.js"></script>
</liferay-util:html-top>

<portlet:defineObjects />

<table>
	<tr>
	<td style="width: 45%"><div id="<portlet:namespace />tree" style="min-height:100px;"></div></td>
	<td style="width: 5%"></td>
	<td style="width: 50%"><div id="<portlet:namespace />nodeDetails"></div></td>
	</tr>
</table>

<script type="text/javascript">
$(document).ready(function() {

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
						type : data.attr("rel"),
						id : data.attr("id")
					};
				},
				url : function(data) {
					return "<portlet:resourceURL id='loadChildren' />";
				}, 
				success : function(data) {
					var result = [];
					for (var i = 0; i < data.length; i++) {
						result.push({
							data : data[i].name,
							attr : {
								id : data[i].pk,
								rel : data[i].type
							},
							state : "closed"
						});
					}
					return result;
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
	$("#<portlet:namespace />tree").jstree(treeData);
});
</script>
