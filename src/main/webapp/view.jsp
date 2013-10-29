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
						id : data.attr("data-id")
					};
				},
				url : function(data) {
					return "<portlet:resourceURL id='loadChildren' />";
				}
			}
		},
		ui : {
			select_limit : 1,
			initially_select : []
		},
		plugins : [ "themes", "json_data", "ui", "types" ]
	};
	$("#<portlet:namespace />tree").jstree(treeData);
});
</script>
