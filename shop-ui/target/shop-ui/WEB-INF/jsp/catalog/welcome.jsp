<!DOCTYPE html>
<%@page import="java.util.Enumeration"%>
<html style="overflow-y: scroll;">
	<head>
		<%@ include file="/WEB-INF/jsp/includes.jsp"%>
	</head>
	
	<body>
	
	
		<%
	             out.println(session.getId());
	    %>
	
		<div class="center">
			<div class="firstCenter">
				<div class="firstBgr"></div>
				
				<div class="firstHead">
					<span class="txtFirstHead">Pizza Special</span>
				</div>
				
				<div>
					<c:if test="${not empty mainMenus}">
						<c:forEach varStatus="status" var="menu" items="${mainMenus}">
							<c:choose>
								<c:when test='${(status.index)%2 eq 0}'>
									<div class="oddRow">
										<div class="oddFirstText">
											<span><c:out value="${menu.name}"/></span>
											<div class="oddFirstPrice" id="price_${menu.item_nr}" onclick="addToBasket('${menu.name}', '${menu.price}', '${menu.item_nr}', ${menu.sub_number});">
												<c:out value="${menu.price}"/> <tags:currency />
											</div>
										</div>
										<div class="oddSecondText"><c:out value="${menu.german_text}"/></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="evenRow">
										<div class="oddFirstText">
											<span><c:out value="${menu.name}"/></span>
											<div class="oddFirstPrice" id="price_${menu.item_nr}" onclick="addToBasket('${menu.name}', '${menu.price}', '${menu.item_nr}', ${menu.sub_number});">
												<c:out value="${menu.price}"/> <tags:currency />
											</div>
										</div>
										<div class="oddSecondText"><c:out value="${menu.german_text}"/></div>
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</div>
			</div>
			
			<div class="secondCenter">
				<div class="cartText">Warenkorb</div>
				<div class="bigShopCart">
					<div id="basketContent">
					
						<%-- <div class="rowCart">
							<div>
								<span class="smallCartText">Pizza Kentucky Classic</span>
								<span class="smallCartPrice">9.90 <tags:currency /></span>
							</div>
							
							<div class="subMenuRow">
								<span class="smallSubName">+ Tofu</span>
								<span class="smallSubPrice">1.50 <tags:currency /></span>
							</div>
							
							<div class="subMenuRow">
								<span class="smallSubName">+ Spicy</span>
								<span class="smallSubPrice">2.50 <tags:currency /></span>
							</div>
							
							<div>
								<span class="smallCartText">
									<span class="addArticle">+</span>
									<span class="removeArticle">-</span>
								</span>
								<span class="smallCartPriceTotal">9.90 <tags:currency /></span>
							</div>
						</div>
						<div class="cartRowSplit"></div>
						
						<div class="rowCart">
							<div>
								<span class="smallCartText">Pizza Kentucky Classic</span>
								<span class="smallCartPrice">9.90 <tags:currency /></span>
							</div>
							<div>
								<span class="smallCartText"></span>
								<span class="smallCartPriceTotal">9.90 <tags:currency /></span>
							</div>
						</div>
						<div class="cartRowSplit"></div>--%>
					</div>
					
					<div id="summaryBlock">
						<span class="summaryText">Summe</span>
						<span class="summaryPrice" id="priceSummary">0.00 </span><tags:currency />
					</div>
					
					<div class="warnMinPrice">
						<div class="first"></div>
						<div class="second">
							<div class="minPriceText">
								<s:message code="warning.minprice.text1" />
								<span id="realMinPrice">10.00 <tags:currency /></span> 
								<s:message code="warning.minprice.text2" /><s:message code="warning.minprice.text3" />
							</div>
						</div>
						<div class="last"></div>
					</div>
					
					<div class="orderBlock">
						<span class="btnOrder">
							<s:message code="button.order.text" /> <span id="btnOrderPrice">0.00</span> <tags:currency />
						</span>
					</div>
					
					<div class="customerInfo">
						<form id="custRegistration" name="custRegistration">
							<div class="regLine">
								<span class="regColumnLeft">
									<label><s:message code="register.customer.company"/></label>
									<input type="text" name="company" id="company">
								</span>
								
								<span class="regColumnRight">
									<label><s:message code="register.customer.department"/></label>
									<input type="text" name="department" id="department">
								</span>
							</div>
							
							<div class="regLine">
								<span>
									<input type="radio" name="sex" value="1"><label><s:message code="register.customer.male"/></label>
								</span>
								<span>
									<input type="radio" name="sex" value="0"><label><s:message code="register.customer.female"/></label>
								</span>
							</div>
							
							<div class="regLine">
								<span class="regColumnLeft">
									<label><s:message code="register.customer.firstname"/><font color="red">*</font></label>
									<input type="text" name="firstname" id="firstname">
								</span>
								
								<span class="regColumnRight">
									<label><s:message code="register.customer.lastname"/><font color="red">*</font></label>
									<input type="text" name="lastname" id="lastname">
								</span>
							</div>
							
							<div class="regLine">
								<span class="regColumnLeft regColLong">
									<label><s:message code="register.customer.street"/><font color="red">*</font></label>
									<input type="text" name="street" id="street" style="width: 194px;">
								</span>
								
								<span class="regColumnRight regColShort">
									<label><s:message code="register.customer.number"/><font color="red">*</font></label>
									<input type="text" name="strNumber" id="strNumber" style="width: 80px;">
								</span>
							</div>
							
							
							<div class="regLine">
								<span class="regColumnLeft regColShort">
									<label><s:message code="register.customer.plz"/><font color="red">*</font></label>
									<input type="text" name="plz" id="plz" style="width: 80px;">
								</span>
								
								<span class="regColumnRight regColLong">
									<label><s:message code="register.customer.city"/><font color="red">*</font></label>
									<input type="text" name="city" id="city" style="width: 194px;">
								</span>
							</div>
							
							<div class="regLine">
								<span class="singleColumn">
									<label><s:message code="register.customer.note"/></label>
									<textarea name="note" id="note" cols="33" rows="2"></textarea>
								</span>
							</div>
							
							<div class="regLine">
								<span class="regColumnLeft regColShort">
									<label><s:message code="register.customer.prefix"/><font color="red">*</font></label>
									<input type="text" name="prefix" id="prefix" style="width: 80px;">
								</span>
								
								<span class="regColumnRight regColLong">
									<label><s:message code="register.customer.telephone"/><font color="red">*</font></label>
									<input type="text" name="telephone" id="telephone" style="width: 194px;">
								</span>
							</div>
							
							<div class="regLine">
								<span class="singleColumn" style="width: 287px;">
									<label><s:message code="register.customer.email"/></label>
									<input type="text" name="email" id="email" style="width: 287px;">
								</span>
							</div>
							
							<div class="regLine">
								<span class="singleColumn">
									<label><s:message code="register.customer.delivery"/></label>
									<textarea name="note" id="note" cols="33" rows="2"></textarea>
								</span>
							</div>
							
							<div class="regLine">
								<font color="red" style="margin-left: 18px;">*</font> <s:message code="register.customer.require"/>
							</div>
							
						</form>
					</div>
					
				</div>
			</div>
			<input type="hidden" id="basket_sequence_id">
		</div>
		
	</body>
	
</html> 

