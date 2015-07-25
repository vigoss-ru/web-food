<!DOCTYPE html>
<html style="overflow: hidden;">
	<head>
		<%@ include file="/WEB-INF/jsp/includes.jsp"%>
	</head>

	<body>
		<div id="subMenuTotal">
			<div class="subDialogMain">
				<div style="height: 150px;">
					<img alt="" src="${sessionScope['STATIC_IMAGE_ROOT_PATH']}pizza_215.jpg" height="150px;" width="681px;">
				</div>
			</div>
			
			<div class="dialogMainMenu">
				<div class="dialogFirstRow">
					<div class="dialogMenuLeft">
						<div class="dialogMenuName"><c:out value="${menu.name}"/></div>
						<div class="dialogMenuDes"><c:out value="${menu.german_text}"/></div>
					</div>
					
					<div class="dialogMenuRight">
						<div class="dialogMenuName"><c:out value="${menu.price}"/> <tags:currency /></div>
					</div>
				</div>
				<div class="dialogDotted"></div>
				
				<div class="dialogSecondRow">
					<div class="dialogExtraFirst"><s:message code="dialog.menu.extra" /></div>
					<div class="dialogExtraSecond"></div>
					<div class="dialogExtraThird"></div>
				</div>
				
				<div class="dialogThirdRow">
					<span class="dlgBtnFirstCol"></span>
					<span class="dlgBtnSecCol" onclick="addSubToBasket('${menu.item_nr}','${menu.name}', ${menu.price});"><s:message code="dialog.basket.add" /></span>
					<span class="dlgBtnThirdCol"><label id="finalSubPrice"><c:out value="${menu.price}"/></label> <tags:currency /></span>
				</div>
				
			</div>
			
			
			<div class="dialogFourRow">
				<div class="dlgExtraText"><s:message code="dialog.extra.list" /></div>
				<c:forEach varStatus="status" var="subMenu" items="${subMenus}">
					<span class="dlgSubColFirst">
						<span class="dlgSubName" onclick="addSubMenu('${subMenu.name}', ${subMenu.price})"><c:out value="${subMenu.name}"/></span>
						<span class="dlgSubPrice"><c:out value="${subMenu.price}"/> <tags:currency /></span>
					</span>
					<c:if test='${(status.index+1)%3 ne 0}'>
						<span class="dlgSubColSpace"></span>
					</c:if>
				</c:forEach>
					
			</div>
		</div>
	</body>

	<script type="text/javascript">
		$(document).ready(function() {
			
		
		});
	</script>

</html>