

	function addToBasket(text, price, item_nr, sub_nr) {
		if(sub_nr>0){
			openFancyBox(item_nr);
		}else{
			appendText(text, price);
		}
	}
	
	function openFancyBox(item_nr){
		
		$.fancybox.open({
			href : getContextPath()+'/menu/submenu.htm?item_nr='+item_nr,
			type : 'ajax',
			padding: 0,
	        fitToView: false,
	        autoSize: false,
	        width: 690,
	        'height': 'auto',
	        afterLoad:function(){
	        	
	        }
		});
		$('.fancybox-lock').css('overflow','hidden');
		$('.fancybox-lock body').css('overflow','hidden');

	}
	
	
	function appendText(text, price) {
		
		var sub_arr = new Array();
		sub_arr.push(name);
		sub_arr.push(price);
		var arr_basket = $("#basket_sequence_id").val();
		arr_basket.push(sub_arr);
		$("#basket_sequence_id").val(arr_basket);
		var id = arr_basket.length-1;
		
		var strApp;
		strApp = '<div class="rowCart" id=basket_item_'+id+'">';
		strApp += '<div><span class="smallCartText">'+text+'</span>';
		strApp += '<span class="smallCartPrice">'+price+' €</span></div>';
		strApp += '<div><span class="smallCartText"><span class="addArticle">+</span>';
		strApp += '<span class="removeArticle">-</span></span>';
		strApp += '<span class="smallCartPriceTotal">'+price+' €</span></div>';
		strApp += '</div><div class="cartRowSplit"></div>';
		$("#basketContent").append(strApp);
		var currPrice = parseFloat($("#priceSummary").html());
		var finalPrice = (currPrice+parseFloat(price)).toFixed(2);
		$("#priceSummary").html(finalPrice);
		$("#btnOrderPrice").html(finalPrice);
		
	
		
	}
	
	