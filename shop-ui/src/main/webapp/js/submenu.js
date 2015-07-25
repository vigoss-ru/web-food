	var textHeight=0;
	var subNum = 0;
	var subNames = new Array();
	var strToDiv = '';
	
	function addSubMenu (name, price){
		// append name of submenu to div
		var sub_arr = new Array();
		sub_arr.push(name);
		sub_arr.push(price);
		subNames.push(sub_arr);
		var textSub = $('.dialogExtraSecond').html();
		if( textSub == ''){
			subNum = 0;
			$('.dialogExtraSecond').append('<a href="#" id="aSub_'+subNum+'" onclick="removeSubMenu('+subNum+', '+price+')">'+name+'</a>');
			textHeight = $('.dialogExtraSecond').height();
		}else{
			subNum++;
			$('.dialogExtraSecond').append('<span id="aSub_'+subNum+'">, <a href="#"  onclick="removeSubMenu('+subNum+','+price+')">'+name+'</a></span>');
		}
	
		var currHeight = $('.dialogExtraSecond').height();
		if(currHeight > textHeight){
			var fancyHeight = $('.fancybox-skin').height()+(currHeight-textHeight);
			textHeight = currHeight;
			
			$('.fancybox-skin').height(fancyHeight);
			$('.fancybox-inner').height(fancyHeight);
			$('.fancybox-inner').css('overflow','hidden');
		}
		
		// calculate the total sub menu price
		var currPrice = parseFloat($('#finalSubPrice').html());
		var finalPrice = (currPrice+parseFloat(price)).toFixed(2);
		$('#finalSubPrice').html(finalPrice);
		
	
	}
	
	function removeSubMenu (id, price){
		// remove name of submenu from div 
		if(subNames.length == 1){
			$('.dialogExtraSecond').html('');
			subNames.length = 0;
		}else{
			subNames.splice(id,1);
			for(var i=0;i<subNames.length;i++){
				if(i==0){
					strToDiv = '<a href="#" id="aSub_'+i+'" onclick="removeSubMenu('+i+', '+subNames[i][1]+')">'+subNames[i][0]+'</a>';
				}else{
					strToDiv += '<span id="aSub_'+i+'">, <a href="#"  onclick="removeSubMenu('+i+', '+subNames[i][1]+')">'+subNames[i][0]+'</a></span>';
				}
			}
			$('.dialogExtraSecond').html(strToDiv);
			var currHeight = $('.dialogExtraSecond').height();
			if(textHeight > currHeight) {
				var fancyHeight = $('.fancybox-skin').height()-(textHeight-currHeight);
				textHeight = currHeight;
				
				$('.fancybox-skin').height(fancyHeight);
				$('.fancybox-inner').height(fancyHeight);
				$('.fancybox-inner').css('overflow','hidden');
			}
		}
		
		// calculate the total sub menu price
		var currPrice = parseFloat($('#finalSubPrice').html());
		var finalPrice = (currPrice-parseFloat(price)).toFixed(2);
		$('#finalSubPrice').html(finalPrice);
	}
	
	function addSubToBasket(subId, text, price){
	
		var arr_basket = $("#basket_sequence_id").val();
		arr_basket.push(subNames);
		$("#basket_sequence_id").val(arr_basket);
		var id = arr_basket.length-1;
		
		price = parseFloat(price).toFixed(2);
		var strApp;
		strApp = '<div class="rowCart" id="basket_item_'+id+'">';
		strApp += '<div><span class="smallCartText">'+text+'</span>';
		strApp += '<span class="smallCartPrice">'+price+' €</span></div>';
		
		// add submenu
		for(var i=0;i<subNames.length;i++){
			strApp += '<div class="subMenuRow">';
			strApp += '<span class="smallSubName">+ '+subNames[i][0]+' </span>';
			strApp += '<span class="smallSubPrice">'+parseFloat(subNames[i][1]).toFixed(2)+' €</span>';
			strApp += '</div>';
			price = parseFloat(price) + parseFloat(subNames[i][1]);
		}
		
		price = parseFloat(price).toFixed(2);
		
		strApp += '<div><span class="smallCartText"><span class="addArticle">+</span>';
		strApp += '<span class="removeArticle">-</span><span class="extraArticle" onclick="openFancyBox('+subId+')">Extras</span></span>';
		strApp += '<span class="smallCartPriceTotal">'+price+' €</span></div>';
		strApp += '</div><div class="cartRowSplit"></div>';
		$("#basketContent").append(strApp);
		var currPrice = parseFloat($("#priceSummary").html());
		var finalPrice = (currPrice+parseFloat(price)).toFixed(2);
		$("#priceSummary").html(finalPrice);
		$("#btnOrderPrice").html(finalPrice);
		
		
		setTimeout(function (){$('.fancybox-overlay').remove();}, 500);
		$('.fancybox-overlay').hide('slow');
		$('.fancybox-lock').css('overflow','scroll');
		//$('.fancybox-lock body').css('overflow-y','scroll');
	}
	